package ex2697;

/*
문제 이름: 다음수 구하기
알고리즘: 구현, 문자열, 그리디
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            String[] input = br.readLine().split("");
            int len = input.length;

            int[] numArr = new int[len];
            for (int i = 0; i < len; i++) {
                numArr[i] = Integer.parseInt(input[i]);
            }

            int[] numCnt = new int[10];
            numCnt[numArr[len - 1]]++;

            boolean isBiggest = true;
            int idx = 0;
            for (int i = len - 2; i >= 0; i--) {
                int cur = numArr[i];
                numCnt[cur]++;
                for (int j = cur + 1; j < 10; j++) {
                    if (numCnt[j] > 0) {
                        isBiggest = false;
                        numArr[i] = j;
                        numCnt[j]--;
                        idx = i + 1;
                        break;
                    }
                }
                if (!isBiggest) {
                    break;
                }
            }
            if (isBiggest) {
                sb.append("BIGGEST\n");
            } else {
                for (int i = idx; i < len; i++) {
                    for (int j = 0; j < 10; j++) {
                        if (numCnt[j] > 0) {
                            numArr[i] = j;
                            numCnt[j]--;
                            break;
                        }
                    }
                }
                for (int i = 0; i < len; i++) {
                    sb.append(numArr[i]);
                }
                sb.append("\n");
            }

        }

        bw.write(sb.toString());
        br.close();
        bw.close();
    }
}
