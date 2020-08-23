package com.simplilearn.virtualkey;

import java.io.*;
import java.util.Scanner;

public class Home {

	static File f, dir,f1;
	static String credentials;
    Home() throws Exception {
    	startCode();
    }
	 public void startCode() throws Exception {

			Scanner scan=new Scanner(System.in);
			String[] s1 = new String[5];
			String[] s2 =new String[5];
			Menu menu=new Menu();
			int loop=0;
			dir = new File(System.getProperty("user.dir") + "/MySecRepository");
			f = new File(dir,"/Dir.txt");
			if (!dir.exists()) {
				dir.mkdir();
				f.createNewFile();
			}
			System.out.println("****************************************");
		 	System.out.println("LockMe - Personalised Digital Locker");
		 	System.out.println("              Welcome               ");
		 	System.out.println("****************************************");	
		 	String option="y";
		 	
		 	do {	 	
		 		System.out.println("Enter an option : \n");
		 		System.out.println("1.NEW USER \n2.EXISTING USER\n3.EXIT");
		 		int userinput=scan.nextInt();
		 		switch (userinput) {
		 		case 1:
		 			s1 = menu.signck(1);
		 			String[] parts = s1[0].split("@"); 
					String name = parts[0].trim();
					f1 = new File(dir + "/"+name + ".txt");
					System.out.println(f1);
					f1.createNewFile();
					printuser(s1[0],s1[1]);
					System.out.println("Congrats!! You are successfully Registered");
					loop=0;
					do {
						System.out.println("Do you want to signin y/n ?:");
						String ck = new Scanner(System.in).next();
						if (ck.equals("y".toString())) {
							s2= menu.signck(2);
							menu.signin(s2);
						}
						else if (ck.equals("n".toString())) { 
							System.out.println("BYE!!!");
							//System.clean();
							option="y";
							loop=1;
						}
						else System.out.println("Enter a valid entry");
					}while(loop==0);
		 			break;
		 		case 2:
		 			s1 = menu.signck(2);
		 			menu.signin(s1);
		 			break;
		 		case 3:
		 			 
		 			 System.exit(1);
		 		}
		 		 
		 	}while(option=="y");
		 	
		
	 }

	public static void main(String[] args) throws Exception {
		Home h=new Home();
	}
	 	
	public static void clrscr(){
	    //Clears Screen in java
	    try {
	        if (System.getProperty("os.name").contains("Windows"))
	            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	        else
	            Runtime.getRuntime().exec("clear");
	    } catch (IOException | InterruptedException ex) {}
	}
	public static void printuser(String userID, String pwd) throws Exception {
		 
		RandomAccessFile raf = new RandomAccessFile(f, "rw");
		    raf.seek(0);
			raf.seek(raf.length());
			raf.write((userID + ":" + pwd +"\n" ).getBytes());
			raf.close();
	}
}
