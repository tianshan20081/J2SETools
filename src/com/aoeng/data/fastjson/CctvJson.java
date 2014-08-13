package com.aoeng.data.fastjson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.alibaba.fastjson.JSONArray;

public class CctvJson {

	public static void main(String[] args) {

		List<Category1> category1s = getCategorys();
		test01(category1s);
		// test02(category1s);
	}

	private static void test02(List<Category1> list) {
		// TODO Auto-generated method stub
		int j = 0;
		Map<Integer, Map<Integer, Map<Integer, Category1>>> map = new HashMap<Integer, Map<Integer, Map<Integer, Category1>>>();
		if (null != list && list.size() != 0) {
			Map<Integer, Map<Integer, Category1>> map2 = new HashMap<Integer, Map<Integer, Category1>>();
			j++;
			for (Category1 category1 : list) {
				int n = 0;
				// 第一层
				List<Category1> list2 = category1.getCommCategoryDtos();
				if (null != list2 && list2.size() != 0) {

					// Map<Integer, Category1> map3 = new HashMap<Integer,
					// Category1>();
					for (Category1 category12 : list2) {
						// 第二层
						List<Category1> list3 = category12
								.getCommCategoryDtos();
						Map<Integer, Category1> map3 = new HashMap<Integer, Category1>();
						int m = 0;
						if (null != list3 && list3.size() != 0) {
							for (Category1 category13 : list3) {
								map3.put(
										m++,
										new Category1(category13
												.getCategoryId(), category13
												.getName()));
							}
						}
						map2.put(n++, map3);
					}

				}
				map.put(j++, map2);
			}

		}
		System.out.println(map.size());

		for (Entry<Integer, Map<Integer, Map<Integer, Category1>>> category1 : map
				.entrySet()) {

		}
	}

	private static void test01(List<Category1> category1s) {
		// TODO Auto-generated method stub
		Map<String, List<Category1>> map = new HashMap<String, List<Category1>>();
		List<Category1> firstList = new ArrayList<Category1>();
		int i = 0;
		for (Category1 catf : category1s) {
			firstList.add(new Category1(catf.getCategoryId(), catf.getName()));
			// System.out.println(catf.getCategoryId() + catf.getName());
			String firstId = catf.getCategoryId();
			// 第一级
			List<Category1> list2 = catf.getCommCategoryDtos();
			List<Category1> secondList = new ArrayList<Category1>();
			if (null != list2) {

				for (Category1 category12 : list2) {
					secondList.add(new Category1(category12.getCategoryId(),
							category12.getName()));
					// 第二级
					List<Category1> list3 = category12.getCommCategoryDtos();
					List<Category1> thirdList = new ArrayList<Category1>();
					String secondId = category12.getCategoryId();
					if (null != list3) {
						for (Category1 category13 : list3) {
							// 第三极
							thirdList.add(new Category1(category13
									.getCategoryId(), category13.getName()));
							// System.out.println(category13.toString());
						}
					}
					map.put(secondId, thirdList);
				}
			}
			map.put(firstId, secondList);
		}
		map.put(i + "", firstList);
		List<Category1> list2 = map.get("0");
		for (Category1 category1 : list2) {
			System.out.println(category1.getCategoryId() + category1.getName());
			List<Category1> list3 = map.get(category1.getCategoryId());
			for (Category1 category12 : list3) {
				System.out.println("----" + category12.getCategoryId()
						+ category12.getName());
				List<Category1> list4 = map.get(category12.getCategoryId());
				for (Category1 category13 : list4) {
					System.out.println("--------" + category13.getCategoryId()
							+ category13.getName());
				}
			}

		}
	}

	private static List<Category1> getCategorys() {
		// TODO Auto-generated method stub
		String pathname = "/home/paynet/androidWork/workspace130105/J2SE/src/com/aoeng/fastjson/zhongshi.txt";
		List<Category1> list = null;
		try {
			FileInputStream inputStream = new FileInputStream(
					new File(pathname));
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					inputStream));
			String str = "";
			StringBuffer buffer = new StringBuffer();
			while ((str = reader.readLine()) != null) {
				buffer.append(str.trim());
			}
			list = JSONArray.parseArray(buffer.toString(), Category1.class);
			reader.close();
			inputStream.close();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
}
