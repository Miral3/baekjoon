package Ex2644;

/*
문제 이름 : 촌수계산
알고리즘 : 그래프탐색
자료구조 : 배열
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  static int n, m, targetX, targetY, result;
  static boolean[] visited;
  static int[][] arr;

  public  static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    n = Integer.parseInt(br.readLine());
    String[] input1 = br.readLine().split(" ");
    targetX = Integer.parseInt(input1[0]);
    targetY = Integer.parseInt(input1[1]);
    m = Integer.parseInt(br.readLine());

    arr = new int[101][101];
    visited = new boolean[101];
    for(int i = 0; i < m; i++) {
      String[] input2 = br.readLine().split(" ");
      int key = Integer.parseInt(input2[0]);
      int value = Integer.parseInt(input2[1]);

      arr[key][value] = 1;
      arr[value][key] = 1;
    }

    result = 0;
    DFS(targetX, targetY, 0);

    if(result == 0) {
      System.out.println(-1);
    } else {
      System.out.println(result);
    }

    br.close();
    bw.close();
  }

  public static void DFS(int me, int find, int num) {
    visited[me] = true;

    if(me == find) {
      result = num;
      return;
    }

    for(int i = 1; i <=n; i++) {
      if(arr[me][i] == 1 && !visited[i]) {
        DFS(i, find, num + 1);
      }
    }
  }
}
