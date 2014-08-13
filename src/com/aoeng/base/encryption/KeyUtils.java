package com.aoeng.base.encryption;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;


public class KeyUtils {

	private static final String TAG = KeyUtils.class.getName().toUpperCase();

	public static String getMD5String(String string) {
		Md5 md51 = new Md5("");
		byte b1[] = null;
		try {
			md51.hmac_Md5(string, "test");
			b1 = md51.getDigest();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return Md5.stringify(b1);
	}

	// public static String createOrderID(String mid) {
	// String date1 = getDateStringByPattern(new Date(), "yyyyMMddHHmmss");
	// String date2 = getDateStringByPattern(new Date(), "yyyyMMdd");
	// Random rand = new Random();
	// String bicker = "000001";
	// String rom = Integer.toString(Math.abs(rand.nextInt(10000)));
	// return date2 + "-" + mid + "-" + date1 + "-" + bicker + "-" + rom;
	// }

	public static String createOrderID(String mid) {
		String date1 = getDateStringByPattern(new Date(), "yyyyMMddHHmmss");
		String date2 = getDateStringByPattern(new Date(), "yyyyMMdd");
		Random rand = new Random();
		String bicker = "000001";
		String rom = Integer.toString(Math.abs(rand.nextInt(10000)));
		SimpleDateFormat format = new SimpleDateFormat("HHmmssSSS");
		return date2 + "-" + mid + "-" + format.format(new Date());
	}

	private static String getDateStringByPattern(Date date, String pattern) {
		// TODO Auto-generated method stub
		if (date == null) {
			return "";
		}
		SimpleDateFormat sf = new SimpleDateFormat(pattern);
		String str = sf.format(date);
		return str;
	}

	/**
	 * @return
	 */
	public static String getYMD() {
		// TODO Auto-generated method stub
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		return dateFormat.format(new Date());
	}

	public static String getGetHttpsUrl(Map<String, String> map)
			throws Exception {
		if (null == map || map.size() == 0) {
			throw new Exception("请求数据集合为空");
		}
		String requestUrl = getRequestUrl(map);
		StringBuffer buffer = new StringBuffer();
		for (Entry<String, String> entry : map.entrySet()) {
			if ("ACCESS_NETWORK".equals(entry.getKey())) {
				continue;
			}
			buffer.append(entry.getKey()).append("=").append(entry.getValue())
					.append("&");
		}
		return "GET--->" + requestUrl + "?"
				+ buffer.deleteCharAt(buffer.length() - 1).toString();
	}

	private static String getRequestUrl(Map<String, String> map) {
		String requestUrl = "";
		for (Entry<String, String> entry : map.entrySet()) {
			if ("ACCESS_NETWORK".equals(entry.getKey())) {
				requestUrl = entry.getValue();
				break;
			}
		}
		return requestUrl;
	}

	/**
	 * 对Sign 字段进行验证
	 * 
	 * @param sourceStr
	 *            加密字段
	 * @param signStr
	 *            验证字符串
	 * @return
	 */
	public static boolean getMd5ReStr(String sourceStr, String signStr) {

		// return true;
		try {
			RSA_MD5 rsaMD5 = new RSA_MD5();
			int k = rsaMD5.PublicVerifyMD5(signStr, sourceStr);
			System.out.println(sourceStr);
			if (k == 0) {
				Loggers.i("验证成功.");
				return true;
			} else {
				Loggers.i("验证失败.");
				return false;
			}

		} catch (Exception e) {
			Loggers.w("验证异常.\n" + e);
			return false;
		}

	}

	public static String getMD5Str(String src) {
		return getMD5Str(src, "test");
	}

	public static String getMD5Str(String src, String md5Key) {
		Md5 md51 = new Md5("");
		byte b1[] = null;
		try {
			md51.hmac_Md5(src, md5Key);
			b1 = md51.getDigest();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		return Md5.stringify(b1);
	}

	public static String getMd5ReStr(String str) {
		Md5 md5 = new Md5("");
		String digestString;
		try {
			md5.hmac_Md5("testtext", "testkey");
			byte b[] = md5.getDigest();
			digestString = md5.stringify(b);
			return digestString.toString();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return "";
		}

	}

	public static String[] getMoneyTypes() {
		// 0为人民币，1为美元，2为欧元，3为英镑，4为日元，5为韩元，
		// 6为澳大利亚元，7为卢布，8为瑞士法郎，9为港币，10为新加坡元，11为澳门元。
		String[] moneyTypes = new String[] { "人民币", "美元", "欧元", "英镑", "日元",
				"韩元", "澳大利亚元", "卢布", "瑞士法郎", "港币", "新加坡元", "澳门元" };

		return moneyTypes;
	}

	public static String getCardnoFormat(String cardNo) {
		if (null == cardNo || "".equals(cardNo)) {
			return null;
		}
		StringBuffer cardStyle = new StringBuffer();
		char[] cs = cardNo.toCharArray();
		for (int i = 0; i < cs.length; i++) {
			cardStyle.append(cs[i]);
			if (cardStyle.length() == 4 || cardStyle.length() == 9
					|| cardStyle.length() == 14 || cardStyle.length() == 19) {
				cardStyle.append(" ");
			}
		}
		return cardStyle.toString();
	}

	public static String getCardNoMask(String str) {
		if (null == str || "".equals(str)) {
			return "";
		}
		str = str.trim().replaceAll(" ", "");
		if (str.length() <= 4) {
			return "";
		}
		StringBuffer buffer = new StringBuffer();
		for (int i = 0; i < str.length() - 4; i++) {
			buffer.append("*");
		}

		return buffer.toString().concat(
				str.substring(str.length() - 4, str.length()));
	}
}
