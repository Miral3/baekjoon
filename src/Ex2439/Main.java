package Ex2439;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        char star = '*';

        for (int i = 0; i < input; i++) {
            for (int j = input-1; j > i; j--) {
                System.out.print(" ");
            }
            for (int k = 0; k < i+1; k++) {
                System.out.print(star);
            }
            System.out.println();
        }
    }
}
