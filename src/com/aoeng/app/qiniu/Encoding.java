package com.aoeng.app.qiniu;

import java.io.IOException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Encoding {

	/**
	 * Performs base64-encoding of input bytes.
	 * 
	 * @param rawData
	 *            * Array of bytes to be encoded.
	 * @return * The base64 encoded string representation of rawData.
	 */
	public static String encodeBase64(byte[] rawData) {

		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(rawData);
		// return Base64.encodeBytes(rawData);
	}

	public static String decodeBase64(byte[] rawData) {

		try {
			BASE64Decoder decoder = new BASE64Decoder();
			return new String(decoder.decodeBuffer(new String(rawData)));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		// return Base64.encodeBytes(rawData);
	}
}
