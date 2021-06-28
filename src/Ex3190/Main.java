package Ex3190;

/*
문제 이름 : 뱀
알고리즘 : 구현
자료구조 : 덱
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

class Node {
  int y, x;

  public Node(int y, int x) {
    this.y = y;
    this.x = x;
  }
}

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    int N = Integer.parseInt(br.readLine());
    int K = Integer.parseInt(br.readLine());

    int[][] map = new int[N + 1][N + 1];
    for(int i = 0; i < K; i++) {
      String[] input1 = br.readLine().split(" ");
      int appleY = Integer.parseInt(input1[0]);
      int appleX = Integer.parseInt(input1[1]);
      map[appleY][appleX] = 1;
    }

    int L = Integer.parseInt(br.readLine());
    int[] num = new int[L];
    String[] c = new String[L];
    for(int i = 0; i < L; i++) {
      String[] input2 = br.readLine().split(" ");
      num[i] = Integer.parseInt(input2[0]);
      c[i] = input2[1];
    }

    int result = 0;
    int y = 1;
    int x = 1;
    int directionIdx = 0;
    int commandIdx = 0;
    Deque<Node> que = new ArrayDeque<>();
    while(true) {
      result++;

      y += dy[directionIdx];
      x += dx[directionIdx];
      int preY = y - dy[directionIdx];
      int preX = x - dx[directionIdx];

      if((y < 1 || x < 1 || y > N || x > N) || map[y][x] == 2) {
        System.out.println(result);
        break;
      }

      if(map[y][x] == 1) {
        map[y][x] = 2;
        que.add(new Node(preY, preX));
      }
      else {
        if(!que.isEmpty()) {
          map[y][x] = 2;
          map[que.getFirst().y][que.getFirst().x] = 0;
          que.removeFirst();
          que.addLast(new Node(preY, preX));
        }
      }

      if(commandIdx < L && num[commandIdx] == result) {
        if(c[commandIdx].equals("D")) {
          directionIdx++;
        } else if(c[commandIdx].equals("L")) {
          directionIdx--;
        }
        if(directionIdx < 0) {
          directionIdx += 4;
        }
        directionIdx %= 4;
        commandIdx++;
      }
    }
    br.close();
    bw.close();
  }
}