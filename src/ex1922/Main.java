package ex1922;

/*
문제 이름: 네트워크 연결
알고리즘: 그래프 이론, 최소 스패팅 트리
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[][] costs = new int[m][3];
        int[] parent = new int[n + 1];
        for (int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            costs[i][0] = Integer.parseInt(input[0]);
            costs[i][1] = Integer.parseInt(input[1]);
            costs[i][2] = Integer.parseInt(input[2]);
        }

        for (int i = 0; i < n + 1; i++) {
            parent[i] = i;
        }

        Arrays.sort(costs, Comparator.comparingInt((int[] o) -> o[2]));

        int answer = 0;
        for (int i = 0; i < m; i++) {
            int a = costs[i][0];
            int b = costs[i][1];
            int c = costs[i][2];

            if (!find(parent, a, b)) {
                answer += c;
                unionParent(parent, a, b);
            }
        }

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }

    public static int getParent(int[] parent, int x) {
        if (parent[x] == x) {
            return x;
        }
        return parent[x] = getParent(parent, parent[x]);
    }

    public static void unionParent(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);

        if (a < b) {
            parent[b] = a;
        } else {
            parent[a] = b;
        }
    }

    public static boolean find(int[] parent, int a, int b) {
        a = getParent(parent, a);
        b = getParent(parent, b);

        if (a == b) {
            return true;
        }
        return false;
    }
}
