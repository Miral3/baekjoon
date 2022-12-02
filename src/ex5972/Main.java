package ex5972;

/*
문제 이름: 택배 배송
알고리즘: 다익스트라
자료구조: 배열 리스트, 우선순위 큐
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    int node;
    int weight;

    public Node(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }
}

public class Main {
    static List<Node>[] list;
    static boolean[] isVisited;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        isVisited = new boolean[n + 1];
        dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        list = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int left = Integer.parseInt(input[0]);
            int right = Integer.parseInt(input[1]);
            int weight = Integer.parseInt(input[2]);

            list[left].add(new Node(right, weight));
            list[right].add(new Node(left, weight));
        }

        dijkstra(1);
        bw.write(dist[n] + "\n");
        br.close();
        bw.close();
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int node = cur.node;

            if (isVisited[node]) {
                continue;
            }
            isVisited[node] = true;

            for (Node next : list[node]) {
                if (dist[next.node] > dist[node] + next.weight) {
                    dist[next.node] = dist[node] + next.weight;
                    pq.add(new Node(next.node, dist[next.node]));
                }
            }
        }
    }
}
