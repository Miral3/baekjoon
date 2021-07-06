package Ex13335;

/*
문제 이름 : 트럭
알고리즘 : 구현
자료구조 : 큐
*/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

class Node {
  int time, weight;

  public Node(int time, int weight) {
    this.time = time;
    this.weight = weight;
  }
}

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    String[] input = br.readLine().split(" ");
    int n = Integer.parseInt(input[0]); // 다리를 건너는 트럭의 수
    int w = Integer.parseInt(input[1]); // 다리의 길이
    int L = Integer.parseInt(input[2]); // 다리의 최대하중

    String[] truck = br.readLine().split(" ");
    Queue<Node> que = new LinkedList<>();
    int idx = 0;
    int time = 1;
    que.add(new Node(time, Integer.parseInt(truck[idx])));
    int weight = Integer.parseInt(truck[idx]);
    while(true) {
      time++;
      if(time - que.peek().time == w) {
        Node cur = que.poll();
        weight -= cur.weight;
      }
      if(idx < n - 1 && weight + Integer.parseInt(truck[idx + 1]) <= L) {
        idx++;
        que.add(new Node(time, Integer.parseInt(truck[idx])));
        weight += Integer.parseInt(truck[idx]);
      }

      if(que.isEmpty()) {
        break;
      }
    }

    System.out.println(time);
    br.close();
    bw.close();
  }
}