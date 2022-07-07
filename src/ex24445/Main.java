package ex24445;

/*
문제 이름: 알고리즘 수업 - 너비 우선 탐색 2
알고리즘: bfs
자료구조: 배열 리스트, 큐
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

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

        for (int i = 1; i <= n; i++) {
            Collections.sort(v[i], Collections.reverseOrder());
        }

        bfs(n, r, v);

        br.close();
        bw.close();
    }

    public static void bfs(int n, int r, ArrayList<Integer> v[]) {
        int count = 1;
        Queue<Integer> que = new LinkedList<>();
        que.add(r);
        int[] isVisited = new int[n + 1];
        isVisited[r] = count;
        count++;

        while (!que.isEmpty()) {
            int cur = que.poll();

            for (int nxt : v[cur]) {
                if (isVisited[nxt] < 1) {
                    isVisited[nxt] = count;
                    que.add(nxt);
                    count++;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(isVisited[i]);
        }
    }
}
