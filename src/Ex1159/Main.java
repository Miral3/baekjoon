package Ex1159;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        int[] arrCnt = new int[26];

        for(int i = 0; i < testCase; i++) {
            String input = br.readLine();
            int lastName = input.charAt(0) - 97;
            arrCnt[lastName]++;
        }

        boolean abstention = true;
        for(int i = 0; i < 26; i++) {
            if(arrCnt[i] >= 5) {
                System.out.print((char)(i+97));
                abstention = false;
            }
        }
        if(abstention) {
            System.out.println("PREDAJA");
        }
    }
}
