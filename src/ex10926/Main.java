package ex10926;

/*
문제 이름: ??!
알고리즘: 구현
자료구조:
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String id = br.readLine();
        bw.write(id + "??!");

        br.close();
        bw.close();
    }
}
