package Ex2577;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int multiply = A * B * C;
        int[] cnt = new int[10];
        int idx = 0;

        for(int i = 0; i < cnt.length; i++) {
            if(multiply == 0) {
                break;
            }
            idx = multiply % 10;
            multiply /= 10;
            cnt[idx]++;
        }

        for(int i = 0; i < cnt.length; i++) {
            System.out.println(cnt[i]);
        }
    }
}
