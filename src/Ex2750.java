import java.io.*;
import java.util.*;

public class Ex2750 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];

        for(int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(br.readLine());

        insertion_sort(arr, N);

        for(int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);
    }


    public static void insertion_sort(int list[], int n){
        int key = 0;
        int tmp = 0;
        int i = 0, j = 0;

        for(i = 1; i < n; i++){
            key = list[i];
            for(j = i-1; j >=0 && list[j]>key; j--){
                    list[j+1] = list[j];
                }
                list[j+1] = key;
        }
    }
}