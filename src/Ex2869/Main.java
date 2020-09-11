package Ex2869;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int climb = Integer.parseInt(input[0]);
        int slide = Integer.parseInt(input[1]);
        int len = Integer.parseInt(input[2]);;
        int ans = (int)Math.ceil((double)(len-slide) / (double)(climb-slide));
        System.out.println(ans);
    }
}
