package com.iwant.bytes;

public class THex {
	
	public static void main(String[] args) {
		
		int a = 0x2f;//Сдʮ�����ƣ��ȼ���0x002f��  
	    System.out.println(Integer.toBinaryString(a));
	      
	    int b = 0x2F;//��дʮ������  
	    System.out.println(Integer.toBinaryString(b));
	      
	    int c = 10;//��׼ʮ����  
	    System.out.println(Integer.toBinaryString(c));
	      
	    int d = 010;//���㿪ͷ����ʾ�˽���  
	    System.out.println(Integer.toBinaryString(d));
	      
	    char e = 0xff;//charΪ2���ֽڣ�16λ  
	    byte f = 0xf;//byteΪ8λ  
	    short g = 0xff;//shortΪ2���ֽڣ�16λ  
	    System.out.println(Integer.toBinaryString(e));
	    System.out.println(Integer.toBinaryString(f)); 
	    System.out.println(Integer.toBinaryString(g));
	    
	    byte[] arr = new byte[10];
	    arr[0] = 0x3C;
	    arr[1] = 0x3E;
	    arr[2] = (byte) 0xe6;
	    System.out.println(arr[0]);
	    System.out.println(arr[1]);
	    System.out.println(arr[2]);
	    
	    String code = "0234";
	    int code1 = Integer.parseInt(code.charAt(0) + "");
	    int code2 = Integer.parseInt(code.charAt(1) + "");
	    int code3 = Integer.parseInt(code.charAt(2) + "");
	    int code4 = Integer.parseInt(code.charAt(3) + "");
	    System.out.println("code1 = " + code1);
	    System.out.println("code2 = " + code2);
	    System.out.println("code3 = " + code3);
	    System.out.println("code4 = " + code4);
	}
	
	
	/**
     * ����һ��
     * byte[] to hex string
     * 
     * @param bytes
     * @return
     */
	private static final char[] HEX_CHAR = {'0', '1', '2', '3', '4', '5', 
            '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
    public static String bytesToHexFun1(byte[] bytes) {
        // һ��byteΪ8λ����������ʮ������λ��ʶ
        char[] buf = new char[bytes.length * 2];
        int a = 0;
        int index = 0;
        for(byte b : bytes) { // ʹ�ó���ȡ�����ת��
            if(b < 0) {
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
     * ��������
     * byte[] to hex string
     * 
     * @param bytes
     * @return
     */
    public static String bytesToHexFun2(byte[] bytes) {
        char[] buf = new char[bytes.length * 2];
        int index = 0;
        for(byte b : bytes) { // ����λ�������ת�������Կ�������һ�ı���
            buf[index++] = HEX_CHAR[b >>> 4 & 0xf];
            buf[index++] = HEX_CHAR[b & 0xf];
        }

        return new String(buf);
    }

}