import java.util.Stack;

public class LIS {
    public static void main(String[] args){
        int[] arr = {1, 5, 6, 2, 3, 4};
        int length = arr.length;
        int[] dp = new int[length];
        int max = 1;

        dp[0] = 1;

        for(int i = 1; i < length; i++){
            dp[i] = 1;
            for(int j = 0; j < i; j++){
                if(arr[j] < arr[i] && dp[i] < dp[j] + 1)
                    dp[i] = dp[j] + 1;
            }
            if(max < dp[i]) {
                max = dp[i];
            }
        }
        System.out.println(max);

        Stack<Integer> st = new Stack<>();
        int idx = max;

        for(int i = length-1; i >= 0; i--){
            if(dp[i] == idx){
                st.push(arr[i]);
                idx--;
            }
            else {
                continue;
            }
        }

        while(!st.isEmpty()){
            System.out.print(st.pop() + " ");
        }
    }
}


