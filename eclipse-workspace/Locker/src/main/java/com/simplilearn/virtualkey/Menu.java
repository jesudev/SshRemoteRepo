package com.simplilearn.virtualkey;

 
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Devi Arumugam
 *
 */
public class Menu {
	Scanner s = new Scanner(System.in);
	String s1;

	public boolean ckmenu(int sno1, String ckval) {
		String regex = "[1-" + sno1 + "]";
		if (ckval.matches(regex)) {
			System.out.println("t");
			return false;
		} else
			return true;
	}

	public void signin(String s1[]) throws IOException {
		AllValidations r = new AllValidations();
		boolean b = r.authenticate(s1);
		if (b) {
			
			try {
				Scanner s = new Scanner(System.in);
				File dir = new File(System.getProperty("user.dir") + "/MySecRepository");
				//String[] partsid = s1[0].split("@");
				//File f = new File(dir + "/" + partsid[0] + ".txt");
				//BufferedReader br = null;
				System.out.println("1.ADD \n2.VIEW \n3.SEARCH \n4.DELETE \n5.BACK \n6.SIGN-OUT");
				System.out.println("Enter any one of the options above");
				String welcomeinput = s.next();
				String regex = "[1-5]";
				if (welcomeinput.matches(regex)) {
					int welcome = Integer.parseInt(welcomeinput);
					switch (welcome) {
					case 1:
						new AddCredential().addRecord(s1, dir);
						break;
					case 2:
						(new ViewAndSearchCredential()).viewRecord(s1, dir);
						break;
					case 3:
						(new ViewAndSearchCredential()).searchRecord(s1, dir);
						break;
					case 4:
						new DeleteCredential().deleteRecord(s1, dir);
						break;
					case 5:
						System.out.println("Successfully Signed out");
						System.exit(1);
						break;
					}
				}
			}

			catch (Exception e) {
			}

		}
	}

	public String[] signck(int homeinput) throws Exception {
		String msg = " ";
		String[] s1 = new String[2];
		if (homeinput == 1) {
			msg = " preferred ";
		}
		System.out.println("Hai!Enter Your" + msg + "mail ID and" + msg + "Password below");
		
		System.out.println("Enter your" + msg + "Mail ID:");
		int j = 0, k = 0;
		String pwd = " ";
		String userID = " ";
		AllValidations obval = new AllValidations();
		while (j == 0) {
			userID = s.nextLine();
			if (obval.validateemail(userID)) {
				j = 1;
				s1[0] = userID;
				System.out.println("Enter your" + msg + "Password:");
				System.out.println(
						"[Min 6 and Max 15 characters in length , One upper case and one lower case, only one special character allowed]");
				while (k == 0) {
					pwd = s.nextLine();
					if (obval.validatepwd(pwd)) {

						s1[1] = pwd;
 						if (homeinput == 1) {
							System.out.println("Great!You are successfully registered!!!");
						}
						if (homeinput == 2) {
							if (obval.authenticate(s1))
								k = 1;
							else {
								System.out.println("User ID & PWD does not exists.Please enter again");
								Home h=new Home();
							}
						} else {
							k = 1;
						}
					}

					else {
						System.out.println("Enter a valid Password:");
					}
				}
			}

			else {
				System.out.println("Enter valid Email-ID");
			}
		}

		return s1;
	}
}
