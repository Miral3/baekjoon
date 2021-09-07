package ex17204;

/*
문제 이름: 죽음의 게임
알고리즘: 그래프 탐색
자료구조: 배열, 리스트
*/

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        int[] arr = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int num = arr[0];
        list.add(num);
        for(int i = 1; i < n; i++) {
            num = arr[num];
            if(list.contains(num)) {
                break;
            } else {
                list.add(num);
            }
        }

        if(!list.contains(k)) {
            System.out.println(-1);
            return;
        }

        int cnt = 0;
        for(int i = 0; i < list.size(); i++) {
            int idx = list.get(i);
            cnt++;
            if(idx == k) {
                System.out.println(cnt);
                break;
            }
        }

        br.close();
        bw.close();
    }
}
