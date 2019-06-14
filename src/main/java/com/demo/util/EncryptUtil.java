/**
 * 
 */
package com.demo.util;

import com.sun.jersey.core.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.SecureRandom;

/**
 * 加密工具类
 * 
 * @author Administrator
 *
 */
public class EncryptUtil {

	private final static String DES = "DES";
	private final static String key = "deed30e1dfef447eb67639fe2bd76400";

	public static void main(String[] args) throws Exception {
		String data = "WPREXhpVLT3uQj3/zn+2M6DGeIKjwKh4ZMm6+ND4xu0xF9DafLh9SexfecGa4k3oNhZWQj0HjpiTuephIV2fXsdHXGoS6zpRTRJvS1WtJNBK8utIw7xJzs+BjOHuhR6r0Uz+YEnmQ3W8fI53gGleyPz0eefMzZ686yZLl30ntm4RKstvKkXFsE9Vf1os623gJs83sDakjFo=";
		// String key = "deed30e1dfef447eb67639fe2bd76400";
		// System.err.println(UUID.randomUUID().toString().replaceAll("-", ""));
		// System.err.println(encrypt(data, key));
		System.err.println(decode(data));

		// System.err.println(decrypt(encrypt(data, key), key));

	}

	public static String encode(String str) {
		String enStr = "";
		try {
			enStr = encrypt(str, key);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return enStr;
	}

	public static String decode(String str) {
		String deStr = "";
		try {
			deStr = decrypt(str, key);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return deStr;
	}

	/**
	 * 参数Md5加密
	 * 
	 * @param inStr
	 * @return
	 */
	public static String string2MD5(String inStr) {
		MessageDigest md5 = null;
		try {
			md5 = MessageDigest.getInstance("MD5");
		} catch (Exception e) {
			e.printStackTrace();
			return "";
		}

		byte[] md5Bytes = md5.digest(inStr.getBytes());

		StringBuffer hexValue = new StringBuffer();
		for (int i = 0; i < md5Bytes.length; i++) {
			int val = ((int) md5Bytes[i]) & 0xff;
			if (val < 16)
				hexValue.append("0");
			hexValue.append(Integer.toHexString(val));
		}
		return hexValue.toString();
	}

	/**
	 * Description 根据键值进行加密
	 * 
	 * @param data
	 * @param key
	 *            加密键byte数组
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String data, String key) throws Exception {
		byte[] bt = encrypt(data.getBytes(), key.getBytes());
		String strs = new String(Base64.encode(bt), "UTF-8");
		return strs;
	}

	/**
	 * Description 根据键值进行解密
	 * 
	 * @param data
	 * @param key
	 *            加密键byte数组
	 * @return
	 * @throws IOException
	 * @throws Exception
	 */
	public static String decrypt(String data, String key) throws IOException, Exception {
		if (data == null)
			return null;

		byte[] buf = Base64.decode(data.getBytes("UTF-8"));
		byte[] bt = decrypt(buf, key.getBytes());
		return new String(bt);
	}

	/**
	 * Description 根据键值进行加密
	 * 
	 * @param data
	 * @param key
	 *            加密键byte数组
	 * @return
	 * @throws Exception
	 */
	private static byte[] encrypt(byte[] data, byte[] key) throws Exception {
		// 生成一个可信任的随机数源
		SecureRandom sr = new SecureRandom();

		// 从原始密钥数据创建DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(key);

		// 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey securekey = keyFactory.generateSecret(dks);

		// Cipher对象实际完成加密操作
		Cipher cipher = Cipher.getInstance(DES);

		// 用密钥初始化Cipher对象
		cipher.init(Cipher.ENCRYPT_MODE, securekey, sr);

		return cipher.doFinal(data);
	}

	/**
	 * Description 根据键值进行解密
	 * 
	 * @param data
	 * @param key
	 *            加密键byte数组
	 * @return
	 * @throws Exception
	 */
	private static byte[] decrypt(byte[] data, byte[] key) throws Exception {
		// 生成一个可信任的随机数源
		SecureRandom sr = new SecureRandom();

		// 从原始密钥数据创建DESKeySpec对象
		DESKeySpec dks = new DESKeySpec(key);

		// 创建一个密钥工厂，然后用它把DESKeySpec转换成SecretKey对象
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance(DES);
		SecretKey securekey = keyFactory.generateSecret(dks);

		// Cipher对象实际完成解密操作
		Cipher cipher = Cipher.getInstance(DES);

		// 用密钥初始化Cipher对象
		cipher.init(Cipher.DECRYPT_MODE, securekey, sr);

		return cipher.doFinal(data);
	}

}
