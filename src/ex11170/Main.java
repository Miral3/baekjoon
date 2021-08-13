package ex11170;

/*
문제 이름:
알고리즘:
자료구조:
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            int cnt = 0;
            for(int j = n; j <= m; j++) {
                String str = Integer.toString(j);
                for(int k = 0; k < str.length(); k++) {
                    if(str.charAt(k) == '0') {
                        cnt++;
                    }
                }
            }

            bw.write(cnt + "\n");
        }
        br.close();
        bw.close();
    }
}
