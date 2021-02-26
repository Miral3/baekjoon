package Ex1389;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  static final int max = 10001;
  static int node, edge, sum;
  static boolean[] visited;
  static ArrayList<Integer> v[] = new ArrayList[max];

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input = br.readLine().split(" ");
    node = Integer.parseInt(input[0]);
    edge = Integer.parseInt(input[1]);

    for(int i = 1; i<= node; i++) {
      v[i] = new ArrayList<>();
    }

    for(int i = 0; i < edge; i++) {
      input = br.readLine().split(" ");
      int key = Integer.parseInt(input[0]);
      int value = Integer.parseInt(input[1]);
      v[key].add(value);
      v[value].add(key);
    }

    for(int i = 1; i <= node; i++) {
      Collections.sort(v[i]);
    }

    int min = 100001;
    int result = 0;
    for(int i = 1; i <= node; i++) {
      visited = new boolean[node+1];
      BFS(i);
      if(min > sum) {
        min = sum;
        result = i;
      }
    }
    bw.write(result + " ");

    br.close();
    bw.close();
  }

  public static void BFS(int root) {
    Queue<Info> que = new LinkedList<>();
    int cnt = 0;
    sum = 0;
    que.add(new Info(root, cnt));
    visited[root] = true;

    while(!que.isEmpty()) {
      Info info = que.poll();
      int x = info.getX();
      int y= info.getY();
      for(int i = 0; i < v[x].size(); i++) {
        if(!visited[v[x].get(i)]) {
          visited[v[x].get(i)] = true;
          que.add(new Info(v[x].get(i), y+1));
          sum += (y+1);
        }
      }
    }
  }
}
class Info {
  int x;
  int y;

  public Info(int x, int y) {
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
