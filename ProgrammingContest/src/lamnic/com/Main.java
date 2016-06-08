package lamnic.com;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// List<String> sampleInput = SampleInputReader.read("0002", "sample1");
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
