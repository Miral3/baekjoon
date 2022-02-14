package ex2641;

/*
문제 이름: 다각형그리기
알고리즘: 구현
자료구조: 베열 리스트
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

class Node implements Comparable<Node> {
    int y;
    int x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }

    @Override
    public int compareTo(Node o) {
        if (y - o.y > 0) {
            return 1;
        } else if (y - o.y < 0) {
            return -1;
        } else {
            return x - o.x;
        }
    }
}

public class Main {
    static int[] dy = {0, 0, -1, 0, 1};
    static int[] dx = {0, 1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Node> list = new ArrayList<>();

        String[] input = br.readLine().split(" ");
        int y = 0;
        int x = 0;
        for (int i = 0; i < n; i++) {
            int dir = Integer.parseInt(input[i]);
            y += dy[dir];
            x += dx[dir];

            list.add(new Node(y, x));
        }

        Collections.sort(list);

        int m = Integer.parseInt(br.readLine());
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            y = 0;
            x = 0;
            ArrayList<Node> temp = new ArrayList<>();
            String input2 = br.readLine();
            String[] arr = input2.split(" ");

            for (int j = 0; j < n; j++) {
                int dir = Integer.parseInt(arr[j]);
                y += dy[dir];
                x += dx[dir];

                temp.add(new Node(y, x));
            }

            Collections.sort(temp);

            boolean isSame = true;
            int difY = list.get(0).y - temp.get(0).y;
            int difX = list.get(0).x - temp.get(0).x;

            for (int j = 1; j < n; j++) {
                if (temp.get(j).y + difY == list.get(j).y &&
                    temp.get(j).x + difX == list.get(j).x) {
                    continue;
                }

                isSame = false;
                break;
            }

            if (isSame) {
                cnt++;
                sb.append(input2 + "\n");
            }
        }

        bw.write(cnt + "\n" + sb.toString());
        br.close();
        bw.close();
    }
}
