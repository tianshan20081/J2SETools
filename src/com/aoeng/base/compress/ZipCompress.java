package com.aoeng.base.compress;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.Adler32;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipCompress {

	public static void main(String[] args) {
		String srcPath = "/home/aoeng/Study/android/MyAdapter.java";

		File srcFile = new File(srcPath);
		if (!srcFile.exists()) {
			System.out.println("file is not exits !");
			return;
		}
		try {
			FileOutputStream fos = new FileOutputStream(new File("disrt.zip"));
			CheckedOutputStream cos = new CheckedOutputStream(fos, new Adler32());
			ZipOutputStream zos = new ZipOutputStream(cos);
			BufferedOutputStream bos = new BufferedOutputStream(zos);
			zos.setComment("A test of zip compress");
			zos.putNextEntry(new ZipEntry(srcPath));
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(srcFile)));

			int b = 0;
			while ((b = reader.read()) != -1)
				zos.write(b);
			zos.flush();
			zos.close();
			reader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
