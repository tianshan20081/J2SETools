/**
 * 
 */
package com.aoeng.base.database.sqlite;

/**
 * @author Aoeng @email<zhangshch2008@gmail.com>
 * @DateTime Jan 30, 2013 12:27:10 PM
 * @Program Upop
 * @Version 1.0
 */
public class City {
	private String href;
	private String pid;
	private String id;
	private String name;

	public City() {
		super();
	}

	/**
	 * 
	 * @param href 对应信息上面的超链接
	 * @param pid 父亲节点 ID
	 * @param id 自身 ID
	 * @param name 自身名字
	 */
	public City(String href, String pid, String id, String name) {
		super();
		this.href = href;
		this.pid = pid;
		this.id = id;
		this.name = name;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
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

	@Override
	public String toString() {
		return "City [href=" + href + ", pid=" + pid + ", id=" + id + ", name=" + name + "]";
	}

}
