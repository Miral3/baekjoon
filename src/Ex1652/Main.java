package Ex1652;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int cnt = 0;
        int blankCount = 0;
        String[] condo = new String[size];

        for(int i = 0; i < size; i++) {
            condo[i] = br.readLine();
            for(int j = 0; j < size; j++) {
                if(condo[i].charAt(j) == '.') {
                    blankCount++;
                }
                else if(condo[i].charAt(j) == 'X') {
                    if(blankCount >= 2) {
                        cnt++;
                        blankCount = 0;
                    }
                    else {
                        blankCount = 0;
                    }
                }
                if(j == size-1) {
                    if(blankCount >= 2) {
                        cnt++;
                        blankCount = 0;
                    }
                    else {
                        blankCount = 0;
                    }
                }
            }
        }
        System.out.print(cnt + " ");

        cnt = 0;
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(condo[j].charAt(i) == '.') {
                    blankCount++;
                }
                else if(condo[j].charAt(i) == 'X') {
                    if(blankCount >= 2) {
                        cnt++;
                        blankCount = 0;
                    }
                    else {
                        blankCount = 0;
                    }
                }
                if(j == size-1) {
                    if(blankCount >= 2) {
                        cnt++;
                        blankCount = 0;
                    }
                    else {
                        blankCount = 0;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}