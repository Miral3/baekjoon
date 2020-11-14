package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        int[] arr = new int[testCase];
        String[] arrStr = br.readLine().split(" ");

        for(int i = 0; i < testCase; i++){
            arr[i] = Integer.parseInt(arrStr[i]);
        }

//        bubbleSort(arr, testCase);
//        selectionSort(arr, testCase);
        insertionSort(arr, testCase);

        for(int i = 0; i < testCase; i++){
            System.out.print(arr[i] + " ");
        }
    }

    public static void swap(int[] arr, int A, int B){
        int temp = arr[A];
        arr[A] = arr[B];
        arr[B] = temp;
    }

    public static void bubbleSort(int[] arr, int testCase){
        for(int i = testCase-1; i >= 0; i--){
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[j+1]){
                    swap(arr, j, j+1);
                }
            }
        }
    }

    public static void selectionSort(int[] arr, int testCase){
        for(int i = 0; i < testCase-1; i++){
            int min = arr[i];
            for(int j = i + 1; j < testCase; j++){
                if(min > arr[j]){
                    min = arr[j];
                }
            }
            if(min != arr[i]){
                swap(arr, min, arr[i]);
            }
        }
    }

    public static void insertionSort(int[] arr, int testCase){
        for(int i = 1; i < testCase; i++){
            int key = i;
            for(int j = i-1; j >= 0; j--){
                if(arr[key] < arr[j]){
                    swap(arr, key, j);
                }
                key--;
            }
        }
    }
}
