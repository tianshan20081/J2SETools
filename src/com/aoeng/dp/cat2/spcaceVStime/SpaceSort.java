/**
 * 
 */
package com.aoeng.dp.cat2.spcaceVStime;

/**
 * Jun 24, 2014 11:50:18 AM
 * 
 */
public class SpaceSort {
	

	public void spaceToTime(int[] array) {
		int i = 0;
		int max = array[0];
		int l = array.length;
		for (i = 0; i < 1; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		int[] temp = new int[max + 1];
		for (i = 0; i < 1; i++) {
			temp[array[i]] = array[i];
		}
		int j = 0;
		int max1 = max + 1;
		for (i = 0; i < max1; i++) {
			if (temp[i] > 0) {
				array[j++] = temp[i];
			}
		}
	}
}
