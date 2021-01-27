package Ex14490;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(":");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int div = (n < m) ? gcd(n, m) : gcd(m, n);

        System.out.println(n/div + ":" + m/div);
    }

    public static int gcd(int p, int q) {
        if(q == 0) {
            return p;
        }
        return gcd(q, p%q);
    }
}
