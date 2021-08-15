package ex1755;

/*
문제 이름: 숫자놀이
알고리즘: 문자열, 정렬
자료구조: 문자열, 배열
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

class Node implements Comparable<Node>{
    int num;
    String str1, str2;

    public Node(int num, String str1, String str2) {
        this.num = num;
        this.str1 = str1;
        this.str2 = str2;
    }

    @Override
    public int compareTo(Node o) {
        if(this.str1.compareTo(o.str1) < 0) {
            return -1;
        } else if(this.str1.compareTo(o.str1) > 0) {
            return 1;
        } else {
            if(this.str2.compareTo(o.str2) < 0) {
                return -1;
            } else if(this.str2.compareTo(o.str2) > 0) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);

        ArrayList<Node> list = new ArrayList<>();
        for(int i = m;  i <= n; i++) {

            if(i < 10) {
                list.add(new Node(i, transform(i), " "));
            } else {
                list.add(new Node(i, transform(i / 10), transform(i % 10) ));
            }
        }

        Collections.sort(list);

        int idx = 0;
        for(Node o : list) {
            bw.write(o.num + " ");

            if(idx % 10 == 9) {
                bw.write("\n");
            }

            idx++;
        }

        br.close();
        bw.close();
    }

    public static String transform (int num) {
        switch (num) {
            case 0 :
                return "zero";
            case 1 :
                return "one";
            case 2 :
                return "two";
            case 3 :
                return "three";
            case 4 :
                return "four";
            case 5 :
                return "five";
            case 6 :
                return "six";
            case 7 :
                return "seven";
            case 8 :
                return "eight";
            case 9 :
                return "nine";
        }
        return null;
    }
}
