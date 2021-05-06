package Ex4358;

/*
문제 이름 : 생태학
알고리즘 : 해시 맵
자료구조 : 해시 맵
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Iterator;
import java.util.TreeMap;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String input;
    TreeMap<String, Double> map = new TreeMap<>();
    int size = 0;
    while((input = br.readLine()) != null) {
      map.put(input, map.getOrDefault(input, 0.0)+1);
      size++;
    }

    Iterator<String> keys = map.keySet().iterator();
    while(keys.hasNext()) {
      String key = keys.next();
      double value = map.get(key);
      bw.write(key + " " + String.format("%.4f", ((value / size) * 100))  + "\n");
    }
    br.close();
    bw.close();
  }
}


