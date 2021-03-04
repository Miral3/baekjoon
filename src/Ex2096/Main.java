package Ex2096;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    int[] arr = new int[3 * N];
    int[] dpMin = new int[3 * N];
    int[] dpMax = new int[3 * N];

    for (int i = 0; i < N; i++) {
      String[] input = br.readLine().split(" ");
      arr[i * 3] = Integer.parseInt(input[0]);
      arr[(i * 3) + 1] = Integer.parseInt(input[1]);
      arr[(i * 3) + 2] = Integer.parseInt(input[2]);
    }

    for(int i = 0; i < 3; i++) {
      dpMin[i] = arr[i];
      dpMax[i] = arr[i];
    }

    for(int i = 3; i < N*3; i++) {
      if(i % 3 == 0) {
        dpMin[i] = arr[i] + Math.min(dpMin[i-3] , dpMin[i-2]);
      } else if(i % 3 == 1) {
        dpMin[i] = arr[i] + Math.min(dpMin[i-4] ,Math.min(dpMin[i-3], dpMin[i-2]));
      } else {
        dpMin[i] = arr[i] + Math.min(dpMin[i-4], dpMin[i-3]);
      }
    }

    for(int i = 3; i < N*3; i++) {
      if(i % 3 == 0) {
        dpMax[i] = arr[i] + Math.max(dpMax[i-3] , dpMax[i-2]);
      } else if(i % 3 == 1) {
        dpMax[i] = arr[i] + Math.max(dpMax[i-4] ,Math.max(dpMax[i-3], dpMax[i-2]));
      } else {
        dpMax[i] = arr[i] + Math.max(dpMax[i-4], dpMax[i-3]);
      }
    }

    int min = Math.min(dpMin[3*(N-1)],Math.min(dpMin[3*(N-1)+1], dpMin[3*(N-1)+2]));
    int max = Math.max(dpMax[3*(N-1)],Math.max(dpMax[3*(N-1)+1], dpMax[3*(N-1)+2]));

    bw.write(max + " " + min + "\n");

    br.close();
    bw.close();
  }
}
