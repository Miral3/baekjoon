package ex15665;

/*
문제 이름: N과 M (11)
알고리즘: 백트래킹
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class Main {
    static int n, m;
    static int[] arr, output;
    static LinkedHashSet<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        arr = new int[n];
        output = new int[m];

        input = br.readLine().split(" ");
        for(int i = 0; i < n ; i++) {
            arr[i] = Integer.parseInt(input[i]);
        }
        Arrays.sort(arr);

        func(0);

        for(String s : set) {
            bw.write(s + "\n");
        }

        br.close();
        bw.close();
    }

    public static void func(int depth) {
        if(depth == m) {
            String str = "";
            for(int i = 0; i < m; i++) {
                str += output[i] + " ";
            }
            set.add(str);
            return;
        }

        for(int i = 0; i < n; i++) {
            output[depth] = arr[i];
            func(depth + 1);
        }
    }
}