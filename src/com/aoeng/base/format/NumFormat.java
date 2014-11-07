package com.aoeng.base.format;

import java.text.DecimalFormat;

public class NumFormat {
	public static DecimalFormat NN_NN = new DecimalFormat("##.00");
	public static DecimalFormat NN_NNN = new DecimalFormat("##.000");
	public static DecimalFormat NN_ = new DecimalFormat("##");

	public static void main(String[] args) {
		System.out.println(NN_.format(3));
		;
	}

}
