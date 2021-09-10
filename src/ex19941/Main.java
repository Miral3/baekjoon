package ex19941;

/*
문제 이름: 햄버거 분배
알고리즘: 그리디
자료구조: 문자열, 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        String table = br.readLine();

        int cnt = 0;
        boolean[] isAte = new boolean[n];
        for(int i = 0; i < n; i++) {
            if(table.charAt(i) != 'P') {
                continue;
            }
            for(int j = i - k; j <= i + k; j++) {
                if(j < 0 || j > n - 1) {
                    continue;
                }
                if(table.charAt(j) != 'H') {
                    continue;
                }
                if(isAte[j]) {
                    continue;
                }

                cnt++;
                isAte[j] = true;
                break;
            }
        }

        bw.write(cnt + "\n");

        br.close();
        bw.close();
    }
}
