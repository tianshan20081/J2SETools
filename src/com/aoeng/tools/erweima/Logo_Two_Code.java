package com.aoeng.tools.erweima;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.encoder.QRCode;

public class Logo_Two_Code {
	/**
	 * 生成二维码(QRCode)图片
	 * 
	 * @param content
	 *            二维码图片的内容
	 * @param imgPath
	 *            生成二维码图片完整的路径
	 * @param ccbpath
	 *            二维码图片中间的logo路径
	 */
	public static int createQRCode(String content, String imgPath,
			String ccbPath) {
		try {
			QRCode qrcodeHandler = new QRCode();
			// 设置二维码排错率，可选L(7%)、M(15%)、Q(25%)、H(30%)，排错率越高可存储的信息越少，但对二维码清晰度的要求越小
			qrcodeHandler.setQrcodeErrorCorrect('M');
			// N代表数字,A代表字符a-Z,B代表其他字符
			qrcodeHandler.setQrcodeEncodeMode('B');
			// 设置设置二维码版本，取值范围1-40，值越大尺寸越大，可存储的信息越大
			qrcodeHandler.setQrcodeVersion(8);

			byte[] contentBytes = content.getBytes("gb2312");
			BufferedImage bufImg = new BufferedImage(500, 500,
					BufferedImage.TYPE_INT_RGB);
			Graphics2D gs = bufImg.createGraphics();

			gs.setBackground(Color.WHITE);
			gs.clearRect(0, 0, 500, 500);

			// 设定图像颜色 > BLACK
			gs.setColor(Color.BLACK);

			// 设置偏移量 不设置可能导致解析出错
			int pixoff = 2;
			// 输出内容 > 二维码
			if (contentBytes.length > 0 && contentBytes.length < 500) {
				boolean[][] codeOut = qrcodeHandler.calQrcode(contentBytes);
				for (int i = 0; i < codeOut.length; i++) {
					for (int j = 0; j < codeOut.length; j++) {
						if (codeOut[j][i]) {
							gs.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
						}
					}
				}
			} else {
				System.err.println("QRCode content bytes length = "
						+ contentBytes.length + " not in [ 0,125]. ");
				return -1;
			}
			Image img = ImageIO.read(new File(ccbPath));// 实例化一个Image对象。
			gs.drawImage(img, 50, 50, null);
			gs.dispose();
			bufImg.flush();

			// 生成二维码QRCode图片
			File imgFile = new File(imgPath);
			ImageIO.write(bufImg, "png", imgFile);

		} catch (Exception e) {
			e.printStackTrace();
			return -100;
		}

		return 0;
	}

	public static void main(String[] args) {
		String content = "zsc";
		String imgPath = "/home/paynet/Study/Android/dimcode/dd.png";
		String ccbPath = "/home/paynet/Study/Android/dimcode/logo_bgw.png";
		String encoderContent = "菩提 千年(手机号：15876148239):你若不离不弃，我必生死相依。鞭策:1,我的理想是什么？2,我下一个目标在哪里？3,我有能力做什么？4,我的钱途呢几何？";
		Logo_Two_Code logo_Two_Code = new Logo_Two_Code();
		logo_Two_Code.createQRCode(encoderContent, imgPath, ccbPath);
	}
}