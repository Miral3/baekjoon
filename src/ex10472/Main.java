package ex10472;

/*
문제 이름: 십자뒤집기
알고리즘: bfs
자료구조: 배열, 해시 셋
*/

import java.io.*;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int[][] d = {
        {0, 1, 3}, {0, 1, 2, 4}, {1, 2, 5},
        {0, 3, 4, 6}, {1, 3, 4, 5, 7}, {2, 4, 5, 8},
        {3, 6, 7}, {4, 6, 7, 8}, {5, 7, 8}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        while(testCase-- > 0) {
            String board = "";

            for (int i = 0; i < 3; i++) {
                char[] input = br.readLine().toCharArray();
                for (int j = 0; j < 3; j++) {
                    if (input[j] == '*') {
                        board += "1";
                    } else {
                        board += "0";
                    }
                }
            }

            bw.write(bfs(board) + "\n");
        }

        br.close();
        bw.close();
    }

    public static int bfs(String startBoard) {
        Queue<String> que = new LinkedList<>();
        que.add(startBoard);
        HashSet<String> set = new HashSet<>();
        int cnt = 0;

        while (!que.isEmpty()) {
            int size = que.size();

            while (size-- > 0) {
                String board = que.poll();

                if (board.equals("000000000")) {
                    return cnt;
                }

                for (int i = 0; i < 9; i++) {
                    char[] arr = board.toCharArray();
                    for (int j = 0; j < d[i].length; j++) {
                        if (arr[d[i][j]] == '1') {
                            arr[d[i][j]] = '0';
                        } else {
                            arr[d[i][j]] = '1';
                        }
                    }

                    String convert = String.valueOf(arr);
                    if (!set.contains(convert)) {
                        que.add(convert);
                        set.add(convert);
                    }
                }
            }
            cnt++;
        }
        return 0;
    }
}
