package com.aoeng.app.qiniu.bean;

import java.io.Serializable;

/**
 * 七牛 获取图片 信息
 * 
 * @author sczhang
 * 
 */
public class QnImageInfo implements Serializable {

	/**
	 * {"format":"jpeg","width":2448,"height":3264,"colorModel":"ycbcr",
	 * "orientation":"Top-left"}
	 */
	private static final long serialVersionUID = 9195683320982057419L;

	
	private String format;
	private int width;
	private int height;
	private String colorModel;
	private String orientation;

	public QnImageInfo() {
		super();
	}

	public QnImageInfo(String format, int width, int height, String colorModel, String orientation) {
		super();
		this.format = format;
		this.width = width;
		this.height = height;
		this.colorModel = colorModel;
		this.orientation = orientation;
	}

	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public String getColorModel() {
		return colorModel;
	}

	public void setColorModel(String colorModel) {
		this.colorModel = colorModel;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	@Override
	public String toString() {
		return "QnImageInfo [format=" + format + ", width=" + width + ", height=" + height + ", colorModel=" + colorModel + ", orientation=" + orientation + "]";
	}

}
