package com.aoeng.base.interview.heima;

import java.util.Arrays;

/*
 * 请自己实现一个快速排序
 * 
 * 分析：
 * 		快速排序是一个非常快的交换排序方式，它的基本思路很简单：
 * 			从待排序的数据序列中任意获取一个数据作为分界值,所有比他小的数据元素一律放左边，
 * 			所有比他大的元素一律放在右边。经过这样一趟下来，该序列形成左，右两个子序列。
 * 			左边序列中的数据元素都比分界值小，右边序列中的值都比分界值大。
 * 			
 * 			接下来对左，右两个子序列进行递归，对两个子序列重新选择中心元素并依此规则调整，
 * 			直到每个子序列的元素只剩一个，排序完成。
 * 
 *  * 一趟快速排序的算法是： 　　
 * 1）设置两个变量i、j，排序开始的时候：i=0，j=N-1； 　　
 * 2）以第一个数组元素作为关键数据，赋值给key，即 key=A[0]； 　　
 * 3）从j开始向前搜索，即由后开始向前搜索（j=j-1即j--），
 * 找到第一个小于key的值A[j]，A[i]与A[j]交换； 　　
 * 4）从i开始向后搜索，即由前开始向后搜索（i=i+1即i++），
 * 找到第一个大于key的A[i]，A[i]与A[j]交换； 　　
 * 5）重复第3、4、5步，直到 I=J； 
 * (3,4步是在程序中没找到时候j=j-1，i=i+1，直至找到为止。
 * 找到并交换的时候i， j指针位置不变。
 * 另外当i=j这过程一定正好是i+或j-完成的最后令循环结束。） 
 */

class QuickSort {
	/**
	 * 
	 * @param data
	 */
	public static void sort(int[] data) {
		quickSort(data, 0, data.length - 1);
	}

	/**
	 * 
	 * @param data
	 * @param i
	 * @param j
	 */
	private static void quickSort(int[] data, int i, int j) {
		int pivotIndex = (i + j) / 2;
		// swap
		swap(data, pivotIndex, j);

		int k = partition(data, i - 1, j, data[j]);
		swap(data, k, j);
		if ((k - i) > 1)
			quickSort(data, i, k - 1);
		if ((j - k) > 1)
			quickSort(data, k + 1, j);

	}

	/**
	 * @param data
	 * @param i
	 * @param j
	 * @return
	 */
	private static int partition(int[] data, int l, int r, int pivot) {
		do {
			while (data[++l] < pivot)
				;
			while ((r != 0) && data[--r] > pivot)
				;
			swap(data, l, r);
		} while (l < r);
		swap(data, l, r);
		return l;
	}

	/**
	 * 
	 * @param data
	 * @param i
	 * @param j
	 */
	private static void swap(int[] data, int i, int j) {
		int temp = data[i];
		data[i] = data[j];
		data[j] = temp;
	}
}

public class Test6 {
	public static void main(String[] args) {
		int[] arr = { 18, 67, 93, -24, 56, 72, 67, 34 };
		System.out.println("排序前：" + Arrays.toString(arr));
		QuickSort.sort(arr);
		System.out.println("排序前：" + Arrays.toString(arr));
	}
}
