package ex2246;

/*
문제 이름: 콘도 선정
알고리즘: 브루트포스
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] condo = new int[n][2];
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            condo[i][0] = Integer.parseInt(input[0]);
            condo[i][1] = Integer.parseInt(input[1]);
        }

        int answer = 0;
        for (int i = 0; i < n; i++) {
            int curD = condo[i][0];
            int curC = condo[i][1];
            boolean isCandidate = true;
            for (int j = 0; j < n; j++) {
                int nextD = condo[j][0];
                int nextC = condo[j][1];
                if (i == j) {
                    continue;
                }

                if (curD > nextD) {
                    if (curC >= nextC) {
                        isCandidate = false;
                        break;
                    }
                }
                if (curC > nextC) {
                    if (curD >= nextD) {
                        isCandidate = false;
                        break;
                    }
                }
            }
            if (isCandidate) {
                answer++;
            }
        }

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }
}
