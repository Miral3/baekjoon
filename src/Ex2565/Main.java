package Ex2565;

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        int[][] arr = new int[testCase][2];
        int dp[] = new int[testCase];
        int max = 1;

        for(int i = 0; i < testCase; i++){
            for(int j = 0; j < 2; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        dp[0] = 1;
        Arrays.sort(arr, Comparator.comparingInt(o1 -> o1[0]));

        for(int i = 1; i < testCase; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(arr[j][1] < arr[i][1] && dp[i] < dp[j] + 1){
                    dp[i] = dp[j] + 1;
                }
            }
            if(max < dp[i]){
                max = dp[i];
            }
        }
        System.out.println(testCase - max);
        sc.close();
    }
}
