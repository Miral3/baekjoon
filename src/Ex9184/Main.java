package Ex9184;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  static int[][][] wData = new int[21][21][21];

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    while(true) {
      String[] input = br.readLine().split(" ");

      int A = Integer.parseInt(input[0]);
      int B = Integer.parseInt(input[1]);
      int C = Integer.parseInt(input[2]);

      if(A == -1 && B == -1 && C == -1) {
        break;
      }

      bw.write("w(" + A + ", " + B + ", " + C + ") = " + w(A, B, C) + "\n");
    }
    br.close();
    bw.close();
  }
  public static int w(int a, int b, int c) {
    if(a >= 0 && a <= 20 && b >= 0 && b <= 20 && c >= 0 && c <= 20) {
      if(wData[a][b][c] != 0) {
        return wData[a][b][c];
      }
    }
    if(a <= 0 || b <= 0 || c <= 0) {
      return 1;
    }
    if(a > 20 || b > 20 || c > 20) {
      return wData[20][20][20] = w(20, 20, 20);
    }

    if(a < b && b < c) {
      return wData[a][b][c] = w(a,b ,c-1) + w(a, b-1, c-1) - w(a, b-1, c);
    }

    return wData[a][b][c] =  w(a-1, b, c) + w(a-1, b-1, c) +
          w(a-1, b, c-1) - w(a-1, b-1, c-1);
  }
}
