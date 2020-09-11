package Ex10250;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int idx = 0;
        int x = 0;
        int y = 0;
        String[] input;

        for(int i = 1; i < testCase+1; i++) {
            int ans = 0;
            input = br.readLine().split(" ");
            x = Integer.parseInt(input[0]);
            y = Integer.parseInt(input[1]);
            idx = Integer.parseInt(input[2]);

            if(idx%x == 0) {
                ans = x*100 + (idx/x);
            }
            else{
                ans = (idx%x)*100 + (idx/x)+1;
            }
            System.out.println(ans);
        }
    }
}
