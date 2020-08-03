package Ex1365;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int[] arr = new int[testCase];
        int[] dp = new int[testCase];
        int[] ans = new int[testCase];
        String[] arrStr = br.readLine().split(" ");
        for(int i = 0; i < testCase; i++){
            arr[i] = Integer.parseInt(arrStr[i]);
        }
        int max = 1;

        dp[0] = 1;
        ans[0] = arr[0];
        int idx = 0;
        for(int i = 1; i < testCase; i++){
            if(ans[idx] < arr[i]){
                ans[++idx] = arr[i];
                dp[i] = idx + 1;
            }
            else{
                int j = lowBound(ans, idx, arr[i]);
                ans[j] = arr[i];
                dp[i] = idx + 1;
            }
            if(max < dp[i]){
                max = dp[i];
            }
        }
        System.out.print(testCase - max);
    }

    public static int lowBound(int[] arr, int end, int target){
        int start = 0;

        while(start < end){
            int mid = (start + end) / 2;
            if(arr[mid] > target){
                end = mid;
            }
            else{
                start = mid + 1;
            }
        }
        return end;
    }

}
