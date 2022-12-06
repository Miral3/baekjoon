package ex3568;

/*
문제 이름: iSharp
알고리즘: 문자열, 파싱
자료구조: 문자열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        for (int i = 1; i < input.length; i++) {
            String str = input[i];
            str = str.replaceAll(",|;", "");
            String engRegex = "[a-zA-Z]*";
            String remainRegex = "\\W*";
            String var = str.replaceAll(remainRegex, "");
            String remain = str.replaceAll(engRegex, "");
            StringBuilder reverse = new StringBuilder();
            reverse.append(remain).reverse();

            String reverseStr = reverse.toString().replaceAll("]\\[", "[]");

            String result = input[0] + reverseStr + " " + var + ";";
            bw.write(result + "\n");
        }

        br.close();
        bw.close();
    }
}
