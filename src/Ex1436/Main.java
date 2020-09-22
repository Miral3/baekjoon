package Ex1436;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        String[] shom = new String[10000];

        int idx = 0;
        int i = 666;
        while(idx < input) {
           String to = Integer.toString(i);
           if(to.contains("666")) {
               shom[idx++] = to;
           }
           i++;
        }

        System.out.println(shom[input-1]);
    }
}
