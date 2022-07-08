package ex24446;

/*
문제 이름: 알고리즘 수업 - 너비 우선 탐색 3
알고리즘: bfs
자료구조: 배열 리스트, 큐
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int node;
    int depth;

    public Node(int node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] graphInfo = br.readLine().split(" ");
        int n = Integer.parseInt(graphInfo[0]);
        int m = Integer.parseInt(graphInfo[1]);
        int r = Integer.parseInt(graphInfo[2]);

        ArrayList<Integer> v[] = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            v[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            String[] edge = br.readLine().split(" ");
            int start = Integer.parseInt(edge[0]);
            int end = Integer.parseInt(edge[1]);

            v[start].add(end);
            v[end].add(start);
        }

        bfs(n, r, v);

        br.close();
        bw.close();
    }

    public static void bfs(int n, int r, ArrayList<Integer> v[]) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(r, 0));
        int[] isVisited = new int[n + 1];
        Arrays.fill(isVisited, -1);
        isVisited[r] = 0;

        while (!que.isEmpty()) {
            Node cur = que.poll();
            int node = cur.node;
            int depth = cur.depth;

            for (int nxt : v[node]) {
                if (isVisited[nxt] < 0) {
                    isVisited[nxt] = depth + 1;
                    que.add(new Node(nxt, depth + 1));
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(isVisited[i]);
        }
    }
}
