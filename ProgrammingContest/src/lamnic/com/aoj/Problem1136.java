package lamnic.com.aoj;

import static java.util.stream.Collectors.*;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Problem1136 {

	public static void main(String[] args) {
		// Queue<String> inputs = SampleInputReader.readByQueue("1136",
		// "sample1");
		Queue<String> inputs = getStdInputToQueue();
		solve(inputs);
	}

	private static void solve(Queue<String> inputs) {
		for (int numberOfTarget = getNextInt(inputs); numberOfTarget != 0; numberOfTarget = getNextInt(inputs)) {

			List<Point2D.Double> baseLines = getPoints(inputs);

			List<Integer> results = new ArrayList<>();
			for (int i = 0; i < numberOfTarget; i++) {
				List<Point2D.Double> targetLines = getPoints(inputs);
				// そもそも線の数が異なるので違う折れ線
				if (!isSameLineSize(baseLines, targetLines)) {
					continue;
				}

				// 同じ方向に、同じ距離だけ移動したかどうかで同じ折れ線かどうかを判定する
				if (isSamePolygonalLine(baseLines, targetLines)) {
					results.add(i + 1);
				}
			}
			results.stream().forEach(d -> System.out.println(d));
			System.out.println("+++++");
		}
	}

	private static int getNextInt(Queue<String> inputs) {
		return Integer.parseInt(inputs.poll());
	}

	private static boolean isSameLineSize(List<Point2D.Double> baseLines, List<Point2D.Double> targetLines) {
		return baseLines.size() == targetLines.size();
	}

	private static boolean isSamePolygonalLine(List<Point2D.Double> baseLines, List<Point2D.Double> targetLines) {
		// 検査対象の始点から調べてみる
		if (!compare(baseLines, targetLines)) {
			// 検査対象の終点から調べてみる
			Collections.reverse(targetLines);
			return compare(baseLines, targetLines);
		}
		return true;
	}

	/**
	 * リストに格納されている点をたどると、どちらのリストも同じ方向・同じ距離に動くかどうか比較する
	 */
	private static boolean compare(List<Point2D.Double> base, List<Point2D.Double> target) {
		for (int n = 0; n + 2 <= base.size() - 1; n++) {

			double baseCrossProduct = getCrossProduct(base.get(n), base.get(n + 1), base.get(n + 2));
			double baseLength = getLength(base.get(n + 1), base.get(n + 2));

			double targetCrossProduct = getCrossProduct(target.get(n), target.get(n + 1), target.get(n + 2));
			double targetLength = getLength(target.get(n + 1), target.get(n + 2));

			// 始点から辿って、同じ長さ且つ同じ方向にまがらなければ違う折れ線
			if (baseCrossProduct != targetCrossProduct || baseLength != targetLength) {
				return false;
			}
		}
		// 始点から辿って、毎回最後まで同じ長さ且つ同じ方向にまがったので同じ折れ線
		return true;
	}

	/**
	 * 指定された数だけ点を読み込んでリストにして返す
	 */
	private static List<Point2D.Double> getPoints(Queue<String> inputs) {
		Integer numberOfLine = getNextInt(inputs);
		List<Point2D.Double> points = new ArrayList<>();
		for (int i = 0; i < numberOfLine; i++) {
			points.add(getPoint(inputs));
		}
		return points;
	}

	/**
	 * 「x y」形式の文字列から点情報を作る
	 */
	private static Point2D.Double getPoint(Queue<String> inputs) {
		String[] splitStr = inputs.poll().split(" ");
		List<Double> pointBase = Arrays.asList(splitStr).stream().map(Double::parseDouble).collect(toList());
		return new Point2D.Double(pointBase.get(0), pointBase.get(1));
	}

	/**
	 * ベクトルの長さを取得する
	 */
	private static double getLength(Point2D.Double from, Point2D.Double to) {
		return Math.sqrt((to.x - from.x) * (to.x - from.x) + (to.y - from.y) * (to.y - from.y));
	}

	/**
	 * from -> toベクトルから見たfrom->targetベクトルとの外積を得る
	 */
	private static double getCrossProduct(Point2D.Double from, Point2D.Double to, Point2D.Double target) {
		double x = from.x - to.x;
		double y = from.y - to.y;

		double x2 = from.x - target.x;
		double y2 = from.y - target.y;

		return x * y2 - y * x2;
	}

	/*
	 * 標準入力を一旦すべて受け取りStringのQueueにする。
	 */
	private static Queue<String> getStdInputToQueue() {
		return (Queue<String>) extracted(new LinkedList<>());
	}

	/*
	 * 標準入力を一旦すべて受け取りStringのListにする。
	 */
	private static List<String> getStdInputToList() {
		return (List<String>) extracted(new ArrayList<>());
	}

	private static Collection<String> extracted(Collection<String> strCollection) {
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
