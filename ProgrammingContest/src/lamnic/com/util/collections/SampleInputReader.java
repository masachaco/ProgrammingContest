package lamnic.com.util.collections;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SampleInputReader {
	public static List<String> read(String probName, String fileName) {
		List<String> strList = new ArrayList<>();
		InputStream is = ClassLoader.getSystemResourceAsStream(getFilePath(probName, fileName));
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				strList.add(line);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
			System.out.println("File read error.");
			System.exit(1);
		}
		return strList;
	}

	private static String getFilePath(String probName, String fileName) {
		return String.format("sample_input/%s/%s", probName, fileName);
	}
}
