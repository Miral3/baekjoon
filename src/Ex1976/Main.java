package Ex1976;

/*
문제 이름 : 집함의 표현
알고리즘 : 분리 집합
자료구조 : 트리
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  static int root[];
  static int rank[];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    int n = Integer.parseInt(br.readLine());
    int m = Integer.parseInt(br.readLine());
    root = new int[n+1];
    rank = new int[n+1];

    for(int i = 0; i <= n; i++) {
      root[i] = i;
      rank[i] = 0;
    }

    String[] input;
    for(int i = 1; i <= n; i++) {
      input = br.readLine().split(" ");

      for(int j = 1; j <= n; j++) {
        int check = Integer.parseInt(input[j-1]);
        if(i == j) {
          continue;
        }
        if(check == 1) {
          union(i, j);
        }
      }
    }

    input = br.readLine().split(" ");
    for(int i = 0; i < m-1; i++) {
      int a = Integer.parseInt(input[i]);
      int b = Integer.parseInt(input[i+1]);

      if(find(a) != find(b)) {
        System.out.println("NO");
        return;
      }
    }
    System.out.println("YES");

    br.close();
    bw.close();
  }

  static int find(int x) {
    if(root[x] == x) {
      return x;
    } else {
      return root[x] = find(root[x]);
    }
  }

  static void union(int x, int y) {
    x = find(x);
    y = find(y);

    if(x == y) {
      return;
    }

    if(rank[x] < rank[y]) {
      root[x] = y;
    } else {
      root[y] = x;

      if(rank[x] == rank[y]) {
        rank[x]++;
      }
    }
  }
}


