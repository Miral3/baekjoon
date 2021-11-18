package ex2268;

/*
문제 이름: 수들의 합 7
알고리즘: 세그먼트 트리
자료구조: 트리
*/

import java.io.*;

public class Main {
    static long[] arr;
    static long[] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        arr = new long[n + 1];
        tree = new long[n * 4];

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            input = br.readLine().split(" ");

            int c = Integer.parseInt(input[0]);
            int x = Integer.parseInt(input[1]);
            int y = Integer.parseInt(input[2]);

            if(c == 0 && x > y) {
                int temp = x;
                x = y;
                y = temp;
            }
            if(c == 0) {
                sb.append(sum(1, n, 1, x, y) + "\n");
            } else if(c == 1) {
                long dif = (long)y - arr[x];
                arr[x] = y;
                update(1, n, 1, x, dif);
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    public static long init(int start, int end, int node) {
        if(start == end) {
            tree[node] = arr[start];
        }

        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, node * 2) + init(mid + 1, end, node * 2 + 1);
    }

    public static long sum(int start, int end, int node, int left, int right) {
        if(left > end || right < start) {
            return 0;
        }
        if(left <= start && end <= right) {
            return tree[node];
        }

        int mid = (start + end) / 2;
        return sum(start, mid, node * 2, left, right) + sum(mid + 1, end, node * 2 + 1, left, right);
    }

    public static void update(int start, int end, int node, int idx, long dif) {
        if(idx < start || idx > end) {
            return;
        }

        tree[node] += dif;

        if(start == end) {
            return;
        }

        int mid = (start + end) / 2;
        update(start, mid, node * 2, idx, dif);
        update(mid + 1, end, node * 2 + 1, idx, dif);
    }
}
