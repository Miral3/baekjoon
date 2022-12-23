package ex5002;

/*
문제 이름: 도어맨
알고리즘: 구현
자료구조: 덱, 스택
*/

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Main {
    static int manNum;
    static int womenNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int x = Integer.parseInt(br.readLine());
        char[] input = br.readLine().toCharArray();

        manNum = 0;
        womenNum = 0;
        Stack<Character> club = new Stack<>();
        Deque<Character> line = new LinkedList<>();

        for (char s : input) {
            line.add(s);
        }

        while (!line.isEmpty()) {
            count(club.push(line.poll()), "plus");
            if (Math.abs(manNum - womenNum) > x) {
                char exile = club.pop();
                count(exile, "minus");
                if (line.isEmpty()) {
                    break;
                }
                count(club.push(line.poll()), "plus");
                if (Math.abs(manNum - womenNum) > x) {
                    club.pop();
                    break;
                }
                line.addFirst(exile);
            }
        }

        bw.write(club.size() + "\n");
        br.close();
        bw.close();
    }
    public static void count(char gender, String cal) {
        if (gender == 'M') {
            if (cal.equals("plus")) {
                manNum++;
            } else if (cal.equals("minus")){
                manNum--;
            }
        } else if (gender == 'W') {
            if (cal.equals("plus")) {
                womenNum++;
            } else if (cal.equals("minus")){
                womenNum--;
            }
        }
    }
}
