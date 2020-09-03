package Ex10996;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        if(input == 1) {
            sb.append("*");
            System.out.println(sb);
            return;
        }

        for(int i = 0; i < input*2; i++) {
            if(i%2 != 0) {
                for(int j = 0; j < input/2; j++) {
                    sb.append(" *");
                }
            }
            else {
                for(int k = 0; k < (input+1)/2; k++) {
                    sb.append("* ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
