package com.iwant.test;

public class TTT {
	
	public static void main(String[] args) {
		
		TA t1 = new TA();
		t1.setAge(1);
		t1.setName("123");
		
		TA t2 = new TA();
		t2.setAge(3);
		t2.setName("1234");
		
		TA t3 = new TA();
		t3.setAge(3);
		t3.setName("1234");
		
		System.out.println(t1 == t2);
		System.out.println(t1.equals(t2));
		
		System.out.println(t1 == t1);
		System.out.println(t2.equals(t2));

		System.out.println(t2 == t3);
		System.out.println(t2.equals(t3));
		
		String t = "001";
		int t4 = Integer.parseInt("001");
		System.out.println(t4);
		
		String t5 = "012345";
		System.out.println(t5.substring(0, 2));
		System.out.println(t5.substring(2, 4));
		System.out.println(t5.substring(4, 6));
	}

}