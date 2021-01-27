package Ex13417;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCase; i++) {
            int size = Integer.parseInt(br.readLine());
            String input = br.readLine();
            input = input.replaceAll(" ","");
            char[] inputCh = input.toCharArray();
            String ans = inputCh[0] + "";

            for(int j = 1; j < size; j++) {
                char target = inputCh[j];
                if((int)ans.charAt(0) >= (int)target) {
                    ans = target + ans;
                }
                else {
                    ans = ans + target;
                }
            }
            System.out.println(ans);
        }
    }
}
