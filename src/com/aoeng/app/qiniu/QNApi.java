package com.aoeng.app.qiniu;

import java.io.UnsupportedEncodingException;

import org.json.JSONException;
import org.json.JSONObject;

import com.aoeng.tools.utils.Base64;
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

	public static String getBucketByUpToken(String uptoken) {
		try {
			String str = uptoken.split(":")[2];
			String jsonStr = new String(Base64.decode(str, Base64.URL_SAFE | Base64.NO_WRAP), "utf-8");
			JSONObject json = new JSONObject(jsonStr);
			String scope = json.optString("scope");
			String bucketName = scope.split(":")[0];
			return bucketName;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Log.d("Scope", bucketName);
		return null;
	}

}
