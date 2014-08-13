/**
 * 
 */
package com.aoeng.base.database.sqlite;

import java.util.LinkedList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * @author Aoeng @email<zhangshch2008@gmail.com>
 * @DateTime Jan 30, 2013 9:53:08 AM
 * @Program Upop
 * @Version 1.0
 */
public class HtmlParser {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		int i = 0;
		String spec = "http://www.stats.gov.cn/tjbz/cxfldm/2012/";
		List<City> proList = getProvinceList(spec);
		System.out.println(proList.toString());
		List<City> cityList = null;
		List<City> areaList = null;
		List<City> townList = null;
		List<City> villageList = null;
		City city = null;
		for (int j = 0; j < proList.size(); j++) {
			city = proList.get(j);
			System.out.println(city.toString());
			String proUrl = city.getHref();
			cityList = getCityList(spec + proUrl);
			// System.out.println("城市地址" + spec + proUrl);
			for (City city2 : cityList) {
				String cityUrl = city2.getHref();
				// System.out.println(cityUrl + city2.toString());
				areaList = getAreaList(spec + cityUrl);
				// System.out.println("县区地址" + spec + cityUrl);
				for (City city3 : areaList) {
					String areaUrl = city3.getHref();
					if ("".equals(areaUrl.trim())) {
						continue;
					}

					String nsp = spec + proUrl.substring(0, 2) + "/" + areaUrl;
					// System.out.println("乡镇地址" + nsp);
					if ("http://www.stats.gov.cn/tjbz/cxfldm/2012/14/05/140501.html"
							.equals(nsp)) {
						continue;
					}
					if ("http://www.stats.gov.cn/tjbz/cxfldm/2012/35/05/350527.html"
							.equals(nsp)) {
						continue;
					}
					townList = getTownList(nsp);
					// System.out.println("乡镇地址 " + nsp);
					i++;
					if (i % 1000 == 0) {
						System.out.println(i + townList.get(0).toString());
					}
					/*
					 * for (City city4 : townList) { String townUrl =
					 * city4.getHref(); String villageGetUrl = spec +
					 * proUrl.substring(0, 2) + "/" + areaUrl.substring(0, 3) +
					 * townUrl; // System.out.println("村委地址" + villageGetUrl);
					 * if (
					 * "http://www.stats.gov.cn/tjbz/cxfldm/2012/13/01/03/130103007.html"
					 * .equals(villageGetUrl)) { continue; } i++ ; if (i%1000 ==
					 * 0) { System.out.println(i); } villageList =
					 * getVillageList(villageGetUrl); for (City city5 :
					 * villageList) { String villageUrl = city5.getHref(); //
					 * System.out.println(villageUrl + city5.toString()); i++ ;
					 * if (i % 1000 ==0) { System.out.println(i); } } }
					 */
				}
			}
		}
		long end = System.currentTimeMillis();
		System.out.println((end - start) / 1000 + "s" + i);
		// getVillageList("http://www.stats.gov.cn/tjbz/cxfldm/2012/23/12/21/231221209.html");
	}

	/**
	 * @throws Exception
	 * 
	 */
	private static void test1() throws Exception {
		// TODO Auto-generated method stub
		// Map<String, City> proMap = getProvinceMap(spec);
		// Map<String, City> cityMap = null;
		// Map<String, City> villageMap = null;
		// Map<String, City> villageMap2 = new LinkedHashMap<String, City>();
		// for (Entry<String, City> proEntry : proMap.entrySet()) {
		// // System.out.println(proEntry.getKey());
		// String proUrl = proEntry.getKey();
		// cityMap = getCityMap(spec + proUrl);
		// for (Entry<String, City> cityEntry : cityMap.entrySet()) {
		// // System.out.println(cityEntry.getKey());
		// String cityUrl = cityEntry.getKey();
		// Map<String, City> areaMap = getAreaMap(spec + cityUrl);
		// for (Entry<String, City> entry : areaMap.entrySet()) {
		// // System.out.println(entry.getKey() +
		// // entry.getValue().toString());
		// String areaUrl = entry.getKey();
		// if ("".equals(areaUrl.trim())) {
		// continue;
		// }
		// String str = areaUrl.substring(areaUrl.lastIndexOf("/") + 1,
		// areaUrl.lastIndexOf("/") + 3) + "/";
		// String newSpes = spec + str + areaUrl;
		// if
		// ("http://www.stats.gov.cn/tjbz/cxfldm/2012/14/05/140501.html".equals(newSpes))
		// {
		// continue;
		// }
		// if
		// ("http://www.stats.gov.cn/tjbz/cxfldm/2012/35/05/350527.html".equals(newSpes))
		// {
		// continue;
		// }
		// Map<String, City> townMap = getTownMap(newSpes);
		// for (Entry<String, City> townEntry : townMap.entrySet()) {
		// String str1 = townEntry.getKey();
		// String str2 = str1.substring(str1.indexOf("/") + 1, str1.indexOf("/")
		// + 5);
		// String newSpecs = spec + str2.substring(0, 2) + "/" +
		// str2.substring(2) + "/" + str1;
		// System.out.println(newSpecs);
		// if
		// ("http://www.stats.gov.cn/tjbz/cxfldm/2012/13/01/03/130103007.html".equals(newSpecs))
		// {
		// continue;
		// }
		// villageMap = getVillageMap(newSpecs);
		// for (Entry<String, City> entry2 : villageMap.entrySet()) {
		// villageMap2.put(townEntry.getKey(), entry2.getValue());
		// }
		// villageMap = null;
		// }
		// }
		// }
		// }

		// 81/131181100.html
		// http://www.stats.gov.cn/tjbz/cxfldm/2012/13/11/81/131181100.html

		// Map<String, City> townMap =
		// getTownMap("http://www.stats.gov.cn/tjbz/cxfldm/2012/61/03/610326.html");
		// for (Entry<String, City> entry : townMap.entrySet()) {
		// System.out.println(entry.getKey() + entry.getValue());
		// }
		// Map<String, City> villageMap =
		// getVillageMap("http://www.stats.gov.cn/tjbz/cxfldm/2012/61/03/26/610326100.html");
	}

	/**
	 * @param string
	 * @return
	 * @throws Exception
	 */
	public static LinkedList<City> getVillageList(String spec) throws Exception {
		LinkedList<City> list = new LinkedList<City>();
		Document doc = Jsoup.connect(spec).get();
		String title = new String(doc.title());
		// System.out.println(title);
		Elements elements = doc.select("tr.villagetr");
		/**
		 * <tr class="countytr">
		 * <td>330301000000</td>
		 * <td>市辖区</td>
		 * </tr>
		 * <tr class="countytr">
		 * <td><a href="03/330302.html">330302000000</a></td>
		 * <td><a href="03/330302.html">鹿城区</a></td>
		 * </tr>
		 */
		// System.out.println(elements);
		int i = 0;
		for (Element element : elements) {
			i++;

			// String value = element.select("td").text();
			String href = element.select("td").select("a").attr("href");
			String[] value = element.select("td").text().split(" ");
			// System.out.println("href----->" + href + "value---->" + value[0]
			// + ":" + value[1] + ":" + value[2]);
			;
			City city = new City(href, null, value[0], value[2]);
			list.add(city);
		}
		// System.out.print(i);
		return list;
	}

	/**
	 * @param string
	 * @return
	 * @throws Exception
	 */
	public static LinkedList<City> getTownList(String spec) throws Exception {
		LinkedList<City> list = new LinkedList<City>();
		Document doc = Jsoup.connect(spec).get();
		String title = new String(doc.title());
		// System.out.println(title);
		Elements elements = doc.select("tr.towntr");
		// System.out.println(elements);
		for (Element element : elements) {

			// String value = element.select("td").text();
			String href = element.select("td").select("a").attr("href");
			String[] value = element.select("td").text().split(" ");
			// System.out.println("href----->" + href + "value---->" + value[0]
			// + ":" + value[1]);
			City city = new City(href, null, value[0], value[1]);
			list.add(city);
		}
		return list;
	}

	/**
	 * @param string
	 * @return
	 * @throws Exception
	 */
	public static LinkedList<City> getAreaList(String spec) throws Exception {
		LinkedList<City> list = new LinkedList<City>();
		Document doc = Jsoup.connect(spec).get();
		String title = new String(doc.title());
		// System.out.println(title);
		Elements elements = doc.select("tr.countytr");
		/**
		 * <tr class="countytr">
		 * <td>330301000000</td>
		 * <td>市辖区</td>
		 * </tr>
		 * <tr class="countytr">
		 * <td><a href="03/330302.html">330302000000</a></td>
		 * <td><a href="03/330302.html">鹿城区</a></td>
		 * </tr>
		 */
		// System.out.println(elements);
		int i = 0;
		for (Element element : elements) {
			i++;

			// String value = element.select("td").text();
			String href = element.select("td").select("a").attr("href");
			String[] value = element.select("td").text().split(" ");
			// System.out.println("href----->" + href + "value---->" + value[0]
			// + ":" + value[1]);
			;
			City city = new City(href, null, value[0], value[1]);
			list.add(city);
		}
		// System.out.print(i);
		return list;
	}

	/**
	 * @param string
	 * @return
	 * @throws Exception
	 */
	public static LinkedList<City> getCityList(String spec) throws Exception {
		LinkedList<City> list = new LinkedList<City>();
		Document doc = Jsoup.connect(spec).get();
		String title = new String(doc.title());
		// System.out.println(title);
		Elements elements = doc.select("tr.citytr");

		/**
		 * <tr class="citytr">
		 * <td><a href="11/1101.html">110100000000</a></td>
		 * <td><a href="11/1101.html">市辖区</a></td>
		 * </tr>
		 * <tr class="citytr">
		 * <td><a href="11/1102.html">110200000000</a></td>
		 * <td><a href="11/1102.html">县</a></td>
		 * </tr>
		 */
		// System.out.println(elements);
		int i = 0;
		for (Element element : elements) {
			String href = element.select("td").select("a").attr("href");
			String[] value = element.select("td").select("a").text().split(" ");
			// System.out.println("href----->" + href + "value---->" + value[0]
			// + ":" + value[1]);
			;
			i++;
			City city = new City(href, null, value[0], value[1]);
			list.add(city);
		}
		// System.out.println(i);
		return list;
	}

	/**
	 * @return
	 * @throws Exception
	 */
	public static LinkedList<City> getProvinceList(String spec)
			throws Exception {
		// TODO Auto-generated method stub
		long start = System.currentTimeMillis();
		LinkedList<City> list = new LinkedList<City>();
		Document doc = Jsoup.connect(spec).get();
		String title = new String(doc.title());
		// System.out.println(title);
		Elements elements = doc.select("tr.provincetr").select("a");
		// System.out.println(elements);
		int i = "110101000000".length();
		for (Element element : elements) {
			i++;
			// "110101000000";
			String href = element.attributes().get("href");
			String value = element.text();
			String str = href.substring(0, href.indexOf("."));
			if (str.length() < i) {
				str += "0000000000";
			}
			City city = new City(href, null, str, value);
			list.add(city);
		}
		System.out.println("province Parser OK !prolist.size---->"
				+ list.size() + "time----->"
				+ (System.currentTimeMillis() - start) / 1000.00 + "s");
		return list;
	}

}
