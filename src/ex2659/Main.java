package ex2659;

/*
문제 이름: 십자카드 문제
알고리즘: 구현
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int min = 10000;
        for(int i = 0; i < 4; i++) {
            String str = "";
            for(int j = i; j < (i + 4); j++) {
                str += input[j % 4];
            }
            int num = Integer.parseInt(str);
            min = Math.min(min, num);
        }

        int cnt = 1;
        int[] arr = new int[4];
        boolean[] isVisited = new boolean[10000];
        for(int a = 1; a <= 9; a++) {
            arr[0] = a;
            for(int b = 1; b <= 9; b++) {
                arr[1] = b;
                for(int c = 1; c <= 9; c++) {
                    arr[2] = c;
                    for(int d = 1; d <= 9; d++) {
                        arr[3] = d;
                        int clockNum = getClockNum(arr);
                        if(!isVisited[clockNum] && min > clockNum) {
                            isVisited[clockNum] = true;
                            cnt++;
                        } else if(min == clockNum) {
                            System.out.println(cnt);
                            return;
                        } else {
                            continue;
                        }
                    }
                }
            }
        }

        br.close();
        bw.close();
    }

    public static int getClockNum(int[] arr) {
        int min = 10000;
        for(int i = 0; i < 4; i++) {
            String str = "";
            for(int j = i; j < (i + 4); j++) {
                str += arr[j % 4];
            }
            int num = Integer.parseInt(str);
            min = Math.min(min, num);
        }

        return min;
    }
}
