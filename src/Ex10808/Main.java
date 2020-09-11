package Ex10808;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int[] cnt = new int[26];

        for(int i = 0; i < input.length(); i++) {
            int trans = input.charAt(i);
            cnt[trans-97]++;
        }
        for(int i = 0; i < cnt.length; i++) {
            System.out.print(cnt[i]+" ");
        }
    }
}
