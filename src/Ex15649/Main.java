package Ex15649;

import java.io.*;

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

        arr = new int[N+1];
        isVisited = new boolean[N+1];
        backtracking(0);
    }
    public static void backtracking(int cnt) {
        if(M == cnt) {
            for(int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i = 1; i <= N; i++) {
            if(!isVisited[i]) {
                isVisited[i] = true;
                arr[cnt] = i;
                backtracking(cnt + 1);
                isVisited[i] = false;
            }
        }
    }
}
