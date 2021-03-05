package Ex10451;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
  static final int max = 1001;
  static int node, edge, cnt;
  static boolean[] visited;
  static ArrayList<Integer> v[] = new ArrayList[max];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int testCase = Integer.parseInt(br.readLine());


    for(int i = 0; i < testCase; i++) {
      node = Integer.parseInt(br.readLine());
      edge = node;
      cnt = 0;
      String[] input = br.readLine().split(" ");

      for(int j = 1; j <= node; j++) {
        v[j] = new ArrayList<>();
      }

      for(int j = 0; j < edge; j++) {
        int key = Integer.parseInt(input[j]);
        int value = j+1;
        v[key].add(value);
        v[value].add(key);
      }

      for(int j = 1; j <= node; j++) {
        Collections.sort(v[j]);
      }

      visited = new boolean[node+1];
      for(int j = 1; j <= node; j++) {
        if(!visited[j]) {
          DFS(j);
          cnt++;
        }
      }
      bw.write(cnt + "\n");
    }

    br.close();
    bw.close();
  }

  public static void DFS(int x) {
    if(visited[x]) {
      return;
    }

    visited[x] = true;
    for(int i = 0; i < v[x].size(); i++) {
      if(!visited[v[x].get(i)]) {
        DFS(v[x].get(i));
      }
    }
  }
}
