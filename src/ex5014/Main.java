package ex5014;

/*
문제 이름: 스타트링크
알고리즘: BFS
자료구조: 큐
*/

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int stairs;
    int cnt;

    public Node(int stairs, int cnt) {
        this.stairs = stairs;
        this.cnt = cnt;
    }
}

public class Main {
    static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        BFS(input);

        if(result == -1) {
            bw.write("use the stairs\n");
        } else {
            bw.write(result + "\n");
        }

        br.close();
        bw.close();
    }

    public static void BFS(String[] input) {
        int F = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);
        int G = Integer.parseInt(input[2]);
        int U = Integer.parseInt(input[3]);
        int D = Integer.parseInt(input[4]);

        Queue<Node> que = new LinkedList<>();
        que.add(new Node(S, 0));
        boolean[] isVisited = new boolean[F + 1];
        isVisited[S] = true;

        while (!que.isEmpty()) {
            Node cur = que.poll();
            int stairs = cur.stairs;
            int cnt = cur.cnt;

            if(stairs == G) {
                result = cnt;
                break;
            }

            if(stairs + U <= F && !isVisited[stairs + U]) {
                que.add(new Node(stairs + U, cnt + 1));
                isVisited[stairs + U] = true;
            }

            if(stairs - D >= 1 && !isVisited[stairs - D]) {
                que.add(new Node(stairs - D, cnt + 1));
                isVisited[stairs - D] = true;
            }
        }
    }
}
