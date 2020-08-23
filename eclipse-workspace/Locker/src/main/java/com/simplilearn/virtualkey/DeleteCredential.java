package com.simplilearn.virtualkey;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DeleteCredential {
	public void deleteRecord(String[] s1, File dir) throws Exception {
		System.out.println("Delete");
		File fdir = new File(dir, "/Dir.txt");
		File f1 = new File(dir + "/" + (s1[0].split("@"))[0] + ".txt");
		System.out.println(f1.getPath());
		f1.delete();

		String fileName = fdir.toString();
		List<String> list = new ArrayList<>();
		 
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			 
			list = stream.filter(line -> !line.contains(s1[0])).collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}
		fdir.delete();
		fdir.createNewFile();
		List<String> arrayList = list;
		Path out = Paths.get(fileName);
		Files.write(out, arrayList, Charset.defaultCharset());
		System.out.println("Your Record deleted successfully");
		 Home h=new Home();
		    System.out.println("Good Day!!!");
			System.exit(1);
		}
		 
	}
 
