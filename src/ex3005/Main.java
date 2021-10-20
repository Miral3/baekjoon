package ex3005;

/*
문제 이름:
알고리즘:
자료구조:
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);

        String[][] map = new String[r][c];
        for(int i = 0; i < r; i++) {
            input = br.readLine().split("");
            for(int j = 0; j < c; j++) {
                map[i][j] = input[j];
            }
        }

        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < r; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < c; j++) {
                if(map[i][j].equals("#")) {
                    if(sb.length() > 1) {
                        list.add(sb.toString());
                    }
                    sb.setLength(0);
                } else {
                    sb.append(map[i][j]);
                }
            }
            if(sb.length() > 1) {
                list.add(sb.toString());
            }
        }

        for(int i = 0; i < c; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < r; j++) {
                if(map[j][i].equals("#")) {
                    if(sb.length() > 1) {
                        list.add(sb.toString());
                    }
                    sb.setLength(0);
                } else {
                    sb.append(map[j][i]);
                }
            }
            if(sb.length() > 1) {
                list.add(sb.toString());
            }
        }

        Collections.sort(list);
        bw.write(list.get(0) + "\n");
        br.close();
        bw.close();
    }
}
