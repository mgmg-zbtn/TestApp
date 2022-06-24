package main;

/**
 * http://okwave.jp/qa/q2998722.html
 * テトリスのブロックを配列で考え回転させる方法を探した
 * 上記がその回答（質問者は別）
 * 
 * http://aidiary.hatenablog.com/entry/20060422/1252930459
 * こちらも同じ方法だった
 */
public class ArrayRotate {

	public static void main(String[] args) {

//		int[][] test = new int[10][20];
//		System.out.println(test.length);
//		System.out.println(test[0].length);
		// arr.length = arr[i][]
		// arr[0].length = arr[][i]

		int N = 4;

		int[][] arr = new int[N][N];
		for (int y = 0; y < arr.length; y++) {
			for (int x = 0; x < arr[0].length; x++) {
				arr[y][x] = x + y * N;
			}
		}
		print(arr);
		System.out.println();

		arr = rotateLeft(arr);
		print(arr);
	}
	
	static int[][] rotateRight(int[][] arr) {
		int[][] tmp = new int[arr.length][arr[0].length];
		for (int y = 0; y < arr[0].length; y++) {
			for (int x = 0; x < arr.length; x++) {
				tmp[y][x] = arr[arr[0].length - 1 - x][y];
			}
		}
		return tmp;
	}
	
	static int[][] rotateLeft(int[][] arr) {
		int[][] tmp = new int[arr.length][arr[0].length];
		for (int y = 0; y < arr[0].length; y++) {
			for (int x = 0; x < arr.length; x++) {
				tmp[y][x] = arr[x][arr.length - 1 -y];
			}
		}
		return tmp;
	}

	static void print(int[][] arr) {
		for (int y = 0; y < arr.length; y++) {
			for (int x = 0; x < arr[0].length; x++) {
				System.out.print(trim(arr[y][x]) + ", ");
			}
			System.out.println();
		}
	}
	
	static String trim(int n) {
		return n < 10 ? "0" + n : "" + n;
	}
}
