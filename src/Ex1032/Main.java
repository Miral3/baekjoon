package Ex1032;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        String compareStr = "";
        String[] input = new String[testCase];
        int len = 0;

        for(int i = 0; i < testCase; i++) {
            input[i] = br.readLine();
        }

        compareStr = input[0];
        len = compareStr.length();

        for(int i = 1; i < testCase; i++) {
            String trans = "";
            for(int j = 0; j < len; j++) {
                if(compareStr.charAt(j) != input[i].charAt(j)) {
                    trans += "?";
                }
                else {
                    trans += compareStr.charAt(j);
                }
            }
            compareStr = trans;
        }
        System.out.println(compareStr);
    }
}
