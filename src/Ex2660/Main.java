package Ex2660;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  static int max = 51;
  static int N = 0;
  static int[] friends;
  static boolean[] isVisited;
  static ArrayList<Integer> v[] = new ArrayList[max];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    N = Integer.parseInt(br.readLine());

    for(int i = 1; i <= N; i++) {
      v[i] = new ArrayList<>();
    }
    friends = new int[N+1];
    while(true) {
      String[] input = br.readLine().split(" ");
      int key = Integer.parseInt(input[0]);
      int value = Integer.parseInt(input[1]);

      if(key == -1 && value == -1) {
        break;
      }
      v[key].add(value);
      v[value].add(key);
    }

    for(int i = 1; i <= N; i++) {
      isVisited = new boolean[N+1];
      BFS(i);
    }

    int min = N+1;

    for(int i = 1; i <= N; i++) {
      if(min > friends[i]) {
        min = friends[i];
      }
    }

    LinkedList<Integer> candidate = new LinkedList<>();
    int cnt = 0;
    for(int i = 1; i <= N; i++) {
      if(friends[i] == min) {
        candidate.add(i);
        cnt++;
      }
    }
    bw.write((min-1) + " " + cnt + "\n");

    for(Integer i : candidate) {
      bw.write(i + " ");
    }
    br.close();
    bw.close();
  }
  public static void BFS(int root) {
    Queue<Integer> q = new LinkedList<>();
    q.add(root);
    isVisited[root] = true;
    while(!q.isEmpty()) {
      friends[root]++;
      int queueSize=q.size();
      for(int k=0; k<queueSize; k++){
        int next=q.poll();
        for (int i = 0; i < v[next].size(); i++) {
          if (!isVisited[v[next].get(i)]) {
            isVisited[v[next].get(i)] = true;
            q.add(v[next].get(i));
          }
        }
      }
    }
  }
}
