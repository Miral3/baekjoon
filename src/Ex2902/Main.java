package Ex2902;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split("-");

        for(int i = 0; i < input.length; i++) {
            System.out.print(input[i].charAt(0));
        }
    }
}
