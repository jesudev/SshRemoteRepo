package com.simplilearn.virtualkey;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ViewAndSearchCredential {
	public boolean viewRecord(String[] s1, File dir) throws IOException {
		BufferedReader br = null;
 		boolean status = false;
		try {
			String[] parts = s1[0].split("@");

			String name = parts[0].trim();
			 
			File f = new File(System.getProperty("user.dir") + "/MySecRepository/" + name + ".txt");
			br = new BufferedReader(new FileReader(f));
			String line = br.readLine();
			//

			System.out.println("Your Credentials are here:");
 			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
				}
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
			}
		}

		return status;

	}

	/**
	 * @param s1
	 * @param dir
	 * @throws IOException 
	 */
	public void searchRecord(String[] s1, File dir) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = null;
		// String[] foundsite=null;
		// boolean status=false;
		try {
			int k = 0;
			String line;
			Scanner s = new Scanner(System.in);

			System.out.println("Enter site name to view credential:");
			String sitename = s.nextLine();
			String[] parts = s1[0].split("@");
			String name = parts[0].trim();
			File f = new File(System.getProperty("user.dir") + "/MySecRepository/" + name + ".txt");
			br = new BufferedReader(new FileReader(f));

 			while ((line = br.readLine()) != null) {
				String[] parts1 = line.split(":");
				System.out.println(parts1[0]);
				if (parts1[0].trim().equals(sitename)) {
					System.out.println("Your requested details are" + "sitename: " + parts1[0] + "siteID" + parts1[1]
							+ "pwd" + parts1[2]);
					k = 1;
				}
			}
			if (k == 1)
				System.out.println("success");
			else
				System.out.println("Given ID not found");
		} catch (Exception e) {
			e.printStackTrace();
		}
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
	}
}
