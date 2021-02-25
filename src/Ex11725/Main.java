package Ex11725;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
  static final int max = 100001;
  static int N;
  static int[] arr;
  static boolean[] visited;
  static ArrayList<Integer> v[] = new ArrayList[max];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());
    arr = new int[N+1];
    visited = new boolean[N+1];

    for(int i = 1; i <= N; i++) {
      v[i] = new ArrayList<>();
    }

    for(int i = 0; i < N-1; i++) {
      String[] input = br.readLine().split(" ");
      int key = Integer.parseInt(input[0]);
      int value = Integer.parseInt(input[1]);
      v[key].add(value);
      v[value].add(key);
    }

    for(int i = 1; i <= N; i++) {
      Collections.sort(v[i]);
    }

    DFS(1);
    for(int i = 2; i <= N; i++) {
      bw.write(arr[i] + "\n");
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
        arr[v[x].get(i)] = x;
        DFS(v[x].get(i));
      }
    }
  }
}
