package Ex5430;

/*
문제 이름 : AC
알고리즘 : 덱, 문자열
자료구조 : 덱
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int testCase = Integer.parseInt(br.readLine());
    loop:
    for(int i = 0; i < testCase; i++) {
      String p = br.readLine();
      int n = Integer.parseInt(br.readLine());
      String input = br.readLine();
      String[] arr = input.substring(1, input.length()-1).split(",");
      boolean isReverse = false;
      Deque<String> deque = new ArrayDeque<>();

      for(String temp: arr) {
        deque.add(temp);
      }

      for(int j = 0; j < p.length(); j++) {
        if(p.charAt(j) == 'R') {
          if(!isReverse) {
            isReverse = true;
          } else {
            isReverse = false;
          }
        } else if(p.charAt(j) == 'D') {
          if(deque.size() < 1 || deque.peekFirst().equals("")) {
            bw.write("error\n");
            continue loop;
          } else {
            if(!isReverse) {
              deque.removeFirst();
            } else {
              deque.removeLast();
            }
          }
        }
      }

      bw.write("[");
      if(!isReverse) {
        while (!deque.isEmpty()) {
          bw.write(deque.removeFirst());
          if(deque.size() > 0) {
            bw.write(",");
          }
        }
      } else {
        while (!deque.isEmpty()) {
          bw.write(deque.removeLast());
          if(deque.size() > 0) {
            bw.write(",");
          }
        }
      }
      bw.write("]\n");
    }

    br.close();
    bw.close();
  }
}
