package Ex16953;

/*
문제 이름 : A -> B
알고리즘 : 그래프탐색
자료구조 : 큐
*/

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

    String[] input = br.readLine().split(" ");
    long A = Integer.parseInt(input[0]);
    long B = Integer.parseInt(input[1]);

    bw.write(BFS(A, B) + "\n");
    br.close();
    bw.close();
  }

  public static long BFS(long S, long T) {
    Queue<Long> que = new LinkedList<>();
    que.add(S);
    long cnt = 1;

    Loop:
    while(true) {
      long size = que.size();

      for(int i = 0; i < size; i++) {
        long x = que.peek();
        long transX = Long.parseLong(x + "1");
        que.poll();

        if (x == T) {
          break Loop;
        }
        if (x * 2 <= T) {
          que.add(x*2);
        }
        if(transX <= T) {
          que.add(transX);
        }
      }
      cnt++;
      if(que.isEmpty()) {
        return -1;
      }
    }
    return cnt;
  }
}


