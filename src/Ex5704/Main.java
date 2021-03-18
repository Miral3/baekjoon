package Ex5704;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    while(true) {
      String input = br.readLine();
      boolean[] check = new boolean[26];
      boolean result = true;

      if(input.equals("*")) {
        break;
      }

      for(int i = 0; i < input.length(); i++) {
        int strToInt = (int)input.charAt(i) - 97;
        if(strToInt != -65) {
          check[strToInt] = true;
        }
      }

      for(int i = 0; i < check.length; i++) {
        if(!check[i]) {
          result = false;
        }
      }

      if(!result) {
        bw.write("N" + "\n");
      } else {
        bw.write("Y" + "\n");
      }
    }

    br.close();
    bw.close();
  }
}
