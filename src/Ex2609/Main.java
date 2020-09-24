package Ex2609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        int result = 0;

        if(x > y) {
            result = GCD(x,y);
            System.out.println(result);
            System.out.println(x*y/result);
        }
        else {
            result = GCD(y,x);
            System.out.println(result);
            System.out.println(y*x/result);
        }
    }
    public static int GCD(int x, int y) {
        int n = 0;
        while(x % y != 0) {
            n = x%y;
            x =  y;
            y = n;
        }
        return y;
    }
}
