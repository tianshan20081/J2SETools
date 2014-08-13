package com.aoeng.base.encryption;

import junit.framework.TestCase;


public class MD5Test extends TestCase {
	public void test2() {
		String v_oid = "20130328-6705-20130328103327-000001-5788";
		String v_cardno = "4270203300048795";
		String v_mac = "a42242418685d5ae1dd4334d10c05698";
		String v_mid = "6705";
		String v_enctype = "0";
		String md5 = KeyUtils
				.getMD5String(v_mid + v_oid + v_cardno + v_enctype);
		System.out.println(md5);
		System.out.println(v_mac);
	}

	/**
	 * @param args
	 */
	public void test1() {
		// TODO Auto-generated method stub
		// CardMessage [
		String status = "0";
		String statusdesc = "Success";
		String mid = "888";
		String oid = "20130115-888-20130115135435-000001-2719";
		String cardno = "6228480890022408813";
		String enctype = "0";
		String servicetype = "3";
		String servicedata = "";
		String sign = "037d384e5e4b93ca987896edc3d27a000f3611c8e38b781512868416bbf58c4822366a54e18ba0a0026098797c1d1acf596731d1b1f7bc9ccd5f9909b7fc0ef24470806666a5966b5f64176dde9280e4d616785e1f157780b5fd406b7e1a31b743ad954ae532f5f4683dbfd3c2fd653ee8b56ea462a96f13a08fab7f3b5654c2";
		boolean flag = false;

		if (sign.equals(KeyUtils.getMD5String(status + mid + oid + cardno
				+ enctype + servicetype))) {
			flag = true;
		}
		System.out.println(sign);
		System.out.println(KeyUtils.getMD5String(status + mid + oid + cardno
				+ enctype + servicetype));
	}
}
