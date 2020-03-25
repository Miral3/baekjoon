package Ex1958;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int lcs[][][] = new int[101][101][101];
        String[] str1 = br.readLine().split("");
        String[] str2 = br.readLine().split("");
        String[] str3 = br.readLine().split("");

        for (int k = 1; k < str3.length+1; k++) {
            for (int i = 1; i < str2.length+1; i++) {
                for (int j = 1; j < str1.length+1; j++) {
                    if (str1[j-1].equals(str2[i-1])&&str2[i-1].equals(str3[k-1])) {
                        lcs[k][i][j] = lcs[k - 1][i - 1][j - 1] + 1;
                    } else {
                        lcs[k][i][j]=Math.max(lcs[k][i-1][j], lcs[k][i][j-1]);
                        lcs[k][i][j]=Math.max(lcs[k][i][j], lcs[k-1][i][j]);
                    }
                }
            }
        }

        System.out.println(lcs[str3.length][str2.length][str1.length]);
    }
}
