package com.aoeng.base.encryption;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: </p>
 * @author unascribed
 * @version 1.0
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigInteger;

import org.bouncycastle.crypto.AsymmetricBlockCipher;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.encodings.PKCS1Encoding;
import org.bouncycastle.crypto.engines.RSAEngine;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.bouncycastle.util.encoders.Hex;
//base64 encode
//MD5

/**
 * <p>
 * Title:
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2004
 * </p>
 * <p>
 * Company:
 * </p>
 * 
 * @author unascribed
 * @version 1.0
 */
public class RSA_MD5 {

	RSAKeyParameters pubParameters;
	RSAKeyParameters privParameters;
	AsymmetricBlockCipher eng = new RSAEngine();
	static RSA_MD5 RSA_MD51 = new RSA_MD5();

	/**
	 * m: 公钥文件中m值 e: 公钥文件中e值
	 * 
	 * */
	public int PublicVerifyMD5(String m, String e, String MD5Value, String src) {
		int i = 3000;
		byte b[];
		b = Hex.decode(MD5Value);
		b = RSA_MD51.PublicKeyDecrypt(m, e, b);
		String s = new String(b);
		String ss = RSA_MD51.GetMD5(src.getBytes());
		i = s.compareToIgnoreCase(ss);
		return i;
	}

	public int PublicVerifyMD5(String MD5Value, String src) {
		int i = 0;
		String s = "";
		byte b[] = Hex.decode(MD5Value);
		String mod = "b831414e0b4613922bd35b4b36802bc1e1e81c95a27c958f5382003df646154ca92fc1ce02c3be047a45e9b02a9089b4b90278237c965192a0fcc86bb49bc82ae6fdc2de709006b86c7676efdf597626fad633a4f7dc48c445d37eb55fcb3b1abb95baaa826d5390e15fd14ed403fa2d0cb841c650609524ec555e3bc56ca957";
		String pubExp = "010001";
		b = RSA_MD51.PublicKeyDecrypt(mod, pubExp, b);
		s = new String(b);
		String ss = GetMD5(src.getBytes());
		i = s.compareToIgnoreCase(ss);
		return i;
	}

	public int PublicVerifyMD5(String filename, String MD5Value, String src)
			throws IOException {
		int i = 3000;
		byte b[];
		String s = "";
		String mod, pubExp, privExp, p, q, pExp, qExp, crtCoef;

		s = RSA_MD5.ReadFile(filename);

		if (s != "" && MD5Value != "" && src != "") {
			mod = RSA_MD5.GetValue("m=", s);
			pubExp = RSA_MD5.GetValue("e=", s);

			s = "";
			b = Hex.decode(MD5Value);
			b = RSA_MD51.PublicKeyDecrypt(mod, pubExp, b);
			s = new String(b);
			String ss = RSA_MD51.GetMD5(src.getBytes());
			i = s.compareToIgnoreCase(ss);
		}
		return i;
	}

	public String PublicSignMD5(String filename, String src) throws IOException {
		String MD5Value = "";
		int i = 0;
		byte b[];
		String s;
		String mod, pubExp, privExp, p, q, pExp, qExp, crtCoef;
		s = RSA_MD5.ReadFile(filename);
		if (s != "" && src != "") {
			mod = RSA_MD5.GetValue("m=", s);
			pubExp = RSA_MD5.GetValue("e=", s);

			s = RSA_MD51.GetMD5(src.getBytes());

			b = Hex.decode(s);
			b = RSA_MD51.PublicKeyEncrypt(mod, pubExp, s.getBytes());

			MD5Value = new String(Hex.encode(b));
		}
		return MD5Value;
	}

	public int PrivateVerifyMD5(String filename, String MD5Value, String src)
			throws IOException {
		int i = 0;
		byte b[];
		String s;
		String mod, pubExp, privExp, p, q, pExp, qExp, crtCoef;
		s = RSA_MD5.ReadFile(filename);
		if (s != "" && MD5Value != "" && src != "") {
			mod = RSA_MD5.GetValue("m=", s);
			pubExp = RSA_MD5.GetValue("e=", s);
			privExp = RSA_MD5.GetValue("privateExponent=", s);
			p = RSA_MD5.GetValue("p=", s);
			q = RSA_MD5.GetValue("q=", s);
			pExp = RSA_MD5.GetValue("dP=", s);
			qExp = RSA_MD5.GetValue("dQ=", s);
			crtCoef = RSA_MD5.GetValue("qInv=", s);

			s = "";
			b = Hex.decode(MD5Value);
			b = RSA_MD51.PrivateKeyDecrypt(mod, pubExp, privExp, p, q, pExp,
					qExp, crtCoef, b);
			s = new String(b);
			String ss = RSA_MD51.GetMD5(src.getBytes());
			i = s.compareToIgnoreCase(ss);
		}
		return i;
	}

	public String PrivateSignMD5(String filename, String src)
			throws IOException {
		String MD5Value = "";
		int i = 0;
		byte b[];
		String s;
		String mod, pubExp, privExp, p, q, pExp, qExp, crtCoef;
		s = RSA_MD5.ReadFile(filename);
		if (s != "" && src != "") {

			mod = RSA_MD5.GetValue("m=", s);
			pubExp = RSA_MD5.GetValue("e=", s);
			privExp = RSA_MD5.GetValue("privateExponent=", s);
			p = RSA_MD5.GetValue("p=", s);
			q = RSA_MD5.GetValue("q=", s);
			pExp = RSA_MD5.GetValue("dP=", s);
			qExp = RSA_MD5.GetValue("dQ=", s);
			crtCoef = RSA_MD5.GetValue("qInv=", s);

			s = RSA_MD51.GetMD5(src.getBytes());

			b = Hex.decode(s);
			b = RSA_MD51.PrivateKeyEncrypt(mod, pubExp, privExp, p, q, pExp,
					qExp, crtCoef, s.getBytes());

			MD5Value = new String(Hex.encode(b));
		}
		return MD5Value;
	}

	public String PrivateStreamSignMD5(String fileStream, String src)
			throws IOException {
		String MD5Value = "";
		int i = 0;
		byte b[];
		String s;
		String mod, pubExp, privExp, p, q, pExp, qExp, crtCoef;
		s = fileStream;
		if (s != "" && src != "") {

			mod = RSA_MD5.GetValue("m=", s);
			pubExp = RSA_MD5.GetValue("e=", s);
			privExp = RSA_MD5.GetValue("privateExponent=", s);
			p = RSA_MD5.GetValue("p=", s);
			q = RSA_MD5.GetValue("q=", s);
			pExp = RSA_MD5.GetValue("dP=", s);
			qExp = RSA_MD5.GetValue("dQ=", s);
			crtCoef = RSA_MD5.GetValue("qInv=", s);

			s = RSA_MD51.GetMD5(src.getBytes());

			b = Hex.decode(s);
			b = RSA_MD51.PrivateKeyEncrypt(mod, pubExp, privExp, p, q, pExp,
					qExp, crtCoef, s.getBytes());

			MD5Value = new String(Hex.encode(b));
		}
		return MD5Value;
	}

	public static void main(String[] args) {
		byte b[];
		String s, ss;
		int i;

		ss = "12345678";
		RSA_MD5 rm = new RSA_MD5();
		try {
			System.out.println("私钥签名...");
			s = rm.RSA_MD51.PrivateSignMD5("Private1024_c.key", ss);
			System.err.println("私钥签名ok");
			System.out.println("公钥验签...");
			System.out.println(rm.RSA_MD51.PublicVerifyMD5("Private1024_c.key",
					s, ss));
			System.out.println("公钥验签ok");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public byte[] PrivateKeyEncrypt(String mod, String pubExp, String privExp,
			String p, String q, String pExp, String qExp, String crtCoef,
			byte[] data) {
		byte[] out = new byte[0];
		RSAKeyParameters privParameters = new RSAPrivateCrtKeyParameters(
				new BigInteger(mod, 16), new BigInteger(pubExp, 16),
				new BigInteger(privExp, 16), new BigInteger(p, 16),
				new BigInteger(q, 16), new BigInteger(pExp, 16),
				new BigInteger(qExp, 16), new BigInteger(crtCoef, 16));
		eng = new PKCS1Encoding(((PKCS1Encoding) eng).getUnderlyingCipher());
		eng.init(true, privParameters);

		try {
			out = eng.processBlock(data, 0, data.length);
		} catch (Exception e) {
			String a = "mod=" + mod + ", pubExp=" + pubExp + ", privExp="
					+ privExp + ", p=" + p + ", q=" + q + ", pExp=" + pExp
					+ ", qExp=" + qExp + ", crtCoef=" + crtCoef;
			System.out.println("RSA_MD5.PrivateKeyEncrypt(), " + a + ", data="
					+ new String(data));
			e.printStackTrace();
		}
		// System.err.println(new String(Hex.encode(out) ));
		return out;
	}

	public byte[] PrivateKeyDecrypt(String mod, String pubExp, String privExp,
			String p, String q, String pExp, String qExp, String crtCoef,
			byte[] data) {
		byte[] out = new byte[0];
		RSAKeyParameters privParameters = new RSAPrivateCrtKeyParameters(
				new BigInteger(mod, 16), new BigInteger(pubExp, 16),
				new BigInteger(privExp, 16), new BigInteger(p, 16),
				new BigInteger(q, 16), new BigInteger(pExp, 16),
				new BigInteger(qExp, 16), new BigInteger(crtCoef, 16));

		// eng = new PKCS1Encoding(eng);
		eng.init(false, privParameters);

		try {
			data = eng.processBlock(data, 0, data.length);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.err.println(new String(data ));
		return data;
	}

	public byte[] PublicKeyDecrypt(String mod, String pubExp, byte[] data) {
		byte[] out = new byte[0];
		RSAKeyParameters pubParameters = new RSAKeyParameters(false,
				new BigInteger(mod, 16), new BigInteger(pubExp, 16));

		eng.init(false, pubParameters);

		try {
			out = eng.processBlock(data, 0, data.length);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.err.println(new String(out));

		return out;
	}

	public byte[] PublicKeyEncrypt(String mod, String pubExp, byte[] data) {
		byte[] out = new byte[0];

		RSAKeyParameters pubParameters = new RSAKeyParameters(false,
				new BigInteger(mod, 16), new BigInteger(pubExp, 16));

		eng.init(true, pubParameters);

		try {
			out = eng.processBlock(data, 0, data.length);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.err.println(new String(Hex.encode(out) ));

		return out;
	}

	public static String GetValue(String n, String src) {
		String s = "";
		int i1, i2;
		i1 = src.indexOf(n);
		i1 = i1 + n.length();

		i2 = src.indexOf(";", i1);
		s = src.substring(i1, i2);
		return s;
	}

	public static String ReadFile(String FileName) throws IOException {
		String s = "";
		byte b[];

		try {
			FileInputStream f = new FileInputStream(FileName);
			b = new byte[f.available()];
			f.read(b);
			s = new String(b);
			f.close();
		} catch (Exception ex) {
			throw new IOException("cipher file read error!");
		}

		return s;
	}

	public RSA_MD5() {
		eng = new PKCS1Encoding(eng);

	}

	public static String GetMD5(byte[] bytes) {
		Digest digest = new MD5Digest();
		byte[] resBuf = new byte[digest.getDigestSize()];
		String resStr = "";
		digest.update(bytes, 0, bytes.length);
		digest.doFinal(resBuf, 0);
		resStr = new String(Hex.encode(resBuf));
		return resStr;
	}

}