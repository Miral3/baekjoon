package ex1182;

/*
문제 이름:
알고리즘:
자료구조:
*/

import java.io.*;

public class Main {
    static int n, s, result;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input1 = br.readLine().split(" ");
        n = Integer.parseInt(input1[0]);
        s = Integer.parseInt(input1[1]);

        arr = new int[21];
        String[] input2 = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(input2[i]);
        }

        result = 0;
        dfs(0, 0);

        System.out.println(result);

        br.close();
        bw.close();
    }

    public static void dfs(int depth, int sum) {
        if(depth == n) {
            return;
        }
        if(sum + arr[depth] == s) {
            result++;
        }

        dfs(depth + 1, sum);
        dfs(depth + 1, sum + arr[depth]);
    }
}
