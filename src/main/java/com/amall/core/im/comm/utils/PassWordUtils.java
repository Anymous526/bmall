package com.amall.core.im.comm.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import sun.misc.BASE64Encoder;

public class PassWordUtils {
	private static int PASSWORD_LENGTH = 6;

	/**
	 * 随机生成密码
	 */
	public static String getPassword() {
		String password = getRandomPassword(PASSWORD_LENGTH);
		return encryption(password);
	}

	private static String encryption(String password) {
		try {
			// SHA or MD5
			MessageDigest md = MessageDigest.getInstance("SHA");

			BASE64Encoder base = new BASE64Encoder();

			return base.encode(md.digest(password.getBytes()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return password;
	}

	private static String getRandomPassword(int passwordLength) {
		char[] base = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
				'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
				'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
		Random random = new Random();

		StringBuffer password = new StringBuffer();
		for (int i = 0; i < passwordLength; i++) {
			int number = random.nextInt(base.length);
			password.append(base[number]);
		}
		return password.toString();
	}
}
