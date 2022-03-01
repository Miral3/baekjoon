package ex14248;

/*
문제 이름: 점프 점프
알고리즘: bfs
자료구조: 큐, 배열
*/

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[] arr;
    static int ans = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i + 1] = Integer.parseInt(input[i]);
        }

        int s = Integer.parseInt(br.readLine());

        bfs(n, s);

        bw.write(ans + "\n");
        br.close();
        bw.close();
    }

    public static void bfs(int n, int s) {
        Queue<Integer> que = new LinkedList<>();
        que.add(s);
        boolean[] isVisited = new boolean[n + 1];
        isVisited[s] = true;

        while (!que.isEmpty()) {
            int cur = que.poll();

            int left = cur - arr[cur];
            int right = cur + arr[cur];

            if (left > 0 && !isVisited[left]) {
                que.add(left);
                isVisited[left] = true;
                ans++;
            }

            if (right <= n && !isVisited[right]) {
                que.add(right);
                isVisited[right] = true;
                ans++;
            }
        }
    }
}
