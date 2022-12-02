package ex19637;

/*
문제 이름: IF문 좀 대신 써줘
알고리즘: 이분 탐색
자료구조: 배열 리스트
*/

import java.io.*;
import java.util.ArrayList;

class Title {
    String name;
    int power;

    public Title(String name, int power) {
        this.name = name;
        this.power = power;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        ArrayList<Title> title = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            title.add(new Title(input[0], Integer.parseInt(input[1])));
        }

        for (int i = 0; i < m; i++) {
            int power = Integer.parseInt(br.readLine());
            int left = 0;
            int right = n - 1;
            int mid = 0;
            while (left <= right) {
                mid = (left + right) / 2;
                if (power <= title.get(mid).power) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            bw.write(title.get(left).name + "\n");
        }
        br.close();
        bw.close();
    }
}
