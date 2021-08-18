package ex17293;

/*
문제 이름: 맥주 99병
알고리즘: 구현
자료구조: 문자열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        for(int i = n; i >= 0; i--) {
            if(i > 0) {
                if(i == 1) {
                    bw.write("1 bottle of beer on the wall, 1 bottle of beer.\n");
                    bw.write("Take one down and pass it around, no more bottles of beer on the wall.\n\n");
                } else if(i == 2) {
                    bw.write("2 bottles of beer on the wall, 2 bottles of beer.\n");
                    bw.write("Take one down and pass it around, 1 bottle of beer on the wall.\n\n");
                } else {
                    bw.write(i + " bottles of beer on the wall, " + i + " bottles of beer.\n");
                    bw.write("Take one down and pass it around, " + (i-1) + " bottles of beer on the wall.\n\n");
                }
            } else {
                bw.write("No more bottles of beer on the wall, no more bottles of beer.\n");

                if(n == 1) {
                    bw.write("Go to the store and buy some more, " + n + " bottle of beer on the wall.");
                } else {
                    bw.write("Go to the store and buy some more, " + n
                        + " bottles of beer on the wall.");
                }
            }
        }

        br.close();
        bw.close();
    }
}
