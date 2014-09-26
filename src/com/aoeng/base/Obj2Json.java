package com.aoeng.base;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import net.sf.json.JSONArray;

public class Obj2Json {

	public static void main(String[] args) {
		List<Date> list = new ArrayList<>();
		list.add(new Date(System.currentTimeMillis() - 100));
		list.add(new Date(System.currentTimeMillis() - 120));
		list.add(new Date(System.currentTimeMillis() - 150));
		list.add(new Date(System.currentTimeMillis() - 170));

		System.out.println(JSONArray.fromObject(list).toString());
	}

}
