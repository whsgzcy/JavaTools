package com.iwant.buff;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class ReadTxtAndWirteTxt {

	public static void main(String[] args) {

		try { // ��ֹ�ļ��������ȡʧ�ܣ���catch��׽���󲢴�ӡ��Ҳ����throw
			/* ����TXT�ļ� */
			String pathname = "/Users/super_yu/Desktop/t.txt"; // ����·�������·�������ԣ������Ǿ���·����д���ļ�ʱ��ʾ���·��
			File filename = new File(pathname); // Ҫ��ȡ����·����input��txt�ļ�
			InputStreamReader reader = new InputStreamReader(new FileInputStream(filename)); // ����һ������������reader
			BufferedReader br = new BufferedReader(reader); // ����һ�����������ļ�����ת�ɼ�����ܶ���������
			String line = "";
			// line = br.readLine();
			StringBuffer b = new StringBuffer();
			while (line != null) {
				line = br.readLine(); // һ�ζ���һ������
				System.out.println(line);
				if (line != null) {
					b.append(line);
					// line = line.substring(47, line.length());
					// out.write(line + "\r\n"); // \r\n��Ϊ����
				}
			}
			
			String content = b.toString();
			int m = 0;
			for (int i = 0; i < content.length(); i++) {
				char cc = content.charAt(i);
				String bb = cc + "";
				if (bb.equals(",")) {
					m++;
					System.out.println("m = " + m);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// String t = "01-02 15:18:08.204 D/whsgzcy ( 1776): time = 174";
		// System.out.println(t.length());
		// System.out.println(t.substring(45,t.length()));

		// try { // ��ֹ�ļ��������ȡʧ�ܣ���catch��׽���󲢴�ӡ��Ҳ����throw
		//
		// /* д��Txt�ļ� */
		// File writename = new File("/Users/super_yu/Desktop/tt.txt"); //
		// ���·�������û����Ҫ����һ���µ�output��txt�ļ�
		// writename.createNewFile(); // �������ļ�
		// BufferedWriter out = new BufferedWriter(new FileWriter(writename));
		//
		// /* ����TXT�ļ� */
		// String pathname = "/Users/super_yu/Desktop/a.txt"; //
		// ����·�������·�������ԣ������Ǿ���·����д���ļ�ʱ��ʾ���·��
		// File filename = new File(pathname); // Ҫ��ȡ����·����input��txt�ļ�
		// InputStreamReader reader = new InputStreamReader(new
		// FileInputStream(filename)); // ����һ������������reader
		// BufferedReader br = new BufferedReader(reader); //
		// ����һ�����������ļ�����ת�ɼ�����ܶ���������
		// String line = "";
		// // line = br.readLine();
		// while (line != null) {
		// line = br.readLine(); // һ�ζ���һ������
		// System.out.println(line);
		// if (line != null) {
		// line = line.substring(47, line.length());
		// out.write(line + "\r\n"); // \r\n��Ϊ����
		// }
		// }
		//
		// out.flush(); // �ѻ���������ѹ���ļ�
		// out.close(); // ���ǵùر��ļ�
		//
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
	}

}
