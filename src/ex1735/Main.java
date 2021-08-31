package ex1735;

/*
문제 이름: 분수 합
알고리즘: 유클리드 호제법, 수학
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstFraction = br.readLine().split(" ");
        int firstNumerator = Integer.parseInt(firstFraction[0]);
        int firstDenominator = Integer.parseInt(firstFraction[1]);

        String[] secondFraction = br.readLine().split(" ");
        int secondNumerator = Integer.parseInt(secondFraction[0]);
        int secondDenominator = Integer.parseInt(secondFraction[1]);

        int firstNum = 0;
        int secondNum = 0;
        int gcd = 0;
        int lcm = 0;
        int[] result = new int[2];
        if(firstDenominator > secondDenominator) {
            gcd = GCD(firstDenominator, secondDenominator);
        } else {
            gcd = GCD(secondDenominator, firstDenominator);
        }

        lcm = (firstDenominator * secondDenominator) / gcd;
        result[1] = lcm;

        firstNum = lcm / firstDenominator;
        secondNum = lcm / secondDenominator;
        result[0] = (firstNumerator * firstNum) + (secondNumerator * secondNum);

        gcd = 0;
        if(result[0] > result[1]) {
            gcd = GCD(result[0], result[1]);
        } else {
            gcd = GCD(result[1], result[0]);
        }

        if(gcd != 1) {
            result[0] /= gcd;
            result[1] /= gcd;
        }

        bw.write(result[0] + " " + result[1] + "\n");

        br.close();
        bw.close();
    }
    public static int GCD(int x, int y) {
        int n = 0;
        while(x % y != 0) {
            n = x % y;
            x = y;
            y = n;
        }
        return y;
    }
}
