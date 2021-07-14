package Ex1058;

/*
문제 이름 : 친구
알고리즘 : 그래프 탐색
자료구조 : 배열 리스트
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {
  static List<Integer>[] list;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N =Integer.parseInt(br.readLine());

    list = new ArrayList[N + 1];

    for(int i = 1; i <= N; i++) {
      list[i] = new ArrayList<>();
    }

    for(int i = 0; i < N; i++) {
      String[] input = br.readLine().split("");
      for(int j = 0; j < N; j++) {
        if(input[j].equals("Y")) {
          list[i+1].add(j+1);
          list[j+1].add(i+1);
        }
      }
    }

    int max = 0;
    for(int i = 1; i <= N; i++) {
      int cnt = 0;
      for(int j = 1; j <= N; j++) {
        if(j != i) {
          if(list[i].contains(j)) {
            cnt++;
          } else {
            for(int k = 0; k < list[i].size(); k++) {
              if(list[j].contains(list[i].get(k))) {
                cnt++;
                break;
              }
            }
          }
        }
      }
      max = Math.max(max, cnt);
    }

    System.out.println(max);

    br.close();
    bw.close();
  }
}