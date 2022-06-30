package ex5545;

/*
문제 이름: 최고의 피자
알고리즘: 그리디, 정렬
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] price = br.readLine().split(" ");
        int doughPrice = Integer.parseInt(price[0]);
        int toppingPrice = Integer.parseInt(price[1]);
        int doughCalorie = Integer.parseInt(br.readLine());
        Integer[] toppingsCalorie = new Integer[n];
        for (int i = 0; i < n; i++) {
            toppingsCalorie[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(toppingsCalorie, Collections.reverseOrder());

        int max = doughCalorie / doughPrice;
        int totalPrice = doughPrice;
        int totalCalorie = doughCalorie;
        for (int i = 0; i < n; i++) {
            totalCalorie += toppingsCalorie[i];
            totalPrice += toppingPrice;
            max = Math.max(max, totalCalorie / totalPrice);
        }

        bw.write(max + "\n");
        br.close();
        bw.close();
    }
}
