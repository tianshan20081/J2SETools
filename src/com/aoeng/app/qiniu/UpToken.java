package com.aoeng.app.qiniu;

import net.sf.json.JSONObject;

import com.aoeng.base.encryption.HMACSHA1;

public class UpToken {
	public static void main(String[] args) throws Exception {

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
