package ex2023;

/*
문제 이름: 신기한 소수
알고리즘: 그래프 탐색, 백트래킹
자료구조: .
*/

import java.io.*;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());

        dfs(0, 0);

        br.close();
        bw.close();
    }

    public static void dfs(int depth, int num) {
        if(depth == n) {
            System.out.println(num);
            return;
        }
        for(int i = 1; i < 10; i++) {
            int sum = num * 10 + i;
            if(isPrime(sum)) {
                dfs(depth + 1, sum);
            }
        }
    }

    public static boolean isPrime(int num) {
        if(num == 1) {
            return false;
        }

        for(int i = 2; i*i <= num; i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
