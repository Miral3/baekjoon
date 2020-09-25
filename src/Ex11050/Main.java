package Ex11050;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        int result = (factorial(N) / (factorial(N-K) * factorial(K)));
        System.out.println(result);
    }
    public static int factorial(int n) {
        if(n == 0) {
            return 1;
        }
        if(n == 1) {
            return n;
        }
        else {
            return n * factorial(n-1);
        }
    }
}
