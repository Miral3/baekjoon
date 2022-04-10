package ex18232;

/*
문제 이름: 텔레포트 정거장
알고리즘: bfs
자료구조: 배열 리스트, 배열
*/

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int position;
    int count;

    public Node(int position, int count) {
        this.position = position;
        this.count = count;
    }
}

public class Main {
    static int answer = 0;
    static ArrayList<Integer> teleport[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        int s = Integer.parseInt(input[0]);
        int e = Integer.parseInt(input[1]);

        teleport = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            teleport[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            teleport[x].add(y);
            teleport[y].add(x);
        }

        int[] isVisited = new int[n + 1];
        for (int i = 0; i < n+1; i++) {
            isVisited[i] = Integer.MAX_VALUE;
        }

        getMinTime(n, s, e, isVisited);

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }

    public static void getMinTime(int n, int s, int e, int[] isVisited) {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(s, 0));
        isVisited[s] = 0;

        while (!que.isEmpty()) {
            Node cur = que.poll();
            int position = cur.position;
            int count = cur.count;

            if (position == e) {
                answer = count;
                return;
            }

            if (position < n && count + 1 < isVisited[position + 1]) {
                que.add(new Node(position + 1, count + 1));
                isVisited[position + 1] = count + 1;
            }
            if (position > 1 && count + 1 < isVisited[position - 1]) {
                que.add(new Node(position - 1, count + 1));
                isVisited[position - 1] = count + 1;
            }

            for (int i = 0; i < teleport[position].size(); i++) {
                if (count + 1 < isVisited[teleport[position].get(i)]) {
                    que.add(new Node(teleport[position].get(i), count + 1));
                    isVisited[teleport[position].get(i)] = count + 1;
                }
            }
        }

    }
}
