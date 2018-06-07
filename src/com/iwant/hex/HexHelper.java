package com.iwant.hex;

public class HexHelper {

	/*
	 * ����ǰ�����ڿ�����������Ҫ���ַ���ת����Ϊ16���Ƶ��ַ���,�������ҵ���һЩ��������֮��,�����ִ���һ������-->�ַ���תΪ16���ƺ���ת����,
	 * Ӣ������,���ĳ�������
	 * 
	 * �������Ǿ���ͨ�����·�ʽ���н��:
	 * 
	 * 1)�ڽ��ַ���תΪ16����֮ǰ�Ƚ���һ��ת��,�Ƚ���ת����ΪUnicode����(�൱�ڰ�������Ӣ���ַ�����),��ת����Ϊ16����
	 * 
	 * 2)�෴��,��ʮ������ת��Ϊ�ַ�����ĵõ�����Unicode����,��ʱ�ٽ�Unicode������뼴�ɻ�ȡԭʼ�ַ���
	 */

	/**
	 * �ַ���ת��unicode
	 * 
	 * @param string
	 * @return
	 */
	public static String string2Unicode(String string) {
		StringBuffer unicode = new StringBuffer();
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			unicode.append("\\u" + Integer.toHexString(c));
		}
		return unicode.toString();
	}

	/**
	 * �ַ���ת����Ϊ16�����ַ���
	 * 
	 * @param s
	 * @return
	 */
	public static String strTo16(String s) {
		String str = "";
		for (int i = 0; i < s.length(); i++) {
			int ch = (int) s.charAt(i);
			String s4 = Integer.toHexString(ch);
			str = str + s4;
		}
		return str;
	}

	/**
	 * 16����ת����Ϊstring�����ַ���
	 * 
	 * @param s
	 * @return
	 */
	public static String hexStringToString(String s) {
		if (s == null || s.equals("")) {
			return null;
		}
		s = s.replace(" ", "");
		byte[] baKeyword = new byte[s.length() / 2];
		for (int i = 0; i < baKeyword.length; i++) {
			try {
				baKeyword[i] = (byte) (0xff & Integer.parseInt(s.substring(i * 2, i * 2 + 2), 16));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		try {
			s = new String(baKeyword, "UTF-8");
			new String();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		return s;
	}

	/**
	 * unicode ת�ַ���
	 */
	public static String unicode2String(String unicode) {
		StringBuffer string = new StringBuffer();
		String[] hex = unicode.split("\\\\u");
		for (int i = 1; i < hex.length; i++) {
			// ת����ÿһ�������
			int data = Integer.parseInt(hex[i], 16);
			// ׷�ӳ�string
			string.append((char) data);
		}
		return string.toString();
	}

	/**
	 * �ַ���ת����Ϊ16����(����Unicode����)
	 * 
	 * @param str
	 * @return
	 */
	public static String str2HexStr(String str) {
		char[] chars = "0123456789ABCDEF".toCharArray();
		StringBuilder sb = new StringBuilder("");
		byte[] bs = str.getBytes();
		int bit;
		for (int i = 0; i < bs.length; i++) {
			bit = (bs[i] & 0x0f0) >> 4;
			sb.append(chars[bit]);
			bit = bs[i] & 0x0f;
			sb.append(chars[bit]);
			// sb.append(' ');
		}
		return sb.toString().trim();
	}

	/**
	 * 16����ֱ��ת����Ϊ�ַ���(����Unicode����)
	 * 
	 * @param hexStr
	 * @return
	 */
	public static String hexStr2Str(String hexStr) {
		String str = "0123456789ABCDEF";
		char[] hexs = hexStr.toCharArray();
		byte[] bytes = new byte[hexStr.length() / 2];
		int n;
		for (int i = 0; i < bytes.length; i++) {
			n = str.indexOf(hexs[2 * i]) * 16;
			n += str.indexOf(hexs[2 * i + 1]);
			bytes[i] = (byte) (n & 0xff);
		}
		return new String(bytes);
	}

	public static void main(String[] args) {
		
        String json = "{\"name\":\"BeJson\",\"url\":\"http://www.bejson.com\",\"page\":88,\"isNonProfit\":true,\"address\":{\"street\":\"�Ƽ�԰·.\",\"city\":\"��������\",\"country\":\"�й�\"},\"links\":[{\"name\":\"Google\",\"url\":\"http://www.google.com\"},{\"name\":\"Baidu\",\"url\":\"http://www.baidu.com\"},{\"name\":\"SoSo\",\"url\":\"http://www.SoSo.com\"}]}";

        String json2 = "6E6968616F";
        
        String json3 = "���,hello,����super_yu,�ҵĵ绰������15656098064";
        
        String json4 = "E4BDA0E5A5BD2C68656C6C6F2CE68891E698AF73757065725F79752CE68891E79A84E794B5E8AF9DE58FB7E7A081E698AF3135363536303938303634";
        
        String json5 = "6E6968616F";
		
        // 1���ڽ��ַ���תΪ16����֮ǰ�Ƚ���һ��ת��,�Ƚ���ת����ΪUnicode����(�൱�ڰ�������Ӣ���ַ�����),��ת����Ϊ16����
        // 2���෴��,��ʮ������ת��Ϊ�ַ�����ĵõ�����Unicode����,��ʱ�ٽ�Unicode������뼴�ɻ�ȡԭʼ�ַ���
        
        // ת��Ϊ unicode
		String a1 = string2Unicode(json2);
		System.out.println("a1 == " + a1.toString());
		
		// ת��Ϊ ԭ string
		String a2 = unicode2String(a1);
		System.out.println("a2 == " + a2.toString());
		
		// unicode ת 16����
		String b1 = strTo16(a1);
		System.out.println("b1 == " + b1.toString());
		
		// unicode ת 16����
		String b2 = str2HexStr(a1);
		System.out.println("b2 == " + b2.toString());
		
		// 16���� ת unicode
		String c1 = string2Unicode(b1);
		String c2 = string2Unicode(b2);
		
		System.out.println("c1 == " + c1.toString());
		System.out.println("c2 == " + c2.toString());
		
		String d1 = str2HexStr(json5);
		System.out.println("d1 == " + d1.toString());
		
		String d2 = hexStr2Str(json5);
		System.out.println("d1 == " + d2.toString());
	}
}