import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SangSoo{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().trim().split(" ");
        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        int new_a = 0, new_b = 0;
        new_a = (a%10)*100 + ((a%100)/10)*10 + (a/100);
        new_b = (b%10)*100 + ((b%100)/10)*10 + (b/100);

        System.out.println((new_a>new_b)?new_a:new_b);
    }
}