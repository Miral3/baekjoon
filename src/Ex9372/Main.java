package Ex9372;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  static final int max = 10001;
  static int node, edge, root, cnt;
  static ArrayList<Integer> v[] = new ArrayList[max];
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int testCase = Integer.parseInt(br.readLine());

    for(int i = 0; i < testCase; i++) {
      String[] input = br.readLine().split(" ");
      node = Integer.parseInt(input[0]);
      edge = Integer.parseInt(input[1]);

      for(int j = 1; j <= node; j++) {
        v[j] = new ArrayList<>();
      }

      for(int j = 0; j < edge; j++) {
        input = br.readLine().split(" ");
        int key = Integer.parseInt(input[0]);
        int value = Integer.parseInt(input[1]);

        v[key].add(value);
        v[value].add(key);

        if(j == 0) {
          root = key;
        }
      }

      visited = new boolean[node+1];
      cnt = 0;
      BFS();

      bw.write(cnt + "\n");
    }

    br.close();
    bw.close();
  }

  public static void BFS() {
    Queue<Integer> q = new LinkedList<>();
    q.add(root);
    visited[root] = true;

    while(!q.isEmpty()) {
      int next = q.poll();
      for(int i = 0; i < v[next].size(); i++) {
        if(!visited[v[next].get(i)]) {
          visited[v[next].get(i)] = true;
          q.add(v[next].get(i));
          cnt++;
        }
      }
    }
  }
}
