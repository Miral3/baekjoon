package ex2961;

/*
문제 이름: 도영이가 만든 맛있는 음식
알고리즘: 브루트포스 알고리즘
자료구조: 배열 리스트
*/

import java.io.*;
import java.util.ArrayList;

class Node {
    int salty;
    int bitter;

    public Node(int salty, int bitter) {
        this.salty = salty;
        this.bitter = bitter;
    }
}

public class Main {
    static int min = Integer.MAX_VALUE;
    static int n;
    static ArrayList<Node> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int salty = Integer.parseInt(input[0]);
            int bitter = Integer.parseInt(input[1]);

            list.add(new Node(salty, bitter));
        }

        getDif(0, 1, 0);

        bw.write(min + "\n");
        br.close();
        bw.close();
    }

    public static void getDif(int depth, int s, int b) {
        if(depth == n) {
            if(s != 0 && b != 0) {
                min = Math.min(Math.abs(s - b), min);
            }
            return;
        }

        getDif(depth + 1, s * list.get(depth).salty, b + list.get(depth).bitter);
        getDif(depth + 1, s, b);
    }
}
