package Ex9322;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCase; i++) {
            int size = Integer.parseInt(br.readLine());
            String[] firstPU = br.readLine().split(" ");
            String[] strSecPU = br.readLine().split(" ");
            ArrayList<String> secPU = new ArrayList<>(Arrays.asList(strSecPU));
            String[] cipherTxt = br.readLine().split(" ");

            for(int j = 0; j < size; j++) {
                System.out.print(cipherTxt[secPU.indexOf(firstPU[j])] + " ");
            }
            System.out.println();
        }
    }
}
