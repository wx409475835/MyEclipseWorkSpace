package com.dw.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * @author bigshuai
 *@date 2017��5��6��
 *
 */
public class MD5Util {

	public static void main(String[] args) {
		String password = "123123";
		String salt = MD5Util.getSalt(4);
		String md = MD5Util.jdkMD(password+salt);
		System.out.println(md);
	}
	
	/**
	 * JDK Md5����
	 */
	public static String jdkMD(String target){
		StringBuilder stringBuilder = new  StringBuilder();
		MessageDigest digest = null;
		try {
			digest = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		byte[] digest2 = digest.digest(target.getBytes());
		for (byte b : digest2) {
			int l = b & 0xff;
			if(l<16){
				stringBuilder.append("0");
			}
			stringBuilder.append(Integer.toHexString(l));
		}
		return stringBuilder.toString();
	}
	/**
	 * ���û�������Σ����Ӱ�ȫ��
	 */
	public static String getSalt(int count) {
		// ��������ַ�
		char[] str = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();

		// �����
		Random random = new Random();
		/**
		 * StringBuilder �̲߳���ȫ Ч�ʸ� ���� StringBuffer �̰߳�ȫ Ч�ʵ�
		 */
		String salt = "";
		for (int i = 0; i < count; i++) {
			salt += str[random.nextInt(str.length)];
		}

		return salt;

	}

}
