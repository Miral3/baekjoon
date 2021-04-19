package Ex1972;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    while(true) {
      String input = br.readLine();
      boolean isSurprising = true;

      if(input.equals("*")) {
        break;
      }

      int len = input.length();
      for(int i = 1; i < len; i++) {
        HashSet<String> hash = new HashSet<>();
        for(int j = 0; j+i < len; j++) {
          int size = hash.size();
          String split = input.substring(j, j+1) + input.substring(j+i, j+i+1);
          hash.add(split);
          if(size == hash.size()) {
            isSurprising = false;
            break;
          }
        }
        if(!isSurprising) {
          break;
        }
      }
      if(isSurprising) {
        bw.write(input + " is surprising.\n");
      } else {
        bw.write(input + " is NOT surprising.\n");
      }
    }
    br.close();
    bw.close();
  }
}
