package com.aoeng.base.interview.heima;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/*
 把d盘目录下的source目录内容拷贝到e盘目录下。
 注意：source目录可能还有目录。
 
 分析：
	1：目录下包含有目录和文件。
	2：用递归实现这个操作，判断是目录就创建。是文件就创建并拷贝。
 */
public class Test8 {
	public static void main(String[] args) throws IOException {
		File source = new File("d:\\source");
		File target = new File("e:\\");
		copyDir(source, target);
	}

	// 拷贝目录
	private static void copyDir(File source, File target) throws IOException {
		// 判断source
		if (source.isDirectory()) {
			// 是目录
			// 在target下创建同名目录
			File dir = new File(target, source.getName());
			dir.mkdirs();
			// 遍历source下所有的子文件，将每个子文件作为source，将新创建的目录作为target进行递归。
			File[] files = source.listFiles();
			for (File file : files) {
				copyDir(file, dir);
			}
		} else {
			// 是文件
			// 在target目录下创建同名文件，然后用流实现文件拷贝。
			File file = new File(target, source.getName());
			file.createNewFile();
			copyFile(source, file);
		}
	}

	// 拷贝文件
	private static void copyFile(File source, File file) throws IOException {
		// 创建流对象
		InputStream is = null;
		OutputStream os = null;
		try {
			is = new FileInputStream(source);
			os = new FileOutputStream(file);

			// 基本读写操作
			byte[] bys = new byte[1024];
			int len = 0;
			while ((len = is.read(bys)) != -1) {
				os.write(bys, 0, len);
			}
		} finally {
			if (os != null) {
				os.close();
			}
			if (is != null) {
				is.close();
			}
		}
	}
}
