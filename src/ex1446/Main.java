package ex1446;

/*
문제 이름: 지름길
알고리즘: 다이나믹 프로그래밍, 다익스트라
자료구조: 배열, 배열 리스트
*/

import java.io.*;
import java.util.ArrayList;

class Node {
    int end, length;

    public Node(int end, int length) {
        this.end = end;
        this.length = length;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int d = Integer.parseInt(input[1]);
        int[] dp = new int[10001];
        ArrayList<Node>[] list = new ArrayList[10001];

        for(int i = 0; i <= d; i++) {
            dp[i] = i;
            list[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end= Integer.parseInt(input[1]);
            int lenght = Integer.parseInt(input[2]);

            if(end - start < lenght) {
                continue;
            }
            if(end > d) {
                continue;
            }

            list[start].add(new Node(end, lenght));
        }

        int before = 0;
        for(int i = 0; i <= d; i++) {
            if(i == 0) {
                before = -1;
            } else {
                before = dp[i - 1];
            }
            dp[i] = Math.min(dp[i], before + 1);

            if(!list[i].isEmpty()) {
                for(int j = 0; j < list[i].size(); j++) {
                    int to = list[i].get(j).end;
                    int cost = list[i].get(j).length;

                    if(to < cost) {
                        continue;
                    }

                    if(dp[i] + cost < dp[to]) {
                        dp[to] = dp[i] +cost;
                    }
                }
            }
        }

        System.out.println(dp[d]);

        br.close();
        bw.close();
    }
}
