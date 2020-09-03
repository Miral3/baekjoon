package Ex8958;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        String quiz;
        int sum;
        int score;

        for(int i = 0; i < testCase; i++) {
            quiz = br.readLine();
            sum = 0;
            score = 0;
            for(int j = 0; j < quiz.length(); j++) {
                if(quiz.charAt(j) == 'O') {
                    ++score;
                    sum += score;
                }
                else if(quiz.charAt(j) == 'X'){
                    score = 0;
                }
            }
            System.out.println(sum);
        }

    }
}
