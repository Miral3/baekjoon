package ex9011;

/*
문제 이름: 순서
알고리즘: 구현
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] arr = new int[n];
            int[] s = new int[n];
            int[] r = new int[n];
            boolean[] isVisited = new boolean[n];
            boolean isPossible = true;
            for(int j = 1; j <= n; j++) {
                arr[j - 1] = j;
            }
            for(int j = 0; j < n; j++) {
                r[j] = Integer.parseInt(input[j]);
            }

            for(int j = n - 1; j >= 0; j--) {
                int idx = r[j];
                int cnt = 0;
                for(int k = 0; k < n; k++) {
                    if(!isVisited[k] && cnt == idx) {
                        s[j] = arr[k];
                        isVisited[k] = true;
                        break;
                    }
                    if(!isVisited[k]) {
                        cnt++;
                    }
                }

                if(s[j] == 0) {
                    isPossible = false;
                    break;
                }
            }
            if(!isPossible) {
                bw.write("IMPOSSIBLE\n");
                continue;
            }
            for(int j = 0; j < n; j++) {
                bw.write(s[j] + " ");
            }
            bw.write("\n");
        }

        br.close();
        bw.close();
    }
}
