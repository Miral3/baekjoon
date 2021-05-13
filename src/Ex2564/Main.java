package Ex2564;

/*
문제 이름 : 경비원
알고리즘 : 구현
자료구조 : 배열 리스트
*/

import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] size = br.readLine().split(" ");
    int x = Integer.parseInt(size[0]);
    int y = Integer.parseInt(size[1]);
    int N = Integer.parseInt(br.readLine());
    ArrayList<Point> list = new ArrayList<>();
    for(int i = 0; i < N; i++) {
      String[] position = br.readLine().split(" ");
      int direction = Integer.parseInt(position[0]);
      int distance = Integer.parseInt(position[1]);

      list.add(new Point(direction, distance));
    }

    String[] donggeun = br.readLine().split(" ");
    int dgX = Integer.parseInt(donggeun[0]);
    int dgY = Integer.parseInt(donggeun[1]);
    int ans = 0;
    for(int i = 0; i < N; i++) {
      int storeX = (int)list.get(i).getX();
      int storeY = (int)list.get(i).getY();

      if(dgX == storeX) {
        ans += Math.abs(dgY - storeY);
      } else {
        if(dgX == 1) {
          if(storeX == 2) {
            ans += Math.min(( dgY + y + storeY ),
                ( (x-dgY) + y + (x-storeY) ));
          } else if(storeX == 3) {
            ans += dgY + storeY;
          } else if(storeX == 4) {
            ans += (x-dgY) + storeY;
          }
        } else if(dgX == 2) {
          if(storeX == 1) {
            ans += Math.min(( dgY + y + storeY ),
                ( (x-dgY) + y + (x-storeY) ));
          } else if(storeX == 3) {
            ans += dgY + (y - storeY);
          } else if(storeX == 4) {
            ans += (x-dgY) + (y - storeY);
          }
        }
        else if(dgX == 3) {
          if(storeX == 4) {
            ans += Math.min(( dgY + x + storeY ),
                ( (y-dgY) + x + (y-storeY) ));
          } else if(storeX == 1) {
            ans += dgY + storeY;
          } else if(storeX == 2) {
            ans += (y-dgY) + storeY;
          }
        }
        else if(dgX == 4) {
          if(storeX == 3) {
            ans += Math.min(( dgY + x + storeY ),
                ( (y-dgY) + x + (y-storeY) ));
          } else if(storeX == 1) {
            ans += dgY + (x - storeY);
          } else if(storeX == 2) {
            ans += (x-dgY) + (x - storeY);
          }
        }
      }
    }
    bw.write(ans + "\n");
    br.close();
    bw.close();
  }
}