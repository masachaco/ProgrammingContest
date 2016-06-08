package lamnic.com.aoj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lamnic.com.util.SampleInputReader;

public class Problem0004 {
	public static void main(String[] args) {
		List<String> sampleInput = SampleInputReader.read("0004", "sample1");
		sampleInput.stream().forEach(d -> solve(d));
	}

	/**
	 * <pre>
	 * ① Get x
	 * ax + by = c
	 * x + by/a = c/a
	 * x = c/a - by/a
	 *
	 * ② Get y from ①
	 * dx + ey = f
	 * d * (c/a - by/a) + ey = f
	 * cd/a - bdy/a + ey = f
	 * -bdy/a + ey = f - cd/a
	 * -bdy/a + aey/a = f - cd/a
	 * (aey -bdy)/a = f - cd /a
	 * (aey - bdy) = af - cd
	 * y(ae - bd) = (af - cd)
	 *
	 * y = (af - cd)/(ae - bd)
	 *
	 * ③ Get Result from ① and ②
	 *
	 * </pre>
	 **/
	private static void solve(String input) {
		String[] token = input.split(" ");
		double a = toDouble(token[0]);
		double b = toDouble(token[1]);
		double c = toDouble(token[2]);
		double d = toDouble(token[3]);
		double e = toDouble(token[4]);
		double f = toDouble(token[5]);

		double y = (a * f - c * d) / (a * e - b * d);
		double x = (c - (b * y)) / a;
		System.out.println(String.format("%.3f %.3f", x, y));
	}

	private static double toDouble(String token) {
		return Double.parseDouble(token);
	}

	/*
	 * 標準入力を一旦すべて受け取りStringのListにする。
	 */
	private static List<String> getInput() {
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
