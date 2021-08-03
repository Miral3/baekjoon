package ex5525;

/*
문제 이름: IOIOI
알고리즘: 문자열
자료구조: 문자열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String s = br.readLine();
        String[] str = s.split("");

        int result = 0;
        int patternCnt = 0;
        for(int i = 1; i < m - 1; i++) {
            if(str[i - 1].equals("I") && str[i].equals("O") && str[i + 1].equals("I")) {
                patternCnt++;
                if(patternCnt == n) {
                    patternCnt--;
                    result++;
                }
                i++;
            } else {
                patternCnt = 0;
            }
        }

        System.out.println(result);

        br.close();
        bw.close();
    }
}
