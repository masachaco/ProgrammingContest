package lamnic.com.aoj;

import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem1130 {
	private static String[][] floor = null;
	private static boolean[][] flag = null;
	private static int tileCounter = 0;
	private static int[] dx = { 0, 0, 1, -1 };
	private static int[] dy = { 1, -1, 0, 0 };
	private static int floorX = 0;
	private static int floorY = 0;

	public static void main(String[] args) {
		// Queue<String> inputs = SampleInputReader.readByQueue("1130",
		// "sample1");
		Queue<String> inputs = getStdInputByQueue();
		solve(inputs);
	}

	private static void solve(Queue<String> inputs) {
		String floorSizeLine = null;
		while (!(floorSizeLine = inputs.poll()).equals("0 0")) {

			initialize(floorSizeLine);

			// スタート地点の座標
			int iX = 0;
			int iY = 0;

			for (int i = 0; i < floorY; i++) {
				// フロアを読み込む
				String inputLine = inputs.poll();
				floor[i] = inputLine.split("");

				// 初期位置が見つかったらその場所を記憶
				int initPointX = inputLine.indexOf("@");
				if (initPointX != -1) {
					iX = initPointX;
					iY = i;
				}
			}

			// スタート地点から移動できるところを全部移動してみる
			move(iX, iY);
			System.out.println(tileCounter);
		}
	}

	private static void initialize(String floorSizeLine) {
		String[] floorSizeToken = floorSizeLine.split(" ");

		floorX = Integer.parseInt(floorSizeToken[0]);
		floorY = Integer.parseInt(floorSizeToken[1]);
		floor = new String[floorY][];
		flag = new boolean[floorY][floorX];
		tileCounter = 0;
	}

	private static void move(int x, int y) {
		markVisited(x, y);

		for (int i = 0; i < dx.length; i++) {
			if (canVisit(x + dx[i], y + dy[i])) {
				move(x + dx[i], y + dy[i]);
			}
		}
	}

	private static boolean canVisit(int x, int y) {
		return (x >= 0 && y >= 0 && x < floorX && y < floorY && !flag[y][x] && !floor[y][x].equals("#"));
	}

	private static void markVisited(int x, int y) {
		tileCounter++;
		flag[y][x] = true;
	}

	/*
	 * 標準入力を一旦すべて受け取りStringのQueueにする。
	 */
	private static Queue<String> getStdInputByQueue() {
		return (Queue<String>) getStrdInputByCollection(new LinkedList<>());
	}

	private static Collection<String> getStrdInputByCollection(Collection<String> strCollection) {
		try (Scanner scan = new Scanner(System.in)) {
			while (scan.hasNextLine()) {
				strCollection.add(scan.nextLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strCollection;
	}

}
