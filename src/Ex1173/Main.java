package Ex1173;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 0; // 운동
        int m = 0; // 처음 맥박
        int M = 0; // 최대 맥박
        int T = 0; // 증가 맥박
        int R = 0; // 휴식 맥박
        int c = 0; // 현재 맥박
        int cnt = 0; // 현재 맥박
        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        M = Integer.parseInt(input[2]);
        T = Integer.parseInt(input[3]);
        R = Integer.parseInt(input[4]);
        c = m;
        while(N > 0) {
            if(c + T <= M) {
                c +=  T;
                N--;
                cnt++;
            }
            else if(c-R >= m) {
                c -= R;
                cnt++;
            }
            else if(c-R <= m && cnt != 0) {
                c = m;
                cnt++;
            }
            else {
                System.out.println("-1");
                return;
            }
        }
        System.out.println(cnt);
    }
}
