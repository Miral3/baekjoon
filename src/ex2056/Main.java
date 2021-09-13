package ex2056;

/*
문제 이름: 작업
알고리즘: 다이나믹 프로그래밍, 위상 저렬
자료구조: 배열, 배열 리스트
*/

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Main {
    static final int max = 10001;
    static int n;
    static ArrayList<Integer> v[] = new ArrayList[max];
    static int[] time = new int[max];
    static int[] degree = new int[max];
    static int[] dp = new int[max];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        time = new int[n + 1];
        degree = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            v[i] = new ArrayList<>();
        }

        for(int i = 1; i <= n; i++) {
            String[] input = br.readLine().split(" ");
            time[i] = Integer.parseInt(input[0]);
            int num = Integer.parseInt(input[1]);

            for(int j = 2; j < num + 2; j++) {
                v[Integer.parseInt(input[j])].add(i);
                degree[i]++;
            }
        }

        dp = time.clone();
        topologySort();

        int result = 0;
        for(int i = 1; i <= n; i++) {
            result = Math.max(time[i], result);
        }

        bw.write(result + "\n");

        br.close();
        bw.close();
    }

    public static void topologySort() {
        Queue<Integer> que = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            if(degree[i] == 0) {
                que.add(i);
            }
        }

        while(!que.isEmpty()) {
            int x = que.poll();

            for(int i = 0; i < v[x].size(); i++) {
                int y = v[x].get(i);

                time[y] = Math.max(time[y], dp[y] + time[x]);

                degree[y]--;
                if(degree[y] == 0) {
                    que.add(y);
                }
            }
        }
    }
}
