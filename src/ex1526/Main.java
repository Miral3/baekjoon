package ex1526;

/*
문제 이름: 가장 큰 금민수
알고리즘: 수학
자료구조: 문자열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        for(int i = n; i >= 1; i--) {
            String str = Integer.toString(i);
            boolean check = true;
            for(int j = 0; j < str.length(); j++) {
                if((str.charAt(j) != '4' && str.charAt(j) != '7')) {
                    check = false;
                    break;
                }
            }
            if(check) {
                System.out.println(i);
                return;
            }
        }

        br.close();
        bw.close();
    }
}
