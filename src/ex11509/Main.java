package ex11509;

/*
문제 이름: 풍선 맞추기
알고리즘: 그리디
자료구조: 배열
*/

import java.io.*;

public class Main {
    static final int MAX = 1000001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[MAX];

        String[] input = br.readLine().split(" ");
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(input[i]);

            arr[x]++;

            if(arr[x + 1] == 0) {
                cnt++;
            } else {
                arr[x + 1]--;
            }
        }

        bw.write(cnt + "\n");
        br.close();
        bw.close();
    }
}
