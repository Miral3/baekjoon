package ex3004;

/*
문제 이름: 체스판 조각
알고리즘: 수학
자료구조: 수학
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[101];
        arr[1] = 2;

        int x = 2;
        int y = 2;
        for(int i = 2; i <= 100; i++) {
            arr[i] = x * y;
            if(i % 2 == 0)  {
                y++;
            } else {
                x++;
            }
        }

        bw.write(arr[n] + "\n");

        br.close();
        bw.close();
    }
}
