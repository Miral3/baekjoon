package ex1647;

/*
문제 이름: 도시 분할 계획
알고리즘: 최소 스패닝 트리
자료구조: 배열 리스트
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node implements Comparable<Node> {
    int left;
    int right;
    int weight;

    public Node(int left, int right, int weight) {
        this.left = left;
        this.right = right;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}

public class Main {
    static List<Node> list = new ArrayList<>();
    static int[] parent = new int[100001];
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        for(int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int left = Integer.parseInt(input[0]);
            int right = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            list.add(new Node(left, right, weight));
        }

        Collections.sort(list);

        for(int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int result = 0;
        int maxEdge = 0;
        for(int i = 0; i < m; i++) {
            int left = list.get(i).left;
            int right = list.get(i).right;
            int weight = list.get(i).weight;

            merge(left, right);

            if(flag) {
                maxEdge = weight;
                result += weight;
            }
        }

        bw.write(result - maxEdge + "\n");
        br.close();
        bw.close();
    }

    public static int find(int u) {
        if(parent[u] == u) {
            return u;
        }

        return parent[u] = find(parent[u]);
    }

    public static void merge(int u, int v) {
        flag = false;
        u = find(u);
        v = find(v);

        if(u == v) {
            return;
        }

        parent[u] = v;
        flag = true;
    }
}
