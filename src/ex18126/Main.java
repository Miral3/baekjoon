package ex18126;

/*
문제 이름: 너구리 구구
알고리즘: dfs
자료구조: 배열 리스트
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Node {
    int end;
    long weight;

    public Node(int end, long weight) {
        this.end = end;
        this.weight = weight;
    }
}
public class Main {
    static int n;
    static long answer;
    static List<Node>[] list;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        answer = 0;
        list = new ArrayList[n + 1];
        isVisited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i ++) {
            String[] input = br.readLine().split(" ");
            int left = Integer.parseInt(input[0]);
            int right = Integer.parseInt(input[1]);
            long weight = Long.parseLong(input[2]);

            list[left].add(new Node(right, weight));
            list[right].add(new Node(left, weight));
        }

        isVisited[1] = true;
        dfs(1, 0);

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }

    public static void dfs(int cur, long weight) {
        answer = Math.max(answer, weight);

        for (Node next : list[cur]) {
            if (!isVisited[next.end]) {
                isVisited[next.end] = true;
                dfs(next.end, weight + next.weight);
            }
        }
    }
}
