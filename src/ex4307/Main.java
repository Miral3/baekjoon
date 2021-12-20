package ex4307;

/*
문제 이름: 개미
알고리즘: 구현
자료구조:
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            String[] input = br.readLine().split(" ");
            int l = Integer.parseInt(input[0]);
            int n = Integer.parseInt(input[1]);
            int half = l/2;

            int min = 0;
            int max = 0;
            for (int i = 0; i < n; i++) {
                int location = Integer.parseInt(br.readLine());
                if(location <= half) {
                    min = Math.max(location, min);
                    max = Math.max(l - location, max);
                } else {
                    min = Math.max(l - location, min);
                    max = Math.max(location, max);
                }
            }
            bw.write(min + " " + max +"\n");
        }

        br.close();
        bw.close();
    }
}
