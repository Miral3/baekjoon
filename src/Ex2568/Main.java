//package Ex2568;
//
//import java.io.IOException;
//import java.util.Arrays;
//import java.util.Comparator;
//import java.util.Scanner;
//import java.util.Stack;
//
//public class Main {
//    public static void main(String[] args) throws IOException{
//        Scanner sc = new Scanner(System.in);
//        int testCase = sc.nextInt();
//        int[][] arr = new int[testCase][2];
//        int[] dp = new int[testCase];
//        int[] ans = new int[testCase];
//        int max = 1;
//        int idx = 0;
//
//        for(int i = 0; i < testCase; i++){
//            for(int j = 0; j < 2; j++){
//                arr[i][j] = sc.nextInt();
//            }
//        }
//
//        dp[0] = 1;
//        ans[0] = arr[0][1];
//        Arrays.sort(arr, Comparator.comparingInt(o1 -> o1[0]));
//        for(int i = 1; i < testCase; i++){
//            if(ans[idx] < arr[i][1]){
//                ans[++idx] = arr[i][1];
//                dp[i] = idx + 1;
//            }
//            else{
//                int j = lowBound(ans, idx, arr[i][1]);
//                ans[j] = arr[i][1];
//                dp[i] = idx + 1;
//
//            }
//            if(max < dp[i]){
//                max = dp[i];
//            }
//        }
//        System.out.println(testCase - max);
//
//        Stack<Integer> st = new Stack<>();
//        for(int i = testCase - 1; i >= 0; i--){
//            if(max == dp[i]){
//                max--;
//            }
//            else{
//                st.push(arr[i][0]);
//            }
//        }
//
//        while(!st.isEmpty()){
//            System.out.println(st.pop());
//        }
//    }
//
//    public static int lowBound(int[] arr, int end, int target){
//        int start = 0;
//        while(start < end){
//            int mid = (start + end) / 2;
//            if(arr[mid] > target){
//                end = mid;
//            }
//            else {
//                start = mid + 1;
//            }
//        }
//        return end;
//    }
//}
