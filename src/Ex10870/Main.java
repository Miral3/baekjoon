package Ex10870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        System.out.println(Fibo(N));
    }
    public static int Fibo(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1 || n ==2) {
            return 1;
        }
        else {
            return Fibo(n-2) + Fibo(n-1);
        }
    }
}
