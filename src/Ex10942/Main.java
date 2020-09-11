package Ex10942;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int len = Integer.parseInt(br.readLine());
        String input = br.readLine();
        String[] arr = input.split(" ");
        int[] arrInt = new int[len+1];

        for(int i = 0; i < len; i++) {
            arrInt[i+1] = Integer.parseInt(arr[i]);
        }
        int testCase = Integer.parseInt(br.readLine());
        boolean[][] isPalindrome = new boolean[len+1][len+1];

        palindrome(isPalindrome, len, arrInt);
        for(int i = 0; i < testCase; i++) {
            String[] range = br.readLine().split(" ");
            int start = Integer.parseInt(range[0]);
            int end = Integer.parseInt(range[1]);
            if(isPalindrome[start][end]) {
                bw.write("1\n");
            }
            else{
                bw.write("0\n");
            }
        }
        br.close();
        bw.flush();
        bw.close();
    }
    public static void palindrome(boolean[][] isPalindrome, int len, int[] arr) {
        for(int i = 1; i <= len; i++) {
            isPalindrome[i][i] = true;
            if(arr[i] == arr[i-1]) {
                isPalindrome[i-1][i] = true;
            }
        }

        for(int i = 2; i <= len; i++) {
            for(int j = 1; j <= len-i; j++) {
                if(arr[j] == arr[j+i] && isPalindrome[j+1][j+i-1]) {
                    isPalindrome[j][j+i] = true;
                }
            }
        }
    }
}
