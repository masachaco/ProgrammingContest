package lamnic.com;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// List<String> sampleInput = SampleInputReader.read("0005", "sample1");
		List<String> sampleInput = getStdInputToList();
		sampleInput.stream().forEach(d -> solve(d));
	}

	private static void solve(String input) {
		String[] token = input.split(" ");
		BigInteger a = new BigInteger(token[0]);
		BigInteger b = new BigInteger(token[1]);
		BigInteger gcd = a.gcd(b);

		BigInteger lcm = a.multiply(b).divide(gcd);

		System.out.println(String.format("%d %d", gcd.longValue(), lcm.longValue()));
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
