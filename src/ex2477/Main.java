package ex2477;

/*
문제 이름: 참외밭
알고리즘: 수학, 구현, 기하학
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());
        int maxWidth = 0;
        int maxWidthIdx = 0;
        int maxHeight = 0;
        int maxHeightIdx = 0;
        int[] weights = new int[6];
        for (int i = 0; i < 6; i++) {
            String[] input = br.readLine().split(" ");
            int dir = Integer.parseInt(input[0]);
            int weight = Integer.parseInt(input[1]);
            weights[i] = weight;
            if (dir == 1 || dir == 2) {
                if (weight > maxWidth) {
                    maxWidth = weight;
                    maxWidthIdx = i;
                }
            } else {
                if (weight > maxHeight) {
                    maxHeight = weight;
                    maxHeightIdx = i;
                }
            }
        }


        int totalArea = maxWidth * maxHeight;
        int emptyPlaceWidth = Math.abs(weights[maxWidthIdx - 1 < 0 ? maxWidthIdx - 1 + 6 : maxWidthIdx - 1] - weights[(maxWidthIdx + 1) % 6]);
        int emptyPlaceHeight = Math.abs(weights[maxHeightIdx - 1 < 0 ? maxHeightIdx - 1 + 6 : maxHeightIdx - 1] - weights[(maxHeightIdx + 1) % 6]);
        int emptyPlace = emptyPlaceWidth * emptyPlaceHeight;

        int answer = (totalArea - emptyPlace) * k;
        bw.write(answer + "\n");
        br.close();
        bw.close();
    }
}
