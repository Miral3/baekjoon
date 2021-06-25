package Ex18352;

/*
문제 이름 : 특정 거리의 도시 찾기
알고리즘 : BFS
자료구조 : 배열 리스트
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
  int end, weight;

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
  static int N, M, K, X;
  static List<Node>[] list;
  static int[] dist;
  static boolean[] check;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input1 = br.readLine().split(" ");
    N = Integer.parseInt(input1[0]);
    M = Integer.parseInt(input1[1]);
    K = Integer.parseInt(input1[2]);
    X = Integer.parseInt(input1[3]);

    list = new ArrayList[N + 1];
    check = new boolean[N + 1];
    dist = new int[N + 1];

    for(int i = 1; i <= N; i++) {
      list[i] = new ArrayList<>();
    }

    Arrays.fill(dist, Integer.MAX_VALUE);

    for(int i = 0; i < M; i++) {
      String[] input2 = br.readLine().split(" ");
      int start = Integer.parseInt(input2[0]);
      int end = Integer.parseInt(input2[1]);

      list[start].add(new Node(end, 1));
    }

    dijkstra(X);

    boolean exists = false;
    for(int i = 1; i <= N; i++) {
      if(dist[i] == K) {
        bw.write(i + "\n");
        exists = true;
      }
    }
    if(!exists) {
      System.out.println(-1);
    }
    br.close();
    bw.close();
  }

  public static void dijkstra(int start) {
    PriorityQueue<Node> pq = new PriorityQueue();
    pq.add(new Node(start, 0));
    dist[start] = 0;

    while(!pq.isEmpty()) {
      Node curNode = pq.poll();
      int cur = curNode.end;

      if(check[cur]) {
        continue;
      }
      check[cur] = true;

      for(Node node : list[cur]) {
        if(dist[node.end] > dist[cur] + node.weight) {
          dist[node.end] = dist[cur] + node.weight;
          pq.add(new Node(node.end, dist[node.end]));
        }
      }
    }
  }
}