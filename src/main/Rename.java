package main;

import java.io.File;

public class Rename {

	public static void main(String[] args) {
		File parent = new File("F:\\data\\");
		File[] files = parent.listFiles();
		
		int stamp = 400;
		for (int i = 0; i < files.length; i++) {
			File before = files[i];
			System.out.print(before.getName() + " " + before.getParent());
			System.out.println();
			
			File after = new File(before.getParent() + "\\" + "20141106-" + stamp + ".jpg");
			before.renameTo(after);
			stamp++;
		}
	}
}
