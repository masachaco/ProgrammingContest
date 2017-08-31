package lamnic.com.aoj;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import lamnic.com.util.SampleInputReader;

public class Problem0001 {
    public static void main(String[] args) {

        // [1]. 標準入力を一旦全部読み取って、Listに格納
        List<String> inputStrings = SampleInputReader.read("0001", "sample1");


        List<Long> list = inputStrings.stream()     //
                .map(Long::parseLong)               // [2]. Stringなので、Longに変換
                .sorted(Comparator.reverseOrder())  // [3]. Longの値を降順でソートして
                .collect(toList());                 // [4]. 再度リストにする

        for (int i = 0; i < 3; i++) {
            System.out.println(list.get(i));        // [5]. リストの先頭から3つを標準出力に出力
        }
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
