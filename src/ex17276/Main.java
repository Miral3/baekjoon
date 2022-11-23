package ex17276;

/*
문제 이름: 배열 돌리기
알고리즘: 구현
자료구조: 배열
*/

import java.io.*;

public class Main {
    static int[][] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int d = Integer.parseInt(input[1]);
            int[][] arr = new int[n][n];
            result = new int[n][n];

            for (int i = 0; i < n; i++) {
                input = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(input[j]);
                    result[i][j] = arr[i][j];
                }
            }

            for (int i = 0; i < 4; i++) {
                int[] num = new int[n];
                int target = d / 45;
                if (target < 0) {
                    target += 8;
                }
                switch (i) {
                    case 0: {
                        for (int j = 0; j < n; j++) {
                            num[j] = arr[j][j];
                        }
                        break;
                    }
                    case 1: {
                        for (int j = 0; j < n; j++) {
                            num[j] = arr[j][n / 2];
                        }
                        break;
                    }
                    case 2: {
                        for (int j = 0; j < n; j++) {
                            num[j] = arr[j][n - (1 + j)];
                        }
                        break;
                    }
                    case 3: {
                        for (int j = 0; j < n; j++) {
                            num[j] = arr[n / 2][n - (j + 1)];
                        }
                        break;
                    }
                }
                inputArr(num, (target + i) % 8, n);
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    bw.write(result[i][j] + " ");
                }
                bw.write("\n");
            }
        }

        br.close();
        bw.close();
    }

    public static void inputArr(int[] num, int target, int n) {
        switch (target) {
            case 0: {
                for (int i = 0; i < n; i++) {
                    result[i][i] = num[i];
                }
                break;
            }
            case 1: {
                for (int i = 0; i < n; i++) {
                    result[i][n / 2] = num[i];
                }
                break;
            }
            case 2: {
                for (int i = 0; i < n; i++) {
                    result[i][n - (1 + i)] = num[i];
                }
                break;
            }
            case 3: {
                for (int i = 0; i < n; i++) {
                    result[n / 2][n - (i + 1)] = num[i];
                }
                break;
            }
            case 4: {
                for (int i = 0; i < n; i++) {
                    result[n - (i + 1)][n - (i + 1)] = num[i];
                }
                break;
            }
            case 5: {
                for (int i = 0; i < n; i++) {
                    result[n - (i + 1)][n / 2] = num[i];
                }
                break;
            }
            case 6: {
                for (int i = 0; i < n; i++) {
                    result[n - (i + 1)][i] = num[i];
                }
                break;
            }
            case 7: {
                for (int i = 0; i < n; i++) {
                    result[n / 2][i] = num[i];
                }
                break;
            }
        }
    }
}
