package Ex9251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int lcs[][] = new int[1001][1001];
        String[] str1 = br.readLine().split("");
        String[] str2 = br.readLine().split("");

        for(int i = 0; i <= str2.length; i++){
            for(int j = 0; j <= str1.length; j++){
                if(i == 0 || j == 0){
                    lcs[i][j] = 0;
                }
                else{
                   if(str2[i-1].equals(str1[j-1])){
                       lcs[i][j] = lcs[i-1][j-1]+1;
                   }
                   else{
                       lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                   }
                }
            }
        }
        System.out.print(lcs[str2.length][str1.length]);
    }
}
