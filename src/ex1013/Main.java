package ex1013;

/*
문제 이름: Contact
알고리즘: 문자열, 정규 표현식
자료구조: 문자열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String pattern = "(100+1+|01)+";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            if(input.matches(pattern)) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
