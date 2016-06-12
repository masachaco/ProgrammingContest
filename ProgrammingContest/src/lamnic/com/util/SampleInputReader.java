package lamnic.com.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SampleInputReader {
	public static List<String> read(String probName, String fileName) {
		return (List<String>) extracted(probName, fileName, new ArrayList<>());
	}

	public static Queue<String> readByQueue(String probName, String fileName) {
		return (Queue<String>) extracted(probName, fileName, new LinkedList<>());
	}

	private static Collection<String> extracted(String probName, String fileName, Collection<String> strCollection) {
		InputStream is = ClassLoader.getSystemResourceAsStream(getFilePath(probName, fileName));
		try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(is))) {
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				strCollection.add(line);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
			System.out.println("File read error.");
			System.exit(1);
		}
		return strCollection;
	}

	private static String getFilePath(String probName, String fileName) {
		return String.format("sample_input/%s/%s", probName, fileName);
	}
}
