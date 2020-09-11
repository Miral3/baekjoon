package Ex1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int cnt = 0;
        boolean cntCheck = false;

        for(int i = 0; i < testCase; i++) {
            String input = br.readLine();
            boolean[] check = new boolean[26];
            for(int j = 0;j < input.length(); j++) {
                int trans = input.charAt(j);

                if(j > 0 && check[trans-97] && input.charAt(j) != input.charAt(j-1)) {
                    cntCheck = true;
                    break;
                }
                check[trans-97] = true;
            }
            if(!cntCheck) {
                cnt++;
            }
            cntCheck = false;
        }
        System.out.println(cnt);
    }
}
