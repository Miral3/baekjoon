package Ex10039;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input;
        int[] score;
        int sum;

        score = new int[5];
        for(int i = 0; i < 5; i++) {
            input = Integer.parseInt(br.readLine());
            if(input < 40) {
                input = 40;
            }
            score[i] = input;
        }

        sum = 0;
        for(int i = 0; i < 5; i++) {
            sum += score[i];
        }
        System.out.println(sum/5);
    }
}
