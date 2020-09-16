package Ex2947;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] wood = new int[5];
        int[] sort = {1, 2, 3, 4, 5};
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i < 5; i ++) {
            wood[i] = sc.nextInt();
        }
        while(true) {
           if(wood[0] > wood[1]) {
               swap(0,1,wood);
               if(Arrays.equals(wood, sort)) {
                   print(wood);
                   break;
               }
               else{
                   print(wood);
               }
           }

            if(wood[1] > wood[2]) {
                swap(1,2,wood);
                if(Arrays.equals(wood, sort)) {
                    print(wood);
                    break;
                }
                else{
                    print(wood);
                }
            }

            if(wood[2] > wood[3]) {
                swap(2,3,wood);
                if(Arrays.equals(wood, sort)) {
                    print(wood);
                    break;
                }
                else{
                    print(wood);
                }
            }
            if(wood[3] > wood[4]) {
                swap(3,4,wood);
                if(Arrays.equals(wood, sort)) {
                    print(wood);
                    break;
                }
                else{
                    print(wood);
                }
            }
        }

    }
    public static void swap(int x, int y, int[] arr) {
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    public static void print(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
