package lamnic.com.aoj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lamnic.com.util.collections.SampleInputReader;

public class Problem0006 {
	public static void main(String[] args) {
		List<String> sampleInput = SampleInputReader.read("0006", "sample1");
		// List<String> sampleInput = getStdInputToList();
		sampleInput.stream().forEach(d -> solve(d));
	}

	private static void solve(String input) {
		String result = "";
		char[] charArray = input.toCharArray();
		for (int i = 0; i < charArray.length; i++) {
			result = charArray[i] + result;
		}
		System.out.println(result);
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
