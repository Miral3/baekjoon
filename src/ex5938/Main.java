package ex5938;

/*
문제 이름: Daisy Chains in the Field
알고리즘: bfs
자료구조: 배열 리스트, 큐
*/

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static List<Integer> v[];
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        v = new ArrayList[n + 1];
        isVisited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            v[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int left = Integer.parseInt(input[0]);
            int right = Integer.parseInt(input[1]);
            v[left].add(right);
            v[right].add(left);
        }

        bfs();

        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (!isVisited[i]) {
                result.append(i + "\n");
            }
        }

        if (result.toString().equals("")) {
            bw.write(0 + "\n");
        } else {
            bw.write(result.toString());
        }
        br.close();
        bw.close();
    }

    public static void bfs() {
        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        isVisited[1] = true;

        while (!que.isEmpty()) {
            int cur = que.poll();

            for (Integer next : v[cur]) {
                if (!isVisited[next]) {
                    isVisited[next] = true;
                    que.add(next);
                }
            }
        }
    }
}
