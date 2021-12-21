package ex2251;

/*
문제 이름: 물통
알고리즘: BFS
자료구조: 배열 리스트, 큐
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

class Node {
    int a;
    int b;
    int c;

    public Node(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}

public class Main {
    static ArrayList<Integer> result = new ArrayList<>();
    static HashSet<String> set = new HashSet<>();
    static int aMax;
    static int bMax;
    static int cMax;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        aMax = Integer.parseInt(input[0]);
        bMax = Integer.parseInt(input[1]);
        cMax = Integer.parseInt(input[2]);
        Queue<Node> que = new LinkedList<>();
        que.add(new Node(0, 0, cMax));

        BFS(que);

        Collections.sort(result);

        for(Integer v : result) {
            bw.write(v + " ");
        }
        br.close();
        bw.close();
    }

    public static void BFS(Queue<Node> que) {
        while(!que.isEmpty()) {
            Node cur = que.poll();
            int a = cur.a;
            int b = cur.b;
            int c = cur.c;

            String str = a + " " + b + " " + c;
            if(set.contains(str)) {
               continue;
            }
            set.add(str);
            if(a == 0 && !result.contains(c)) {
                result.add(c);
            }

            if(a > 0) {
                if(b < bMax && bMax - b <= a) {
                    que.add(new Node(a - (bMax - b), bMax, c));
                }
                if(b + a <= bMax) {
                    que.add(new Node(0, b + a, c));
                }
                if(c < cMax && cMax - c <= a) { // c가 꽉차있지 않고 c를 꽉 채울만큼 갖고있다면
                    que.add(new Node(a - (cMax - c), b, cMax));
                }
                if(c + a <= cMax) { // c에 a만큼 다 채워도 cMax보다 크지 않을때
                    que.add(new Node(0, b, c + a));
                }
            }

            if(b > 0) {
                if(a < aMax && aMax - a <= b) {
                    que.add(new Node(aMax, b - (aMax - a), c));
                }
                if(a + b <= aMax) {
                    que.add(new Node(a + b, 0, c));
                }
                if(c < cMax && cMax - c <= b) {
                    que.add(new Node(a, b - (cMax - c), cMax));
                }
                if(c + b <= cMax) {
                    que.add(new Node(a, 0, c + b));
                }
            }

            if(c > 0) {
                if(a < aMax && aMax - a <= c) {
                    que.add(new Node(aMax, b, c - (aMax - a)));
                }
                if(a + c <= aMax) {
                    que.add(new Node(a + c, b, 0));
                }
                if(b < bMax && bMax - b <= c) {
                    que.add(new Node(a, bMax, c - (bMax - b)));
                }
                if(b + c <= bMax) {
                    que.add(new Node(a, b + c, 0));
                }
            }
        }
    }
}
