package ex2174;

/*
문제 이름: 로봇 시뮬레이션
알고리즘: 구현, 시뮬레이션
자료구조: 배열, 리스트
*/

import java.io.*;
import java.util.ArrayList;

class Node {

    int y;
    int x;
    String d;

    public Node(int y, int x, String d) {
        this.y = y;
        this.x = x;
        this.d = d;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int[][] map = new int[b][a];

        input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        ArrayList<Node> list = new ArrayList<>();
        list.add(0, null);
        for (int i = 0; i < n; i++) {
            input = br.readLine().split(" ");

            int x = Integer.parseInt(input[0]) - 1;
            int y = b - Integer.parseInt(input[1]);
            String d = input[2];

            list.add(i + 1, new Node(y, x, d));
            map[y][x] = i + 1;
        }

        String[] cmdList = new String[m];
        for (int i = 0; i < m; i++) {
            cmdList[i] = br.readLine();
        }

        for (int i = 0; i < m; i++) {
            String[] cmd = cmdList[i].split(" ");

            int idx = Integer.parseInt(cmd[0]);
            String command = cmd[1];
            int num = Integer.parseInt(cmd[2]);

            for (int j = 0; j < num; j++) {

                Node cur = list.get(idx);
                int y = cur.y;
                int x = cur.x;
                String d = cur.d;

                map[y][x] = 0;

                if (command.equals("F")) {
                    if (d.equals("E")) {
                        x += 1;
                    } else if (d.equals("W")) {
                        x -= 1;
                    } else if (d.equals("S")) {
                        y += 1;
                    } else if (d.equals("N")) {
                        y -= 1;
                    }

                    if (x < 0 || y < 0 || x >= a || y >= b) {
                        System.out.println("Robot " + idx + " crashes into the wall");
                        return;
                    }
                    if (map[y][x] != 0) {
                        System.out.println("Robot " + idx + " crashes into robot " + map[y][x]);
                        return;
                    }

                } else if (command.equals("L")) {

                    if (d.equals("E")) {
                        d = "N";
                    } else if (d.equals("W")) {
                        d = "S";
                    } else if (d.equals("S")) {
                        d = "E";
                    } else if (d.equals("N")) {
                        d = "W";
                    }

                } else if (command.equals("R")) {

                    if (d.equals("E")) {
                        d = "S";
                    } else if (d.equals("W")) {
                        d = "N";
                    } else if (d.equals("S")) {
                        d = "W";
                    } else if (d.equals("N")) {
                        d = "E";
                    }

                }

                map[y][x] = idx;
                list.set(idx, new Node(y, x, d));
            }
        }

        bw.write("OK\n");
        br.close();
        bw.close();
    }
}
