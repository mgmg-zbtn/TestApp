package main;

import java.io.File;
import java.io.IOException;

public class Lhaplus {

	public static void main(String[] args) throws IOException {
		
		String target = "G:\\Eclipse";
		String outPut = "E:\\Eclipse";
		
		////////////////////////////////////////////////////////////////////////////////////////
		
		File targetPath = new File(target);
		File outPutPath = null;
		if (outPut.length() == 0) {
			outPutPath = new File(targetPath.getAbsolutePath() + "\\" + System.nanoTime());
		} else {
			outPutPath = new File(outPut);
		}
		
		outPutPath.mkdirs();

		
		for (File f : targetPath.listFiles()) {
			ProcessBuilder pb = new ProcessBuilder(new String[] {
					"C:\\Program Files (x86)\\Lhaplus\\Lhaplus.exe",
					"/c:zip",
					"/n:" + outPutPath.getAbsolutePath() + "\\" + f.getName(),
					f.getAbsolutePath()
			});
			pb.start();
		}
	}
}
