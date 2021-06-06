package Ex11779;

/*
문제 이름 : 최소비용 구하기2
알고리즘 : 다익스트라, 그래프 이론
자료구조 : 배열 리스트, 배열, 스택
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
import java.util.Stack;

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
  static int n, m;
  static int[] dist;
  static int[] route;
  static List<Node>[] list;
  static boolean[] check;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());

    list = new ArrayList[n + 1];

    for(int i = 1; i <= n; i++) {
      list[i] = new ArrayList<>();
    }

    for(int i = 0; i < m; i++) {
      String[] input1 = br.readLine().split(" ");
      int start = Integer.parseInt(input1[0]);
      int end = Integer.parseInt(input1[1]);
      int weight = Integer.parseInt(input1[2]);

      list[start].add(new Node(end, weight));
    }

    String[] input2 = br.readLine().split(" ");
    int startCity = Integer.parseInt(input2[0]);
    int endCity = Integer.parseInt(input2[1]);

    int city = endCity;
    Stack<Integer> result = new Stack<>();
    result.add(endCity);
    dijkstra(startCity);

    bw.write(dist[endCity] + "\n");
    while(true) {
      if(city == startCity) {
        break;
      }
      result.add(route[city]);
      city = route[city];
    }
    bw.write(result.size() + "\n");

    while(!result.isEmpty()) {
      bw.write(result.pop() + " ");
    }

    br.close();
    bw.close();
  }

  public static void dijkstra(int start) {
    dist = new int[n + 1];
    route = new int[n + 1];
    check = new boolean[n + 1];
    int[] test = new int[n + 1];
    PriorityQueue<Node> que = new PriorityQueue<>();

    Arrays.fill(dist, Integer.MAX_VALUE);
    dist[start] = 0;
    que.add(new Node(start, 0));

    while(!que.isEmpty()) {
      Node curNode = que.poll();
      int cur = curNode.end;

      if(check[cur]) {
        continue;
      }

      check[cur] = true;

      for(Node node : list[cur]) {
        if(dist[node.end] >= dist[cur] + node.weight) {
          dist[node.end] = dist[cur] +node.weight;
          que.add(new Node(node.end, dist[node.end]));
          route[node.end] = cur;
        }
      }
    }
  }
}