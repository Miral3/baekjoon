package ex1132;

/*
문제 이름: 합
알고리즘: 그리디
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        Long[] alphabet = new Long[10];
        Arrays.fill(alphabet, (long)0);
        boolean[] check = new boolean[10];
        for(int i = 0; i < n; i++) {
           char[] input = br.readLine().toCharArray();
           int len = input.length;
           long d = 1;
           check[input[0]-'A'] = true;
           for(int j = len-1; j >= 0; j--) {
               alphabet[input[j] - 'A'] += d;
               d *= 10;
           }
        }

        int temp = 0;
        for(int i = 0; i < 10; i++) {
            if(!check[i]) {
                temp = i;
                break;
            }
        }
        for(int i = 0; i < 10; i++) {
            if(!check[i] && alphabet[temp] > alphabet[i]) {
                temp = i;
            }
        }

        alphabet[temp] = (long)0;
        Arrays.sort(alphabet, Collections.reverseOrder());

        long result = 0;
        for(int i = 0; i < 10; i++) {
            result += (9-i) * alphabet[i];
        }

        System.out.println(result);
        br.close();
        bw.close();
    }
}
