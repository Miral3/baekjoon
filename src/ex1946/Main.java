package ex1946;

/*
문제 이름: 신입 사원
알고리즘: 그리디, 정렬
자료구조: 배열 리스트
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

class Score implements Comparable<Score> {
    int documentN;
    int interviewN;

    public Score(int documentN, int interviewN) {
        this.documentN = documentN;
        this.interviewN = interviewN;
    }

    @Override
    public int compareTo(Score o) {
        return documentN - o.documentN;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());
        for(int i = 0 ; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            ArrayList<Score> list = new ArrayList<>();
            for(int j = 0; j < n; j++) {
                String[] input = br.readLine().split(" ");
                int documentScore = Integer.parseInt(input[0]);
                int interviewScore = Integer.parseInt(input[1]);
                list.add(new Score(documentScore, interviewScore));
            }

            Collections.sort(list);

            int cnt = 1;
            int min = list.get(0).interviewN;
            for(int j = 1; j < list.size(); j++) {
                if(list.get(j).interviewN < min) {
                    cnt++;
                    min = list.get(j).interviewN;
                }
            }

            bw.write(cnt + "\n");
        }

        br.close();
        bw.close();
    }

}
