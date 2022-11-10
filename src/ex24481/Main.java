package ex24481;

/*
문제 이름: 알고리즘 수업 - 깊이 우선 탐색 3
알고리즘: dfs, 정렬
자료구조: 배열 리스트
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int n;
    static int m;
    static List<Integer>[] list;
    static boolean[] isVisited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        int r = Integer.parseInt(input[2]);

        list = new ArrayList[n + 1];
        isVisited = new boolean[n + 1];
        result = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            list[start].add(end);
            list[end].add(start);
        }

        for (int i = 1; i <= n; i++) {
            Collections.sort(list[i]);
        }

        dfs(r, 0);

        for (int i = 1; i <= n; i++) {
            if (i != r && result[i] == 0) {
                bw.write(-1 + "\n");
                continue;
            }
            bw.write(result[i] + "\n");
        }
        br.close();
        bw.close();
    }

    public static void dfs(int x, int depth) {
        if (isVisited[x]) {
            return;
        }
        isVisited[x] = true;
        result[x] = depth;
        for (Integer next : list[x]) {
            if (!isVisited[next]) {
                dfs(next, depth + 1);
            }
        }
    }
}
