package Ex1238;

/*
문제 이름 : 파티
알고리즘 : 다익스트라, 그래프 이론
자료구조 : 배열 리스트, 배열
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
  int end;
  int weight;

  public Node(int end, int weight) {
    this.end = end;
    this.weight = weight;
  }

  @Override
  public int compareTo(Node o) {
    return weight - o.weight;
  }
}

public class Main {
  static final int INF = 10000000;
  static int N, M, X;
  static List<Node>[] list;
  static int[] dist;
  static boolean[] check;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input1 = br.readLine().split(" ");
    N = Integer.parseInt(input1[0]);
    M = Integer.parseInt(input1[1]);
    X = Integer.parseInt(input1[2]);

    list = new ArrayList[N + 1];

    for(int i = 1; i <= N; i++) {
      list[i] = new ArrayList<>();
    }

    for(int i = 0; i < M; i++) {
      String[] input2 = br.readLine().split(" ");
      int start = Integer.parseInt(input2[0]);
      int end = Integer.parseInt(input2[1]);
      int weight = Integer.parseInt(input2[2]);

      list[start].add(new Node(end, weight));
    }

    long answer = 0;

    for(int i = 1; i <= N; i++) {
      answer = Math.max(dijkstra(i, X) + dijkstra(X, i), answer);
    }

    if(answer >= INF || answer < 0) {
      System.out.println(-1);
    } else {
      System.out.println(answer);
    }
    br.close();
    bw.close();
  }

  public static int dijkstra(int start, int end) {
    dist = new int[N + 1];
    check = new boolean[N + 1];
    Arrays.fill(dist, INF);
    Arrays.fill(check, false);

    PriorityQueue<Node> que = new PriorityQueue<>();
    que.add(new Node(start, 0));
    dist[start] = 0;

    while(!que.isEmpty()) {
      Node curNode = que.poll();
      int cur = curNode.end;

      if(check[cur]) {
        continue;
      }
      check[cur] = true;

      for(Node node : list[cur]) {
        if(dist[node.end] > dist[cur] + node.weight) {
          dist[node.end] = dist[cur] + node.weight;
          que.add(new Node(node.end, dist[node.end]));
        }
      }
    }

    return dist[end];
  }
}