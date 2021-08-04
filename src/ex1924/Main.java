package ex1924;

/*
문제 이름: 2007
알고리즘: 구현
자료구조: 배열
*/

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        int[] month = new int[13];

        month[1] = 1;

        for(int i = 2; i <= 12; i++) {
            int days = 0;
            if(i == 5 || i == 7 || i == 10 || i == 12) {
                days += 30;
            } else if(i == 3) {
                days += 28;
            }
            else {
                days += 31;
            }

            days += month[i - 1];
            month[i] = days % 7;
        }

        int week = (month[x] + y - 1) % 7;
        switch (week) {
            case 0 :
                bw.write("SUN\n");
                break;
            case 1 :
                bw.write("MON\n");
                break;
            case 2 :
                bw.write("TUE\n");
                break;
            case 3 :
                bw.write("WED\n");
                break;
            case 4 :
                bw.write("THU\n");
                break;
            case 5 :
                bw.write("FRI\n");
                break;
            case 6 :
                bw.write("SAT\n");
                break;
        }

        br.close();
        bw.close();
    }
}
