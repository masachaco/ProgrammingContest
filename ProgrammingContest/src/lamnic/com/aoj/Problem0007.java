package lamnic.com.aoj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lamnic.com.util.SampleInputReader;

public class Problem0007 {
	public static void main(String[] args) {
		List<String> sampleInput = SampleInputReader.read("0007", "sample1");
		// List<String> sampleInput = getStdInputToList();
		sampleInput.stream().forEach(d -> solve(d));
	}

	private static void solve(String input) {
		long week = Long.parseLong(input);
		long amount = 100000;
		for (int i = 0; i < week; i++) {
			amount = (long) Math.ceil((amount * 1.05) / 1000) * 1000;
		}
		System.out.println(amount);
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
