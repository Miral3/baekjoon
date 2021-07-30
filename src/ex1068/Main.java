package ex1068;

/*
문제 이름: 트리
알고리즘: 그래프 탐색
자료구조: 트리
*/

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static final int max = 51;
    static int n, d, result = 0;
    static ArrayList<Integer> v[] = new ArrayList[max];
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];

        for(int i = 0; i < n; i++) {
            v[i] = new ArrayList<>();
        }

        String[] input = br.readLine().split(" ");
        int root = 0;

        d = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            int node = Integer.parseInt(input[i]);

            if(node >= 0 && i != d) {
                v[node].add(i);
            } else if(node == -1) {
                root = i;
            }
        }
        bfs(root);

        System.out.println(result);

        br.close();
        bw.close();
    }

    public static void bfs(int x) {
        Queue<Integer> que = new LinkedList<>();
        if(x != d) {
            que.add(x);
            visited[x] = true;
        }

        while (!que.isEmpty()) {
            int nxt = que.poll();

            for(int i = 0; i < v[nxt].size(); i++) {
                if(!visited[v[nxt].get(i)] && v[nxt].get(i) != d) {
                    visited[v[nxt].get(i)] = true;
                    que.add(v[nxt].get(i));
                }
            }

            if(v[nxt].size() == 0) {
                result++;
            }
        }
    }
}
