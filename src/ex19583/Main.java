package ex19583;

/*
문제 이름: 싸이버개강총회
알고리즘: 문자열, 해시 셋
자료구조: 문자열, 해시 셋
*/

import java.io.*;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        String[] s = input[0].split(":");
        int startTime = Integer.parseInt(s[0]) * 60 + Integer.parseInt(s[1]);
        String[] e = input[1].split(":");
        int endTime = Integer.parseInt(e[0]) * 60 + Integer.parseInt(e[1]);
        String[] q = input[2].split(":");
        int quitTime = Integer.parseInt(q[0]) * 60 + Integer.parseInt(q[1]);

        String input2;
        HashSet<String> enterance = new HashSet<>();
        HashSet<String> exit = new HashSet<>();
        while ((input2 = br.readLine()) != null) {
            String[] arr = input2.split(" ");
            String[] t = arr[0].split(":");
            int time = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
            String nickName = arr[1];

            if(time <= startTime) {
                enterance.add(nickName);
            } else if(time >= endTime && time <= quitTime) {
                if(enterance.contains(nickName) && !exit.contains(nickName)) {
                    exit.add(nickName);
                }
            }
        }

        bw.write(exit.size() + "\n");
        br.close();
        bw.close();
    }

}
