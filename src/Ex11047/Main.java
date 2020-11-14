package Ex11047;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int type = Integer.parseInt(input[0]);
        int sum = Integer.parseInt(input[1]);
        int[] coin = new int[type];
        int cnt = 0;

        for(int i = 0; i < type; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        for(int i = type-1; i >= 0; i--) {
            if(sum/coin[i] != 0) {
                cnt += sum/coin[i];
                sum = sum%coin[i];
            }
            if(sum == 0) {
                break;
            }
        }
        System.out.println(cnt);
    }
}
