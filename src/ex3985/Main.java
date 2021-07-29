package ex3985;

/*
문제 이름:
알고리즘:
자료구조:
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int l = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        boolean[] check = new boolean[l + 1];

        int expectedMax = 0;
        int actualMax = 0;
        int[] result = new int[2];
        for(int i = 1; i <= n; i++) {
            int cnt = 0;
            String[] input = br.readLine().split(" ");
            int start = Integer.parseInt(input[0]);
            int end = Integer.parseInt(input[1]);
            int piece = end - start;

            if(expectedMax < piece) {
                expectedMax = piece;
                result[0] = i;
            }

            for(int j = start; j <= end; j++) {
                if(!check[j]) {
                    cnt++;
                    check[j] = true;
                }
            }

            if(actualMax < cnt) {
                actualMax = cnt;
                result[1] = i;
            }
        }

        for(int i = 0; i < 2; i++) {
            System.out.println(result[i]);
        }

        br.close();
        bw.close();
    }
}
