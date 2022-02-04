package ex1240;

/*
문제 이름: 노드사이의 거리
알고리즘: dfs
자료구조: 배열
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Node {
    int end;
    int weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}

public class Main {
    static List<Node>[] list;
    static int[] isVisited;
    static int[][] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        d = new int[n + 1][n + 1];
        isVisited = new int[n + 1];
        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            input = br.readLine().split(" ");
            int left = Integer.parseInt(input[0]);
            int right = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            list[left].add(new Node(right, weight));
            list[right].add(new Node(left, weight));
        }

        for (int i = 1; i <= n; i++) {
            isVisited[i] = 1;
            dfs(i, i, 0);
            isVisited[i] = 0;
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int left = Integer.parseInt(input[0]);
            int right = Integer.parseInt(input[1]);

            bw.write(d[left][right] + "\n");
        }

        br.close();
        bw.close();
    }

    public static void dfs(int start, int i, int len) {
        d[start][i] = len;
        int size = list[i].size();

        for (int j = 0; j < size; j++) {
            int end = list[i].get(j).end;
            int weight = list[i].get(j).weight;

            if (isVisited[end] == 0) {
                isVisited[end] = 1;
                dfs(start, end, len + weight);
                isVisited[end] = 0;
            }
        }
    }
}
