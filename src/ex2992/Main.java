package ex2992;

/*
문제 이름: 크면서 작은 수
알고리즘: 문자열, 백트래킹
자료구조: 배열, 열결 해시 셋
*/

import java.io.*;
import java.util.Arrays;
import java.util.LinkedHashSet;

public class Main {
    static String x;
    static String[] arr;
    static String[] output;
    static boolean[] isVisited;
    static LinkedHashSet<String> set = new LinkedHashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        x = br.readLine();
        int n = x.length();

        arr = new String[n];
        output = new String[n];
        isVisited = new boolean[n];
        for(int i = 0; i < n; i++) {
            arr[i] = x.charAt(i) + "";
        }

        Arrays.sort(arr);
        dfs(n,0);

        String[] setArr = set.toArray(new String[set.size()]);
        for(int i = 0; i < set.size(); i++) {
            if(setArr[i].equals(x) && i < set.size() - 1) {
                System.out.println((setArr[i + 1]));
                return;
            }
        }

        System.out.println(0);

        br.close();
        bw.close();
    }

    public static void dfs(int n, int depth) {
        if(depth == n) {
            String result = "";
            for(int i = 0; i < depth; i++) {
                result += output[i];
            }
            set.add(result);
            return;
        }

        for(int i = 0; i < n; i++) {
            if(!isVisited[i]) {
                isVisited[i] = true;
                output[depth] = arr[i];
                dfs(n, depth + 1);
                isVisited[i] = false;
            }
        }
    }
}
