package ex14426;

/*
문제 이름: 접두사 찾기
알고리즘: 문자열
자료구조: 문자열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        String[] strArr = new String[n];

        for(int i = 0; i < n; i++) {
            strArr[i] = br.readLine();
        }

        int result = 0;
        for(int i = 0; i < m; i++) {
            String test = br.readLine();
            for(int j = 0; j < n; j++) {
                if(strArr[j].startsWith(test)) {
                    result++;
                    break;
                }
            }
        }

        bw.write(result + "\n");
        br.close();
        bw.close();
    }
}
