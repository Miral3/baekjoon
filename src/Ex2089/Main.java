package Ex2089;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String ans = "";

        if(N == 0) {
            System.out.println("0");
            return;
        }

        while(N != 0) {
            if(N%(-2) == 1 || N%(-2) == 0) {
                ans = N%(-2) + ans;
                N /= (-2);
            }
            else {
                ans = "1" + ans;
                N = (N/(-2)) + 1;
            }
        }

        System.out.println(ans);
    }
}
