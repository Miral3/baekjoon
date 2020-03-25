package Ex9252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

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
        Stack<String> st = new Stack<>();
        int i = str2.length;
        int j = str1.length;

        while(lcs[i][j] != 0){
            if(lcs[i][j] == lcs[i][j-1])
                j--;
            else if(lcs[i][j] == lcs[i-1][j])
                i--;
            else if(lcs[i][j] -1 == lcs[i-1][j-1])
            {
                st.push(str1[j-1]);
                i--;
                j--;
            }
        }
        System.out.println(lcs[str2.length][str1.length]);

        while (!st.isEmpty())
            System.out.print(st.pop());
    }
}

