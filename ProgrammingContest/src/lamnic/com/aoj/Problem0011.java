package lamnic.com.aoj;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Problem0011 {

	public static void main(String[] args) {
		// List<String> inputs = SampleInputReader.read("0011", "sample1");
		List<String> inputs = getStdInputToList();

		solve(inputs);
	}

	private static void solve(List<String> inputs) {
		long numberOfPositions = Long.parseLong(inputs.get(0));
		inputs.remove(0);
		inputs.remove(0);

		Map<Integer, Integer> goals = new HashMap<>();
		for (int startPosition = 1; startPosition <= numberOfPositions; startPosition++) {
			goals.put(getGoalPosition(startPosition, inputs, 0), startPosition);
		}

		for (int i = 1; i <= numberOfPositions; i++) {
			System.out.println(goals.get(i));
		}
	}

	private static int getGoalPosition(int current, List<String> inputs, int index) {
		// isGoal
		if (index >= inputs.size()) {
			return current;
		}

		String[] split = inputs.get(index).split(",");

		return getNextPosition(current, inputs, index, toInt(split[0]), toInt(split[1]));
	}

	private static int getNextPosition(int current, List<String> inputs, int index, int point1, int point2) {
		if (current == point1) {
			return getGoalPosition(point2, inputs, ++index);
		}

		if (current == point2) {
			return getGoalPosition(point1, inputs, ++index);
		}

		return getGoalPosition(current, inputs, ++index);
	}

	private static int toInt(String str) {
		return Integer.parseInt(str);
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
