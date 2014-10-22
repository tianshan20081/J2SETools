package com.aoeng.app.qiniu;

import org.json.JSONObject;

import com.aoeng.base.encryption.HMACSHA1;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.config.Config;
import com.qiniu.api.rs.PutPolicy;

public class UpToken {

	public static void main(String[] args) throws Exception {

		test();
		// test2();

	}

	private static void test() throws Exception {
		// TODO Auto-generated method stub

		System.out.println(QNApi.getUpToken());
	}

	private static void test2() throws Exception {
		// TODO Auto-generated method stub
		// 1410869441
		// 1410872219

		// {"scope":"androidplay","deadline":1410872219}
		String scope = "androidplay";
		String AccessKey = "yXKy9jtDxW-WbSYdgeFiJmGFbLTeMqhgTOEUA7uc";
		String SecretKey = "GWKfr2UAorAIGPcv_9dcDhUJoB51TkCDP6xOD0kv";

		long deadline = (System.currentTimeMillis() + 10 * 60 * 60) / 1000;
		JSONObject jsonObject = new JSONObject();

		jsonObject.put("scope", "androidplay");
		jsonObject.put("deadline", deadline);

		System.out.println(jsonObject.toString());

		String encoded = new String(Encoding.encodeBase64(jsonObject.toString().getBytes()));
		System.out.println(encoded);
		// eyJzY29wZSI6ImFuZHJvaWRwbGF5IiwiZGVhZGxpbmUiOjE0MTA4NzQ0Njh9
		// eyJzY29wZSI6ImFuZHJvaWRwbGF5IiwiZGVhZGxpbmUiOjE0MTA4NzQ0Njh9

		System.out.println(new String(Encoding.decodeBase64(encoded.getBytes())));
		String signature = HMACSHA1.getSignature(SecretKey, encoded);

		String encode_signed = new String(Encoding.encodeBase64(signature.getBytes()));

		String upload_token = AccessKey + ":" + encode_signed + ":" + encoded;

		System.out.println(upload_token);
	}

}
