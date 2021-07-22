package ex1449;

/*
문제 이름: 수리공 항승
알고리즘: 그리디
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int l = Integer.parseInt(input1[1]);

        String[] input2 = br.readLine().split(" ");
        int[] leak = new int[n];
        for(int i = 0; i < n; i++) {
            leak[i] = Integer.parseInt(input2[i]);
        }
        Arrays.sort(leak);

        int cnt = 0;
        int start = 0;
        for(int i = 0; i < n; i++) {
           if(start <= leak[i]) {
               start = leak[i] + l;
               cnt++;
           }
        }

        System.out.println(cnt);

        br.close();
        bw.close();
    }
}