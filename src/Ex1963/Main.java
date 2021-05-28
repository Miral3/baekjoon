package Ex1963;

/*
문제 이름 : 소수 경로
알고리즘 : BFS, 에라토스테네스의 체
자료구조 : 문자열, 배열
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
  static final int MAX = 10001;
  static int[] arr = new int[MAX];
  static int[] check;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


    primeNumberSieve();

    int testCase = Integer.parseInt(br.readLine());
    for(int i = 0; i < testCase; i++) {
      String[] input = br.readLine().split(" ");
      int start = Integer.parseInt(input[0]);
      int end = Integer.parseInt(input[1]);
      check = new int[MAX];

      if(start == end) {
        bw.write(0 + "\n");
      } else {
        BFS(start);
        bw.write(check[end]-1 + "\n");
      }
    }
    br.close();
    bw.close();
  }

  public static void primeNumberSieve() {
    for(int i = 0; i < MAX; i++) {
      arr[i] = i;
    }

    for(int i = 2; i < MAX; i++) {
      if(arr[i] == 0) {
        continue;
      }
      for(int j = i+i; j < MAX; j += i) {
        if(arr[j] % i == 0) {
          arr[j] = 0;
        }
      }
    }
  }

  public static void BFS(int start) {
    Queue<Integer> que  = new LinkedList<>();
    que.add(start);
    check[start] = 1;

    while(!que.isEmpty()) {
      int next = que.poll();
      for(int i = 0; i < 4; i++) {
        char[] nodeCh = Integer.toString(next).toCharArray();
        for(int j = 0; j < 10; j++) {
          if(i == 0 && j == 0) {
            continue;
          }
          nodeCh[i] = (char)(j+'0');
          int nodeInt = Integer.parseInt(new String(nodeCh));
          if(arr[nodeInt] != 0 && check[nodeInt] == 0) {
            check[nodeInt] = check[next] + 1;
            que.add(nodeInt);
          }
        }
      }
    }
  }
}

