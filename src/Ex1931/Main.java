package Ex1931;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int[][] meetingRoom = new int[testCase][2];
        for(int i = 0;i < testCase; i++) {
            String[] input = br.readLine().split(" ");
            meetingRoom[i][0] = Integer.parseInt(input[0]);
            meetingRoom[i][1] = Integer.parseInt(input[1]);
        }
        Arrays.sort(meetingRoom, (o1, o2) -> {
            if(o1[1] == o2[1]) {
                return Integer.compare(o1[0], o2[0]);
            } else {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        int[][] use = new int[1][2];
        use[0][0] = meetingRoom[0][0];
        use[0][1] = meetingRoom[0][1];

        for(int i = 0; i < testCase; i++) {
            if(use[0][1] <= meetingRoom[i][0]) {

            }
        }
        System.out.println();
    }
}
