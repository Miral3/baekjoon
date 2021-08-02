package ex9996;

/*
문제 이름: 한국이 그리울 땐 서버에 접속하지
알고리즘: 문자열
자료구조: 문자열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String pattern = br.readLine();
        String[] side = pattern.split("\\*");

        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            if(input.length() < pattern.length() - 1) {
                bw.write("NE\n");
                continue;
            }

            String start = input.substring(0, side[0].length());
            String end = input.substring(input.length() - (side[1].length()));

            if(start.equals(side[0]) && end.equals(side[1])) {
                bw.write("DA\n");
            } else {
                bw.write("NE\n");
            }
        }

        br.close();
        bw.close();
    }
}
