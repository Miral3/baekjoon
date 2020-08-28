package Ex14681;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int xLocation = Integer.parseInt(br.readLine());
        int yLocation = Integer.parseInt(br.readLine());

        if(xLocation > 0) {
            if(yLocation > 0) {
                System.out.println(1);
            }
            else {
                System.out.println(4);
            }
        }
        else {
            if(yLocation > 0) {
                System.out.println(2);
            }
            else {
                System.out.println(3);
            }
        }
    }
}
