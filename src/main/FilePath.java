package main;

import java.io.File;

public class FilePath {

	
	public static void main(String[] args) {
		File f = new File(System.getProperty("user.dir"));
//		File f = new File("src");
		System.out.println("1 : " + f.getAbsolutePath());
		System.out.println("2 : " + f.getPath());
		System.out.println("3 : " + f.getParent());
		System.out.println("4 : " + f.getName());
		System.out.println("5 : " + f.getName().split("\\.")[0]);
		
		File temp = new File(f.getParent() + "\\" + f.getName().split("\\.")[0] + ".png");
		System.out.println("7 : " + temp.getAbsolutePath());
		System.out.println("8 : " + temp.getPath());
	}
}

