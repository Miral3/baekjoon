package ex12851;

/*
문제 이름: 숨바꼭질 2
알고리즘: BFS
자료구조: 배열 리시트, 우선순위 큐
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Node implements Comparable<Node> {
    int position;
    int time;

    public Node(int position, int time) {
        this.position = position;
        this.time = time;
    }

    @Override
    public int compareTo(Node o) {
        return this.time - o.time;
    }
}

public class Main {
    static int n;
    static int k;
    static final int MAX = 100001;
    static ArrayList<Node> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        k = Integer.parseInt(input[1]);

        BFS();

        bw.write(result.get(0).time + "\n" + result.size());
        br.close();
        bw.close();
    }

    public static void BFS() {
        PriorityQueue<Node> que = new PriorityQueue<>();
        int[] isVisited = new int[MAX];
        Arrays.fill(isVisited, Integer.MAX_VALUE);
        que.add(new Node(n, 0));
        isVisited[n] = 0;

        while (!que.isEmpty()) {
            Node cur = que.poll();
            int position = cur.position;
            int time = cur.time;

            if (position == k) {
                if(!result.isEmpty() && result.get(0).time != time) {
                    return;
                }
                result.add(new Node(position, time));
            }

            if (canMove(position + 1) && isVisited[position + 1] >= time + 1) {
                isVisited[position + 1] = time + 1;
                que.add(new Node(position + 1, time + 1));
            }

            if (canMove(position - 1) && isVisited[position - 1] >= time + 1) {
                isVisited[position - 1] = time + 1;
                que.add(new Node(position - 1, time + 1));
            }

            if (canMove(position * 2) && isVisited[position * 2] >= time + 1) {
                isVisited[position * 2] = time + 1;
                que.add(new Node(position * 2, time + 1));
            }
        }
    }

    public static boolean canMove(int position) {
        if(position < 0 || position >= MAX) {
            return false;
        }

        return true;
    }
}
