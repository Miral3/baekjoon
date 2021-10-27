package ex11437;

/*
문제 이름: LCA
알고리즘: lca, dfs, 트리
자료구조: 배열, 연결리스트
*/

import java.io.*;
import java.util.LinkedList;

public class Main {
    static LinkedList<Integer>[] tree;
    static int[] parent;
    static int[] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        tree = new LinkedList[n + 1];
        parent = new int[n + 1];
        depth = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            tree[i] = new LinkedList<>();
        }

        for(int i = 0; i < n-1; i++) {
            String[] input = br.readLine().split(" ");
            int left = Integer.parseInt(input[0]);
            int right = Integer.parseInt(input[1]);

            tree[left].add(right);
            tree[right].add(left);
        }

        dfs(1, -1, 0);

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++) {
            String[] input = br.readLine().split(" ");
            int node1 = Integer.parseInt(input[0]);
            int node2 = Integer.parseInt(input[1]);

            bw.write(lca(node1, node2) + "\n");
        }
        br.close();
        bw.close();
    }
    public static void dfs(int cur, int p, int d) {
        parent[cur] = p;
        depth[cur] = d;

        for (int next : tree[cur]) {
            if(next != p) {
                dfs(next, cur, d + 1);
            }
        }
    }

    public static int lca(int node1, int node2) {
        int d1 = depth[node1];
        int d2 = depth[node2];

        while (d1 > d2) {
            node1 = parent[node1];
            d1--;
        }
        while (d1 < d2) {
            node2 = parent[node2];
            d2--;
        }
        while (node1 != node2) {
            node1 = parent[node1];
            node2 = parent[node2];
        }

        return node1;
    }
}
