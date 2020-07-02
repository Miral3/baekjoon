package Ex2438;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        char star = '*';

        for(int i = 0; i < input; i++) {
            System.out.print(star);
            for(int j = 0; j < i; j++){
                System.out.print(star);
            }
            System.out.println();
        }
    }
}
