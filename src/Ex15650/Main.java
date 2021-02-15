package Ex15650;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

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
        arr = new int[M+1];
        isVisited = new boolean[N+1];
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        backtracking(0, 1);

        br.close();
        bw.close();
    }

    public static void backtracking(int index, int cnt) throws IOException{
        if(index == M) {
            for(int i = 0; i < M; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for(int i = cnt; i <= N; i++) {
            if(!isVisited[i]) {
                arr[index] = i;
                isVisited[i] = true;
                backtracking(index+1, i+1);
                isVisited[i] = false;
            }
        }
    }
}
