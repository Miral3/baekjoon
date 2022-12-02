package Ex18352;

/*
문제 이름 : 특정 거리의 도시 찾기
알고리즘 : 다익스트라
자료구조 : 배열 리스트
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
  int node;
  int weight;

  public Node(int node, int weight) {
    this.node = node;
    this.weight = weight;
  }

  @Override
  public int compareTo(Node o) {
    return weight - o.weight;
  }
}

public class Main {
  static int n;
  static List<Integer>[] list;
  static int[] dist;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input = br.readLine().split(" ");
    n = Integer.parseInt(input[0]);
    int m = Integer.parseInt(input[1]);
    int k = Integer.parseInt(input[2]);
    int x = Integer.parseInt(input[3]);

    dist = new int[n + 1];
    Arrays.fill(dist, Integer.MAX_VALUE);

    list = new List[n + 1];
    for (int i = 1; i <= n; i++) {
      list[i] = new ArrayList<>();
    }

    for (int i = 0; i < m; i++) {
      input = br.readLine().split(" ");
      int left = Integer.parseInt(input[0]);
      int right = Integer.parseInt(input[1]);

      list[left].add(right);
    }

    dijkstra(x);

    boolean isExist = false;
    for (int i = 1; i <= n; i++) {
      if (dist[i] == k) {
        bw.write(i + "\n");
        isExist = true;
      }
    }

    if (!isExist) {
      bw.write(-1 + "\n");
    }
    br.close();
    bw.close();
  }

  public static void dijkstra(int x) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.add(new Node(x, 0));
    boolean[] isVisited = new boolean[n + 1];
    dist[x] = 0;

    while (!pq.isEmpty()) {
      int cur = pq.poll().node;

      if (isVisited[cur]) {
        continue;
      }
      isVisited[cur] = true;

      for (int next : list[cur]) {
        if (dist[next] > dist[cur] + 1) {
          dist[next] = dist[cur] + 1;
          pq.add(new Node(next, dist[next]));
        }
      }
    }
  }
}