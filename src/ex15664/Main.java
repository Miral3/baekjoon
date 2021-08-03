package ex15664;

/*
문제 이름: N과 M (10)
알고리즘: 백트래킹
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class Main {
    static int n, m;
    static int[] arr, output;
    static boolean[] isVisited;
    static LinkedHashSet<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        arr = new int[n];
        output = new int[m];
        isVisited = new boolean[n];

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
            if(!isVisited[i]) {
                isVisited[i] = true;
                output[depth] = arr[i];
                if (depth > 0 && output[depth] >= output[depth - 1]) {
                    func(depth + 1);
                } else if (depth == 0) {
                    func(depth + 1);
                }
                isVisited[i] = false;
            }
        }
    }
}