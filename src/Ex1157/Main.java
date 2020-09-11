package Ex1157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        char[] alphabet = input.toCharArray();
        int[] check = new int[26];
        int max = 0;
        int idx = 0;
        int cnt = 0;

        for(int i = 0; i < alphabet.length; i++) {
            if((int)alphabet[i] < 91) {
                check[(int) alphabet[i]-65]++;
            }
            else {
                check[(int) alphabet[i]-97]++;
            }
        }

        for(int i = 0; i < check.length; i++) {
            if(max < check[i]) {
                max = check[i];
                idx = i + 65;
            }
        }

        for(int i =0; i < check.length; i++) {
            if(max == check[i]) {
                cnt++;
            }
        }
        if(cnt > 1) {
            System.out.println("?");
            return;
        }
        System.out.println((char)idx);
    }
}
