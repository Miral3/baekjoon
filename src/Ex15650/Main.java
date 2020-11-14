package Ex15650;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        arr = new int[M+1];
        isVisited = new boolean[N+1];

        backtracking(0, 1);
    }

    public static void backtracking(int cnt, int idx) {
        if(cnt == M) {
            for(int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for(int i = idx; i <= N; i++) {
            if(!isVisited[i]) {
                isVisited[i] = true;
                arr[cnt] = i;
                backtracking(cnt+1, idx+1);
                isVisited[i] = false;
            }
        }
    }
}
