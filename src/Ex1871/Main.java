package Ex1871;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int testCase = Integer.parseInt(br.readLine());

    for(int i = 0; i < testCase; i++) {
      String[] input = br.readLine().split("-");
      String first = input[0];
      String second = input[1];
      int firstSum = 0;
      int secondSum = Integer.parseInt(second);

      for(int j = 0; j < first.length(); j++) {
        int index = (int)first.charAt(j) - 65;
        firstSum += (index * Math.pow(26, first.length()-j-1));
      }

      int diff = Math.abs(firstSum - secondSum);
      if(diff <= 100) {
        bw.write("nice\n");
      } else {
        bw.write("not nice\n");
      }
    }

    br.close();
    bw.close();
  }
}
