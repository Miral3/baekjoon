package Ex15652;

import java.io.*;

public class Main {
    static int[] arr;
    static boolean[] isVisited;
    static BufferedWriter bw;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        arr = new int[N+1];
        isVisited = new boolean[N+1];
        bw = new BufferedWriter(new OutputStreamWriter(System.out));
        backtracking(0, 1, N, M);
        br.close();
        bw.close();
    }
    public static void backtracking(int cnt, int idx, int N, int M) throws IOException{
        if(cnt == M) {
            for(int i = 0; i < M; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for(int i = 1; i <= N; i++) {
            arr[cnt] = i;
            backtracking(cnt + 1, idx+1, N, M);
        }
    }
}
