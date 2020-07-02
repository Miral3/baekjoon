package Ex2741;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());

        for(int i = input-1; i >= 0; i--) {
            System.out.println(input - i);
        }
        br.close();
    }
}
