package Ex1453;

/*
문제 이름 : 피시방 알바
알고리즘 : 구현
자료구조 : 해시셋
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int testCase = Integer.parseInt(br.readLine());
    String[] input = br.readLine().split(" ");

    HashSet<Integer> set = new HashSet<>();
    int result = 0;
    for(int i = 0; i < testCase; i++) {
      if(set.contains(Integer.parseInt(input[i]))) {
        result++;
      } else {
        set.add(Integer.parseInt(input[i]));
      }
    }

    System.out.println(result);
    br.close();
    bw.close();
  }
}