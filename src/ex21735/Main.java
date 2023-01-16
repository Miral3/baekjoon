package ex21735;

/*
문제 이름: 눈덩이 굴리기
알고리즘: bfs
자료구조: 큐
*/

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int size;
    int cnt;
    int idx;

    public Node(int size, int cnt, int idx) {
        this.size = size;
        this.cnt = cnt;
        this.idx = idx;
    }
}
public class Main {
    static int n;
    static int m;
    static int[] arr;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        arr = new int[n + 1];
        input = br.readLine().split(" ");
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(input[i-1]);
        }

        bfs();

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }

    public static void bfs() {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(1, m, 0));
        while (!que.isEmpty()) {
            Node cur = que.poll();
            int size = cur.size;
            int cnt = cur.cnt;
            int idx = cur.idx;

            if (idx == n || cnt == 0) {
                continue;
            }

            if (idx < n) {
                answer = Math.max(size + arr[idx + 1], answer);
                que.add(new Node(size + arr[idx + 1], cnt - 1, idx + 1));
            }

            if (idx < n - 1) {
                answer = Math.max(size / 2 + arr[idx + 2], answer);
                que.add(new Node(size / 2 + arr[idx + 2], cnt - 1, idx + 2));
            }
        }
    }
}
