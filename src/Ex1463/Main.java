package Ex1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        int[] dp = new int[1000001];

        dp[2] = 1;
        dp[3] = 1;
        if (input > 3) {
            for (int i = 4; i <= input; i++) {
                int caseOne = dp[i - 1] + 1;
                int caseTwo = dp[i - 1] + 1;
                if (i % 2 == 0)
                    caseOne = dp[i / 2] + 1;
                if (i % 3 == 0)
                    caseTwo = dp[i / 3] + 1;
                int caseThr = dp[i - 1] + 1;
                dp[i] = Math.min(caseOne, Math.min(caseTwo, caseThr));
            }
        }
        System.out.println(dp[input]);
    }
}
