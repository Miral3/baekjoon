package ex11067;

/*
문제 이름: 모노톤길
알고리즘: 구현, 정렬
자료구조: 배열
*/

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[][] map1 = new int[n][2];
            int[][] map2 = new int[n][2];
            for(int i = 0; i < n; i++) {
                String[] input = br.readLine().split(" ");
                map1[i][0] = Integer.parseInt(input[0]);
                map1[i][1] = Integer.parseInt(input[1]);
                map2[i][0] = Integer.parseInt(input[0]);
                map2[i][1] = Integer.parseInt(input[1]);
            }

            Arrays.sort(map1, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0] == o2[0]) {
                        return o1[1] - o2[1];
                    } else {
                        return o1[0] - o2[0];
                    }
                }
            });
            Arrays.sort(map2, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[0] == o2[0]) {
                        return o2[1] - o1[1];
                    } else {
                        return o1[0] - o2[0];
                    }
                }
            });

            boolean isAscending = true;
            int beforeX = 0;
            int beforeY = 0;
            String[] coordinates = new String[n];
            coordinates[0] = "0 0";
            if(!(map1[0][0] == 0 && map1[0][1] == 0)) {
                isAscending = false;
            }
            for(int i = 1; i < n; i++) {
                if(isAscending) {
                    if(map1[i][0] == beforeX) {
                        coordinates[i] = map1[i][0] + " " + map1[i][1];
                        beforeX = map1[i][0];
                        beforeY = map1[i][1];
                    } else {
                        if(map1[i][1] != beforeY) {
                            coordinates[i] = map2[i][0] + " " + map2[i][1];
                            beforeX = map2[i][0];
                            beforeY = map2[i][1];
                            isAscending = false;
                        } else {
                            coordinates[i] = map1[i][0] + " " + map1[i][1];
                            beforeX = map1[i][0];
                            beforeY = map1[i][1];
                            isAscending = true;
                        }
                    }
                } else {
                    if(map2[i][0] == beforeX) {
                        coordinates[i] = map2[i][0] + " " + map2[i][1];
                        beforeX = map2[i][0];
                        beforeY = map2[i][1];
                    } else {
                        if(map2[i][1] != beforeY) {
                            coordinates[i] = map1[i][0] + " " + map1[i][1];
                            beforeX = map1[i][0];
                            beforeY = map1[i][1];
                            isAscending = true;

                        } else {
                            coordinates[i] = map2[i][0] + " " + map2[i][1];
                            beforeX = map2[i][0];
                            beforeY = map2[i][1];
                            isAscending = false;
                        }
                    }
                }
            }

            String[] input = br.readLine().split(" ");
            for(int i = 1; i <= Integer.parseInt(input[0]); i++) {
                bw.write(coordinates[Integer.parseInt(input[i]) - 1] + "\n");
            }
        }

        br.close();
        bw.close();
    }
}
