package Ex15649;

import java.io.*;

public class Main {
    static BufferedWriter bw;
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
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        backtracking(0);

        br.close();
        bw.close();
    }

    public static void backtracking(int index) throws IOException{
        if(index == M) {
            for(int i = 0; i < M; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for(int i = 1; i <= N; i++) {
            if(!isVisited[i]) {
                arr[index] = i;
                isVisited[i] = true;
                backtracking(index+1);
                isVisited[i] = false;
            }
        }
    }
}
