package Ex13549;

/*
문제 이름 : 숨바꼭질 3
알고리즘 : BFS
자료구조 : 우선순위 큐
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
  int position, time;

  public Node(int position, int time) {
    this.position = position;
    this.time = time;
  }

  @Override
  public int compareTo(Node o) {
    return time - o.time;
  }
}

public class Main {
  static final int MAX = 100001;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    int K = Integer.parseInt(input[1]);

    System.out.println(BFS(N, K));
    br.close();
    bw.close();
  }

  public static int BFS(int N, int K) {
    boolean[] isVisted = new boolean[MAX];
    PriorityQueue<Node> que = new PriorityQueue<>();
    que.add(new Node(N, 0));
    isVisted[N] = true;

    while(!que.isEmpty()) {
      int position = que.peek().position;
      int time = que.peek().time;
      que.poll();
      isVisted[position] = true;

      if(position == K) {
        return time;
      }
      if(position * 2 < MAX && !isVisted[position * 2]) {
        que.add(new Node(position * 2, time));
      }
      if(position + 1 < MAX && !isVisted[position + 1]) {
        que.add(new Node(position + 1, time + 1));
      }
      if(position - 1 >= 0 && !isVisted[position - 1]) {
        que.add(new Node(position - 1, time + 1));
      }
    }
    return 0;
  }
}