package com.aoeng.base.file.filechecksum;

import java.io.File;
import java.io.FileInputStream;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * 文件属性　md5 hash
 * 
 * @author paynet
 * 
 */
public class Main {
	public static void main(String[] args) {
		test();
	}

	public static void test() {
		String pathname = "/home/nk-aoeng/Downloads/wumi_2001002.apk";
		System.out.println("-----------------------------------------------------------------------------------");
		System.out.println("文件名：" + text(pathname));
		System.out.println("CRC:\t" + test01(pathname));
		System.out.println("文件大小(字节)：" + test02(pathname));
		test03(pathname);
		System.out.println("最后修改时间:  " + test04(pathname));
		// test05();
	}

	private static String text(String pathname) {
		// TODO Auto-generated method stub
		File file = new File(pathname);
		if (!file.isFile()) {
			System.out.println("文件错误");
		}
		return file.getName();

	}

	private static void test05() {
		// TODO Auto-generated method stub
		Long time = System.currentTimeMillis();
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日， HH:mm:ss");
		cal.setTimeInMillis(time);
		System.out.println(formatter.format(cal.getTime()));
	}

	public static String test01(String pathname) {

		long crc32 = ChecksumCRC32.getFileCRC32(pathname);
		return Long.toHexString(crc32).toUpperCase();

	}

	// 获得文件的字节长度
	public static String test02(String pathname) {
		try {
			FileInputStream fileInputStream = new FileInputStream(new File(pathname));
			int i = fileInputStream.available();
			NumberFormat format = NumberFormat.getInstance();
			return format.format(i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public static void test03(String pathname) {
		try {
			System.out.println("MD5:    " + ChecksumMd5.getHash(pathname, "MD5").toUpperCase());
			System.out.println("SHA-1:  " + ChecksumMd5.getHash(pathname, "SHA-1").toUpperCase());
			System.out.println("SHA-256:" + ChecksumMd5.getHash(pathname, "SHA-256").toUpperCase());
			System.out.println("SHA-384:" + ChecksumMd5.getHash(pathname, "SHA-384").toUpperCase());
			System.out.println("SHA-512:" + ChecksumMd5.getHash(pathname, "SHA-512").toUpperCase());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static String test04(String filePath) {
		File file = new File(filePath);
		Long time = file.lastModified();
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日， HH:mm:ss");
		cal.setTimeInMillis(time);
		return formatter.format(cal.getTime());
	}
}
