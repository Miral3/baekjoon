package ex1106;

/*
문제 이름: 호텔
알고리즘: 다이나믹 프로그래밍
자료구조: 배열, 연결 리스트
*/

import java.io.*;
import java.util.LinkedList;

class Node {
    int cost;
    int customer;

    public Node(int cost, int customer) {
        this.cost = cost;
        this.customer = customer;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int c = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        int[] dp = new int[100001];
        LinkedList<Node> list = new LinkedList<>();

        for(int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            int cost = Integer.parseInt(input[0]);
            int customer = Integer.parseInt(input[1]);

            list.add(new Node(cost, customer));
        }

        for(int i = 0; i < list.size(); i++) {
            Node cur = list.get(i);
            int cost = cur.cost;
            int customer = cur.customer;

            for(int k = 1; k < 100001; k++) {
                if (k - cost >= 0) {
                    dp[k] = Math.max(dp[k], dp[k - cost] + customer);
                }
            }
        }

        for(int i = 1; i < 100001; i++) {
            if(dp[i] >= c) {
                bw.write(i + "\n");
                break;
            }
        }

        br.close();
        bw.close();
    }
}
