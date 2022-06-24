package main;

/**
 * http://www.javadrive.jp/start/stream/index7.html
 */
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class SampleHTML {
	
	public SampleHTML() {
		
		File file = new File("index.html");
		int MAX = 300;
	
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
				
			pw.println("<html>");
			pw.println("<head>");
			pw.println("</head>");
			pw.println("<body>");
			for (int i = 1; i <= MAX; i++) {
				String num;
				
				if (i < 10) {
					num = "00" + i;
				} else if (i < 100) {
					num = "0" + i;
				} else {
					num = "" + i;
				}
				pw.println("<img src=\"" + num + ".jpg\">");
			}

			pw.println("</body>");
			pw.println("</html>");

			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String args[]) {
		new SampleHTML();
	}
}