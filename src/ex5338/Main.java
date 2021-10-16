package ex5338;

/*
문제 이름: 마이크로소프트 로고
알고리즘: 구현
자료구조:
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write("       _.-;;-._\n"
            + "'-..-'|   ||   |\n"
            + "'-..-'|_.-;;-._|\n"
            + "'-..-'|   ||   |\n"
            + "'-..-'|_.-''-._|");
        br.close();
        bw.close();
    }
}
