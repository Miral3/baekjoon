package Ex12865;

import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input = br.readLine().split(" ");
    int testCase = Integer.parseInt(input[0]);
    int maxWeight = Integer.parseInt(input[1]);
    int[][] thing = new int[testCase+1][2];
    int[][] thingData = new int[testCase+1][maxWeight+1];

    for (int i = 1; i <= testCase; i++) {
      input = br.readLine().split(" ");
      int thingWeight = Integer.parseInt(input[0]);
      int thingValue = Integer.parseInt(input[1]);

      thing[i][0] = thingWeight;
      thing[i][1] = thingValue;
    }

    for(int i = 1; i <= testCase; i++) {
      int weight = thing[i][0];
      int value = thing[i][1];

      for(int j = 0; j <= maxWeight; j++) {
        if(j < weight) {
          thingData[i][j] = thingData[i-1][j];
        } else {
          thingData[i][j] = Math.max(thingData[i-1][j], thingData[i-1][j-weight] + value);
        }
      }
    }

    bw.write(thingData[testCase][maxWeight] + "\n");

    br.close();
    bw.close();
  }
}
