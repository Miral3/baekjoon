package Ex2446;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < input*2-1; i++) {
            if(i < input) {
                for (int x = 0; x < i; x++) {
                    sb.append(" ");
                }
                for (int j = (input * 2 - 1) - 2 * i; j > 0; j--) {
                    sb.append("*");
                }
                sb.append("\n");
            }
            else {
                for (int x = i+1; x < input*2-1; x++) {
                    sb.append(" ");
                }
                for (int j = 0; j < 2*(i-input+1)+1; j++) {
                    sb.append("*");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}
