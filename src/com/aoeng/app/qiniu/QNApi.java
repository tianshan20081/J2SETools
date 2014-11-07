package com.aoeng.app.qiniu;

import org.json.JSONObject;

import com.aoeng.tools.utils.Base64;
import com.qiniu.api.auth.digest.Mac;
import com.qiniu.api.config.Config;
import com.qiniu.api.rs.PutPolicy;

public class QNApi {

	private static final int WEIGHT = 0;
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

	/**
	 * 获得七牛服务器上面 图片的最小高度为 min 的请求参数
	 * 
	 * @param min
	 * @return
	 */
	public static String getMinHeight(int minValue, ImageInfo type) {
		// TODO Auto-generated method stub
		String format = "?imageView2/2/%s/%d/q/85";
		return String.format(format, type.getValue(), minValue);
	}

	enum ImageInfo {
		WEIGHT("w"), HEIGHT("h");

		private String value;

		ImageInfo(String value) {
			this.value = value;
		}

		public String getValue() {
			return this.value;
		}

	}

	public static Mac getMac() {
		// TODO Auto-generated method stub
		return mac;
	}
}
