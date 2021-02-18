package Ex9657;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  static int[] dpArr;

  public  static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int rockCount = Integer.parseInt(br.readLine());

    dpArr = new int[1001];
    dpArr[2] = 1;

    dp(rockCount);

    if(dpArr[rockCount] == 0) {
      bw.write("SK");
    } else {
      bw.write("CY");
    }
    br.close();
    bw.close();
  }
  public static void dp(int N) {
    if(N < 5) {
      return;
    }

    for(int i = 5; i <= N; i++) {
      if(dpArr[i] != (dpArr[i-1]) || dpArr[i] != (dpArr[i-3])
          || dpArr[i] != (dpArr[i-4])) {
        continue;
      } else {
        dpArr[i] = 1;
      }
    }
  }
}
