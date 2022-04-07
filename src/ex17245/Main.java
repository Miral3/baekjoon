package ex17245;

/*
문제 이름: 서버실
알고리즘: 이분 탐색
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] serverRoom = new int[n][n];
        long sum = 0;
        long low = 0;
        long high = 0;
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                serverRoom[i][j] = Integer.parseInt(input[j]);
                sum += serverRoom[i][j];
                high = Math.max(high, serverRoom[i][j]);
            }
        }

        long half = (long)Math.ceil((double)sum / 2);
        while (low <= high) {
            long mid = (low + high) / 2;
            long count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (serverRoom[i][j] < mid) {
                        count += serverRoom[i][j];
                    } else {
                        count += mid;
                    }
                }
            }

            if (count >= half) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        bw.write(low + "\n");
        br.close();
        bw.close();
    }
}
