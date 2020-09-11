package Ex1373;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       String input = br.readLine();
       int len = input.length();

       if(len%3 == 1) {
           input = "00" + input;
       }
       else if(len%3 == 2) {
           input = "0" + input;
       }

       len = input.length();
       for(int i = len%3; i < len; i = i+3) {
           System.out.print(((input.charAt(i)-'0')*4) + ((input.charAt(i+1)-'0')*2) + ((input.charAt(i+2)-'0')*1));
       }
        System.out.println();
    }
}
