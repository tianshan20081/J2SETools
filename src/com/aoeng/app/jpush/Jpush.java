package com.aoeng.app.jpush;

import java.util.HashMap;

import com.alibaba.fastjson.JSONObject;

import cn.jpush.api.JPushClient;
import cn.jpush.api.common.APIRequestException;

public class Jpush {

	public static void main(String[] args) throws Exception, APIRequestException {
		String masterSecret = "2e42e589c49594e4507f73b7";
		String appKey = "ab5429e6e1b8036167c2f00f";
		JPushClient client = new JPushClient(masterSecret, appKey);
		// client.sendMessageAll("hello");
		JSONObject json = new JSONObject();
		json.put("opt", 1);
		json.put("result", "result");
		json.put("time",System.currentTimeMillis());
		HashMap<String, String> extras = new HashMap<String, String>();
		System.out.println(json.toJSONString());
		extras.put("optStr", json.toJSONString());
		client.sendAndroidNotificationWithAlias(null, "", extras, "123456789");
		// client.sendAndroidNotificationWithAlias(title, alert, extras, alias)
		;
	}

}
