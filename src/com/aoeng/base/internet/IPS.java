package com.aoeng.base.internet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class IPS {
	public static void main(String[] args) throws Exception {
		final Map<String, String> pingMap = new HashMap<String, String>();

		InetAddress address = InetAddress.getLocalHost();
		String hostAddress = address.getHostAddress();
		System.out.println("hostAddress" + hostAddress);
		hostAddress = "192.168.1.1";
		int pos = hostAddress.lastIndexOf(".");
		String wd = hostAddress.substring(0, pos - 1);
		for (int i = 0; i < 255; i++) {
			final String ip = wd + i;
			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					Process process;
					try {
						process = Runtime.getRuntime().exec("ping " + ip);
						InputStream stream = process.getInputStream();
						InputStreamReader reader = new InputStreamReader(stream);
						BufferedReader bufferedReader = new BufferedReader(
								reader);
						String line = bufferedReader.readLine();
						// System.out.println(line);
						while (line != null) {
							if (line != null && !line.equals("")) {
								// if (line.substring(0, 2).equals("form") ||
								// (line.length() > 10 && line.substring(0,
								// 10).equals("Reply from"))) {
								if (line.contains("From")) {
									pingMap.put(ip, "true");
									System.out.println(ip);
								}
							}
							// System.out.println(line);
							line = bufferedReader.readLine();
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
		}
		StringBuffer ta_allip = new StringBuffer();
		Set<String> set = pingMap.keySet();
		Iterator<String> iterator = set.iterator();
		while (iterator.hasNext()) {
			String key = iterator.next();
			String value = pingMap.get(key);
			if (value.equals("true")) {
				ta_allip.append(key + "\n");
			}
		}
		System.out.println(ta_allip.toString());
	}
}
