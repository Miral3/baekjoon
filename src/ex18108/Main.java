package ex18108;

/*
문제 이름: 1998년생인 내가 태국에서는 2541년생?!
알고리즘: 수학
자료구조: 정수
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int y = Integer.parseInt(br.readLine());

        bw.write(y - 543 + "\n");
        br.close();
        bw.close();
    }
}
