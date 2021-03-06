package lamnic.com.aoj;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import lamnic.com.util.SampleInputReader;

public class Problem0005 {
	public static void main(String[] args) {
		List<String> sampleInput = SampleInputReader.read("0005", "sample1");
		// List<String> input = getInput();
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
