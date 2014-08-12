package com.aoeng.base.compress;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * 
 * @author aoeng Aug 12, 2014 9:23:32 PM
 * 
 *         Gzip Compress
 */
public class GZipCompress {

	public static void main(String[] args) {
		String srcPath = "/home/aoeng/Study/android/MyAdapter.java";
		File srcFile = new File(srcPath);
		try {
			if (!srcFile.exists()) {
				System.out.println("srcPath is not a availiable file");
				return;
			}
			BufferedReader br = new BufferedReader(new FileReader(srcFile));
			BufferedOutputStream bout = new BufferedOutputStream(new GZIPOutputStream(new FileOutputStream("test.gz")));
			System.out.println("write out file");
			int b = 0;
			while ((b = br.read()) != -1) {
				bout.write(b);
			}
			bout.flush();
			bout.close();
			br.close();

			BufferedReader reader = new BufferedReader(new InputStreamReader(new GZIPInputStream(new FileInputStream("test.gz"))));
			BufferedOutputStream outputStream = new BufferedOutputStream(new FileOutputStream("test.java"));
			byte[] bs = new byte[1024];
			int len = 0;
			while ((len = reader.read()) != -1) {
				outputStream.write(len);
			}
			outputStream.flush();
			outputStream.close();
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
