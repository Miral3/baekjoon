package Ex14719;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
  public  static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input = br.readLine().split(" ");
    int row = Integer.parseInt(input[0]);
    int column = Integer.parseInt(input[1]);
    int count = 0;
    int result = 0;
    int[][] world = new int[row][column];

    input = br.readLine().split(" ");
    int[] block = new int[column];

    for(int i = 0; i < column; i++) {
      block[i] = Integer.parseInt(input[i]);

      if(block[i] != 0) {
        for(int j = 0; j < block[i]; j++) {
          world[row-1-j][i] = 1;
        }
      }
    }

    for(int i = row-1; i >= 0; i--) {
      boolean isBlocked = false;
      count = 0;

      for(int j = 0; j < column; j++) {
        if(world[i][j] == 1) {
          if(!isBlocked) {
            isBlocked = true;
          } else if(count > 0){
            result += count;
            count = 0;
          }
        }
        else {
          if(isBlocked) {
            count++;
          }
        }
      }
    }

    bw.write(result+"");

    br.close();
    bw.close();
  }
}
