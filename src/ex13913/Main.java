package ex13913;

/*
문제 이름: 숨바꼭질 4
알고리즘: BFS
자료구조: 배열, 큐
*/

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int position;
    int time;
    String route;

    public Node(int position, int time, String route) {
        this.position = position;
        this.time = time;
        this.route = route;
    }
}

public class Main {
    static final int MAX = 100001;
    static int n;
    static int k;
    static boolean[] isVisited = new boolean[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        if (n > k) {
            bw.write(n - k + "\n");
            for (int i = n; i >= k; i--) {
                bw.write(i + " ");
            }
        } else {
            BFS();
        }

        br.close();
        bw.close();
    }

    public static void BFS() {
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(n, 0, Integer.toString(n)));
        isVisited[n] = true;

        while (!que.isEmpty()) {
            Node cur = que.poll();
            int position = cur.position;
            int time = cur.time;
            String route = cur.route;

            if(position == k) {
                System.out.println(time);
                System.out.print(route);
                return;
            }

            if (position - 1 >= 0 && !isVisited[position - 1]) {
                isVisited[position - 1] = true;
                que.add(new Node(position - 1, time + 1, route + " " + (position - 1)));
            }

            if (position + 1 < MAX && !isVisited[position + 1]) {
                isVisited[position + 1] = true;
                que.add(new Node(position + 1, time + 1, route + " " + (position + 1)));
            }

            if (position * 2 < MAX && !isVisited[position * 2]) {
                isVisited[position * 2] = true;
                que.add(new Node(position * 2, time + 1, route + " " + (position * 2)));
            }
        }
    }
}
