package Ex5543;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] hamburger;
        int[] drink;
        int sum;

        hamburger = new int[3];
        for(int i = 0; i < 3; i++) {
            hamburger[i] = Integer.parseInt(br.readLine());
        }
        drink = new int[2];
        for(int i = 0; i < 2; i++) {
            drink[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(hamburger);
        Arrays.sort(drink);

        sum = hamburger[0] + drink[0];

        System.out.println(sum - 50);
    }
}
