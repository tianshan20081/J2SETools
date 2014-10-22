package com.aoeng.app.qiniu;

import org.json.JSONException;

import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.config.Config;
import com.qiniu.api.rs.PutPolicy;

public class QNApi {

	private static Mac mac;

	static {
		Config.ACCESS_KEY = "yXKy9jtDxW-WbSYdgeFiJmGFbLTeMqhgTOEUA7uc";
		Config.SECRET_KEY = "GWKfr2UAorAIGPcv_9dcDhUJoB51TkCDP6xOD0kv";
		mac = new Mac(Config.ACCESS_KEY, Config.SECRET_KEY);
	}

	public static String getUpToken() {
		// 请确保该bucket已经存在
		String uptoken;
		try {
			String bucketName = "androidplay";
			PutPolicy putPolicy = new PutPolicy(bucketName);
			uptoken = putPolicy.token(mac);
			System.out.println(uptoken);
			return uptoken;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
