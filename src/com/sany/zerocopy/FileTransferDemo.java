package com.sany.zerocopy;

import java.io.*;
import java.nio.channels.FileChannel;

/**
 * 零拷贝方式：sendFile机制（与DMA有关）
 */
public class FileTransferDemo {

    public static void main(String[] args) {
        File sourceFile = new File("NettyDemo/1.txt");
        System.out.println(sourceFile.getAbsoluteFile() + ":size = " + sourceFile.length());
        long startTime = System.currentTimeMillis();
        moveFileByStream(sourceFile, new File("NettyDemo/1.stream.txt"));
        long endTime = System.currentTimeMillis();
        System.out.println("传统IO文件拷贝耗时：" + (endTime - startTime));
        startTime = System.currentTimeMillis();
        moveFileByChannel(sourceFile, new File("NettyDemo/1.channel.txt"));
        endTime = System.currentTimeMillis();
        System.out.println("ZeroCopy文件拷贝耗时：" + (endTime - startTime));
    }

    /**
     * NIO中transfer方式的零拷贝，这种拷贝方式不光拷贝硬盘文件，还可以用作底层硬件之间的拷贝实现。
     * 例如kafka中使用这种方式将消息从硬盘拷贝到网卡。
     */
    private static void moveFileByChannel(File sourceFile, File targetFile) {
        try {
            final FileInputStream sourceFis = new FileInputStream(sourceFile);
            final FileChannel sourceReadChannel = sourceFis.getChannel();

            final FileOutputStream targetFos = new FileOutputStream(targetFile);
            final FileChannel targetWriteChannel = targetFos.getChannel();

            sourceReadChannel.transferTo(0, sourceFile.length(), targetWriteChannel);

            sourceFis.close();
            targetFos.close();
        } catch (IOException e) {

        }
    }

    /**
     * 传统数据流拷贝方式
     */
    private static void moveFileByStream(File sourceFile, File targetFile) {
        try {
            BufferedReader sourceBr = new BufferedReader(new InputStreamReader(new FileInputStream(sourceFile)));
            BufferedWriter targetBw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(targetFile)));
            while (true) {
                final String line = sourceBr.readLine();
                if (line == null || "".equals(line)) {
                    break;
                }
                targetBw.write(line);
            }
            targetBw.flush();
            sourceBr.close();
            targetBw.close();
        } catch (IOException e) {}
    }
}

/**
 * rocket高性能原因：
 * 第一点：使用了零拷贝，零拷贝有sendFile和MMAP，rocketMQ使用了后者
 * 第二点：顺序写机制，配合固态硬盘写入速度可以达到内存级别。避免了随机写在硬盘中寻址的过程（寻址就是找到一块空闲空间可以写入数据）。
 * 第三点：刷盘机制。PageCache：磁盘文件在内核中的缓存。读写磁盘文件都会通过PageCache。
 *          那么把PageCache中的文件写入磁盘的过程就称为刷盘。rocketMQ设计了两种刷盘机制：
 *          配置项： flushDiskType=ASYNC_FLUSH or SYNC_FLUSH
 *          异步刷盘：把Java Heap中数据，写到内存中的PageCache就可以了，直接返回了。但是这时PageCache数据还没刷盘时候突然断电了，那么就会有数据丢失。
 *          同步刷盘：每个消息都会刷盘，且操作系统刷盘成功了，应用程序才会返回成功。这样消息不会丢失，但是性能差。
 *
 * brokerRole=ASYNC_MASTER(异步复制)、SYNC_MASTER(同步复制)、SLAVE
 */