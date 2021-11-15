package ex1197;

/*
문제 이름: 최소 스패닝 트리
알고리즘: 최소 스패닝 트리
자료구조: 배열 리스트
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node implements Comparable<Node> {
    int start;
    int end;
    int weight;

    public Node(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}

public class Main {
    static int[] parent = new int[10001];
    static List<Node> list = new ArrayList<>();
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int v = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);

        for(int i = 0; i < e; i++) {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            list.add(new Node(start, end, weight));
        }

        Collections.sort(list);

        for (int i = 1; i <= v; i++) {
            parent[i] = i;
        }

        int result = 0;
        for (int i = 0; i < e; i++) {
            int start = list.get(i).start;
            int end = list.get(i).end;
            int weight = list.get(i).weight;

            merge(start, end);

            if(flag) {
                result += weight;
            }
        }

        bw.write(result + "\n");
        br.close();
        bw.close();
    }

    public static int find(int u) {
        if (u == parent[u]) {
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
