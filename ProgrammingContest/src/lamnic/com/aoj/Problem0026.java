package lamnic.com.aoj;

import static java.util.stream.Collectors.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Problem0026 {
	private static final int SMALL = 1;
	private static final int MEDIUM = 2;
	private static final int LARGE = 3;
	private static Map<List<Integer>, Integer> canvas = new HashMap<>();

	public static void main(String[] args) {
		// List<String> inputs = SampleInputReader.read("0026", "sample1");
		List<String> inputs = getStdInputToList();
		inputs.stream().forEach(d -> dropInk(d));
		printResult();
	}

	private static void dropInk(String inputStr) {
		List<Integer> inputs = Arrays.asList(inputStr.split(",")).stream().map(Integer::parseInt).collect(toList());
		int x = inputs.get(0);
		int y = inputs.get(1);
		switch (inputs.get(2)) {
		case LARGE:
			draw(x, y, new int[] { 0, -2, 2, 0 }, new int[] { -2, 0, 0, 2 });
		case MEDIUM:
			draw(x, y, new int[] { -1, 1, -1, 1, }, new int[] { -1, -1, 1, 1 });
		case SMALL:
			draw(x, y, new int[] { 0, -1, 0, 1, 0 }, new int[] { -1, 0, 0, 0, 1 });
		}
	}

	private static void draw(int x, int y, int[] dx, int[] dy) {
		for (int i = 0; i < dx.length; i++) {
			List<Integer> position = Arrays.asList(x + dx[i], y + dy[i]);
			int colorDepth = canvas.getOrDefault(Arrays.asList(x + dx[i], y + dy[i]), 0) + 1;
			canvas.put(position, colorDepth);
		}
	}

	private static void printResult() {
		int maxColorDepth = 0;
		int numberOfWhite = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				Integer colorDepth = canvas.getOrDefault(Arrays.asList(i, j), 0);
				if (maxColorDepth < colorDepth) {
					maxColorDepth = colorDepth;
				}
				if (colorDepth == 0) {
					numberOfWhite++;
				}
			}
		}
		System.out.println(numberOfWhite);
		System.out.println(maxColorDepth);
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
