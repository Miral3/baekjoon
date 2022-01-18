package ex17295;

/*
문제 이름: 엔드게임 스포일러
알고리즘: 구현
자료구조: 문자열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();

        bw.write("Avengers: Endgame\n");
        br.close();
        bw.close();
    }
}
