package com.iwant.bytes;

import org.apache.commons.codec.DecoderException;  
import org.apache.commons.codec.binary.Hex; 

public class StringUtil {
	
	 /** 
     * �ֽ�����ת����16�����ַ��� 
     * @param bytes �ֽ����� 
     * @return 16�����ַ��� 
     */  
    public static String hexEncode(byte[] bytes) {  
        if (bytes == null || bytes.length <= 0) {  
            return null;  
        }  
        return new String(Hex.encodeHex(bytes)); //Hex.encodeHex(bytes, false)  
    }  
  
    /** 
     * 16�����ַ���ת�����ֽ����� 
     * @param hexStr 16�����ַ��� 
     * @return �ֽ����� 
     */  
    public static byte[] hexDecode(String hexStr) {  
        if (hexStr == null || "".equals(hexStr)) {  
            return null;  
        }  
        try {  
            char[] cs = hexStr.toCharArray();  
            return Hex.decodeHex(cs);  
        } catch (DecoderException e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
      
    /** 
     * �ֽ�����תΪ16�����ַ��� 
     * @param bytes �ֽ����� 
     * @return 16�����ַ��� 
     */  
    public static String byteArray2HexString(byte[] bytes) {  
        if (bytes == null || bytes.length <= 0) {  
            return null;  
        }  
        //�Ȱ�byte[] ת��άchar[]���ٰ�char[]ת��Ϊ�ַ���  
        char[] chars = new char[bytes.length * 2]; // ÿ��byte��Ӧ�����ַ�  
        final char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };  
        for (int i = 0, j = 0; i < bytes.length; i++) {  
            chars[j++] = hexDigits[bytes[i] >> 4 & 0x0f]; // �ȴ�byte�ĸ�4λ  
            chars[j++] = hexDigits[bytes[i] & 0x0f]; // �ٴ�byte�ĵ�4λ  
        }  
  
        return new String(chars);  
    }  
  
    /** 
     * 16�����ַ���ת�ֽ����� 
     * @param hexString 16�����ַ��� 
     * @return �ֽ����� 
     */  
    public static byte[] hexString2ByteArray(String hexString) {  
        if (hexString == null || "".equals(hexString)) {  
            return null;  
        }  
        //�Ȱ��ַ���ת��Ϊchar[]����ת��Ϊbyte[]  
        int length = hexString.length() / 2;  
        char[] hexChars = hexString.toCharArray();  
        byte[] bytes = new byte[length];  
        String hexDigits = "0123456789abcdef";  
        for (int i = 0; i < length; i++) {  
            int pos = i * 2; // �����ַ���Ӧһ��byte  
            int h = hexDigits.indexOf(hexChars[pos]) << 4; // ע1  
            int l = hexDigits.indexOf(hexChars[pos + 1]); // ע2  
            if (h == -1 || l == -1) { // ��16�����ַ�  
                return null;  
            }  
            bytes[i] = (byte) (h | l);  
        }  
        return bytes;  
    }  
      
      
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
         //String str = "15811111111";  
         String str = "0x55AA";  
         String result = null;  
         byte[] bytes = null;  
         long b = System.currentTimeMillis();  
         for(int i=0; i<10000; i++){  
             //result = byteArray2HexString(str.getBytes()); //27  
             result = hexEncode(str.getBytes());    //32  
         }  
         System.out.println("��ʱ��"+(System.currentTimeMillis()-b));  
           
         System.out.println("result��"+result);  
         long b2 = System.currentTimeMillis();  
         for(int i=0; i<10000; i++){  
             //bytes = hexString2ByteArray(result); //32  
             bytes = hexDecode(result); //16  
         }  
         System.out.println("��ʱ��"+(System.currentTimeMillis()-b2));  
         System.out.println("result��"+new String(bytes));  
    }  

}