package Ex8393;

        import java.io.*;
        import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());
        int testCase = input;

        for(int i = 0; i < testCase; i++) {
            input += i;
        }
        System.out.print(input);
        br.close();
    }
}
