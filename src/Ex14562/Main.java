package Ex14562;

/*
문제 이름 : 태권왕
알고리즘 : 그래프탐색
자료구조 : 큐
*/

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int testCase = Integer.parseInt(br.readLine());

    for(int i = 0; i < testCase; i++) {
      String[] input = br.readLine().split(" ");
      int S = Integer.parseInt(input[0]);
      int T = Integer.parseInt(input[1]);
      bw.write(BFS(S, T) + "\n");
    }
    br.close();
    bw.close();
  }
  public static int BFS(int S, int T) {
    Queue<Point> que = new LinkedList<>();
    que.add(new Point(S, T));
    int cnt = 0;

    Loop:
    while(true) {
      int size = que.size();
      for(int i = 0; i < size; i++) {
        int x = que.peek().x;
        int y = que.peek().y;
        que.poll();

        if (x == y) {
          break Loop;
        }
        if (x * 2 <= y + 3) {
          que.add(new Point(x * 2, y + 3));
        }
        que.add(new Point(x + 1, y));
      }
      cnt++;
    }
    return cnt;
  }
}

