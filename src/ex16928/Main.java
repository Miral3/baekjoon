package ex16928;

/*
문제 이름: 뱀과 사다리 게임
알고리즘: bfs
자료구조: 큐, 배열
*/

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int num;
    int cnt;

    public Node(int num, int cnt) {
        this.num = num;
        this.cnt = cnt;
    }
}

public class Main {
    static int n;
    static int m;
    static int[] ladder;
    static int[] snake;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        ladder = new int[101];
        snake = new int[101];

        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            ladder[x] = y;
        }
        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int u = Integer.parseInt(input[0]);
            int v = Integer.parseInt(input[1]);
            snake[u] = v;
        }

        bfs();

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }

    public static void bfs() {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(1, 0));
        boolean[] isVisited = new boolean[101];
        isVisited[1] = true;

        while (!que.isEmpty()) {
            Node cur = que.poll();
            int num = cur.num;
            int cnt = cur.cnt;

            if (num == 100) {
                answer = cnt;
                return;
            }

            for (int i = 1; i <= 6; i++) {
                int nxt = num + i;

                if (nxt > 100) {
                    continue;
                }
                if (isVisited[nxt]) {
                    continue;
                }

                if (ladder[nxt] != 0) {
                    que.add(new Node(ladder[nxt], cnt + 1));
                } else if (snake[nxt] != 0) {
                    que.add(new Node(snake[nxt], cnt + 1));
                } else {
                    que.add(new Node(nxt, cnt + 1));
                }

                isVisited[nxt] = true;
            }
        }
    }
}
