package ex2671;

/*
문제 이름: 잠수함식별
알고리즘: 문자열, 정규 표현식
자료구조: 문자열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = br.readLine();
        String pattern = "(100+1+|01)+";
        if(input.matches(pattern)) {
            bw.write("SUBMARINE\n");
        } else {
            bw.write("NOISE\n");
        }

        br.close();
        bw.close();
    }
}
