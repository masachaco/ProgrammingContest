package lamnic.com.aoj;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import lamnic.com.util.SampleInputReader;

public class Problem0009 {
	private static Map<Long, Long> primeNumeberCounter = new HashMap<>();

	public static void main(String[] args) {
		List<String> sampleInput = SampleInputReader.read("0009", "sample1");
		// List<String> sampleInput = getStdInputToList();
		initCounter();
		sampleInput.stream().forEach(d -> solve(d));
	}

	private static void solve(String input) {
		long inp = Long.parseLong(input);
		System.out.println(getNumberOfPrimeNumber(inp));
	}

	private static long getNumberOfPrimeNumber(long inp) {
		long result = 0;
		for (long i = inp; i > 1; i--) {
			if (primeNumeberCounter.containsKey(i)) {
				return primeNumeberCounter.get(i);
			}
		}
		return result;
	}

	private static void initCounter() {
		long counter = 0;
		for (long i = 0; i < 1000000L; i++) {
			// ヤマ張り検索^^;
			if (new BigInteger(i + "").isProbablePrime(10)) {
				counter++;
				primeNumeberCounter.put(i, counter);
			}
		}
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
