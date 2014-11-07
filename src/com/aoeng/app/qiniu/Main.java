package com.aoeng.app.qiniu;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.aoeng.app.qiniu.QNApi.ImageInfo;
import com.aoeng.app.qiniu.bean.QnImageInfo;
import com.qiniu.api.io.IoApi;
import com.qiniu.api.io.PutExtra;
import com.qiniu.api.io.PutRet;
import com.qiniu.api.rs.PutPolicy;

public class Main {

	public static void main(String[] args) {

		testUpload();
		
		
		String bucket = QNApi.getBucketByUpToken(QNApi.getUpToken());
		System.out.println(bucket);

		// testUpToken();
		// String imageUrl =
		// "http://androidplay.qiniudn.com/lqijZv4UGDVPnEsQw9dsNHLIwtvH";
		String imageUrl = "http://androidplay.qiniudn.com/Fsj_Ayppv03eCLHBqnTSsvb3pnyN";
		int min = 768;
		List<String> list = new ArrayList<String>();
		list.add("http://androidplay.qiniudn.com/lqijZv4UGDVPnEsQw9dsNHLIwtvH");
		list.add("http://androidplay.qiniudn.com/lqijZv4UGDVPnEsQw9dsNHLIwtvH");
		QnImageInfo imgInfo = getImageInfo(imageUrl);

		if (null != imgInfo) {
			String url = getImageUrl(imageUrl, imgInfo, min);
			System.out.println(url);
		}

	}

	@Test
	public static void testUpload() {
		try {
			String scope = QNApi.getBucketByUpToken(QNApi.getUpToken());
			System.out.println(scope);
			PutPolicy policy = new PutPolicy(scope);
			PutPolicy putPolicy = new PutPolicy(scope);
			String uptoken = putPolicy.token(QNApi.getMac());
			PutExtra extra = new PutExtra();
			HashMap<String, String> params = new HashMap<>();
			params.put("date", new Date().toLocaleString());
			params.put("datel", System.currentTimeMillis() + "");
			extra.params = params;
			String key = UUID.randomUUID().toString();

			String localFile = "D:\\git\\J2SETools\\src\\com\\aoeng\\app\\qiniu\\bean\\QnImageInfo.java";
			PutRet ret = IoApi.putFile(uptoken, key, localFile, extra);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static String getImageUrl(String imageUrl, QnImageInfo info, int min) {
		// TODO Auto-generated method stub
		if (info.getWidth() > info.getHeight()) {
			return imageUrl.concat(QNApi.getMinHeight(min, ImageInfo.HEIGHT));
		} else {
			return imageUrl.concat(QNApi.getMinHeight(min, ImageInfo.WEIGHT));
		}
	}

	private static QnImageInfo getImageInfo(String imageUrl) {
		// TODO Auto-generated method stub
		HttpClient client = new DefaultHttpClient();
		HttpPost post = new HttpPost(imageUrl.concat("?imageInfo"));

		try {
			List<NameValuePair> valuePairs = new ArrayList<NameValuePair>();
			// valuePairs.add(new BasicNameValuePair("imageInfo", ""));
			post.setEntity(new UrlEncodedFormEntity(valuePairs, "utf-8"));
			HttpResponse response = client.execute(post);
			if (null != response && response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				String resp = EntityUtils.toString(response.getEntity());
				System.out.println(resp);
				return JSON.parseObject(resp, QnImageInfo.class);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	private static void testUpToken() {
		// TODO Auto-generated method stub
		String upToken = QNApi.getUpToken();
		System.out.println(upToken);
		upToken = "sUp_H-7FJu_nie9pCBVoQ_dHxtIdXBWnU5nqnc7x:Zm8Xiz_sKdXkb-cyypPT8kvcL58=:eyJzY29wZSI6Im5va2VlIiwiZGVhZGxpbmUiOjE0MTQwMzk0NjN9";
		String bucket = QNApi.getBucketByUpToken(upToken);
		System.out.println(bucket);
	}

}
