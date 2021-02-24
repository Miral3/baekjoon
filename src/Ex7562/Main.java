package Ex7562;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;

public class Main {
  static int size;
  static int currentX, currentY, targetX, targetY;
  static boolean[][] visited;
  static int[] dx = {1, -1, 2, 2, -2, -2, -1 ,1};
  static int[] dy = {-2, -2, 1, -1, 1, -1, 2, 2};

  public  static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int testCase = Integer.parseInt(br.readLine());
    for(int i  = 0; i < testCase; i++) {
      size = Integer.parseInt(br.readLine());
      visited = new boolean[size][size];

      String[] currentPosition = br.readLine().split(" ");
      currentX = Integer.parseInt(currentPosition[0]);
      currentY = Integer.parseInt(currentPosition[1]);

      String[] targetPosition = br.readLine().split(" ");
      targetX = Integer.parseInt(targetPosition[0]);
      targetY = Integer.parseInt(targetPosition[1]);

      bw.write(BFS() + "\n");
    }

    br.close();
    bw.close();
  }
  public static int BFS() {
    int x = currentX;
    int y = currentY;
    int result = 0;
    LinkedList<Info> list = new LinkedList<>();

    list.add(new Info(x, y, result));
    visited[x][y] = true;

    while(!list.isEmpty()) {
      Info info = list.poll();
      x = info.getPositionX();
      y = info.getPositionY();
      result = info.getDistance();

      if(x == targetX && y == targetY) {
        break;
      }
      for (int i = 0; i < 8; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (nx >= 0 && ny >= 0 && nx < size && ny < size) {
          if (!visited[nx][ny]) {
            visited[nx][ny] = true;
            list.add(new Info(nx, ny, result+1));
          }
        }
      }
    }

    list.clear();

    return result;
  }
}

class Info {
  int positionX;
  int positionY;
  int distance;

  public Info(int positionX, int positionY, int distance) {
    this.positionX = positionX;
    this.positionY = positionY;
    this.distance = distance;
  }

  public int getPositionX() {
    return positionX;
  }
  public int getPositionY() {
    return positionY;
  }
  public int getDistance() {
    return distance;
  }
}