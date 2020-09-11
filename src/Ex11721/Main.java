package Ex11721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int len = input.length();
        for(int i = 0; i < input.length()/10+1; i++) {
            if((i+1)*10 <input.length()) {
                System.out.println(input.substring(i*10, (i+1) * 10));
            }
            else {
                System.out.println(input.substring(i*10, len));
            }
        }
    }
}
