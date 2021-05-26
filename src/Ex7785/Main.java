package Ex7785;

/*
문제 이름 : 회사에 있는 살마
알고리즘 : 문자열, 해시셋
자료구조 : 해시셋
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    Set<String> set = new HashSet<>();

    for(int i = 0; i < n; i++) {
      String[] input = br.readLine().split(" ");
      if(input[1].equals("enter")) {
        set.add(input[0]);
      }
      else if(input[1].equals("leave")) {
        set.remove(input[0]);
      }
    }

    List<String> list = new ArrayList(set);
    list.sort(Collections.reverseOrder());
    for(String key : list) {
      bw.write(key + "\n");
    }

    br.close();
    bw.close();
  }
}

