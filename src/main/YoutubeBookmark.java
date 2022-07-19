package main;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.htmlparser.jericho.Element;
import net.htmlparser.jericho.HTMLElementName;
import net.htmlparser.jericho.Source;

/**
 * 
 * DLしたyoutubeの適当なページからチャンネルのURLとタイトルを抽出してchrome用のブックマークファイルにエクスポート
 * そのままインポートすることができる
 * 
 * jerichoの練習
 * chromeのブックマークの仕様
 * 正規表現はシンプル
 * 
 */
public class YoutubeBookmark {

	public static void main(String[] args) {
		
		File temp = new File("temp//" + System.nanoTime() + ".html");
		try {
			temp.createNewFile();
			
			BufferedWriter bw = new BufferedWriter(new FileWriter(temp));
			bw.write("<!DOCTYPE NETSCAPE-Bookmark-file-1>");
			bw.newLine();
			bw.write("<META HTTP-EQUIV=\"Content-Type\" CONTENT=\"text/html; charset=UTF-8\">");
			bw.newLine();
			bw.write("<TITLE>Bookmarks</TITLE>");
			bw.newLine();
			bw.write("<H1>Bookmarks</H1>");
			bw.newLine();
			bw.write("<DL><p>");
			bw.newLine();

			Source source = new Source(new URL("file:temp//YouTube.html"));
			List<Element> linkList = source.getAllElements(HTMLElementName.A);
			
			String insertLine = "";
			String href = "";
			String title = "";
			Pattern p1 = Pattern.compile("/channel/");
			Pattern p2 = Pattern.compile("/c/");
			
			for (Element link : linkList) {

				href = link.getAttributeValue("href");
				if (href == null) continue;
				
				Matcher m1 = p1.matcher(href);
				Matcher m2 = p2.matcher(href);
				if (m1.find() || m2.find()) {
					title = link.getAttributeValue("title");
					if (title == null) continue;

					insertLine = "\t<DT><A HREF=\"" + href + "\">" + title + "</A>";
					bw.write(insertLine);
					bw.newLine();
				}
			}
			
			bw.write("</DL><p>");
			bw.newLine();
			bw.close();

		} catch (MalformedURLException e1) {
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
