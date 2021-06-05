package Ex1504;

/*
문제 이름 : 특정한 최단 경로
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
  static final int INF = 200000000;
  static int N, E;
  static List<Node>[] list;
  static int[] dist;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input = br.readLine().split(" ");

    N = Integer.parseInt(input[0]);
    E = Integer.parseInt(input[1]);

    list = new ArrayList[N + 1];

    for(int i = 1; i <= N; i++) {
      list[i] = new ArrayList<>();
    }

    for(int i = 0; i < E; i++) {
      input = br.readLine().split(" ");
      int start = Integer.parseInt(input[0]);
      int end = Integer.parseInt(input[1]);
      int weight = Integer.parseInt(input[2]);

      list[start].add(new Node(end, weight));
      list[end].add(new Node(start, weight));
    }

    input = br.readLine().split(" ");
    int firstPath = Integer.parseInt(input[0]);
    int secondPath = Integer.parseInt(input[1]);

    int[] result = dijkstra(1);
    int[] temp1= dijkstra(firstPath);
    int[] temp2 = dijkstra(secondPath);

    long answer = Math.min(result[firstPath] + temp1[secondPath] + temp2[N],
        result[secondPath] + temp2[firstPath] + temp1[N]);
    if(answer >= INF || answer < 0) {
      System.out.println(-1);
    } else {
      System.out.println(answer);
    }
    br.close();
    bw.close();
  }

  public static int[] dijkstra(int start) {
    dist = new int[N + 1];
    Arrays.fill(dist, INF);
    PriorityQueue<Node> que = new PriorityQueue<>();
    boolean[] check = new boolean[N + 1];
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
    return dist;
  }
}