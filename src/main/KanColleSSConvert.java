package main;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.imageio.ImageIO;


/**
 * 特定のキャプチャ画像6枚と同じフォルダに置き実行する必要がある
 * 順番などは指定できず、ファイルを取得した順番に依存する
 * 単体での動作は問題ない
 * 
 * 
 * 2018/11/28
 * 2期仕様に伴い提督業も忙しいの変更に対応
 * mspaintで絶対値直し
 * jpg->png
 * 
 */
public class KanColleSSConvert {

	public static void main(String[] args) {

		// 2 * 3 ::6
		File inputDir = new File(System.getProperty("user.dir"));
		File[] preFiles = inputDir.listFiles();
		List<File> fileList = new ArrayList<File>();
		
		for (File f : preFiles) {
			if (f.isFile() && f.getName().matches(".+\\.png$")) fileList.add(f);
		}
		
		File outDir = new File(inputDir + "\\convert");
		String timeStamp = new SimpleDateFormat("yyyyMMdd-HHmmssSS", Locale.JAPAN).format(new Date());
		String filename = "\\Convert - " + timeStamp + ".png";
		
		if (!outDir.exists()) {
			outDir.mkdir();
		}

		File outputPath = new File(outDir + filename);
		
//		int x = 330;
//		int y = 100;
//		int width = 460;
//		int height = 365;

		// 2期仕様
		int x = 470;
		int y = 145;
		int width = 730;
		int height = 575;

		int row = 1;
		if (fileList.size() % 2 == 1) {
			row = (fileList.size() / 2) + 1;
		} else {
			row = (fileList.size() / 2);
		}
		if (row == 0) row = 1;
		
		BufferedImage convertImage = new BufferedImage(width * 2, height * row, BufferedImage.TYPE_INT_RGB);
		
		Graphics2D g = convertImage.createGraphics();
		
		try {
			for (int i = 0; i < fileList.size(); i++) {
				BufferedImage temp = ImageIO.read(fileList.get(i));
				g.drawImage(
					temp.getSubimage(
							x,
							y,
							width,
							height
					),
					null,
					width*(i%2),
					height*(i/2)
				);
			}
			ImageIO.write(convertImage, "jpg", outputPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
