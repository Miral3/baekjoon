package ex16935;

/*
문제 이름: 배열 돌리기3
알고리즘: 구현
자료구조: 배열
*/

import java.io.*;

public class Main {
    static int n;
    static int m;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        int r = Integer.parseInt(input[2]);
        arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(input[j]);
            }
        }

        input = br.readLine().split(" ");
        for (int i = 0; i < r; i++) {
            int num = Integer.parseInt(input[i]);
            switch (num) {
                case 1: {
                    reverseTopBottom();
                    break;
                }
                case 2: {
                    reverseLeftRight();
                    break;
                }
                case 3: {
                    rotate90DegreeClockWise();
                    break;
                }
                case 4: {
                    rotate90DegreeCounterClockWise();
                    break;
                }
                case 5: {
                    changeGroupClockWise();
                    break;
                }
                case 6: {
                    changeGroupCounterClockWise();
                    break;
                }
                default: {
                    break;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(arr[i][j] + " ");
            }
            bw.write("\n");
        }
        br.close();
        bw.close();
    }

    public static void reverseTopBottom() {
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[n - 1 - i][j];
                arr[n - 1 - i][j] = temp;
            }
        }
    }

    public static void reverseLeftRight() {
        for (int i = 0; i < m / 2; i++) {
            for (int j = 0; j < n; j++) {
                int temp = arr[j][i];
                arr[j][i] = arr[j][m - 1 - i];
                arr[j][m - 1 - i] = temp;
            }
        }
    }

    public static void rotate90DegreeClockWise() {
        int[][] rArr = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rArr[j][n - 1 - i] = arr[i][j];
            }
        }

        arr = rArr;
        int temp = n;
        n = m;
        m = temp;
    }

    public static void rotate90DegreeCounterClockWise() {
        int[][] rArr = new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rArr[m - 1 - j][i] = arr[i][j];
            }
        }

        arr = rArr;
        int temp = n;
        n = m;
        m = temp;
    }

    public static void changeGroupClockWise() {
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[n / 2 + i][j];
                arr[n / 2 + i][j] = arr[n / 2 + i][m / 2 + j];
                arr[n / 2 + i][m / 2 + j] = arr[i][m / 2 + j];
                arr[i][m / 2 + j] = temp;
            }
        }
    }

    public static void changeGroupCounterClockWise() {
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < m / 2; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[i][m / 2 + j];
                arr[i][m / 2 + j] = arr[n / 2 + i][m / 2 + j];
                arr[n / 2 + i][m / 2 + j] = arr[n / 2 + i][j];
                arr[n / 2 + i][j] = temp;
            }
        }
    }
}
