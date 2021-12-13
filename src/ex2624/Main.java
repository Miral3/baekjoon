package ex2624;

/*
문제 이름: 동전 바꿔주기
알고리즘: 다이나믹 프로그래밍
자료구조: 배열, 배열 리스트
*/

import java.io.*;
import java.util.ArrayList;

class Node {
    int coin;
    int num;

    public Node(int coin, int num) {
        this.coin = coin;
        this.num = num;
    }
}

public class Main {
    static final int MAX = 10001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        int[] dp = new int[MAX];
        ArrayList<Node> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            String[] input = br.readLine().split(" ");
            int coin = Integer.parseInt(input[0]);
            int num = Integer.parseInt(input[1]);

            list.add(new Node(coin, num));
        }

        dp[0] = 1;
        for (int i = 0; i < k; i++) {
            Node cur = list.get(i);
            int coin = cur.coin;
            int num = cur.num;

            for (int j = t; j >= 0; j--) {
                for (int l = 1; l <= num; l++) {
                    if(j - (coin * l) < 0) {
                        continue;
                    }
                    dp[j] += dp[j - coin * l];
                }
            }
        }

        bw.write(dp[t] + "\n");
        br.close();
        bw.close();
    }
}
