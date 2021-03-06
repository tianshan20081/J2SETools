package com.aoeng.base.sort;

/***
 * 合并排序
 * 
 * 算法思想 合并排序是采用分治策略实现对n个元素进行排序的算法，是分治法的一个典型应用和完美体现。它是一种平衡、简单的二分分治策略，
 * 
 * 其计算过程分为三大步：
 * 
 * （1）分解：将待排序元素分成大小大致相同的两个子序列。
 * 
 * （2）求解子问题：用合并排序法分别对两个子序列递归地进行排序。
 * 
 * （3）合并：将排好序的有序子序列进行合并，得到符合要求的有序序列。
 * 
 * @author aoeng Aug 26, 2014 7:47:59 PM
 */
public class MergeSort {
	public static void main(String[] args) {
		int[] attr = {4,7,2,9,4,6,90,43,21,54,25,67};
		mergeSort(attr,0,attr.length);
	}

	private static void mergeSort(int[] attr, int low, int hight) {
		// TODO Auto-generated method stub
		
	}

}
