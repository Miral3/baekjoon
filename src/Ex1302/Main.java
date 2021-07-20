package Ex1302;

/*
문제 이름 : 베스트셀러
알고리즘 : 구현
자료구조 : 문자열, 해시맵
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int testCase = Integer.parseInt(br.readLine());
    Map<String, Integer> map = new HashMap<>();
    for(int i = 0 ; i < testCase; i++) {
      String input = br.readLine();
      map.put(input, map.getOrDefault(input, 0) + 1);
    }

    int max = 0;
    String result = "";
    for(String key: map.keySet()) {
      if(max <= map.get(key)) {
        if(max == map.get(key)) {
          if(result.compareTo(key) > 0) {
            result = key;
          }
        }
        else {
          result = key;
          max = map.get(key);
        }
      }
    }

    System.out.println(result);

    br.close();
    bw.close();
  }
}