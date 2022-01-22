package ex2942;

/*
문제 이름: 퍼거슨과 사과
알고리즘: 수학
자료구조: 정수
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int r = Integer.parseInt(input[0]);
        int g = Integer.parseInt(input[1]);
        int min = Math.min(r, g);

        for (int i = 1; i <= min; i++) {
            if (r % i == 0 && g % i == 0) {
                bw.write(i + " " + (r / i) + " " + (g / i) + "\n");
            }
        }

        br.close();
        bw.close();
    }
}
