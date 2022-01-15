package ex8911;

/*
문제 이름: 거북이
알고리즘: 구현, 시뮬레이션
자료구조: 문자열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] input = br.readLine().split("");
            int n = input.length;

            int y = 0;
            int x = 0;
            int minY = 0;
            int maxY = 0;
            int minX = 0;
            int maxX = 0;
            int dir = 0;
            for (int i = 0; i < n; i++) {
                String cur = input[i];

                switch (cur) {
                    case "F": {
                        if (dir == 0) {
                            y++;
                        } else if (dir == 90) {
                            x++;
                        } else if (dir == 180) {
                            y--;
                        } else if (dir == 270) {
                            x--;
                        }
                        break;
                    }
                    case "B": {
                        if (dir == 0) {
                            y--;
                        } else if (dir == 90) {
                            x--;
                        } else if (dir == 180) {
                            y++;
                        } else if (dir == 270) {
                            x++;
                        }
                        break;
                    }
                    case "L": {
                        dir -= 90;
                        break;
                    }
                    case "R": {
                        dir += 90;
                        break;
                    }
                }

                if (dir < 0) {
                    dir += 360;
                } else if (dir >= 360) {
                    dir %= 360;
                }

                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);
                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
            }

            int result = (maxX - minX) * (maxY - minY);
            bw.write(result + "\n");
        }

        br.close();
        bw.close();
    }
}
