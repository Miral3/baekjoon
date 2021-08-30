package ex2529;

/*
문제 이름: 부등호
알고리즘: 백트래킹, 브루트포스
자료구조: 연결 리스트
*/

import java.io.*;
import java.util.LinkedList;

public class Main {
    static int k;
    static String[] input;
    static boolean[] isUsed;
    static int[] arr;
    static int[] out;
    static LinkedList<String> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        k = Integer.parseInt(br.readLine());
        input = br.readLine().split(" ");
        isUsed = new boolean[10];
        arr = new int[10];
        out = new int[k + 1];
        for(int i = 0; i < 10; i++) {
            arr[i] = i;
        }

        dfs(0);

        bw.write(result.get(result.size() - 1) + "\n" + result.get(0) + "\n");

        br.close();
        bw.close();
    }
    public static void dfs(int depth){
        String sum = "";
        if(depth == k + 1) {
            for(int i = 0; i < depth; i++) {
                sum += out[i] + "";
            }
            result.add(sum);
            return;
        }

        for(int i = 0; i < 10; i++) {
            if(depth == 0) {
                isUsed[arr[i]] = true;
                out[depth] = arr[i];
                dfs(depth + 1);
                isUsed[arr[i]] = false;
            } else {
                if(!isUsed[arr[i]]) {
                    if(input[depth - 1].equals("<")) {
                        if(arr[i] > out[depth - 1]) {
                            isUsed[arr[i]] = true;
                            out[depth] = arr[i];
                            dfs(depth + 1);
                            isUsed[arr[i]] = false;
                        }
                    } else {
                        if(arr[i] < out[depth - 1]) {
                            isUsed[arr[i]] = true;
                            out[depth] = arr[i];
                            dfs(depth + 1);
                            isUsed[arr[i]] = false;
                        }
                    }
                }
            }
        }
    }
}
