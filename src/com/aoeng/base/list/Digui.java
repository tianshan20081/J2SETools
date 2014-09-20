package com.aoeng.base.list;

import java.io.File;
import java.util.ArrayList;

public class Digui {
	public static void main(String[] args) {
		String path = "/home/nk-aoeng/Desktop/test";
		File file = new File(path);
		ArrayList<String> list = getFiles(file);
		for (String string : list) {
			System.out.println(string);
		}
		System.out.println(list.size());
	}

	private static ArrayList<String> getFiles(File file) {
		// TODO Auto-generated method stub
		ArrayList<String> list = new ArrayList<String>();
		if (null == file || !file.exists() || !file.isDirectory()) {
			System.out.println("请输入正确的文件夹名称");
			return null;
		}
		File[] files = file.listFiles();
		for (File f : files) {
			if (f.isFile()) {
				list.add(f.getAbsolutePath());
			} else {
				list.addAll(getFiles(f));
			}
		}

		return list;
	}

}
