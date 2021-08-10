package ex14888;

/*
문제 이름: 연산자 끼워넣기
알고리즘: 백트래킹
자료구조: 배열
*/

import java.io.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static int[] nums, operator;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        nums = new int[n];
        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");
        operator = new int[4];

        int size = 0;
        for(int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(input[i]);
            size += Integer.parseInt(input[i]);
        }

        int[] arr = new int[size];
        int[] output = new int[size];
        int idx = 0;
        for(int i = 0; i < operator[0]; i++) {
            arr[idx++] = 0;
        }
        for(int i = 0; i < operator[1]; i++) {
            arr[idx++] = 1;
        }
        for(int i = 0; i < operator[2]; i++) {
            arr[idx++] = 2;
        }
        for(int i = 0; i < operator[3]; i++) {
            arr[idx++] = 3;
        }

        isVisited = new boolean[size];
        backTracking(arr, output, size, 0);

        bw.write(max + "\n" + min + "\n");

        br.close();
        bw.close();
    }

    public static void backTracking(int[]arr, int[] output, int n, int depth) {
        if(n == depth) {
            int result = nums[0];
            for(int i = 0; i < n; i++) {
                switch (output[i]) {
                    case 0:
                        result += nums[i + 1];
                        break;
                    case 1:
                        result -= nums[i + 1];
                        break;
                    case 2:
                        result *= nums[i + 1];
                        break;
                    case 3:
                        result /= nums[i + 1];
                        break;
                }
            }
            min = Math.min(result, min);
            max = Math.max(result, max);
        }

        for(int i = 0; i < n; i++) {
            if(!isVisited[i]) {
                isVisited[i] = true;
                output[depth] = arr[i];
                backTracking(arr, output, n, depth + 1);
                isVisited[i] = false;
            }
        }
    }
}
