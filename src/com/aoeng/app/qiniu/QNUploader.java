package com.aoeng.app.qiniu;

import java.io.File;
import java.util.UUID;

import com.qiniu.api.io.IoApi;
import com.qiniu.api.io.PutExtra;
import com.qiniu.api.io.PutRet;

public class QNUploader {

	public static void main(String[] args) {
		PutExtra extra = new PutExtra();
		String key = UUID.randomUUID().toString();
		
		String localFile = "D:\\Download\\2.zip";
		File file = new File(localFile);
		if (file.exists() && file.isFile()) {
			PutRet ret = IoApi.putFile(QNApi.getUpToken(), key, localFile, extra);
			System.out.println(ret.getKey());
		}

	}
}
