package ex14226;

/*
문제 이름: 이모티콘
알고리즘: 그래프 탐색
자료구조: 배열
*/

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int value, copy, count;

    public Node(int value, int copy, int count) {
        this.value = value;
        this.copy = copy;
        this.count = count;
    }
}

public class Main {
    static final int max = 10001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int s = Integer.parseInt(br.readLine());
        bfs(s);

        br.close();
        bw.close();
    }

    public static void bfs(int s) {
        boolean[][] isVisited = new boolean[10001][10001];
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(1, 0, 0));
        isVisited[1][0] = true;

        while(!que.isEmpty()) {
            Node cur = que.poll();
            int val = cur.value;
            int copy = cur.copy;
            int cnt = cur.count;

            if(val == s) {
                System.out.println(cnt);
                return;
            }

            if(val > 1 && !isVisited[val-1][copy]) {
                isVisited[val-1][copy] = true;
                que.add(new Node(val - 1, copy, cnt + 1));
            }
            if(val < max && !isVisited[val+copy][copy]) {
                isVisited[val+copy][copy] = true;
                que.add(new Node(val + copy, copy, cnt + 1));
            }
            if(val != copy && !isVisited[val][val]) {
                isVisited[val][val] = true;
                que.add(new Node(val, val, cnt + 1));
            }
        }
    }
}
