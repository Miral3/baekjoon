package Ex2805;

/*
문제 이름 : 나무 자르기
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

    String[] input = br.readLine().split(" ");
    int N = Integer.parseInt(input[0]);
    long M = Integer.parseInt(input[1]);
    long[] trees = new long[N];
    input = br.readLine().split(" ");

    for (int i = 0; i < N; i++) {
      trees[i] = Integer.parseInt(input[i]);
    }

    Arrays.sort(trees);

    System.out.println(binarySearch(trees, N, M));
    br.close();
    bw.close();
  }

  public static long binarySearch(long[] arr, int N, long M) {
    long left = 0;
    long right = arr[N - 1];
    long result = 0;

    while (left <= right) {
      long mid = (left + right) / 2;
      long sum = 0;

      for (int i = 0; i < N; i++) {
        if (mid < arr[i]) {
          sum += arr[i] - mid;
        }
      }
      if (sum >= M) {
        if (result < mid) {
          result = mid;
        }
        left = mid + 1;
      } else {
        right = mid - 1;
      }

    }
    return result;
  }
}
