package ex6603;

/*
문제 이름: 로또
알고리즘: 백트래킹
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while(true) {
            String[] input = br.readLine().split(" ");

            if(input[0].equals("0")) {
                break;
            }

            int n = Integer.parseInt(input[0]);
            int[] arr = new int[n];
            int[] output = new int[6];

            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(input[i + 1]);
            }

            Arrays.sort(arr);
            backTracking(arr, output, n, 0);

            bw.write("\n");

        }

        br.close();
        bw.close();
    }
    public static void backTracking(int[] arr, int[] output, int n, int depth) throws IOException{
        if(depth == 6) {
            for(int i = 0; i < 6; i++) {
                bw.write(output[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for(int i = 0; i < n; i++) {
            if(depth == 0) {
                output[depth] = arr[i];
                backTracking(arr, output, n, depth + 1);
            } else {
                if(arr[i] > output[depth - 1]) {
                    output[depth] = arr[i];
                    backTracking(arr, output, n, depth + 1);
                }
            }
        }
    }
}
