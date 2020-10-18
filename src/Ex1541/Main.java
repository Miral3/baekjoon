package Ex1541;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split("-");
        String[] plus;
        int result = 0;

        for(int i = 0; i < input.length; i++) {
            int sum = 0;
            plus = input[i].split("\\+");
            for(int j = 0; j < plus.length; j++) {
                sum += Integer.parseInt((plus[j]));
            }
            if(i == 0) {
                result += sum;
                continue;
            }
            result -= sum;
        }
        System.out.println(result);
    }
}
