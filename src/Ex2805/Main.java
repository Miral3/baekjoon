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
    int M = Integer.parseInt(input[1]);
    int[] trees = new int[N];
    int max = 0;
    input = br.readLine().split(" ");

    for (int i = 0; i < N; i++) {
      trees[i] = Integer.parseInt(input[i]);
    }

    Arrays.sort(trees);

    System.out.println(binarySearch(trees, N, M));
    br.close();
    bw.close();
  }

  public static int binarySearch(int[] arr, int N, int M) {
    int left = 0;
    int right = arr[N - 1];
    int result = 0;

    while (left <= right) {
      int mid = (left + right) / 2;
      int sum = 0;

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
