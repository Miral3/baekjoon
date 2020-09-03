package Ex3052;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] remain = new int[42];
        int cnt = 0;

        for(int i = 0; i < 10; i++) {
            int input = Integer.parseInt(br.readLine());
            int idx = input % 42;
            remain[idx]++;
        }

        for(int i = 0; i < 42; i++) {
            if(remain[i] != 0) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
