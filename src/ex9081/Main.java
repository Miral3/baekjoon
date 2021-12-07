package ex9081;

/*
문제 이름: 단어 맞추기
알고리즘: 문자열
자료구조: 문자열, 배열
*/

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0) {
            String str = br.readLine();
            char[] input = str.toCharArray();
            int len = input.length;
            int[] arr = new int[len];
            for (int i = 0; i < len; i++) {
                arr[i] = (int)input[i] - 'A';
            }

            if(len == 1) {
                bw.write(input[0] + "\n");
                continue;
            }

            int i;
            for (i = len - 1; i > 0; i--) {
                if(arr[i - 1] < arr[i]) {
                    break;
                }
            }

            if(i == 0) {
                bw.write(str + "\n");
                continue;
            }

            int j;
            for (j = len - 1; j >= 0; j--) {
                if(arr[i - 1] < arr[j]) {
                    break;
                }
            }

            char temp = input[i - 1];
            input[i - 1] = input[j];
            input[j] = temp;

            Arrays.sort(input, i, len);

            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < len; k++) {
                sb.append(input[k]);
            }

            bw.write(sb.toString() + "\n");
        }
        br.close();
        bw.close();
    }
}
