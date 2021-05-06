package Ex1620;

/*
문제 이름 : 나는야 포켓몬 마스터 이다솜
알고리즘 : 해시 맵
자료구조 : 문자열
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int M = Integer.parseInt(input[1]);
    HashMap<Integer, String> numHash = new HashMap<>();
    HashMap<String, Integer> strHash = new HashMap<>();
    for(int i = 1; i <= N; i++) {
      String name = br.readLine();
      numHash.put(i, name);
      strHash.put(name, i);
    }

    for(int i = 0; i < M; i++) {
      String test = br.readLine();
      if(isNumber(test)) {
        bw.write(numHash.get(Integer.parseInt(test)) + "\n");
      } else {
        bw.write(strHash.get(test) + "\n");
      }
    }
    br.close();
    bw.close();
  }

  public static boolean isNumber(String str) {
    try {
      Integer.parseInt(str);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }
}


