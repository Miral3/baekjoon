package ex14496;

/*
문제 이름: 그대, 그머가 되어
알고리즘: bfs, 다익스트라
자료구조: 배열리스트
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    int end, weight;

    public Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}

public class Main {
    static int n, m;
    static List<Node>[] list;
    static boolean[] isVisited;
    static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        isVisited = new boolean[n + 1];
        d = new int[n + 1];
        list = new ArrayList[n + 1];

        for(int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        Arrays.fill(d, Integer.MAX_VALUE);

        for(int j = 0; j < m; j++) {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);

            list[start].add(new Node(end, 1));
            list[end].add(new Node(start, 1));
        }

        dijkstra(a);

        if(d[b] > m) {
            System.out.println(-1);
            return;
        }
        System.out.println(d[b]);


        br.close();
        bw.close();
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        d[start] = 0;

        while(!pq.isEmpty()) {
            Node curNode = pq.poll();
            int end = curNode.end;

            if(isVisited[end]) {
                continue;
            }

            isVisited[end] = true;

            for(Node node : list[end]) {
                if(d[node.end] > d[end] + node.weight) {
                    d[node.end] = d[end] + node.weight;
                    pq.add(new Node(node.end, d[node.end]));
                }
            }
        }
    }
}
