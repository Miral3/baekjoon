package ex2877;

/*
문제 이름: 4와 7
알고리즘: 구현
자료구조: 문자열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());
        String binaryString = Integer.toBinaryString(k + 1);
        String split = binaryString.substring(1);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < split.length(); i++) {
            if(split.charAt(i) == '0') {
                sb.append(4);
            } else {
                sb.append(7);
            }
        }

        bw.write(sb.toString() + "\n");
        br.close();
        bw.close();
    }
}
