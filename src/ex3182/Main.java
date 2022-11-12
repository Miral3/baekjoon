package ex3182;

/*
문제 이름: 한동이는 공부가 하기 싫어!
알고리즘: bfs
자료구조: 배열 리스트, 큐
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {
    static int n;
    static List<Integer>[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        v = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            v[i] = new ArrayList();
        }

        for (int i = 1; i <= n; i++) {
            v[i].add(Integer.parseInt(br.readLine()));
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(v[i]);
        }

        int max = -1;
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            int depth = bfs(i);
            if (max < depth ) {
                answer = i;
                max = depth;
            }
        }

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }
    public static int bfs(int x) {
        Queue<Integer> que = new LinkedList<>();
        boolean[] isVisited = new boolean[n + 1];
        int depth = 0;
        que.add(x);
        isVisited[x] = true;

        while (!que.isEmpty()) {
            int cur = que.poll();

            for (Integer next : v[cur]) {
                if (!isVisited[next]) {
                    que.add(next);
                    isVisited[next] = true;
                }
            }
            depth++;
        }

        return depth;
    }
}
