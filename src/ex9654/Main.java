package ex9654;

/*
문제 이름: 나부 함대 데이터
알고리즘: 구현
자료구조:
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        bw.write("SHIP NAME      CLASS          DEPLOYMENT IN SERVICE\n"
            + "N2 Bomber      Heavy Fighter  Limited    21        \n"
            + "J-Type 327     Light Combat   Unlimited  1         \n"
            + "NX Cruiser     Medium Fighter Limited    18        \n"
            + "N1 Starfighter Medium Fighter Unlimited  25        \n"
            + "Royal Cruiser  Light Combat   Limited    4         \n");

        br.close();
        bw.close();
    }
}
