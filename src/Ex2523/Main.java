package Ex2523;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        for(int i = 0; i < input*2-1; i++) {
            if(i < input) {
                for (int j = 0; j < i + 1; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
            else {
                for(int j = i; j < input*2-1; j++) {
                    System.out.print("*");
                }
                System.out.println();
            }
        }
    }
}
