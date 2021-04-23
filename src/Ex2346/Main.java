package Ex2346;

/*
문제 이름 : 풍선 터뜨리기
알고리즘 : 덱
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

    Deque<Node> deq = new ArrayDeque<>();
    int N = Integer.parseInt(br.readLine());
    String[] input = br.readLine().split(" ");

    for(int i = 1; i < N+1; i++) {
      deq.add(new Node(i, Integer.parseInt(input[i-1])));
    }

    int num = 0;
    int value = 0;
    while(!deq.isEmpty()) {
      if(deq.size() == N) {
        num = deq.peekFirst().num;
        value = deq.peekFirst().value;
        bw.write(num + " ");
        deq.removeFirst();
      }
      if(value > 0)
      for(int i = 0; i < value-1; i++) {
        deq.addLast(deq.removeFirst());
      } else {
        for(int i = 0; i < Math.abs(value); i++) {
          deq.addFirst(deq.removeLast());
        }
      }
      num = deq.peekFirst().num;
      value = deq.peekFirst().value;
      bw.write(num + " ");
      deq.removeFirst();
    }

    br.close();
    bw.close();
  }
  public static class Node {
    int num;
    int value;

    public Node(int num, int value) {
      this.num = num;
      this.value = value;
    }
  }
}
