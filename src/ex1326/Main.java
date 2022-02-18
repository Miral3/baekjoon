package ex1326;

/*
문제 이름: 폴짝폴짝
알고리즘: bfs
자료구조: 큐, 배열
*/

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int position;
    int cnt;

    public Node(int position, int cnt) {
        this.position = position;
        this.cnt = cnt;
    }
}

public class Main {
    static int n;
    static int[] arr;
    static int a;
    static int b;
    static boolean[] isVisited = new boolean[10001];
    static int answer = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i + 1] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        a = Integer.parseInt(input[0]);
        b = Integer.parseInt(input[1]);

        bfs();

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }

    public static void bfs() {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(a, 0));
        isVisited[a] = true;

        while (!que.isEmpty()) {
            Node cur = que.poll();
            int position = cur.position;
            int cnt = cur.cnt;

            if (position == b) {
                answer = cnt;
                return;
            }

            for (int i = 1; position + (arr[position] * i) <= n; i++) {
                int nxt = position + (arr[position] * i);
                if (!isVisited[nxt]) {
                    isVisited[nxt] = true;
                    que.add(new Node(nxt, cnt + 1));
                }
            }
            for (int i = 1; position - (arr[position] * i) >= 1; i++) {
                int nxt = position - (arr[position] * i);
                if (!isVisited[nxt]) {
                    isVisited[nxt] = true;
                    que.add(new Node(nxt, cnt + 1));
                }
            }
        }
    }
}
