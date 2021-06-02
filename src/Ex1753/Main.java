package Ex1753;

/*
문제 이름 : 최단경로
알고리즘 : 그래프 이론, 다익스트라
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

public class Main {
  static int V, E, K;
  static int[] d;
  static List<Node>[] list;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input = br.readLine().split(" ");
    V = Integer.parseInt(input[0]);
    E = Integer.parseInt(input[1]);
    K = Integer.parseInt(br.readLine());

    list = new ArrayList[V + 1];
    d = new int[V + 1];

    for(int i = 1; i <= V; i++) {
      list[i] = new ArrayList<>();
    }

    Arrays.fill(d, Integer.MAX_VALUE);

    for(int i = 0; i < E; i++) {
      input = br.readLine().split(" ");
      int u = Integer.parseInt(input[0]);
      int v = Integer.parseInt(input[1]);
      int w = Integer.parseInt(input[2]);

      list[u].add(new Node(v, w));
    }

    dijkstra(K);

    for(int i = 1; i <= V; i++) {
      if(d[i] == Integer.MAX_VALUE) {
        bw.write("INF\n");
      } else {
        bw.write(d[i] + "\n");
      }
    }

    br.close();
    bw.close();
  }

  public static void dijkstra(int start) {
    PriorityQueue<Node> pq = new PriorityQueue();
    boolean[] check = new boolean[V + 1];
    pq.add(new Node(start, 0));
    d[start] = 0;

    while(!pq.isEmpty()) {
      Node curNode = pq.poll();
      int cur = curNode.end;

      if(check[cur]) {
        continue;
      }
      check[cur] = true;

      for(Node node : list[cur]) {
        if(d[node.end] > d[cur] + node.weight) {
          d[node.end] = d[cur] + node.weight;
          pq.add(new Node(node.end, d[node.end]));
        }
      }
    }
  }
  public static class Node implements Comparable<Node>{
    int end, weight;

    public Node(int end, int weight){
      this.end = end;
      this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
      return weight - o.weight;
    }
  }
}

