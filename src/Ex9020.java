import java.awt.*;
import java.io.*;
import java.util.*;

public class Ex9020 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int arr[] = new int[10000];
        int length = arr.length-1;

        for(int i = 0; i <= length; i++)
            arr[i] = 0;
        arr[1] = 1;

        for(int i = 2; i <= length; i++) {
            for (int j = 2; i * j <= length; j++)
                arr[i * j] = 1;
        }

        int T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T; i++){
            int n = Integer.parseInt(br.readLine());
            for(int j = n/2; j > 0; j--){
                int min = j;
                int max = n-j;
                if(CheckDemical(arr, min) && CheckDemical(arr,max)){
                    System.out.println(min + " "+ max);
                    break;
                }
            }
        }

    }

    public static boolean CheckDemical(int arr[], int x){
        boolean result = true;
        for(int i = 0; i < arr.length; i++){
            if(arr[x] != 1)
                break;
            else
                result = false;
        }
        return result;
    }
}