package com.aoeng.tools.json;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aoeng.base.bean.KeyValue;

public class FastJson {

	public static void main(String[] args) {
		List<KeyValue> list = new ArrayList<KeyValue>();
		list.add(new KeyValue(0, "key", "value", new Date(), true, 324234.45f, 34534543.453454, 'C', 454353));
		list.add(new KeyValue(1, "key", "value", new Date(), true, 324234.45f, 34534543.453454, 'C', 454353));
		list.add(new KeyValue(2, "key", "value", new Date(), true, 324234.45f, 34534543.453454, 'C', 454353));
		String json = JSON.toJSONString(list);
//		System.out.println(json);

		String str = "{\"enable\":1,\"off_time\":\"--:--\",\"on_time\":\"12:39\",\"repeat\":0}";
		System.out.println(str);
		String st = str.replaceAll("\\", "");
		System.out.println(st);
		
		
		
	}
}
