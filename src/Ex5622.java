import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ex5622 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int sum = 0;
        for(int i = 0; i < line.length(); i++){
            if('P'<=line.charAt(i) && line.charAt(i) <='S')
                sum += 8;
            else if ('T' <= line.charAt(i) && line.charAt(i) <= 'V')
                sum += 9;
            else if ('W'<=line.charAt(i) && line.charAt(i) <= 'Z')
                sum += 10;
            else
                sum += (line.charAt(i) - 'A')/3 + 3;
        }
        System.out.print(sum);
    }
}
