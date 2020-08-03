/*
참고 : https://seungkwan.tistory.com/8
 */

package Ex14003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

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

        dp[0] = 1;
        ans[0] = arr[0];
        int idx = 0;
        int max = 1;

        for(int i = 1; i < testCase; i++){
            if(ans[idx] < arr[i]) {
                ans[++idx] = arr[i];
                dp[i] = idx + 1;
            }
            else {
                int j = lowerBound(ans, arr[i], idx);
                ans[j] = arr[i];
                dp[i] = j + 1;
            }
            if(max < dp[i])
                max = dp[i];
        }

        System.out.println(max);

        Stack<Integer> st = new Stack<>();
        int j = max;

        for(int i = testCase-1; i >= 0; i--){
            if(dp[i] == j){
                st.push(arr[i]);
                j--;
            }
            else {
                continue;
            }
        }

        while(!st.isEmpty()){
            System.out.print(st.pop() + " ");
        }
    }

    public static int lowerBound(int[] arr, int target, int end){
        int start = 0;

        while(start < end){
            int mid = (start + end) / 2;
            if(arr[mid] >= target){
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        return end;
    }
}