package ex16564;

/*
문제 이름: 히오스 프로게이머
알고리즘: 이분 탐색, 매개 변수 탐색
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[] arr = new int[n];
        int low = 1000000001;
        int high = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            low = Math.min(arr[i], low);
            high = Math.max(arr[i] + k, high);
        }

        int answer = 0;
        while (low <= high) {
            int mid = (low + high)/ 2;
            int sum = 0;
            boolean isSatisfied = true;
            for (int i = 0; i < n; i++) {
                int requiredLevel = mid - arr[i];
                if (requiredLevel > 0) {
                    sum += requiredLevel;
                }
                if (sum > k) {
                    isSatisfied = false;
                    break;
                }
            }
            if (isSatisfied) {
                answer = Math.max(answer, mid);
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }
}
