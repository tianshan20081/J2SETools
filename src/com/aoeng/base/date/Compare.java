package com.aoeng.base.date;

import java.util.Date;

public class Compare {

	public static void main(String[] args) {
		// long l = System.currentTimeMillis();
		// Date d1 = new Date(l);
		// System.out.println(d1.getTime());
		// System.out.println(l == d1.getTime());

		ImageInfo i1 = new ImageInfo(new Date());
		ImageInfo i2 = new ImageInfo(new Date(System.currentTimeMillis() - 1000 * 60 * 61));

		System.out.println(i1.equals(i2));

	}

}

class ImageInfo {
	Date d;

	public ImageInfo() {
		super();
	}

	public ImageInfo(Date d) {
		super();
		this.d = d;
	}

	public Date getD() {
		return d;
	}

	public void setD(Date d) {
		this.d = d;
	}

	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		if (o == null || !(o instanceof ImageInfo)) {
			return false;
		}
		ImageInfo info = (ImageInfo) o;
		long t1 = d.getTime();
		long t2 = info.getD().getTime();
		// 设定 图片间隔超过 一小时 为 一组
		if (Math.abs(t1 - t2) <= 1000 * 60 * 60) {
			return true;
		}
		return false;
	}

}
