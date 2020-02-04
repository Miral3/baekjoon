package Ex1904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int length = Integer.parseInt(br.readLine());
        int count[] = new int[length+1];

        count[0] = 1;
        count[1] = 2;

        for(int i = 2; i < count.length; i++)
            count[i] = (count[i-2] + count[i-1]) % 15746;

        System.out.print(count[(length-1)]);
    }
}
