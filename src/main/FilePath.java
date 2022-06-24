package main;

import java.io.File;

public class FilePath {

	
	public static void main(String[] args) {
//		File f = new File("E:\\Eclipse\\study\\Paiza\\src\\A005\\Main.java");
		File f = new File("Eclipse\\study\\Paiza\\src\\A005\\Main.java");
		System.out.println(f.getAbsolutePath());
		System.out.println(f.getPath());
		System.out.println(f.getParent());
		System.out.println(f.getName());
		System.out.println(f.getName().split("\\.")[0]);
		System.out.println(f.getName().split("\\.")[1]);
		File temp = new File(f.getParent() + "\\" + f.getName().split("\\.")[0] + ".png");
		System.out.println(temp.getAbsolutePath());
	}
}

