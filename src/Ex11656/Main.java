package Ex11656;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        int len = input.length();
        String[] arr = new String[len];
        
        for(int i = 0; i < len; i++) {
            arr[i] =  input.substring(i);
        }

        Arrays.sort(arr);

        for(int i = 0; i < len; i++) {
            System.out.println(arr[i]);
        }
    }
}
