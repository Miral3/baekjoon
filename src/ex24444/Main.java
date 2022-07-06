package ex24444;

/*
문제 이름: 알고리즘 수업 - 너비 우선 탐색 1
알고리즘: bfs
자료구조: 배열 리스트, 큐
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int max = 200001;
    static ArrayList<Integer> v[] = new ArrayList[max];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] graphInfo = br.readLine().split(" ");
        int n = Integer.parseInt(graphInfo[0]);
        int m = Integer.parseInt(graphInfo[1]);
        int r = Integer.parseInt(graphInfo[2]);

        for (int i = 1; i <= n; i++) {
            v[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            String[] edgeInfo = br.readLine().split(" ");
            int start = Integer.parseInt(edgeInfo[0]);
            int end = Integer.parseInt(edgeInfo[1]);
            v[start].add(end);
            v[end].add(start);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(v[i]);
        }

        bfs(n, r);

        System.out.println();
        br.close();
        bw.close();
    }
    public static void bfs(int n, int r) {
        int count = 1;
        int[] isVisited = new int[n + 1];
        isVisited[r] = count;
        count++;
        Queue<Integer> que = new LinkedList<>();
        que.add(r);

        while(!que.isEmpty()) {
            int cur = que.poll();

            for (int i = 0; i < v[cur].size(); i++) {
                if (isVisited[v[cur].get(i)] == 0) {
                    isVisited[v[cur].get(i)] = count;
                    que.add(v[cur].get(i));
                    count++;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(isVisited[i]);
        }
    }
}
