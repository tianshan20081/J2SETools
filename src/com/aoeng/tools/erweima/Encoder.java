package com.aoeng.tools.erweima;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Hashtable;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

/**
 * 生成二维码 May 8, 2014 1:36:34 PM
 * 
 */
public class Encoder {

	public static void main(String[] args) {

		// 支付网关
		// String contents = "http://192.168.4.55:8080/PayEase/PayEasePay.apk";
		String contents = "http://www.beijing.com.cn";
		Hashtable<EncodeHintType, String> hints = new Hashtable<EncodeHintType, String>();

		hints.put(EncodeHintType.CHARACTER_SET, "GBK");

		BitMatrix matrix = null;
		int hight = 1000;// 生成二维码的高度
		int width = 1000;// 生成二维码的宽度

		try {

			matrix = new MultiFormatWriter().encode(contents, BarcodeFormat.QR_CODE, width, hight,
					hints);
		} catch (WriterException e) {
			e.printStackTrace();
		}
		Date d = new Date();
		String sss = "" + d.getSeconds() + d.getMinutes();
		File file = new File("/home/paynet/Desktop/" + "www.beijing.com.cn" + ".png");
		try {
			MatrixToImageWriter.writeToFile(matrix, "png", file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}