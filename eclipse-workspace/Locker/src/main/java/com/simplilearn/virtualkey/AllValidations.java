package com.simplilearn.virtualkey;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AllValidations {

	private Pattern pattern;
	private Matcher matcher;

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,8})";

	public boolean authenticate(String[] s1) {
		BufferedReader br = null;
		int i = 0;
 		try {
			File dir = new File(System.getProperty("user.dir") + "/MySecRepository");
			File file = new File(dir + "/Dir.txt");
			br = new BufferedReader(new FileReader(file));

			String line;
 			while ((line = br.readLine()) != null) {
				 
				String[] parts = line.split(":");
				 
				if (parts[0].trim().equals(s1[0]) && parts[1].trim().equals(s1[1]))
					i = 1;
				else
					;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			// Always close the BufferedReader
			if (br != null) {
				try {
					br.close();
				} catch (Exception e) {
				}
				;
			}
		}
		if (i == 1)
			return true;
		else
			return false;
	}

	/**
	 * Validate hex with regular expression
	 *
	 * @param hex hex for validation
	 * @return true valid hex, false invalid hex
	 */
	public boolean validate(final String hex) {

		matcher = pattern.matcher(hex);
		return matcher.matches();

	}

	public boolean validateemail(String hex) {
		pattern = Pattern.compile(EMAIL_PATTERN);
		return validate(hex);
	}

	public boolean validatepwd(String hex) {
		pattern = Pattern.compile(PASSWORD_PATTERN);
		return validate(hex);
	}

}
