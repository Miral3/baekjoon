package ex9653;

/*
문제 이름: 스타워즈 로고
알고리즘: 구현
자료구조:
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write("    8888888888  888    88888\n"
            + "   88     88   88 88   88  88\n"
            + "    8888  88  88   88  88888\n"
            + "       88 88 888888888 88   88\n"
            + "88888888  88 88     88 88    888888\n"
            + "\n"
            + "88  88  88   888    88888    888888\n"
            + "88  88  88  88 88   88  88  88\n"
            + "88 8888 88 88   88  88888    8888\n"
            + " 888  888 888888888 88  88      88\n"
            + "  88  88  88     88 88   88888888");

        br.close();
        bw.close();
    }
}
