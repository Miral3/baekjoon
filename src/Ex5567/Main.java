package Ex5567;

/*
문제 이름 : 결혼식
알고리즘 : BFS
자료구조 : 배열 리스트
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
  static int n, m, result = 0;
  static List<Integer>[] list;
  static int[] check;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    m = Integer.parseInt(br.readLine());

    list = new ArrayList[n + 1];
    check = new int[n + 1];

    for(int i = 1; i <= n; i++) {
      list[i] = new ArrayList<>();
    }


    for(int i = 0; i < m ;i++) {
      String[] input = br.readLine().split(" ");
      int a = Integer.parseInt(input[0]);
      int b = Integer.parseInt(input[1]);

      list[a].add(b);
      list[b].add(a);
    }

    BFS();
    for(int i = 2; i <= n; i++) {
      if(check[i] == 2 || check[i] == 3) {
        result++;
      }
    }
    System.out.println(result);

    br.close();
    bw.close();
  }

  public static void BFS() {
    Queue<Integer> que = new LinkedList<>();
    que.add(1);
    check[1] = 1;

    while(!que.isEmpty()) {
      int next = que.poll();

      for(int i = 0; i < list[next].size(); i++) {
        if(check[list[next].get(i)] == 0) {
          check[list[next].get(i)] = check[next] + 1;
          que.add(list[next].get(i));
        }
      }
    }
  }
}