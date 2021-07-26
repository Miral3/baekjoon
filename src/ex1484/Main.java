package ex1484;

/*
문제 이름: 다이어트
알고리즘: 두 포인터
자료구조: 
*/

import java.io.*;

public class Main {
    static final int MAX = 100001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int g = Integer.parseInt(br.readLine());

        twoPoint(g);

        br.close();
        bw.close();
    }

    public static void twoPoint(int g) {
        long start = 1;
        long end = 1;
        long diff = 0;
        boolean isExist = false;

        while(true) {
            diff = (long)(Math.pow(end, 2) - Math.pow(start, 2));

            if(diff == g) {
                isExist = true;
                System.out.println(end);
            }

            if(end - start == 1 && diff > g) {
                break;
            }

            if(diff > g) {
                start++;
            } else {
                end++;
            }

        }

        if(!isExist) {
            System.out.println(-1);
        }
    }
}
