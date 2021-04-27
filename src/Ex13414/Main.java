package Ex13414;

/*
문제 이름 : 수강신청
알고리즘 : 해시 맵
자료구조 : 리스트, 셋
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    LinkedList<String> list = new LinkedList<>();
    Set<String> set = new LinkedHashSet<>();
    String[] input = br.readLine().split(" ");
    int K = Integer.parseInt(input[0]);
    int L = Integer.parseInt(input[1]);

    for(int i = 0; i < L; i++) {
      String studentNum = br.readLine();
      list.add(studentNum);
    }

    while(!list.isEmpty()) {
      set.add(list.remove(list.size()-1));
    }

    ArrayList<String> success = new ArrayList<>(set);
    Collections.reverse(success);
    for(int i = 0; i < K; i++) {
      if(success.isEmpty()) {
        break;
      }
      bw.write(success.remove(0) + "\n");
    }

    br.close();
    bw.close();
  }
}
