package ex1343;

/*
문제 이름: 폴리오미노
알고리즘: 그리디
자료구조: 문자열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String a = "AAAA";
        String b = "BB";
        String input = br.readLine();
        String result = "";

        int cnt = 0;
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == 'X') {
                cnt++;
            }
            if(input.charAt(i) == '.' || i == input.length() -1){
                if(cnt % 4 == 0) {
                    int div = cnt / 4;
                    for(int j = 0; j < div; j++) {
                        result += a;
                    }
                }
                else if(cnt == 2) {
                    result += b;
                }
                else {
                    int aQuo = cnt / 4;
                    int aRem = cnt % 4;
                    int bRem = aRem % 2;
                    if(bRem == 0) {
                        for(int j = 0; j < aQuo; j++) {
                            result += a;
                        }
                        result += b;
                    }
                    else {
                        System.out.println(-1);
                        return;
                    }
                }
                if(input.charAt(i) == '.') {
                    result += ".";
                }
                cnt = 0;
            }
        }

        System.out.println(result);

        br.close();
        bw.close();
    }
}
