package Ex2078;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int A = Integer.parseInt(input[0]);
        int B = Integer.parseInt(input[1]);
        int left = 0;
        int right = 0;
        while(!(A==1&&B==1)) {
            if(A > B) {
                A -= B;
                left++;
            }
            else {
                B -= A;
                right++;
            }
        }
        System.out.println(left + " " + right);
    }
}
