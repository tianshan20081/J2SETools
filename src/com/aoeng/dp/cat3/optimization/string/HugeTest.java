/**
 * 
 */
package com.aoeng.dp.cat3.optimization.string;

import java.util.ArrayList;
import java.util.List;

/**
 * Jun 24, 2014 2:59:54 PM
 * 
 */
public class HugeTest {
	public static void main(String[] args) {
		List<String> handler = new ArrayList<String>();
		for(int i=0;i< 1000000;i++){
//			HugeStr h = new HugeStr();
			ImprovedHugeStr h =   new ImprovedHugeStr();
			handler.add(h.getSubString(1,5));
		}
	}

	static class HugeStr {
		private String str = new String(new char[10000000]);

		public String getSubString(int begin, int end) {
			return str.substring(begin, end);
		}
	}

	static class ImprovedHugeStr {
		private String str = new String(new char[10000000]);

		public String getSubString(int begin, int end) {
			return new String(str.substring(begin, end));
		}
	}
}
