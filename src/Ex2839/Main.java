package Ex2839;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static int sugarData[];
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int sugar = Integer.parseInt(br.readLine());
    sugarData = new int[5001];
    sugarData[0] = -1;
    sugarData[1] = -1;
    sugarData[2] = -1;
    sugarData[3] = 1;
    sugarData[4] = -1;
    sugarData[5] = 1;
    System.out.println(dp(sugar));
  }
  public static int dp(int n) {
    if(n <= 5) {
      return sugarData[n];
    }
    for(int i = 6; i <= n; i++) {
      int dataThr = Integer.MAX_VALUE;
      int dataFiv = Integer.MAX_VALUE;
      if(sugarData[i-3] != -1) {
        dataThr = sugarData[i-3] + 1;
      }
      if(sugarData[i-5] != -1) {
        dataFiv = sugarData[i-5] + 1;
      }
      if(sugarData[i-3] == -1 && sugarData[i-5] == -1) {
        sugarData[i] = -1;
        continue;
      }
      sugarData[i] = Math.min(dataThr, dataFiv);
    }
    return sugarData[n];
  }
}
