package Ex10816;

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
    String[] writtenNumStr = br.readLine().split(" ");
    int M = Integer.parseInt(br.readLine());
    String[] numStr = br.readLine().split(" ");

    int[] writtenNum = new int[N];
    int[] num = new int[M];

    for(int i = 0; i < N; i++) {
      writtenNum[i] = Integer.parseInt(writtenNumStr[i]);
    }
    for(int i = 0; i < M; i++) {
      num[i] = Integer.parseInt(numStr[i]);
    }

    Arrays.sort(writtenNum);

    for(int i = 0; i < M; i++) {
      int upper = 0;
      int lower = 0;

      lower = lowerBinary(writtenNum, num[i], N);
      upper = upperBinary(writtenNum, num[i], N);
      if(upper == N - 1 && writtenNum[N-1] == num[i]) {
        upper++;
      }
      bw.write((upper - lower) + " ");
    }
    br.close();
    bw.close();
  }

  public static int lowerBinary(int[] arr, int target, int size) {
    int start = 0;
    int end = size - 1;
    int mid = 0;

    while (end > start) {
      mid = (start + end) / 2;
      if(arr[mid] >= target) {
        end = mid;
      } else {
        start = mid + 1;
      }
    }
    return end;
  }

  public static int upperBinary(int[] arr, int target, int size) {
    int start = 0;
    int end = size - 1;
    int mid = 0;

    while (end > start) {
      mid = (start + end) / 2;
      if(arr[mid] > target) {
        end = mid;
      } else {
        start = mid + 1;
      }
    }
    return end;
  }
}
