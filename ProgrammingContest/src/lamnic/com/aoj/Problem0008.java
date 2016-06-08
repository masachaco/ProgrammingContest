package lamnic.com.aoj;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import lamnic.com.util.SampleInputReader;

public class Problem0008 {
	public static void main(String[] args) {
		List<String> sampleInput = SampleInputReader.read("0008", "sample1");
		// List<String> sampleInput = getStdInputToList();
		sampleInput.stream().forEach(d -> solve(d));
	}

	private static void solve(String input) {
		long inp = Long.parseLong(input);

		// まったく同一の並びは除外してカウントする
		Set<String> resultSet = new HashSet<>();

		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 10; j++)
				for (int f = 0; f < 10; f++)
					for (int n = 0; n < 10; n++)
						if (sum(i, j, f, n) == inp)
							resultSet.add(String.format("%d%d%d%d", i, j, f, n));

		System.out.println(resultSet.size());
	}

	private static long sum(int i, int j, int f, int n) {
		return i + j + f + n;
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
