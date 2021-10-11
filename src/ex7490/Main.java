package ex7490;

/*
문제 이름: 0 만들기
알고리즘: 구현, 백트래킹
자료구조: regex, 배열 리스트, 문자열, 배열
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    static int n;
    static int[] arr;
    static String[] out;
    static String[] arithmetic = {" ", "+", "-"};
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0; i < testCase; i++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n];
            out = new String[n - 1];
            for(int j = 1; j <= n; j++) {
                arr[j-1] = j;
            }
            backTracking(0);
            bw.write("\n");
        }

        br.close();
        bw.close();
    }
    public static void backTracking(int depth) throws IOException{
        if(depth == n - 1) {
            String str = "";
            StringBuilder sb = new StringBuilder("1");

            for(int i = 1; i < n; i++) {
                sb.append(out[i - 1]);
                sb.append(arr[i]);
            }
            str = sb.toString();
            String delSpace = str.replaceAll(" ", "");
            List<String> numList = new ArrayList<>();
            List<String> arithmeticList= new ArrayList<>();

            Matcher matcher = Pattern.compile("\\d+").matcher(delSpace);
            while(matcher.find()) {
                numList.add(matcher.group());
            }
            matcher = Pattern.compile("\\D").matcher(delSpace);
            while(matcher.find()) {
                arithmeticList.add(matcher.group());
            }
            int sum = Integer.parseInt(numList.get(0));
            int idx = 1;
            for(int i = 0; i < arithmeticList.size(); i++) {
                if(!arithmeticList.get(i).equals("")) {
                    switch (arithmeticList.get(i)) {
                        case "+" :
                            sum += Integer.parseInt(numList.get(idx++));
                            break;
                        case "-" :
                            sum -= Integer.parseInt(numList.get(idx++));
                            break;
                    }
                }
            }

            if(sum == 0) {
                bw.write(str + "\n");
            }
            return;
        }
        for(int i = 0; i < 3; i++) {
            out[depth] = arithmetic[i];
            backTracking(depth + 1);
        }
    }
}
