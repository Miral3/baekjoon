package Ex1110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int cnt;
        int sum;
        String origin;

        if(Integer.parseInt(input) < 10) {
            input = "0" + input;
        }

        origin = input;
        cnt = 0;
        while(true) {
             sum = Integer.parseInt(input.charAt(0)+"") + Integer.parseInt(input.charAt(1)+"");
             input =  input.charAt(1) + "" + sum%10;
             cnt++;
             if(input.equals(origin)) {
                 break;
             }
        }
        System.out.println(cnt);
    }
}
