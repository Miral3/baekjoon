package Ex1965;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        String[] arrStr = br.readLine().split(" ");
        int[] arr = new int[testCase];
        int[] dp = new int[testCase];
        int max = 1;
        for(int i = 0; i < testCase; i++){
            arr[i] = Integer.parseInt(arrStr[i]);
        }

        dp[0] = 1;

        for(int i = 1; i < testCase; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                }
            }
            if(max < dp[i]){
                max = dp[i];
            }
        }
        System.out.println(max);
        br.close();
    }
}
