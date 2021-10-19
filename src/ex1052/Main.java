package ex1052;

/*
문제 이름: 물병
알고리즘: 구현
자료구조:
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);

        int result = n;
        while(true) {
            if(getCount(result) <= k) {
                break;
            } else {
                result++;
            }
        }

        bw.write(result - n + "\n");
        br.close();
        bw.close();
    }

    public static int getCount(int n) {
        int cnt = 0;
        while(n > 0) {
            if(n % 2 == 1) {
                cnt++;
            }
            n /= 2;
        }
        return cnt;
    }
}
