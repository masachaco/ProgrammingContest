package lamnic.com.aoj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lamnic.com.util.SampleInputReader;

public class Problem0003 {
	public static void main(String[] args) {
		List<String> sampleInput = SampleInputReader.read("0003", "sample1");
		sampleInput.remove(0);
		sampleInput.stream().forEach(d -> solve(d));
	}

	private static void solve(String input) {
		String[] token = input.split(" ");

		for (int i = 0; i < 3; i++) {
			if (isRightTriangle(toLong(token[i % 3]), toLong(token[(i + 1) % 3]), toLong(token[(i + 2) % 3]))) {
				System.out.println("YES");
				return;
			}
		}

		System.out.println("NO");
		return;
	}

	private static boolean isRightTriangle(long long1, long long2, long long3) {
		return long3 == Math.sqrt(Math.pow(long1, 2) + Math.pow(long2, 2));
	}

	private static long toLong(String token) {
		return Long.parseLong(token);
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
