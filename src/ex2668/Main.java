package ex2668;

/*
문제 이름: 숫자고르기
알고리즘: dfs
자료구조: 배열, 배열 리스트
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static int n;
    static int[] arr;
    static boolean[] isVisited;
    static ArrayList<Integer> temp;
    static ArrayList<Integer> result = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        isVisited = new boolean[n + 1];

        for(int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 1; i <= n; i++) {
            temp = new ArrayList<>();
            dfs(i, i);
        }

        Collections.sort(result);
        bw.write(result.size() + "\n");
        for (Integer v : result) {
            bw.write(v + "\n");
        }

        br.close();
        bw.close();
    }

    public static void dfs(int idx, int x) {
        if(isVisited[x]) {
            if(x == idx) {
                for (int i = 0; i < temp.size(); i++) {
                    if(!result.contains(temp.get(i))) {
                        result.add(temp.get(i));
                    }
                }
            }
            return;
        }

        temp.add(x);
        isVisited[x] = true;
        dfs(idx, arr[x]);
        isVisited[x] = false;
    }
}
