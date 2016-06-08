package lamnic.com.aoj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lamnic.com.util.SampleInputReader;

public class Problem0002 {
	public static void main(String[] args) {
		List<String> sampleInput = SampleInputReader.read("0002", "sample1");
		sampleInput.stream().forEach(d -> solve(d));
	}

	private static void solve(String d) {
		String[] split = d.split(" ");
		System.out.println(String.format("%d", toLong(split[0]) + toLong(split[1])).length());
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
