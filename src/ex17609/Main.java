package ex17609;

/*
문제 이름: 회문
알고리즘: 구현, 문자열, 그리디, 두 포인터
자료구조: 문자열, 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        for(int i = 0; i < t; i++) {
            String input = br.readLine();
            String[] arr = input.split("");

            if(isPalindrome(arr)) {
                bw.write(0 + "\n");
            } else if(isPseudoPalindrome(arr, 0, arr.length - 1, 1)) {
                bw.write(1 + "\n");
            } else {
                bw.write(2 + "\n");
            }
        }

        br.close();
        bw.close();
    }

    public static boolean isPalindrome(String[] str) {
        for(int i = 0, j = str.length - 1; i <= j; i++, j--) {
            if(!str[i].equals(str[j])) {
                return false;
            }
        }

        return true;
    }

    public static boolean isPseudoPalindrome(String[] str, int start, int end, int chance) {
        if(start > end) {
            return true;
        }

        if(str[start].equals(str[end])) {
            return isPseudoPalindrome(str, start + 1, end - 1, chance);
        }
        else if(chance == 1) {
            if(isPseudoPalindrome(str, start + 1, end, 0) || isPseudoPalindrome(str, start, end - 1, 0)) {
                return true;
            } else {
                return false;
            }
        }
        else {
            return false;
        }
    }
}
