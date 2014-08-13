package com.aoeng.data.fastjson;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

public class AddressJson extends TestCase {
	public void test10() {
		for (int i = 0; i < 100; i++) {
			test();
			System.out.println();
		}
	}

	public void test() {
		long start = System.currentTimeMillis();
		for (int i = 0; i < 100; i++) {
			test02();
		}
		System.out.print(System.currentTimeMillis() - start);
		System.out.print("\t");
		long start2 = System.currentTimeMillis();
		for (int i = 0; i < 10; i++) {
			test03();
		}
		System.out.print(System.currentTimeMillis() - start2);
	}

	public void test02() {
		String filePath = "area1.txt";
		try {
			FileInputStream inputStream = new FileInputStream(
					new File(filePath));
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					inputStream));
			String str = "";
			long strat = System.currentTimeMillis();
			StringBuffer buffer = new StringBuffer();
			while ((str = reader.readLine()) != null) {
				buffer.append(str);
			}
			List<Area> area = JSONArray.parseArray(buffer.toString(),
					Area.class);
			// System.out.println(area2.toString());
			// System.out.println("areas2.size()" + area.size());
			long end = System.currentTimeMillis();
			// System.out.println(end - strat);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void test01() {
		try {
			FileInputStream inputStream = new FileInputStream(
					new File(
							"/home/paynet/androidWork/workspace130105/J2SE/src/com/aoeng/fastjson/area.txt"));
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					inputStream));
			String str = "";
			long strat = System.currentTimeMillis();
			StringBuffer buffer = new StringBuffer();
			List<Area> areas = new ArrayList<Area>();
			Area area = null;
			while ((str = reader.readLine()) != null) {
				// buffer.append(str).append("\n");
				String[] strs = str.split(",");
				areas.add(new Area(strs[0], strs[1], strs[2], strs[3], strs[4],
						strs[5]));
			}
			// long end = System.currentTimeMillis();
			// System.out.println(buffer.toString());
			for (Area area2 : areas) {
				// System.out.println(area2.toString());
			}
			reader.close();
			inputStream.close();
			long end = System.currentTimeMillis();
			System.out.println(end - strat);

			StringBuffer json = new StringBuffer(JSON.toJSONString(areas));
			// System.out.println(json.toString());
			FileWriter fileWriter = new FileWriter(
					new File(
							"/home/paynet/androidWork/workspace130105/J2SE/src/com/aoeng/fastjson/area1.txt"));
			fileWriter.write(json.toString());
			fileWriter.flush();
			fileWriter.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void test03() {
		try {
			FileInputStream inputStream = new FileInputStream(
					new File(
							"/home/paynet/androidWork/workspace130105/J2SE/src/com/aoeng/fastjson/area.txt"));
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					inputStream));
			String str = "";
			long strat = System.currentTimeMillis();
			StringBuffer buffer = new StringBuffer();
			List<Area> areas = new ArrayList<Area>();
			Area area = null;
			StringBuffer buffer2 = new StringBuffer();
			while ((str = reader.readLine()) != null) {
				// buffer.append(str).append("\n");
				String[] strs = str.split(",");
				areas.add(new Area(strs[0], strs[1], strs[2], strs[3], strs[4],
						strs[5]));
				if (!str.contains("其他")) {
					buffer2.append(str).append("\n");
				}
			}
			FileWriter fileWriter = new FileWriter(
					new File(
							"/home/paynet/androidWork/workspace130105/J2SE/src/com/aoeng/fastjson/area3.txt"));
			fileWriter.write(buffer2.toString());
			fileWriter.flush();
			fileWriter.close();
			// System.out.println(areas.size());
			long end = System.currentTimeMillis();
			// System.out.println(end - strat);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
