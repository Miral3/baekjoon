package ex15886;

/*
문제 이름: 내 선물을 받아줘 2
알고리즘: 문자열
자료구조: 문자열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String input = br.readLine();
        int count = (input.length() - input.replaceAll("EW", "").length()) / 2;
        if(count == 0) {
            count = 1;
        }

        bw.write(count + "\n");
        br.close();
        bw.close();
    }
}
