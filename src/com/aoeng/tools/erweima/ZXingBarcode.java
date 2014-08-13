package com.aoeng.tools.erweima;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;

public class ZXingBarcode {
	/**
	 * 
	 * @param args
	 */
	/*
	 * 条形码测试
	 */
	public static void main(String[] args) {
		int barcodeW = 400;
		int barcodeH = 200;
		String contentStr = "6923450657713";
		String imgBarcodePath = "/home/paynet/Study/Android/dimcode/zxing/bacode.png";
		createBarcode(contentStr, imgBarcodePath, barcodeW, barcodeH);
		String barcodeContentStr = decodeBarcode(imgBarcodePath);
		System.out.println(barcodeContentStr);
	}

	private static String decodeBarcode(String imgBarcodePath) {
		// TODO Auto-generated method stub
		BufferedImage image = null;
		Result result = null;
		try {
			image = ImageIO.read(new File(imgBarcodePath));
			if (image == null) {
				System.out.println("the decode image may be not exit.");
			}
			LuminanceSource source = new BufferedImageLuminanceSource(image);
			BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

			result = new MultiFormatReader().decode(bitmap, null);
			return result.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static void createBarcode(String contentStr, String imgBarcodePath, int barcodeW, int barcodeH) {
		// TODO Auto-generated method stub
		int codeWidth = 3 + // start guard
				(7 * 6) + // left bars
				5 + // middle guard
				(7 * 6) + // right bars
				3; // end guard
		codeWidth = Math.max(codeWidth, barcodeW);
		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(contentStr, BarcodeFormat.EAN_13, codeWidth, barcodeH, null);

			MatrixToImageWriter.writeToFile(bitMatrix, "png", new File(imgBarcodePath));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
