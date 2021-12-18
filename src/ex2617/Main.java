package ex2617;

/*
문제 이름: 구슬 찾기
알고리즘: dfs
자료구조: 배열 리스트
*/

import java.io.*;
import java.util.ArrayList;

public class Main {
    static final int max = 100;
    static int n;
    static int m;
    static ArrayList<Integer> heavier[] = new ArrayList[max];
    static ArrayList<Integer> lighter[] = new ArrayList[max];
    static boolean[] hVisited = new boolean[max];
    static boolean[] lVisited = new boolean[max];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        for (int i = 1; i <= n; i++) {
            heavier[i] = new ArrayList<>();
            lighter[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            int heavy = Integer.parseInt(input[0]);
            int light = Integer.parseInt(input[1]);

            heavier[heavy].add(light);
            lighter[light].add(heavy);
        }

        boolean[] result = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            hVisited = new boolean[max];
            lVisited = new boolean[max];

            if (HDFS(i) > (n + 1) / 2) {
                result[i] = true;
            }
            if (LDFS(i) > (n + 1) / 2) {
                result[i] = true;
            }
        }

        int answer = 0;
        for (int i = 1; i <= n ; i++) {
            if(result[i]) {
                answer++;
            }
        }

        bw.write(answer + "\n");
        br.close();
        bw.close();
    }

    public static int HDFS(int x) {
        int cnt = 1;
        for (int i = 0; i < heavier[x].size(); i++) {
            if(!hVisited[heavier[x].get(i)]) {
                hVisited[heavier[x].get(i)] = true;
                cnt += HDFS(heavier[x].get(i));
            }
        }
        return cnt;
    }

    public static int LDFS(int x) {
        int cnt = 1;
        for (int i = 0; i < lighter[x].size(); i++) {
            if(!lVisited[lighter[x].get(i)]) {
                lVisited[lighter[x].get(i)] = true;
                cnt += LDFS(lighter[x].get(i));
            }
        }
        return cnt;
    }
}
