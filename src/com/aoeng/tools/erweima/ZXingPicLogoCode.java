package com.aoeng.tools.erweima;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

public class ZXingPicLogoCode {
	/**
	 * 生成带logo的 二维码，logo面积不能超过 30 %
	 * 
	 * @param args
	 * @throws Exception
	 */
	/*
	 * 思路：1.先生成一张二维码，2.将logo 图标放到二维码的中间位置
	 */
	public static void main(String[] args) throws Exception {
		// String qrContent =
		// "王晓东\n项目发展部\n易智付科技（北京）有限公司\n北京西城区阜成门外大街22号 外经贸大厦620-626室\n电话：82652626--6659\n邮编：100037";
		String qrContent = "http://www.beijing.com.cn";
		qrContent = new String(qrContent.getBytes("utf-8"), "iso-8859-1");
		String logoPath = "/home/paynet/paynet/WorkFIle/CompanyImage/img/icon144.png";
		String qrPath = "/home/paynet/Desktop/aa/";

		// String deQrPath = "/home/paynet/Desktop/aa/1375415189985.png";
		int qrH = 250;
		int qrW = 250;
		createPic(qrContent, logoPath, qrPath, qrW, qrH);

		encodePic();

		// String imgStr = decodePic(deQrPath);

		// System.out.println(imgStr);

	}

	private static void encodePic() {
		// TODO Auto-generated method stub
		try {
			BitMatrix bitMatrix = new MultiFormatWriter().encode(null, null, 0,
					0, null);
		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String decodePic(String deQrPath) {
		// TODO Auto-generated method stub
		BufferedImage image = null;
		Result result = null;
		try {
			image = ImageIO.read(new File(deQrPath));
			if (image == null) {
				System.out.println("the decode image may be not exit.");
			}
			LuminanceSource source = new BufferedImageLuminanceSource(image);
			BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));

			Map<DecodeHintType, Object> hints = new HashMap<DecodeHintType, Object>();
			hints.put(DecodeHintType.CHARACTER_SET, "GBK");

			new MultiFormatReader().decode(bitmap, hints);

			result = new MultiFormatReader().decode(bitmap);
			return result.getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static void createPic(String qrContent, String logoPath,
			String qrPath, int qrW, int qrH) throws Exception {
		// TODO Auto-generated method stub
		BitMatrix matrix = new MultiFormatWriter().encode(qrContent,
				BarcodeFormat.QR_CODE, qrW, qrH);
		int width = matrix.getWidth();
		int height = matrix.getHeight();
		qrPath += String.valueOf(System.currentTimeMillis()) + ".png";
		File file = new File(qrPath);
		file.createNewFile();
		MatrixToImageWriter.writeToFile(matrix, "png", file);

		Image image = ImageIO.read(file);
		int h = image.getHeight(null);
		int w = image.getWidth(null);
		BufferedImage bufferedImage = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		Graphics graphics = bufferedImage.createGraphics();
		graphics.drawImage(image, 0, 0, width, height, null);

		Image logoImage = ImageIO.read(new File(logoPath));
		int logW = logoImage.getWidth(null);
		int logH = logoImage.getHeight(null);
		int logPw = (w - logW) / 2;
		int logPh = (h - logH) / 2;
		graphics.drawImage(logoImage, logPw, logPh, logW, logH, null);

		graphics.dispose();

		FileOutputStream fileOutputStream = new FileOutputStream(qrPath);
		JPEGImageEncoder encoder = JPEGCodec
				.createJPEGEncoder(fileOutputStream);
		encoder.encode(bufferedImage);
		fileOutputStream.close();
	}
}
