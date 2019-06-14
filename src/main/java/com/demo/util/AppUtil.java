package com.demo.util;

import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;
import java.util.UUID;

/**
 * 工具类
 * 
 * @author Administrator
 *
 */
@Slf4j
public class AppUtil {
	public static void main(String[] args) {
		System.err.println(createNnoncestr());
		System.err.println(createTimestamp());
	}

	/** 雪花算法实体 */
	private static final IdGen idGen = IdGen.get();

	/** 生产随机accessToken */
	public static String buildAccessToken() {
		return EncryptUtil.string2MD5(UUID.randomUUID().toString() + LocalDateTime.now());
	}

	/** 生产随机secret */
	public static String buildSecret() {
		return EncryptUtil.string2MD5(UUID.randomUUID().toString() + LocalDateTime.now()).toLowerCase();
	}

	/** 生产全局唯一id */
	public static long getId() {
		return idGen.nextId();
	}

	/** 生产随机noncestr */
	public static String createNnoncestr() {
		String base = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		Random random = new Random();
		StringBuffer sb = new StringBuffer();

		for (int i = 0; i < 16; ++i) {
			int number = random.nextInt(base.length());
			sb.append(base.charAt(number));
		}

		return sb.toString();
	}

	/** 生产时间戳 */
	public static String createTimestamp() {
		return Long.toString(System.currentTimeMillis() / 1000);
	}

	/**
	 * 将Map存储的对象，转换为key=value&key=value的字符
	 * 
	 * @param requestParam
	 * @param coder
	 * @return
	 */
	public static String getRequestParamString(Map<String, String> requestParam, String coder) {
		if (null == coder || "".equals(coder)) {
			coder = "UTF-8";
		}
		StringBuffer sf = new StringBuffer("");
		String reqstr = "";
		if (null != requestParam && 0 != requestParam.size()) {
			for (Entry<String, String> en : requestParam.entrySet()) {
				try {
					sf.append(en.getKey() + "=" + (null == en.getValue() || "".equals(en.getValue()) ? ""
							: URLEncoder.encode(en.getValue(), coder)) + "&");
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
					log.error("数据拼接异常{}", e.getMessage());
					return "";
				}
			}
			reqstr = sf.substring(0, sf.length() - 1);
		}
		return reqstr;
	}

}
