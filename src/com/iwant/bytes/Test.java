package com.iwant.bytes;

public class Test {

	public static void main(String[] args) {

		// ��֯�� byteҵ���߼�
		byte[] b = new byte[30];
		b[0] = 60;
		b[29] = 62;

		b[1] = 11;
		b[2] = 11;
		b[3] = 11;

		byte[] x = double2Bytes(1.323);
		byte[] y = double2Bytes(11.545);
		byte[] p = double2Bytes(0.68);

		System.arraycopy(x, 0, b, 4, 8);
		System.arraycopy(y, 0, b, 12, 8);
		System.arraycopy(p, 0, b, 20, 8);

		double xx = bytes2Double(x);
		double yy = bytes2Double(y);
		double pp = bytes2Double(p);

		byte[] xxx = new byte[8];
		System.arraycopy(b, 4, xxx, 0, 8);
		double xxxx = bytes2Double(xxx);

		System.out.println("xx = " + xx);
		System.out.println("yy = " + yy);
		System.out.println("pp = " + pp);
		System.out.println("xxxx = " + xxxx);

		// ȡ�� double �� byte[]

		for (int i = 0; i < b.length; i++) {
			System.out.print(b[i] + " ");
		}

		System.out.println();

		// д�� 16�����ַ���
		String hexStr = bytesToHexFun1(b);
		System.out.println(hexStr);
		System.out.println(hexStr.length());
		// 16��������ת��Ϊ byte
		byte[] strs = toBytes(hexStr);
		for (int i = 0; i < strs.length; i++) {
			System.out.print(strs[i] + " ");
		}

		// �����ַ�
		String start = "<";
		byte[] start_byte = start.getBytes();

		System.out.println();
		System.out.println(" * " + start_byte[0]);
		System.out.println(" * " + start_byte.length);

		// ��֤
		// 60 60 15 20 20 0 0 0 0 0 0 -16 63 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 62 62
		// 0x3C 0x3C 15 11 11 0.06 0.123 0.123 0x3E 0x3E
		byte[] s = { 60, 60, 15, 20, 20, 0, 0, 0, 0, 0, 0, -16, 63, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 62,62 };
		byte[] nav_p = {0, 0, 0, 0, 0, 0, -16, 63};
		byte[] nav_x = {0, 0, 0, 0, 0, 0, 0, 0};
		byte[] nav_y = {};
		System.out.println(bytes2Double(nav_p));
		System.out.println(bytes2Double(nav_x));
		
		 // ʵ��
	    // byte[] one int + long + string
	    // byte[] two int + long + string
	    // byte[] three one + two
	    // three һ��һ��ת�� hexString
	    
	    byte[] three = new byte[17];
	    three[0] = 60;
	    three[1] = 60;
	    
	    three[15] = 62;
	    three[16] = 62;
	    
	    three[2] = 12;
	    
	    three[3] = 4;
	    three[4] = 5;
	    three[5] = 6;
	    three[6] = 7;
	    
	    byte[] one = double2Bytes(0.68);
	    
		System.arraycopy(one, 0, three, 7, 8);
		
		System.out.println(bytesToHexFun1(three));
		
		for(int i = 0; i < three.length; i++){
			byte[] two = new byte[1];
			two[0] = three[i];
			System.out.print(bytesToHexFun1(two));
		}
		
		System.out.println();
		
		byte[] one1 = new byte[1];
		one1[0] = three[0];
		
		byte[] one2 = new byte[9];
		one2[0] = three[1];
		one2[1] = three[2];
		one2[2] = three[3];
		one2[3] = three[4];
		one2[4] = three[5];
		one2[5] = three[6];
		one2[6] = three[7];
		one2[7] = three[8];
		one2[8] = three[9];
		
		byte[] one3 = new byte[7];
		one3[0] = three[10];
		one3[1] = three[11];
		one3[2] = three[12];
		one3[3] = three[13];
		one3[4] = three[14];
		one3[5] = three[15];
		one3[6] = three[16];
		
		System.out.print(bytesToHexFun1(one1));
		System.out.print(bytesToHexFun1(one2));
		System.out.print(bytesToHexFun1(one3));
				
		System.out.println();
		byte[] four = toBytes("aa0004ffbb");
		
		for(int i = 0; i < four.length; i++){
			System.out.print(four[i] + " ");
		}
		
		System.out.println(bytesToHexFun2(four));
	    
	}

	public static byte[] double2Bytes(double d) {
		long value = Double.doubleToRawLongBits(d);
		byte[] byteRet = new byte[8];
		for (int i = 0; i < 8; i++) {
			byteRet[i] = (byte) ((value >> 8 * i) & 0xff);
		}
		return byteRet;
	}

	/**
	 * ����һ�� byte[] to hex string
	 * 
	 * @param bytes
	 * @return
	 */
	private static final char[] HEX_CHAR = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e',
			'f' };

	public static String bytesToHexFun1(byte[] bytes) {
		// һ��byteΪ8λ����������ʮ������λ��ʶ
		char[] buf = new char[bytes.length * 2];
		int a = 0;
		int index = 0;
		for (byte b : bytes) { // ʹ�ó���ȡ�����ת��
			if (b < 0) {
				a = 256 + b;
			} else {
				a = b;
			}

			buf[index++] = HEX_CHAR[a / 16];
			buf[index++] = HEX_CHAR[a % 16];
		}
		return new String(buf);
	}

	/**
	 * �������� byte[] to hex string
	 * 
	 * @param bytes
	 * @return
	 */
	public static String bytesToHexFun2(byte[] bytes) {
		char[] buf = new char[bytes.length * 2];
		int index = 0;
		for (byte b : bytes) { // ����λ�������ת�������Կ�������һ�ı���
			buf[index++] = HEX_CHAR[b >>> 4 & 0xf];
			buf[index++] = HEX_CHAR[b & 0xf];
		}

		return new String(buf);
	}

	/**
	 * �������� byte[] to hex string
	 * 
	 * @param bytes
	 * @return
	 */
	public static String bytesToHexFun3(byte[] bytes) {
		StringBuilder buf = new StringBuilder(bytes.length * 2);
		for (byte b : bytes) { // ʹ��String��format��������ת��
			buf.append(String.format("%02x", new Integer(b & 0xff)));
		}

		return buf.toString();
	}

	/**
	 * ��16�����ַ���ת��Ϊbyte[]
	 * 
	 * @param str
	 * @return
	 */
	public static byte[] toBytes(String str) {
		if (str == null || str.trim().equals("")) {
			return new byte[0];
		}

		byte[] bytes = new byte[str.length() / 2];
		for (int i = 0; i < str.length() / 2; i++) {
			String subStr = str.substring(i * 2, i * 2 + 2);
			bytes[i] = (byte) Integer.parseInt(subStr, 16);
		}

		return bytes;
	}

	public static double bytes2Double(byte[] arr) {
		long value = 0;
		for (int i = 0; i < 8; i++) {
			value |= ((long) (arr[i] & 0xff)) << (8 * i);
		}
		return Double.longBitsToDouble(value);
	}
}