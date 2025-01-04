# 动态规划题目盘点

## 抬手就能做的最基础dp题目
53 最大数组和
62 主题思路很容易想到，校招面试遇到过一次。注意点是，空间可以优化
64 是62题的进阶版本
70 和斐波那契（509题）一模一样

## 股票脉脉问题
121 最基础的股票买卖问题，其实不需要用到dp

## 经典题目
115* dp开篇第一题
5*   最长回文子串
300* 最长递增子序列（经典题，必刷必会）674、53、368一起做
322* 零钱兑换问题(递推公式不难，难的是编码细节)
368* 最大整除子集

## 放在dp中，其实用线性方法解决
都是经典必须反复刷的题
45 & 55(跳跃游戏，不算简单)、121(基础版股票买卖)、53(最大子数组和)、300、354、368、674

## 子集dp问题
368 最大整除子集，这题有些难度不太好想（为啥说叫接龙型的dp）

## 字符串dp问题

###
回文串 5：最长回文串 131、132：分割字符串使子串都是回文串

## 刷过的题目小计

说是dp，其实感觉和dp没啥关系不用dp做更好理解：leetcode.股票第一题、leetcode.674
最基础的dp: 509斐波那契数、322零钱兑换问题，这两题都是从底到上递推比较好理解。

//Leetcode 674 Longest Continuous Increasing Subsequence (接龙型dp)
//Leetcode 62 Unique Paths II
//Leetcode 70 Climbing Stairs
//Leetcode 64 Minimum Path Sum
//Leetcode 368 Largest Divisible Subset (接龙型dp)
//Leetcode 300 Longest Increasing Subsequence (接龙型dp)
Leetcode 354 Russian Doll Envelopes (接龙型dp， 300的2D版)
Leetcode 256 Paint House(会员题)
//Leetcode 121 Best Time to Buy and Sell Stock
//Leetcode 55 Jump Game
//Leetcode 45 Jump Game II
//Leetcode 132 Palindrome Partitioning II
Leetcode 312 Burst Balloons (区间型dp)
Leetcode 1143 Longest Common Subsequence (前缀型dp)
Leetcode 1062 Longest Repeating Substring (dp方法与longest common substring一致)
Leetcode 718 Maximum Length of Repeated Subarray (和1062本质上一样)
Leetcode 174 Dungeon Game
Leetcode 115 Distinct Subsequences
Leetcode 72 Edit Distance
Leetcode 91 Decode Ways
Leetcode 639 Decode Ways II
Leetcode 712 Minimum ASCII Delete Sum for Two Strings
Leetcode 221 Maximal Square
Leetcode 1277 Count Square Submatrices with All Ones (可以使用221一样的解法)
Leetcode 198 House Robber
Leetcode 213 House Robber II
Leetcode 740 Delete and Earn
Leetcode 87 Scramble String
Leetcode 1140 Stone Game II
Leetcode 322 Coin Change
Leetcode 518 Coin Change II (01背包型)
Leetcode 1048 Longest String Chain
Leetcode 44 Wildcard Matching
Leetcode 10 Regular Expression Matching
Leetcode 32 Longest Valid Parentheses
Leetcode 1235 Maximum Profit in Job Scheduling (DP + binary search)
Leetcode 1043 Partition Array for Maximum Sum
Leetcode 926 Flip String to Monotone Increasing