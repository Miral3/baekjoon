package Ex1916;

/*
문제 이름 : 최소비용 구하기
알고리즘 : 다익스트라
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

  public Node(int end, int weight){
    this.end = end;
    this.weight = weight;
  }

  @Override
  public int compareTo(Node o) {
    return weight - o.weight;
  }
}

public class Main {
  static int N, M;
  static List<Node>[] list;
  static int[] dist;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());
    M = Integer.parseInt(br.readLine());

    list = new ArrayList[N + 1];
    dist = new int[N + 1];

    Arrays.fill(dist, Integer.MAX_VALUE);

    for(int i = 1; i <= N; i++) {
      list[i] = new ArrayList<>();
    }

    String[] input;
    for(int i = 0; i < M; i++) {
      input = br.readLine().split(" ");
      int start = Integer.parseInt(input[0]);
      int end = Integer.parseInt(input[1]);
      int weight = Integer.parseInt(input[2]);

      list[start].add(new Node(end, weight));
    }


    input = br.readLine().split(" ");
    int startCity = Integer.parseInt(input[0]);
    int endCity = Integer.parseInt(input[1]);

    dijkstra(startCity);
    bw.write(dist[endCity] + "\n");

    br.close();
    bw.close();
  }

  public static void dijkstra(int start) {
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
  }
}

