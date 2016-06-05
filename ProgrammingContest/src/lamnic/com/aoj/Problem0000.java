package lamnic.com.aoj;

public class Problem0000 {
	private static final int MAX_VAL = 10;

	public static void solve() {
		for (int i = 1; i < MAX_VAL; i++) {
			for (int n = 1; n < MAX_VAL; n++) {
				System.out.println(String.format("%dx%d=%d", i, n, i * n));
			}
		}
	}
}
