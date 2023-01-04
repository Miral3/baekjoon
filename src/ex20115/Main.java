package ex20115;

/*
문제 이름: 에너지 드링크
알고리즘: 그리디, 정렬
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        float[] arr = new float[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Float.parseFloat(input[i]);
        }

        Arrays.sort(arr);

        for (int i = 0; i < n - 1; i++) {
            float mix = arr[i] / 2 + arr[n - 1];
            arr[n - 1] = mix;
        }

        bw.write(arr[n - 1] + "\n");
        br.close();
        bw.close();
    }
}
