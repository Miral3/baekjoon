package Ex15920;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int N = Integer.parseInt(br.readLine());
    String[] input = br.readLine().split("");
    int cnt = 0; // W count
    int position = 1; //A = 1, B = 2, C = 3
    boolean lever = false; // 5 = false, 1 = true
    boolean multiTrackDrifting = false;

    for(int i = 0; i < N; i++) {
      if(position == 3) {
        break;
      }
      if(input[i].equals("P")) {
        if(lever) {
          lever = false;
        } else {
          lever = true;
        }
        if(position == 2) {
          multiTrackDrifting = true;
        }
      } else {
        cnt++;
        position++;
      }
    }

    if(cnt < 2) {
      bw.write(0 + "\n");
    } else {
      if(multiTrackDrifting) {
        bw.write(6 + "\n");
      }
      else if(lever) {
        bw.write(1 + "\n");
      }
      else if(!lever){
        bw.write(5 + "\n");
      }
    }
    br.close();
    bw.close();
  }
}
