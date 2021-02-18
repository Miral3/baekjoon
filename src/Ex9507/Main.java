package Ex9507;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  static long[] dpArr;

  public  static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int testCase= Integer.parseInt(br.readLine());
    int max = 0;
    int[] inputArr = new int[testCase];

    for(int i = 0; i < testCase; i++) {
      int input = Integer.parseInt(br.readLine());

      if(max < input) {
        max = input;
      }

      inputArr[i] = input;
    }

    dpArr = new long[max+1];
    dp(max);

    for(int i = 0; i < testCase; i++) {
      bw.write(dpArr[inputArr[i]] + "\n");
    }

    br.close();
    bw.close();
  }

  public static void dp(int N) {
    dpArr[0] = 1;
    dpArr[1] = 1;
    dpArr[2] = 2;
    dpArr[3] = 4;

    for(int i = 4; i <= N; i++) {
      dpArr[i] = dpArr[i-4] + dpArr[i-3] + dpArr[i-2] + dpArr[i-1];
    }
  }
}
