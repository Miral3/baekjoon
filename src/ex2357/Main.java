package ex2357;

/*
문제 이름: 최솟값과 최댓값
알고리즘: 세그먼트 트리
자료구조: 트리
*/

import java.io.*;

public class Main {
    static int[] arr;
    static int[] minTree;
    static int[] maxTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        arr = new int[n + 1];
        minTree = new int[n * 4];
        maxTree = new int[n * 4];

        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        init(1, n, 1);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int left = Integer.parseInt(input[0]);
            int right = Integer.parseInt(input[1]);
            sb.append(minFind(1, n, 1, left, right) + " " + maxFind(1, n, 1, left, right) + "\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    public static void init(int start, int end, int node) {
        if(start == end) {
            minTree[node] = arr[start];
            maxTree[node] = arr[start];
            return;
        }

        int mid = (start + end) / 2;
        init(start, mid, node * 2);
        init(mid + 1, end, node * 2 + 1);
        minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]);
        maxTree[node] = Math.max(maxTree[node * 2], maxTree[node * 2 + 1]);
        return;
    }

    public static int minFind(int start, int end, int node, int left, int right) {
        if(left > end || right < start) {
            return Integer.MAX_VALUE;
        }
        if(left <= start && end <= right) {
            return minTree[node];
        }

        int mid = (start + end) / 2;
        return Math.min(minFind(start, mid, node * 2, left, right), minFind(mid + 1, end, node * 2 + 1, left, right));
    }

    public static int maxFind(int start, int end, int node, int left, int right) {
        if(left > end || right < start) {
            return Integer.MIN_VALUE;
        }
        if(left <= start && end <= right) {
            return maxTree[node];
        }

        int mid = (start + end) / 2;
        return Math.max(maxFind(start, mid, node * 2, left, right), maxFind(mid + 1, end, node * 2 + 1, left, right));
    }
}
