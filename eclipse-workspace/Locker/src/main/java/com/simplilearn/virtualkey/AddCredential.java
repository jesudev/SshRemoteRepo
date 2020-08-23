package com.simplilearn.virtualkey;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class AddCredential {
	public void addRecord(String[] s1, File dir) throws IOException {
		String[] parts = s1[0].split("@");
		String name = parts[0].trim();
		File f = new File(System.getProperty("user.dir") + "/MySecRepository/" + name + ".txt");
		try (Scanner sinput = new Scanner(System.in)) {
			System.out.println("Add Credentials");
			System.out.println("Enter Site name:");
			String sitename1 = sinput.nextLine();
			System.out.println("Uid:");
			String siteid = sinput.nextLine();
			System.out.println("Enter Pwd:");
			String sitepwd = sinput.nextLine();
			RandomAccessFile raf = new RandomAccessFile(f, "rw");
			raf.seek(raf.length());
			raf.write(("\n" + sitename1 + ":" + siteid + ":" + sitepwd).getBytes());
			raf.close();
			int i=1;
			while(i==1) {
			System.out.println("Enter any one of the option:\n1.Back \n2.signout");
			Scanner s=new Scanner(System.in);
			String opt=s.next();
			Menu menu=new Menu();
			if(opt.equals("1")) {
				menu.signin(s1);
				i=0;
			}
			else if(opt.equals("2")) {
				i=0;
			    System.out.println("Good Day!!!");
				System.exit(1);
			}
			else {
				System.out.println("Not a valid Entry");
				 i=1;}
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}
	
}
