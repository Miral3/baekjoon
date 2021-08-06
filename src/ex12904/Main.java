package ex12904;

/*
문제 이름: A와 B
알고리즘: 구현, 문자열, 그리디
자료구조: 문자열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String t = br.readLine();

        while(true) {
            if(s.equals(t)) {
                bw.write(1 + "\n");
                break;
            }

            if(t.length() < s.length()) {
                bw.write(0 + "\n");
                break;
            }

            StringBuilder sb = new StringBuilder(t);
            String reverse = sb.reverse().toString();
            if(t.charAt(t.length() - 1) == 'A') {
                t = deleteTail(t);
            }
            else if(reverse.charAt(0) == 'B') {
                t = reverse(reverse);
            }
            else {
                bw.write(0 + "\n");
                break;
            }
        }

        br.close();
        bw.close();
    }

    public static String deleteTail(String str) {
        return str.substring(0, str.length() - 1);
    }

    public static String reverse(String str) {
        return str.substring(1);
    }
}
