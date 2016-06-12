package lamnic.com.aoj;

import static java.util.stream.Collectors.*;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Problem0012 {
	public static void main(String[] args) {
		// List<String> inputs = SampleInputReader.read("0012", "sample1");
		List<String> inputs = getStdInputToList();

		inputs.stream().forEach(d -> solve(d));
	}

	private static void solve(String input) {
		List<String> inputStrs = Arrays.asList(input.split(" "));
		List<Double> inputs = inputStrs.stream().map(Double::parseDouble).collect(toList());

		Point2D.Double[] points = new Point2D.Double[3];
		Point2D.Double targetPoint = new Point2D.Double(inputs.get(6), inputs.get(7));
		for (int i = 0; i < 6; i += 2) {
			points[i / 2] = new Point2D.Double(inputs.get(i), inputs.get(i + 1));
		}

		if (targetPointIsInTriangle(points, targetPoint)) {
			System.out.println("YES");
			return;
		}

		System.out.println("NO");

	}

	private static boolean targetPointIsInTriangle(Point2D.Double[] points, Point2D.Double targetPoint) {
		boolean isAllLeft = true;
		boolean isAllRight = true;
		int numberOfVertex = points.length;
		for (int i = 0; i < numberOfVertex; i++) {
			double result = getCrossProduct(points[i % numberOfVertex], points[(i + 1) % numberOfVertex], targetPoint);

			if (result > 0) {
				isAllRight = false;
			}

			if (result < 0) {
				isAllLeft = false;
			}
		}

		return isAllLeft || isAllRight;
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
	 * 標準入力を一旦すべて受け取りStringのListにする。
	 */
	private static List<String> getStdInputToList() {
		List<String> strList = new ArrayList<>();
		try (Scanner scan = new Scanner(System.in)) {
			while (scan.hasNextLine()) {
				strList.add(scan.nextLine());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return strList;
	}
}
