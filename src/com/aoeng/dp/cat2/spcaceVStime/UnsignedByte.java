/**
 * 
 */
package com.aoeng.dp.cat2.spcaceVStime;

/**
 * Jun 24, 2014 11:19:55 AM
 * 
 */
public class UnsignedByte {
	/**
	 * 将 byte 转为 无符号 数字
	 * @param i
	 * @return
	 */
	public short getValue(byte i) {
		short li = (short) (i & 0xff);
		return li;
	}

	/**
	 * 将 short 转为 无符号 byte
	 * 
	 * @param s
	 * @return
	 */
	public byte toUnsingnedByte(short i) {
		// TODO Auto-generated method stub
		return (byte) (i & 0xff);
	}

}
