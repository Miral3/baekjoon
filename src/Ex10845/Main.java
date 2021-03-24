package Ex10845;

/*
문제 이름 : 큐
알고리즘 : 큐
자료구조 : 연결 리스트
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Main {
  static LinkedList<Integer> que = new LinkedList<>();

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int testCase = Integer.parseInt(br.readLine());

    for(int i = 0; i  < testCase; i++) {
      String[] input = br.readLine().split(" ");
      if(input.length < 2) {
        command(input[0], 0);
      } else {
        command(input[0], Integer.parseInt(input[1]));
      }
    }
    br.close();
    bw.close();
  }

  public static void command(String input, int num) {
        switch (input) {
          case "push":
            que.add(num);
            break;
          case "pop":
            if(que.isEmpty()) {
              System.out.println("-1");
            } else {
              System.out.println(que.poll());
            }
            break;
          case "size":
            System.out.println(que.size());
            break;
          case "empty":
        if(que.isEmpty()) {
          System.out.println("1");
        } else {
          System.out.println("0");
        }
          break;
      case "front":
        if(que.isEmpty()) {
          System.out.println("-1");
        } else {
          System.out.println(que.getFirst());
        }
        break;
      case "back":
        if(que.isEmpty()) {
          System.out.println("-1");
        } else {
          System.out.println(que.getLast());
        }
        break;
    }
  }
}
