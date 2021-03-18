package Ex4108;

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
      String[] input = br.readLine().split(" ");
      int R = Integer.parseInt(input[0]);
      int C = Integer.parseInt(input[1]);
      int[] dx = {-1, 1, 0, 0, -1, -1, 1, 1};
      int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};
      String[][] map = new String[R][C];

      if(R == 0 && C == 0) {
        break;
      }

      for(int i = 0; i < R; i++) {
        input = br.readLine().split("");
        for(int j = 0; j < C; j++) {
          map[i][j] = input[j];
        }
      }

      for(int i = 0; i < R; i++) {
        for(int j = 0; j < C; j++) {
          int cnt = 0;

          if(map[i][j].equals(".")) {
            for(int k = 0; k < 8; k++) {
              int nx = i + dx[k];
              int ny = j + dy[k];

              if(nx >= 0 && ny >= 0 && nx < R && ny < C) {
                if(map[nx][ny].equals("*")) {
                  cnt ++;
                }
              }
            }
            map[i][j] = Integer.toString(cnt);
          }
        }
      }

      for(int i = 0; i < R; i++) {
        for(int j = 0; j < C; j++) {
          bw.write(map[i][j] + "");
        }
        bw.write("\n");
      }
    }

    bw.close();
    br.close();
  }
}
