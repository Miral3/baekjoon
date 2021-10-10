package ex10797;

/*
문제 이름: 10부제
알고리즘: 구현
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int result = 0;
        for(int i = 0; i < 5; i++) {
            if(k == Integer.parseInt(input[i])) {
                result++;
            }
        }

        bw.write(result + "\n");
        br.close();
        bw.close();
    }
}
