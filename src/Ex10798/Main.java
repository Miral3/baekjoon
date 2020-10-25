package Ex10798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] greenBoard = new String[5];
        for(int i = 0; i < 5; i++) {
            greenBoard[i] = br.readLine();
        }

        for(int i = 0; i < 15; i++) {
            for(int j = 0; j < 5; j++) {
                if(greenBoard[j].length() > i) {
                    System.out.print(greenBoard[j].charAt(i));
                }
            }
        }
    }
}
