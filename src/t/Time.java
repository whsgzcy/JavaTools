package t;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Time {

	// SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	// String time= sdf.format( new Date());
	// ����ַ��� time�Ѿ���Ϊ��Ҫ�ĸ�ʽ��
	// �ַ�����date
	// Date date=sdf.parse(time);
	
	public static void main(String[] args) {
		
		 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String time= sdf.format( new Date());
		
		 System.out.println(time);
		 
		 try {
			Date date=sdf.parse(time);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
