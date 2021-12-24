package ex15900;

/*
문제 이름: 나무 탈출
알고리즘: DFS
자료구조: 배열 리스트
*/

import java.io.*;
import java.util.ArrayList;

public class Main {
    static ArrayList<Integer> v[];
    static boolean[] isVisited;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        v = new ArrayList[n + 1];
        for (int i = 0; i <=n; i++) {
            v[i] = new ArrayList<>();
        }
        isVisited = new boolean[n + 1];

        for (int i = 0; i < n-1; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            v[a].add(b);
            v[b].add(a);
        }

        isVisited[1] = true;
        DFS(1, 0);

        if(result % 2 == 1) {
            bw.write("Yes\n");
        } else {
            bw.write("No\n");
        }
        br.close();
        bw.close();
    }

    public static void DFS(int x, int cnt) {
        if(x != 1 && v[x].size() == 1) {
            result += cnt;
            return;
        }

        for (Integer value : v[x]) {
            if(!isVisited[value]) {
                isVisited[value] = true;
                DFS(value, cnt + 1);
                isVisited[value] = false;
            }
        }
    }
}
