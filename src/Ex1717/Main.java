package Ex1717;

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

    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]);
    int m = Integer.parseInt(input[1]);
    root = new int[n+1];
    rank = new int[n+1];

    for(int i = 0; i <= n; i++) {
      root[i] = i;
      rank[i] = 0;
    }

    for(int i = 0; i < m; i++) {
      input = br.readLine().split(" ");
      int type = Integer.parseInt(input[0]);
      int a = Integer.parseInt(input[1]);
      int b = Integer.parseInt(input[2]);

      if(type == 0) {
        union(a, b);
      } else if(type == 1) {
        if(find(a) == find(b)) {
          bw.write("YES\n");
        } else {
          bw.write("NO\n");
        }
      }
    }

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


