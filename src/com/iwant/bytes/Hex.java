package com.iwant.bytes;

public class Hex {

	public void testPositiveIntToHex() {
		// �������С��15ʱ��ֻ����һλ�������ǰ������������λ��׼ʮ�����������ʾ�ģ��������������
		System.out.println(Integer.toHexString(2));// 2
		System.out.println(Integer.toHexString(15));// f
		System.out.println(Integer.toHexString(16));// 10
		System.out.println(Integer.valueOf("F", 16));// 16
	}

	/*
	 * Integer.valueOf()ʵ���ϵ��õ���Integer.parseInt()����ɵģ�����
	 * Integer.parseInt()��Integer.valueOf()������һ���ģ�ֻ�Ƿ���ֵ�� һ������
	 */
	public void testNegativeIntToHex() {
		// ������ʱ��ǰ�������˶���� FF ��û��ȥ��ǰ������ FF������˫�ֽ���ʽ���
		System.out.println(Integer.toHexString(-2).toUpperCase());// FFFFFFFE

		// ʵ����0xFF����ת����0x000000FF���ٽ���λ����
		System.out.println(Integer.toHexString(-2 & 0xFF).toUpperCase());// FE
		System.out.println(Integer.toHexString(-2 & 0x000000FF).toUpperCase());// FE

		// ע��FE���ʱ����Ϊ-2����Ϊ��ʱ�����FE���ɸ�����valueOf����������ִ���������
		System.out.println(Integer.valueOf("FE", 16));// 254
		// ���Ҫ���-2��ֻ�ܰ�������ʽ���
		System.out.println(Integer.valueOf("-2", 16));// -2

		// ����Ҫ�� FE ���ɸ��Ļ���ֻ����ǰ����ϸ��ţ������������������-2��
		// �����ȼ���Integer.valueOf("FE", 16)�����ڽ��ǰ���ϸ�
		System.out.println(Integer.valueOf("-FE", 16));// -254

		/*
		 * �������Ҫ����ĳ������������ֻ������������ľ���ֵ��ԭ��ʮ�����ƣ�����ǰ����ϸ��ţ� �������ʾ-128�����ȶԾ���ֵ128��ʮ������
		 * 80������ǰ����ϸ��� -80
		 */
		System.out.println(Integer.valueOf("-80", 16));// -128

		/*
		 * Ϊʲô˵valueOf���������ִ����������أ��뿴�������д��룬��Ϊ�������Ϊ2147483647�� �����
		 * ��7fffffff�����ϼ���һ��һ�����п϶������������ֱ�����0x80000000��һ������ ��ô�Ϳ���֤��
		 */
		System.out.println(Integer.valueOf("7fffffff", 16));// 2147483647
		// �˾�����ʱ�ᱨ����Ϊ�������Ϊ7fffffff������ -80000000 ȴ�ֿ������У���Ϊû����������Χ
		// System.out.println(Integer.valueOf("80000000", 16));//�������У���ע��
		System.out.println(Integer.valueOf("-80000000", 16));// -2147483648

		/*
		 * ע�����ʱ���Ǹ���������������Ϊ0xFEֻ��8λ����������32λ��������int��ʽ����ʱǰ ����Զ���24���㣬��һλ���㣬�������������
		 */
		System.out.println(0xFE);// 254
		System.out.println(-0xFE);// -254
		// ��0x80000000���������貹����һλΪһ���������Ϊ����
		System.out.println(0x80000000);// -2147483648
	}

	public void testNegativeIntToBin() {
		System.out.println(Integer.toBinaryString(-2));// 11111111111111111111111111111110
		// ʵ����0xFF����ת����0x000000FF���ٽ���λ����
		System.out.println(Integer.toBinaryString(-2 & 0xFF));// 11111110
		System.out.println(Integer.toBinaryString(-2 & 0x000000FF));// 11111110

		// ������ʮ��������һ����
		System.out.println(Integer.valueOf("1111111111111111111111111111111", 2));// 2147483647
		// ����������л������ע��
		// System.out.println(Integer.valueOf("10000000000000000000000000000000",
		// 2));
		System.out.println(Integer.valueOf("-10000000000000000000000000000000", 2));// -2147483648
		System.out.println(Integer.valueOf("11111110", 2));// 254
		System.out.println(Integer.valueOf("-11111110", 2));// -254

		/*
		 * ע��Java��û��ֱ��ʹ�ö����Ʊ�ʾһ������Ŀǰֻ֧�ְ���ʮ������ֱ�ӱ�ʾ������������ʵ��һ�� �˽��Ƶ�����ʮ���Ƶ���
		 */
		System.out.println(010);// 8
		System.out.println(10);// 10
	}

	public void testByteToHex() {

		byte negativeByte = -2;
		byte positiveByte = 2;

		/*
		 * toHexString��������Ϊint�ͣ�����תHexǰ���������������ͺ��ٽ���ת�����������£�
		 * 10000010(ԭ��)->11111110(����)->11111111 11111111 11111111 11111110(����)
		 * ->FFFFFFFE(תHex�������)
		 */
		System.out.println(Integer.toHexString(negativeByte).toUpperCase());// FFFFFFFE

		/*
		 * ��һ����-2ת�����ͣ� 10000010(ԭ��)->11111110(����)->11111111 11111111 11111111
		 * 11111110(ת����) �ڶ����� 0xFF ǰ��24���㣺 00000000 00000000 00000000 11111111
		 * ���������ѵ�һ�������������λ���㣺 00000000 00000000 00000000 11111110 ���һ����תʮ�����ƽ��Ϊ
		 * FE
		 */
		System.out.println(Integer.toHexString(negativeByte & 0xFF).toUpperCase());// FE

		// ��һ��ת����������Ը�����������byte�������������ĵ��ֽ����
		System.out.println(Integer.toHexString((negativeByte & 0x000000ff) | 0xffffff00).substring(6).toUpperCase());// FE
		System.out.println(Integer.toHexString((positiveByte & 0x000000ff) | 0xffffff00).substring(6).toUpperCase());// 02
	}

	/**
	 * λ���������������е���������������һ����
	 */
	public void testBiteMathematical() {
		System.out.println(0x8000000000000000L);// -9223372036854775808
		System.out.println((int) 0x8000000000000000L);// 0
		System.out.println(0x8000000000000010L);// -9223372036854775792
		System.out.println(0x80000000);// -2147483648
		System.out.println(0x80000010);// -2147483632

		// 0x00000010�����ɳ����ͣ������Ϊ������0x8000000000000010L
		System.out.println(0x00000010 | 0x8000000000000000L);// -9223372036854775792
		// 0x0010���������Σ������Ϊ����0x80000010
		System.out.println(0x0010 | 0x80000000);// -2147483632
	}

	public static void main(String[] args) {
		
		new Hex().testByteToHex();
		new Hex().testNegativeIntToHex();


	}

}
