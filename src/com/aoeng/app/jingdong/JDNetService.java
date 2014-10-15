package com.aoeng.app.jingdong;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.jcloud.jss.JingdongStorageService;
import com.jcloud.jss.domain.Bucket;
import com.jcloud.jss.exception.StorageClientException;
import com.jcloud.jss.exception.StorageServerException;

/**
 * jing Dong yun Service
 * 
 * @author aoeng
 *
 */
public class JDNetService {

	public static void main(String[] args) throws Exception, Exception, Exception {
		String accessKey = "8f02595c11a14a1d83c4faaaee4953ed";
		String sercretKey = "c18f464f51f7446d9573c48f3e461912TWE4jd14";

		JingdongStorageService jss = new JingdongStorageService(accessKey, sercretKey);
		List<Bucket> bucket = jss.listBucket();
		for (Bucket bt : bucket) {
			System.out.println(bt.getName());
		}
		String pathname = "/home/aoeng/Desktop/Java性能优化权威指南.pdf";
		File file = new File(pathname);
		String md5 = jss.bucket("imagesupload").object(file.getName()).entity(file).put();

		System.out.println(md5);

		File f2 = new File("/home/aoeng/Desktop/text.pdf");
		if (!f2.exists()) {
			f2.createNewFile();
		}
		jss.bucket("imagesupload").object(file.getName()).entity(f2).get().toFile(f2);

	}
}
