package Ex10431;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int testCase = Integer.parseInt(br.readLine());

    for(int i = 0; i < testCase; i++) {
      String[] input = br.readLine().split(" ");
      int len = input.length;
      int cnt = 0;
      LinkedList<Integer> list = new LinkedList<>();

      for(int j = 1; j < len; j++) {
        list.add(Integer.parseInt(input[j]));
      }

      for(int k = 1; k < len-1; k++) {
        int target = list.get(k);

        while(true) {
          int idx = list.indexOf(target);
          if(idx < 1) {
            break;
          } else if(target > list.get(idx-1)) {
            break;
          }

          list.remove(idx);
          list.add(idx-1, target);
          cnt++;
        }
      }

      bw.write(i+1 + " ");
      bw.write(cnt + "\n");
    }

    br.close();
    bw.close();
  }
}
