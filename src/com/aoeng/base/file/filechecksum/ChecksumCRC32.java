package com.aoeng.base.file.filechecksum;

import java.io.File;
import java.io.FileInputStream;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;

public class ChecksumCRC32 {

	public static long getFileCRC32(String pathname) {
		File file = null;
		CheckedInputStream cis = null;
		FileInputStream fileInputStream = null;
		long fileCRC = 0;
		try {
			file = new File(pathname);
			if (!file.isFile()) {
				throw new Exception("文件错误");
			}
			fileInputStream = new FileInputStream(file);
			cis = new CheckedInputStream(fileInputStream, new CRC32());
			byte[] buf = new byte[128];
			while (cis.read(buf) >= 0) {
			}
			fileCRC = cis.getChecksum().getValue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return fileCRC;
	}
}
