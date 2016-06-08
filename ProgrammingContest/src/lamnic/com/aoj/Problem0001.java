package lamnic.com.aoj;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

import lamnic.com.util.SampleInputReader;

public class Problem0001 {
	public static void main(String[] args) {
		List<String> inputStrings = SampleInputReader.read("0001", "sample1");
		List<Long> list = inputStrings.stream().map(toLong()).sorted(longDesc()).collect(toList());

		for (int i = 0; i < 3; i++) {
			System.out.println(list.get(i));
		}
	}

	private static Comparator<? super Long> longDesc() {
		return (o1, o2) -> o1.compareTo(o2) * -1;
	}

	private static Function<String, Long> toLong() {
		return d -> Long.parseLong(d);
	}

	/**
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
