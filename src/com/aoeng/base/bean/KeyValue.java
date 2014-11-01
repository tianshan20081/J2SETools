package com.aoeng.base.bean;

import java.io.Serializable;
import java.util.Date;

public class KeyValue implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4933570443026739424L;

	private int id;
	private String key;
	private String value;
	private Date date;
	private boolean isFlag;
	private float fl;
	private double dl;
	private char ch;
	private long lng;

	public KeyValue() {
		super();
	}

	public KeyValue(int id, String key, String value, Date date, boolean isFlag, float fl, double dl, char ch, long lng) {
		super();
		this.id = id;
		this.key = key;
		this.value = value;
		this.date = date;
		this.isFlag = isFlag;
		this.fl = fl;
		this.dl = dl;
		this.ch = ch;
		this.lng = lng;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isFlag() {
		return isFlag;
	}

	public void setFlag(boolean isFlag) {
		this.isFlag = isFlag;
	}

	public float getFl() {
		return fl;
	}

	public void setFl(float fl) {
		this.fl = fl;
	}

	public double getDl() {
		return dl;
	}

	public void setDl(double dl) {
		this.dl = dl;
	}

	public char getCh() {
		return ch;
	}

	public void setCh(char ch) {
		this.ch = ch;
	}

	public long getLng() {
		return lng;
	}

	public void setLng(long lng) {
		this.lng = lng;
	}

	@Override
	public String toString() {
		return "KeyValue [id=" + id + ", key=" + key + ", value=" + value + ", date=" + date + ", isFlag=" + isFlag + ", fl=" + fl + ", dl=" + dl + ", ch=" + ch + ", lng=" + lng + "]";
	}

}
