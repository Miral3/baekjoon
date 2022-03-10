package ex11286;

/*
문제 이름: 절대값 힙
알고리즘: 우선순위 큐
자료구조: 우선순위 큐
*/

import java.io.*;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    int num;
    int abs;

    public Node(int num, int abs) {
        this.num = num;
        this.abs = abs;
    }

    @Override
    public int compareTo(Node o) {
        if (abs - o.abs == 0) {
            return num - o.num;
        } else {
            return abs - o.abs;
        }
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            int abs = Math.abs(num);

            if (num == 0) {
                if (pq.isEmpty()) {
                    bw.write("0\n");
                } else {
                    bw.write(pq.poll().num + "\n");
                }
            } else {
                pq.add(new Node(num, abs));
            }
        }

        br.close();
        bw.close();
    }
}
