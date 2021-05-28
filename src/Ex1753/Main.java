package Ex1753;

/*
문제 이름 : 최단경로
알고리즘 : 그래프 이론, 다익스트라
자료구조 : 배열
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
  static final int MAX = 20001;
  static int[] d;
  static ArrayList<Node>  vector[] = new ArrayList[MAX];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input = br.readLine().split(" ");
    int V = Integer.parseInt(input[0]);
    int E = Integer.parseInt(input[1]);
    int K = Integer.parseInt(br.readLine());

    for(int i = 1; i <= V; i++) {
      vector[i] = new ArrayList<>();
    }

    d = new int[V+1];
    for(int i = 1; i <= V; i++) {
      d[i] = Integer.MAX_VALUE;
    }

    for(int i = 0; i < E; i++) {
      input = br.readLine().split(" ");
      int u = Integer.parseInt(input[0]);
      int v = Integer.parseInt(input[1]);
      int w = Integer.parseInt(input[2]);

      vector[u].add(new Node(v, w));
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
    d[start] = 0;

    PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
      @Override
      public int compare(Node o1, Node o2) {
        if(o1.y < o2.y) {
          return -1;
        } else if(o1.y == o2.y) {
          return 0;
        } else {
          return 1;
        }
      }
    });

    pq.add(new Node(start, 0));

    while(!pq.isEmpty()) {
      int current = pq.peek().getX();
      int distance = -pq.peek().getY();
      pq.poll();

      if(d[current] < distance) {
        continue;
      }
      for(int i = 0; i < vector[current].size(); i++) {
        int next = vector[current].get(i).getX();
        int nextDistance = distance + vector[current].get(i).getY();

        if(nextDistance < d[next]) {
          d[next] = nextDistance;
          pq.add(new Node(next, -nextDistance));
        }
      }
    }
  }
  public static class Node {
    int x;
    int y;

    public Node(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public int getX() {
      return x;
    }
    public int getY() {
      return y;
    }
  }
}

