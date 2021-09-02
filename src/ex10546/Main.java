package ex10546;

/*
문제 이름: 배부른 마라토너
알고리즘: 정렬
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] player = new String[n];
        String[] goal = new String[n];

        for(int i = 0; i < n; i++) {
            player[i] = br.readLine();
        }
        for(int i = 0; i < n -1; i++) {
            goal[i] = br.readLine();
        }
        goal[n-1] = "zzzzzzzzzzzzzzzzzzzz";

        Arrays.sort(player);
        Arrays.sort(goal);
        for(int i = 0; i < n; i++) {
            if(!player[i].equals(goal[i])) {
                bw.write(player[i] + "\n");
                break;
            }
        }



        br.close();
        bw.close();
    }
}
