package ex12761;

/*
문제 이름: 돌다리
알고리즘: 그래프 탐색
자료구조: 배열
*/

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int value, idx;

    public Node(int value, int idx) {
        this.value = value;
        this.idx = idx;
    }
}

public class Main {
    static final int MAX = 100001;
    static int a, b, n, m;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        a = Integer.parseInt(input[0]);
        b = Integer.parseInt(input[1]);
        n = Integer.parseInt(input[2]);
        m = Integer.parseInt(input[3]);

        visited = new boolean[MAX];
        bfs();

        br.close();
        bw.close();
    }

    public static void bfs() {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(n, 0));
        visited[n] = true;

        while (!que.isEmpty()) {
            Node cur = que.poll();
            int value = cur.value;
            int idx = cur.idx;

            if(value == m) {
                System.out.println(idx);
                return;
            }
            if(value - 1 >= 0 && !visited[value - 1]) {
                visited[value - 1] = true;
                que.add(new Node(value - 1, idx + 1));
            }
            if(value + 1 < MAX && !visited[value + 1]) {
                visited[value + 1] = true;
                que.add(new Node(value + 1, idx + 1));
            }
            if(value - a >= 0 && !visited[value - a]) {
                visited[value - a] = true;
                que.add(new Node(value - a, idx + 1));
            }
            if(value + a < MAX && !visited[value + a]) {
                visited[value + a] = true;
                que.add(new Node(value + a, idx + 1));
            }
            if(value - b >= 0 && !visited[value - b]) {
                visited[value - b] = true;
                que.add(new Node(value - b, idx + 1));
            }
            if(value + b < MAX && !visited[value + b]) {
                visited[value + b] = true;
                que.add(new Node(value + b, idx + 1));
            }
            if(value * a < MAX && !visited[value * a]) {
                visited[value * a] = true;
                que.add(new Node(value * a, idx + 1));
            }
            if(value * b < MAX && !visited[value * b]) {
                visited[value * b] = true;
                que.add(new Node(value * b, idx + 1));
            }

        }
    }
}
