package Ex10973;

/*
문제 이름 : 이전 순열
알고리즘 : 구현
자료구조 : 배열
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int n = Integer.parseInt(br.readLine());
    String[] input = br.readLine().split(" ");
    int[] arr = new int[n];

    for(int i = 0; i < n; i++) {
      arr[i] = Integer.parseInt(input[i]);
    }

    int idx = n - 1;
    while(idx > 0 && arr[idx - 1] <= arr[idx]) {
      idx--;
    }

    if(idx <= 0) {
      System.out.println(-1);
      return;
    }

    int idx2 = n - 1;
    while(arr[idx - 1] <= arr[idx2]) {
      idx2--;
    }
    swap(arr, idx - 1, idx2);

    idx2 = n - 1;
    while(idx < idx2) {
      swap(arr, idx, idx2);
      idx++;
      idx2--;
    }

    for(int i = 0; i < n; i++) {
      System.out.print(arr[i] + " ");
    }

    br.close();
    bw.close();
  }

  public static void swap(int[] arr, int x, int y) {
    int temp = arr[x];
    arr[x] = arr[y];
    arr[y] = temp;
  }
}