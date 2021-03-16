package Ex13419;

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
      String input = br.readLine();
      String first = "";
      String second = "";

      input += input;

      for(int j = 0; j < input.length()-1; j+=2) {
        char firstCh = input.charAt(j);
        char secondCh = input.charAt(j+1);

        if(first.contains(firstCh+"") || second.contains(secondCh+"")) {
          continue;
        }

        first += input.charAt(j);
        second += input.charAt(j + 1);
      }

      bw.write(first+"\n");
      bw.write(second+"\n");
    }
    br.close();
    bw.close();
  }
}
