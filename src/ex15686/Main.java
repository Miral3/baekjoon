package ex15686;

/*
문제 이름: 치킨 배달
알고리즘: 구현, 백트래킹
자료구조: 배열 리스트, 스택
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;

class Node {
    int y;
    int x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static ArrayList<Node> chickenPlace;
    static ArrayList<Node> houses;
    static Stack<Node> selectedChickenPlace;
    static int minDist = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] map = new int[n][n];
        houses = new ArrayList<>();
        chickenPlace = new ArrayList<>();
        selectedChickenPlace = new Stack<>();
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(input[j]);

                if (map[i][j] == 1) {
                    houses.add(new Node(i, j));
                } else if (map[i][j] == 2) {
                    chickenPlace.add(new Node(i, j));
                }
            }
        }

        select(0, 0, m);

        bw.write(minDist + "\n");
        br.close();
        bw.close();
    }

    public static void select (int start, int depth, int m) {
        if (depth == m) {
            calcDist();
            return;
        }

        for (int i = start; i < chickenPlace.size(); i++) {
            selectedChickenPlace.push(chickenPlace.get(i));
            select(i + 1, depth + 1, m);
            selectedChickenPlace.pop();
        }
    }

    public static void calcDist() {
        int sum = 0;
        for (Node house : houses) {
            int min = Integer.MAX_VALUE;

            for (Node chicken : selectedChickenPlace) {
                int dist = Math.abs(house.x - chicken.x) + Math.abs(house.y - chicken.y);
                min = Math.min(min, dist);
            }

            sum += min;

            if (sum > minDist) {
                return;
            }
        }
        minDist = Math.min(sum, minDist);
    }
}
