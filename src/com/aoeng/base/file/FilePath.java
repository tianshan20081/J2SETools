package com.aoeng.base.file;

import java.io.File;

import com.aoeng.tools.utils.StringUtils;

public class FilePath {

	public static String getRootPath() {

		System.out.println(Thread.currentThread().getContextClassLoader().getResource("").getPath());
		System.out.println(FilePath.class.getClassLoader().getResource(""));
		System.out.println(ClassLoader.getSystemResource(""));
		System.out.println(FilePath.class.getResource(""));
		System.out.println(FilePath.class.getResource("/"));
		System.out.println(new File("").getAbsolutePath());
		System.out.println(System.getProperty("user.dir"));
		// FilePath.class.getClass().getClassLoader().
		// System.getProperty("user.dir");
		// return
		// Thread.currentThread().getContextClassLoader().getResource("").getPath();
		String path = FilePath.class.getResource("/").getPath();
		if (!StringUtils.isEmpty(path)) {
			File binFolder = new File(path);
			return binFolder.getParent();
		}
		return "";
	}

	public static void main(String[] args) {
		System.out.println(getRootPath().replace('\\', '/'));
	}

	public static String getRootSrcPath() {
		// TODO Auto-generated method stub
		if (!StringUtils.isEmpty(getRootPath())) {

		}
		return null;
	}

	public static String getRootBinPath() {
		// TODO Auto-generated method stub

		return FilePath.class.getResource("/").getPath();
	}

}
