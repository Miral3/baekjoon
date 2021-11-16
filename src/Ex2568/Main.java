package ex2568;

/*
문제 이름: 전깃줄 - 2
알고리즘: LIS, LowerBound
자료구조: 배열 리스트, 스택
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

class Node implements Comparable<Node> {
    int A;
    int B;

    public Node(int A, int B) {
        this.A = A;
        this.B = B;
    }

    @Override
    public int compareTo(Node o) {
        return A - o.A;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Node> list = new ArrayList<>();
        int[] ans = new int[n];
        int[] dp = new int[n];

        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);

            list.add(new Node(A, B));
        }

        Collections.sort(list);


        dp[0] = 1;
        ans[0] = list.get(0).B;
        int j = 0;
        int max = 1;
        for(int i = 1; i < n; i++) {
            if (ans[j] < list.get(i).B) {
                ans[++j] = list.get(i).B;
                dp[i] = j + 1;
            } else {
                int idx = lowerBound(ans, list.get(i).B, j);
                ans[idx] = list.get(i).B;
                dp[i] = idx + 1;
            }

            max = Math.max(dp[i], max);
        }

        bw.write(n - max + "\n");

        Stack<Integer> st = new Stack<>();
        for(int i = n-1; i >= 0; i--) {
            if(dp[i] == max) {
                max--;
            } else {
                st.push(list.get(i).A);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.append(st.pop()).append("\n");
        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }

    public static int lowerBound(int[] arr, int target, int right) {
        int left = 0;

        while(left < right) {
            int mid = (left + right) / 2;

            if (target <= arr[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }
}
