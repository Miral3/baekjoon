package ex6497;

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

        while (true) {
            String[] input = br.readLine().split(" ");
            if (input[0].equals("0") && input[1].equals("0")) {
                break;
            }
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            int[] parent = new int[n];
            int[][] costs = new int[m][3];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }

            for (int i = 0; i < m; i++) {
                input = br.readLine().split(" ");

                costs[i][0] = Integer.parseInt(input[0]);
                costs[i][1] = Integer.parseInt(input[1]);
                costs[i][2] = Integer.parseInt(input[2]);
            }

            Arrays.sort(costs, Comparator.comparingInt((int[] o) -> o[2]));
            int answer = 0;
            for (int i = 0; i < m; i++) {
                int x = costs[i][0];
                int y = costs[i][1];
                int z = costs[i][2];

                if (!find(parent, x, y)) {
                    unionParent(parent, x, y);
                } else {
                    answer += z;
                }
            }

            bw.write(answer + "\n");
        }
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
