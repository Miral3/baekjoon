package ex6118;

/*
문제 이름: 숨바꼭질
알고리즘: BFS
자료구조: 배열 리스트
*/

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int node;
    int cnt;

    public Node(int node, int cnt) {
        this.node = node;
        this.cnt = cnt;
    }
}

public class Main {
    static int n;
    static int m;
    static ArrayList<Integer> v[];
    static boolean[] isVisited;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        v = new ArrayList[n + 1];
        isVisited = new boolean[n + 1];
        result = new int[n + 1];

        for(int i = 0; i <= n; i++) {
            v[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int left = Integer.parseInt(input[0]);
            int right = Integer.parseInt(input[1]);

            v[left].add(right);
            v[right].add(left);
        }

        BFS();

        int max = 0;
        int idx = 0;
        int distance = 0;
        int same = 0;
        for (int i = 2; i <= n; i++) {
            if(max <= result[i]) {
                if(max == result[i]) {
                    same++;
                } else {
                    max = result[i];
                    idx = i;
                    distance = result[i];
                    same = 1;
                }
            }
        }

        bw.write(idx + " " + distance + " " + same);
        br.close();
        bw.close();
    }

    public static void BFS() {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(1, 0));
        isVisited[1] = true;

        while (!que.isEmpty()) {
            Node cur = que.poll();
            int node = cur.node;
            int cnt = cur.cnt;

            for (int i = 0; i < v[node].size(); i++) {
                int x = v[node].get(i);
                if (!isVisited[x]) {
                    isVisited[x] = true;
                    que.add(new Node(x, cnt + 1));
                    result[x] = cnt + 1;
                }
            }
        }
    }
}
