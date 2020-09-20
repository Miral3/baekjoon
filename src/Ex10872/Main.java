package Ex10872;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        System.out.println(factorial(N));
    }
    public static int factorial(int n) {
        if(n == 0) {
            return 1;
        }
        if(n < 2) {
            return n;
        }
        else {
            return n * factorial(n-1);
        }
    }
}
