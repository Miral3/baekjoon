package Ex19564;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String input = br.readLine();
    int cnt = 1;

    for(int i = 0; i < input.length()-1; i++) {
      if((int)input.charAt(i) < (int)input.charAt(i+1)) {
        continue;
      }
      cnt++;
    }

    bw.write(cnt+"\n");
    br.close();
    bw.close();
  }
}
