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
import java.util.ArrayList;
import java.util.List;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.junit.Test;

public class ZipCompress {

	public static void main(String[] args) {
	}

	@Test
	public void unZipCompress() {
		try {
			FileInputStream fis = new FileInputStream(new File("zipcompress.zip"));
			CheckedInputStream cis = new CheckedInputStream(fis, new Adler32());
			ZipInputStream zis = new ZipInputStream(cis);
			BufferedInputStream bin = new BufferedInputStream(zis);
			ZipEntry ze;
			while ((ze = zis.getNextEntry()) != null) {
				String fileName = ze.getName();
				BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(fileName));
				int b = 0;
				// byte[] bs = ze.getExtra();
				while ((b = bin.read()) != -1) {
					bos.write(b);
				}

				bos.close();

			}
			bin.close();
			// zis.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void zipCompress() {

		List<String> lists = new ArrayList<String>();
		lists.add("D:\\git\\J2SETools/J2SETools/src/com/aoeng/dp/cat1/singleton/LazySingleton.java");
		lists.add("D:\\git\\J2SETools/git/J2SETools/src/com/aoeng/dp/cat1/singleton/Main.java");
		lists.add("/home/aoeng/git/J2SETools/src/com/aoeng/dp/cat1/singleton/SerSingleton.java");
		lists.add("/home/aoeng/git/J2SETools/src/com/aoeng/dp/cat1/singleton/Singleton.java");
		lists.add("/home/aoeng/git/J2SETools/src/com/aoeng/dp/cat1/singleton/StaticSingelton.java");

		try {
			FileOutputStream fos = new FileOutputStream(new File("zipcompress.zip"));
			CheckedOutputStream cos = new CheckedOutputStream(fos, new Adler32());
			ZipOutputStream zos = new ZipOutputStream(cos);
			BufferedOutputStream bos = new BufferedOutputStream(zos);
			zos.setComment("A test of zip compress");
			for (String srcPath : lists) {
				zos.putNextEntry(new ZipEntry(new File(srcPath).getName()));
				BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(srcPath)));

				int b = 0;
				while ((b = reader.read()) != -1)
					zos.write(b);
				zos.flush();
				reader.close();
			}

			zos.close();

			System.out.println(cos.getChecksum().getValue());
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
