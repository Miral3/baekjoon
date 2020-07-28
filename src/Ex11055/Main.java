package Ex11055;

import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size+1];
        int[] dp = new int[size+1];
        int max = 0;

        for(int i = 1; i <= size; i++){
            arr[i] = sc.nextInt();
        }


        for(int i = 1; i <= size; i++){
            dp[i] = arr[i];
            for(int j = 1; j < size; j++){
                if(arr[i] > arr[j] && dp[i] < dp[j] + arr[i]){
                    dp[i] = dp[j] + arr[i];
                }
            }
            if(max < dp[i]) {
                max = dp[i];
            }
        }
        System.out.println(max);
    }
}
