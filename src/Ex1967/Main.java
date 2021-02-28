package Ex1967;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
  static final int max = 10001;
  static int node, edge, maxNode = 0, maxWeight = 0;
  static boolean[] visited;
  static ArrayList<Node> v[] = new ArrayList[max];

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    node = Integer.parseInt(br.readLine());
    edge = node - 1;

    for(int i = 1; i <= node; i++) {
      v[i] = new ArrayList<>();
    }

    for(int i = 0; i < edge; i++) {
      String[] input = br.readLine().split(" ");
      int key = Integer.parseInt(input[0]);
      int value = Integer.parseInt(input[1]);
      int weight = Integer.parseInt(input[2]);

      /* 그래프 저장 */
      v[key].add(new Node(value, weight));
      v[value].add(new Node(key, weight));
    }

    if(node == 1) {
      bw.write("0\n");
      bw.close();
      return;
    }
    visited = new boolean[node+1];
    DFS(1, 0);

    visited = new boolean[node+1];
    maxWeight = 0;
    DFS(maxNode, 0);

    bw.write(maxWeight + "\n");
    br.close();
    bw.close();
  }

  public static void DFS(int root, int sumWeigh) {
    if(visited[root]) {
      return;
    }

    visited[root] = true;

    if(sumWeigh > maxWeight) {
      maxWeight = sumWeigh;
      maxNode = root;
    }

    for(Node next : v[root]) {
      if(!visited[next.n]) {
        DFS(next.n, sumWeigh + next.weight);
      }
    }
  }
  static class Node {
    int n, weight;

    Node(int n, int weight) {
      this.n = n;
      this.weight = weight;
    }
  }
}
