package Ex10952;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input;
        int A, B;

        while(true) {
            input = br.readLine().split(" ");
            A = Integer.parseInt(input[0]);
            B = Integer.parseInt(input[1]);
            if(A == 0 && B == 0) {
                break;
            }
            System.out.println(A + B);
        }
    }
}
