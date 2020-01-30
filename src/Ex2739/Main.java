package Ex2739;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());

        for(int i = 1; i <=9; i++){
            bw.write(input + " * " + i + " = " + (input*i) + "\n");
        }

        bw.flush();
        br.close();
        bw.close();
    }
}
