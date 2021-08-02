package ex1769;

/*
문제 이름: 3의 배수
알고리즘: 문자열
자료구조: 문자열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String x = br.readLine();
        if(x.length() < 2) {
            System.out.println(0);
            if(Integer.parseInt(x) % 3 == 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            return;
        }

        int cnt = 1;
        while(true) {
            int sum = 0;
            for(int i = 0; i < x.length(); i++) {
                sum += x.charAt(i) - '0';
            }

            if(sum < 10) {
                System.out.println(cnt);
                if(sum % 3 == 0) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
                break;
            }

            x = Integer.toString(sum);

            cnt++;
        }

        br.close();
        bw.close();
    }
}
