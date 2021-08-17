package ex6064;

/*
문제 이름: 카잉 달력
알고리즘: 수학
자료구조: 정수
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            int m = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);
            int x = Integer.parseInt(input[2]);
            int y = Integer.parseInt(input[3]);

            x -= 1;
            y -= 1;
            boolean isContain = false;
            for(int j = x; j < (n * m); j += m) {
                if(j % n == y) {
                    bw.write(j + 1 + "\n");
                    isContain = true;
                    break;
                }
            }

            if(!isContain) {
                bw.write(-1 + "\n");
            }
        }

        br.close();
        bw.close();
    }
}
