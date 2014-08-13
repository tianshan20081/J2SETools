/**
 * 
 */
package com.aoeng.base.database.sqlite;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

import com.aoeng.base.mail.Email;

/**
 * @author Aoeng @email<zhangshch2008@gmail.com>
 * @DateTime Jan 30, 2013 11:45:53 AM
 * @Program Upop
 * @Version 1.0
 */
public class AddressUtils {
	private static String dataUrl = "jdbc:sqlite://home/paynet/Study/sql/address.db";
	private static long itemCounts;
	private static long begin;
	private static java.util.Date startInsertDate;

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) {
		try {
			// System.out.println(areaFlag);
			long start = System.currentTimeMillis();
			System.out.println("开始解析 省份解析中。。。" + new Date(start).toLocaleString());
			// 解析省份
			 boolean insertValueToProvince = insertValueToProvince();
			System.out.println((System.currentTimeMillis() - start) / 1000.00 + "s Province is OK !" + new Date(start).toLocaleString());
			// 解析 城市
			 boolean cityFlag = cityTable(getCityList());
			System.out.println((System.currentTimeMillis() - start) / 1000.00 + "s City is OK !" + new Date(start).toLocaleString());
			// 解析 县区
			 boolean areaFlag = areaTable(getAreaList());
			System.out.println((System.currentTimeMillis() - start) / 1000.00 + "s Area is OK !" + new Date(start).toLocaleString());
			// 解析 乡镇
			 boolean townFlag2 = townFlag2(townFlag());
			System.out.println((System.currentTimeMillis() - start) / 1000.00 + "s Town is OK !" + new Date(start).toLocaleString());
			// 解析乡村

			boolean villageFlag = villageFlag();
			System.out.println((System.currentTimeMillis() - start) / 1000.00 + "s Village is OK !" + new Date(start).toLocaleString());
			// System.out.println(villageFlag);
			long end = System.currentTimeMillis();

			System.out.println("解析+添加共耗时+" + (end - start) / 1000.00);
			System.out.println("解析完毕" + new Date(System.currentTimeMillis()) + new Date(start).toLocaleString());

			Email.send("数据添加完毕" + new Date(System.currentTimeMillis()).toLocaleString());
		} catch (Exception e) {
			Email.send("网页爬虫－程序挂了" + e.toString() + new Date(System.currentTimeMillis()).toLocaleString());

			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @return 县区列表
	 * @throws Exception
	 */
	private static List<City> getAreaList() throws Exception {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		String spec = "http://www.stats.gov.cn/tjbz/cxfldm/2012/";
		List<City> proList = HtmlParser.getProvinceList(spec);
		List<City> cityList = null;
		List<City> areaList = null;
		List<City> list = new LinkedList<City>();
		for (City city : proList) {
			// System.out.println(city.toString());
			String proUrl = city.getHref();
			cityList = HtmlParser.getCityList(spec + proUrl);
			System.out.println("省份 ：" + city.getName());
			for (City city2 : cityList) {
				String cityUrl = city2.getHref();
				// System.out.println(cityUrl + city2.toString());
				areaList = HtmlParser.getAreaList(spec + cityUrl);
				for (City city3 : areaList) {
					list.add(new City(null, city2.getId(), city3.getId(), city3.getName()));
				}
			}
		}
		System.out.println("解析完毕" + (System.currentTimeMillis() - start) / 1000.00 + "s:共有 " + list.size() + "县区");
		return list;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	private static List<City> getCityList() throws Exception {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		String spec = "http://www.stats.gov.cn/tjbz/cxfldm/2012/";
		// /11.html
		if (!DBServices.createCityTable(dataUrl)) {
			return null;
		}
		List<City> proList = HtmlParser.getProvinceList(spec);
		List<City> cityList = null;
		List<City> cities = new LinkedList<City>();
		for (City entry : proList) {
			String proid = entry.getId();
			System.out.println(entry.getName() + "Province");
			String proUrl = entry.getHref();
			cityList = HtmlParser.getCityList(spec + proUrl);
			// System.out.println("城市地址" + spec + proUrl);
			for (City city : cityList) {
				cities.add(new City(null, proid, city.getId(), city.getName()));
			}

		}
		System.out.println("City 解析完毕" + (System.currentTimeMillis() - start) / 1000.00 + "s:共有 " + cities.size() + "城市");
		return cities;
	}

	/**
	 * @param map
	 * @return
	 */
	private static boolean townFlag2(List<City> list) {
		// TODO Auto-generated method stub
		String dataUrl = "jdbc:sqlite://home/paynet/AndroidDev/Address/add.db";
		if (!DBServices.createTownTable(dataUrl)) {
			return false;
		}
		DBServices.insertListToTown(list);
		return true;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	private static boolean villageFlag() throws Exception {
		// TODO Auto-generated method stub
		String spec = "http://www.stats.gov.cn/tjbz/cxfldm/2012/";
		// /11.html
		// 创建　乡村　表
		if (!DBServices.createVillageTable(dataUrl)) {
			return false;
		}
		long start = System.currentTimeMillis();
		java.util.Date startDate = new java.util.Date();
		Email.send("数据开始解析－－－－乡村，现在时间" + startDate.toLocaleString());
		List<City> list = villageMap2();
		long parserOK = System.currentTimeMillis();
		java.util.Date parserOKDate = new java.util.Date();
		System.out.println("数据解析完毕 Village" + (parserOK - start) / 1000 + "s 共" + list.size() + "条数据,已经开始添加数据");
		Email.send("数据解析完毕，共" + list.size() + "条数据，耗时" + (parserOK - start) / 1000 + "s,现在已经开始数据添加,开始解析时间－－－－－当前时间：" + startDate.toLocaleString() + "----" + parserOKDate.toLocaleString());
		LinkedList<City> cities = new LinkedList<City>();
		long startInsert = System.currentTimeMillis();
		startInsertDate = new java.util.Date();
		for (City city : list) {
			itemCounts++;
			cities.add(city);
			if (itemCounts % 10000 == 0) {
				DBServices.insertMapToVillage(cities);
				cities = null;
				cities = new LinkedList<City>();
				new Thread(new Runnable() {
					@Override
					public void run() {
						// TODO Auto-generated method stub
						Email.send("已经添加数据" + itemCounts + "条，耗时" + (System.currentTimeMillis() - begin) / 1000.00 + "s,开始添加数据时间：现在时间：添加条目数" + startInsertDate.toLocaleString() + ":"
								+ new java.util.Date().toLocaleString());
					}
				}).start();

				begin = System.currentTimeMillis();
				startInsertDate = new java.util.Date();
			}
		}
		// 添加剩余的条目数
		DBServices.insertMapToVillage(cities);
		long end = System.currentTimeMillis();
		System.out.println("数据添加完毕,开始解析时间：开始添加时间：现在时间：" + new java.util.Date().toLocaleString());
		StringBuffer buffer = new StringBuffer("数据添加完毕,开始解析时间：开始添加时间：现在时间：");
		buffer.append("\n");
		buffer.append(startDate.toLocaleString()).append(":");
		buffer.append(parserOKDate.toLocaleString()).append(":");
		buffer.append(new java.util.Date().toLocaleString()).append(".");
		Email.send(buffer.toString());
		return true;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	private static List<City> villageMap() throws Exception {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		long parserTime = 0l;
		long inserTime = 0l;
		long villageSize = 0l;
		boolean flag = false;

		String spec = "http://www.stats.gov.cn/tjbz/cxfldm/2012/";
		List<City> proList = HtmlParser.getProvinceList(spec);
		List<City> cityList = null;
		List<City> areaList = null;
		List<City> townList = null;
		List<City> villageList = null;
		int i = 0;
		List<City> list = null;
		for (City city : proList) {
			list = new LinkedList<City>();

			System.out.println(city.getName() + "村委会。开始解析中");
			long parserStart = System.currentTimeMillis();
			String proUrl = city.getHref();
			cityList = HtmlParser.getCityList(spec + proUrl);
			// System.out.println("城市地址" + spec + proUrl);
			for (City city2 : cityList) {
				String cityUrl = city2.getHref();
				// System.out.println(cityUrl + city2.toString());
				areaList = HtmlParser.getAreaList(spec + cityUrl);
				// System.out.println("县区地址" + spec + cityUrl);
				for (City city3 : areaList) {
					String areaUrl = city3.getHref();
					if ("".equals(areaUrl.trim())) {
						continue;
					}
					// System.out.println(areaUrl + city3.toString());
					String nsp = spec + proUrl.substring(0, 2) + "/" + areaUrl;
					if ("http://www.stats.gov.cn/tjbz/cxfldm/2012/14/05/140501.html".equals(nsp)) {
						continue;
					}
					if ("http://www.stats.gov.cn/tjbz/cxfldm/2012/14/05/140501.html".equals(nsp)) {
						continue;
					}
					if ("http://www.stats.gov.cn/tjbz/cxfldm/2012/35/05/350527.html".equals(nsp)) {
						continue;
					}
					townList = HtmlParser.getTownList(nsp);
					// System.out.println("乡镇地址 " + nsp);
					for (City city4 : townList) {
						String townUrl = city4.getHref();
						String villageUrl = spec + proUrl.substring(0, 2) + "/" + areaUrl.substring(0, 3) + townUrl;
						System.out.println("村委地址" + villageUrl);

						if ("http://www.stats.gov.cn/tjbz/cxfldm/2012/13/01/03/130103007.html".equals(villageUrl)) {
							continue;
						}
						if ("http://www.stats.gov.cn/tjbz/cxfldm/2012/13/01/08/130108004.html".equals(villageUrl)) {
							continue;
						}
						if ("http://www.stats.gov.cn/tjbz/cxfldm/2012/13/03/02/130302012.html".equals(villageUrl)) {
							continue;
						}
						if ("http://www.stats.gov.cn/tjbz/cxfldm/2012/13/07/29/130729204.html".equals(villageUrl)) {
							continue;
						}
						if ("http://www.stats.gov.cn/tjbz/cxfldm/2012/14/05/21/140521203.html".equals(villageUrl)) {
							continue;
						}
						if ("http://www.stats.gov.cn/tjbz/cxfldm/2012/21/01/02/210102021.html".equals(villageUrl)) {
							continue;
						}

						villageList = HtmlParser.getVillageList(villageUrl);
						for (City city5 : villageList) {
							list.add(new City(null, city4.getId(), city5.getId(), city5.getName()));
							i++;
							if (i <= 162500) {
								list = null;
								list = new LinkedList<City>();
								continue;
							}
							flag = true;
							if (i % 500 == 0) {
								System.out.println(i + new java.util.Date().toLocaleString());
								DBServices.insertMapToVillage(list);
								list = null;
								list = new LinkedList<City>();
							}
						}
					}
				}
			}

			long insertStart = System.currentTimeMillis();
			parserTime += (insertStart - parserStart);
			System.out.println(city.getName() + "数据解析耗时" + (insertStart - parserStart) / 1000.00 + "条目数" + list.size() + "数据添加中。。。");
			villageSize += list.size();
			if (flag) {
				DBServices.insertMapToVillage(list);
			}

			long insertFinfish = System.currentTimeMillis();
			inserTime += (insertFinfish - insertStart);
			System.out.println(city.getName() + "数据添加时间" + (insertFinfish - insertStart) / 1000.00);
			inserTime += (insertFinfish - insertStart);
			list = null;
		}
		long end = System.currentTimeMillis();
		System.out.println("村委共耗时 " + "解析耗时" + (end - start) / 1000 + "数据条目" + villageSize);
		System.out.println("数据解析共耗时" + parserTime / 1000.00 + "数据添加共耗时" + inserTime / 1000.00);
		return list;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	private static List<City> villageMap2() throws Exception {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		long parserTime = 0l;
		long inserTime = 0l;
		long villageSize = 0l;
		boolean flag = false;

		String spec = "http://www.stats.gov.cn/tjbz/cxfldm/2012/";
		LinkedList<City> proList = HtmlParser.getProvinceList(spec);
		LinkedList<City> cityList = null;
		LinkedList<City> areaList = null;
		LinkedList<City> townList = null;
		LinkedList<City> villageList = null;
		int i = 0;
		List<City> list = new LinkedList<City>();
		for (City city : proList) {
			System.out.println(city.getName() + "村委会。开始解析中");
			long parserStart = System.currentTimeMillis();
			String proUrl = city.getHref();
			cityList = HtmlParser.getCityList(spec + proUrl);
			// System.out.println("城市地址" + spec + proUrl);
			for (City city2 : cityList) {
				String cityUrl = city2.getHref();
				// System.out.println(cityUrl + city2.toString());
				areaList = HtmlParser.getAreaList(spec + cityUrl);
				// System.out.println("县区地址" + spec + cityUrl);
				for (City city3 : areaList) {
					String areaUrl = city3.getHref();
					if ("".equals(areaUrl.trim())) {
						continue;
					}
					// System.out.println(areaUrl + city3.toString());
					String nsp = spec + proUrl.substring(0, 2) + "/" + areaUrl;
					if ("http://www.stats.gov.cn/tjbz/cxfldm/2012/14/05/140501.html".equals(nsp)) {
						continue;
					}
					if ("http://www.stats.gov.cn/tjbz/cxfldm/2012/14/05/140501.html".equals(nsp)) {
						continue;
					}
					if ("http://www.stats.gov.cn/tjbz/cxfldm/2012/35/05/350527.html".equals(nsp)) {
						continue;
					}
					townList = HtmlParser.getTownList(nsp);
					// System.out.println("乡镇地址 " + nsp);
					for (City city4 : townList) {
						String townUrl = city4.getHref();
						String villageUrl = spec + proUrl.substring(0, 2) + "/" + areaUrl.substring(0, 3) + townUrl;
						// System.out.println("村委地址" + villageUrl);

						if ("http://www.stats.gov.cn/tjbz/cxfldm/2012/13/03/02/130302012.html".equals(villageUrl)) {
							continue;
						}
						if ("http://www.stats.gov.cn/tjbz/cxfldm/2012/14/05/21/140521203.html".equals(villageUrl)) {
							continue;
						}
						if ("http://www.stats.gov.cn/tjbz/cxfldm/2012/21/01/02/210102021.html".equals(villageUrl)) {
							continue;
						}
						if ("http://www.stats.gov.cn/tjbz/cxfldm/2012/13/01/03/130103007.html".equals(villageUrl)) {
							// continue;
						}
						if ("http://www.stats.gov.cn/tjbz/cxfldm/2012/13/07/29/130729204.html".equals(villageUrl)) {
							// continue;
						}

						villageList = HtmlParser.getVillageList(villageUrl);
						for (City city5 : villageList) {
							list.add(new City(null, city4.getId(), city5.getId(), city5.getName()));
							i++;
							if (i % 10000 == 0) {
								System.out.println(i + new java.util.Date().toLocaleString() + "list.size()" + list.size());
								System.out.println();
							}
						}
					}
				}
			}
		}
		System.out.println(list.size());
		return list;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	private static List<City> townFlag() throws Exception {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		String spec = "http://www.stats.gov.cn/tjbz/cxfldm/2012/";
		List<City> proList = HtmlParser.getProvinceList(spec);
		List<City> cityList = null;
		List<City> areaList = null;
		List<City> townList = null;
		List<City> list = new LinkedList<City>();
		for (City city : proList) {
			System.out.println(city.toString());
			String proUrl = city.getHref();
			cityList = HtmlParser.getCityList(spec + proUrl);
			System.out.println("城市地址" + city.getName());
			for (City city2 : cityList) {
				String cityUrl = city2.getHref();
				// System.out.println(cityUrl + city2.toString());
				areaList = HtmlParser.getAreaList(spec + cityUrl);
				// System.out.println("县区地址" + spec + cityUrl);
				for (City city3 : areaList) {
					String areaUrl = city3.getHref();
					if ("".equals(areaUrl.trim())) {
						continue;
					}
					// System.out.println(areaUrl + city3.toString());
					String nsp = spec + proUrl.substring(0, 2) + "/" + areaUrl;
					if ("http://www.stats.gov.cn/tjbz/cxfldm/2012/14/05/140501.html".equals(nsp)) {
						continue;
					}
					if ("http://www.stats.gov.cn/tjbz/cxfldm/2012/35/05/350527.html".equals(nsp)) {
						continue;
					}
					townList = HtmlParser.getTownList(nsp);
					for (City city4 : townList) {
						list.add(new City(null, city3.getId(), city4.getId(), city4.getName()));
					}
				}
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("Parser Town OK " + list.size() + "解析耗时" + (end - start) / 1000);
		return list;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	private static boolean areaTable(List<City> list) throws Exception {
		// TODO Auto-generated method stub
		if (!DBServices.createAreaTable(dataUrl)) {
			return false;
		}
		DBServices.insertMapToArea(list);
		return true;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	private static boolean cityTable(List<City> list) throws Exception {
		// TODO Auto-generated method stub
		if (!DBServices.createCityTable(dataUrl)) {
			return false;
		}
		DBServices.insertMapToCity(list);
		return true;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	private static boolean insertValueToProvince() throws Exception {
		// TODO Auto-generated method stub
		String spec = "http://www.stats.gov.cn/tjbz/cxfldm/2012";
		List<City> map = HtmlParser.getProvinceList(spec);
		if (!DBServices.createProTable(dataUrl)) {
			return false;
		}
		boolean inserProvince = DBServices.insertMapToProvince(dataUrl, map);
		System.out.println(inserProvince);
		return true;
	}

}
