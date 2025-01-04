package com.sany.zerocopy;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 零拷贝方式：MMAP
 * DirectByteBuffer：不保存数据，通过Unsafe类直接操作底层
 * HeapedByteBuffer：保存在自己的数组里面
 */
public class MappedByteBufferDemo {

    public static void main(String[] args) throws IOException {

        RandomAccessFile randomAccessFile = new RandomAccessFile("MappedBF.txt", "rw");
        //获取对应的通道
        FileChannel channel = randomAccessFile.getChannel();

        /**
         * 参数一：FileChannel.MapMode.READ_WRITE 使用的读模式
         * 参数二：0：可以直接修改的起始位置
         * 参数三： 5：是映射到内存的大小(不是索引位置)，即将 "MappedBF.txt" 的多少个字节映射到内存
         * 可以直接血钙的范围就是 0-5
         * 实际类型 DirectoryByteBuffer
         */
        MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);
        mappedByteBuffer.put(0, (byte) 'H');
        mappedByteBuffer.put(3, (byte) '9');

        randomAccessFile.close();
    }
}
