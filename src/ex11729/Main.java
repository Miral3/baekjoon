package ex11729;

/*
문제 이름: 하노이 탑 이동 순서
알고리즘: 재귀
자료구조: 큐
*/

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static Queue<String> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        hanoi(n, 1, 2, 3);

        bw.write(result.size() + "\n");
        while(!result.isEmpty()) {
            bw.write(result.poll() + "\n");
        }

        br.close();
        bw.close();
    }
    public static void hanoi(int n, int from, int by, int to) {
        if(n == 0) {
            return;
        }
        hanoi(n - 1, from, to, by);
        String move = from + " " + to;
        result.add(move);
        hanoi(n - 1, by, from, to);
    }
}
