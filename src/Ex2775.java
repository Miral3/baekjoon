import java.io.*;
import java.util.*;

public class Ex2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int arr[][]= new int[15][15];

        for(int i = 0; i <= 14; i++) {
            for(int j = 0; j <= 14; j++){
                if(i == 0)
                    arr[0][j] = j+1;
                else {
                    if(j == 0)
                        arr[i][j] = 1;
                    else
                        arr[i][j] = arr[i][j-1] + arr[i-1][j];
                }
            }
        }

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(arr[k][n-1]);
        }


        br.close();
        bw.close();
    }
}