package Ex1920;

/*
문제 이름 : 수 찾기
알고리즘 : 이분 탐색
자료구조 : 배열
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    String[] input = br.readLine().split(" ");
    int[] A = new int[N];
    for(int i = 0; i < N; i++) {
      A[i] = Integer.parseInt(input[i]);
    }

    int M = Integer.parseInt(br.readLine());
    input = br.readLine().split(" ");
    Arrays.sort(A);
    for(int i = 0; i < M; i++) {
      bw.write(binarySearch(A, Integer.parseInt(input[i])) + "\n");
    }

    br.close();
    bw.close();
  }

  public static int binarySearch(int[] arr, int target) {
    int first = 0;
    int last = arr.length - 1;
    int mid = 0;

    while( first <= last) {
      mid = (first + last) / 2;

      if(target == arr[mid]) {
        return 1;
      } else {
        if(target < arr[mid]) {
          last = mid - 1;
        } else {
          first = mid + 1;
        }
      }
    }
    return 0;
  }
}
