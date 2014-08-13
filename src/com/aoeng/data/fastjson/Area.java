package com.aoeng.data.fastjson;

public class Area {
	private String id;
	private String name;
	private String pid;
	private String tag1;
	private String tag2;
	private String tag3;

	public Area() {
		super();
	}

	public Area(String id, String name, String pid, String tag1, String tag2, String tag3) {
		super();
		this.id = id;
		this.name = name;
		this.pid = pid;
		this.tag1 = tag1;
		this.tag2 = tag2;
		this.tag3 = tag3;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getTag1() {
		return tag1;
	}

	public void setTag1(String tag1) {
		this.tag1 = tag1;
	}

	public String getTag2() {
		return tag2;
	}

	public void setTag2(String tag2) {
		this.tag2 = tag2;
	}

	public String getTag3() {
		return tag3;
	}

	public void setTag3(String tag3) {
		this.tag3 = tag3;
	}

	@Override
	public String toString() {
		return "Area [id=" + id + ", name=" + name + ", pid=" + pid + ", tag1=" + tag1 + ", tag2=" + tag2 + ", tag3=" + tag3 + "]";
	}

}
