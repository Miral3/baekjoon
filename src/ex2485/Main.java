package ex2485;

/*
문제 이름: 가로수
알고리즘: 유클리드 호제법
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] tree = new int[n];
        int[] diff = new int[n - 1];
        for(int i = 0; i < n; i++) {
            tree[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < n - 1; i++) {
            diff[i] = tree[i + 1] - tree[i];
        }

        int min = diff[0];
        for(int i = 1; i < n - 1; i++) {
           min = gcd(min, diff[i]);
        }

        int result = 0;
        for(int i = 1; i < n; i++) {
            int difference = tree[i] - tree[i - 1];
            result += (difference / min) - 1;
        }

        System.out.println(result);

        br.close();
        bw.close();
    }
    public static int gcd(int a, int b) {
        if(a % b == 0) {
            return b;
        } else {
            return gcd(b, a % b);
        }
    }
}
