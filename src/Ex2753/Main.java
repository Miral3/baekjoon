package Ex2753;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int input = Integer.parseInt(br.readLine());
        if (input >= 1 && input <= 4000) {
            if (input % 4 == 0 && input % 100 != 0 || input % 400 == 0)
                bw.write("1\n");
            else
                bw.write("0\n");
        } else
            bw.write("1에서 4000사이의 연도를 입력하세요.");
        bw.flush();
        br.close();
        bw.close();
    }
}
