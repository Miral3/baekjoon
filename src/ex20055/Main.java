package ex20055;

/*
문제 이름: 컨베이어 벨트 위의 로봇
알고리즘: 구현, 시뮬레이션
자료구조: 배열 리스트
*/

import java.io.*;
import java.util.ArrayList;

class Node {
    int durability;
    boolean hasRobot;

    public Node(int durability, boolean hasRobot) {
        this.durability = durability;
        this.hasRobot = hasRobot;
    }
}

public class Main {
    static int n;
    static ArrayList<Node> belt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");

        belt = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            belt.add(new Node(Integer.parseInt(input[i]), false));
        }

        int result = 1;
        while(true) {
            rotate();
            move();
            putRobot();

            int cnt = check();
            if (cnt >= k) {
                bw.write(result + "\n");
                break;
            }
            result++;
        }

        br.close();
        bw.close();
    }

    public static void rotate() {
        int len = 2*n;
        Node lastData = belt.get(len-1);

        for (int i = len - 1; i > 0; i--) {
            belt.set(i, belt.get(i-1));
        }

        belt.set(0, lastData);
        belt.set(n-1, new Node(belt.get(n-1).durability, false));
    }

    public static void move() {
        for (int i = n-2; i >= 0; i--) {
            Node cur = belt.get(i);
            Node next = belt.get(i + 1);
            if(cur.hasRobot && (!next.hasRobot && next.durability >= 1)) {
                cur.hasRobot = false;
                next.hasRobot = true;
                next.durability -= 1;
            }
        }

        belt.set(n-1, new Node(belt.get(n-1).durability, false));
    }

    public static void putRobot() {
        Node first = belt.get(0);
        if(!first.hasRobot && first.durability > 0) {
            first.hasRobot = true;
            first.durability -= 1;
        }
    }

    public static int check() {
        int cnt = 0;
        for (int i = 0; i < 2 * n; i++) {
            if(belt.get(i).durability == 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
