package ex9205;

/*
문제 이름: 맥주 마시면서 걸어가기
알고리즘: bfs
자료구조: 배열 리스트
*/

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int n;
    static String answer;
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());

            ArrayList<Node> temp = new ArrayList<>();
            for (int i = 0; i < n + 2; i++) {
                String[] input = br.readLine().split(" ");
                int x = Integer.parseInt(input[0]);
                int y = Integer.parseInt(input[1]);
                temp.add(new Node(x, y));
            }

            graph = new ArrayList<>();
            for (int i = 0; i < n + 2; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < n + 2; i++) {
                for (int j = i + 1; j < n + 2; j++) {
                    if (Math.abs(temp.get(i).x - temp.get(j).x) +
                        Math.abs(temp.get(i).y - temp.get(j).y) <= 1000) {
                        graph.get(i).add(j);
                        graph.get(j).add(i);
                    }
                }
            }

            answer = "sad";
            bfs(0);
            bw.write(answer + "\n");
        }

        br.close();
        bw.close();
    }

    public static void bfs(int start) {
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        boolean[] isVisited = new boolean[n + 2];
        isVisited[start] = true;

        while (!que.isEmpty()) {
            int cur = que.poll();

            if (cur == n + 1) {
                answer = "happy";
                return;
            }

            for (int nxt : graph.get(cur)) {
                if (!isVisited[nxt]) {
                    isVisited[nxt] = true;
                    que.add(nxt);
                }
            }
        }
    }
}
