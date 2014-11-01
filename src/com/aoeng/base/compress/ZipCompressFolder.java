package com.aoeng.base.compress;

import com.aoeng.base.file.FilePath;

/**
 * 使用 zip 命令 压缩/解压文件夹
 * 
 * @author sczhang
 * 
 */
public class ZipCompressFolder {

	public static void main(String[] args) {
		String folder = "";
		String path = FilePath.getRootPath();
		String srcPath = FilePath.getRootSrcPath();
		String binPath = FilePath.getRootBinPath();
		System.out.println("binPath"+binPath);
		System.out.println(path);

		System.out.println(ZipCompressFolder.class.getClass().getResource("/").getPath());
		System.out.println(ZipCompressFolder.class.getResource("/").getPath());
	
		
		System.out.println(System.getProperty("user.dir"));
	}

}
