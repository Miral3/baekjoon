package Ex10871;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int arrSize = sc.nextInt();
        int compare = sc.nextInt();
        int[] arr = new int[arrSize];

        for(int i = 0; i < arrSize; i++) {
            arr[i] = sc.nextInt();
            }

        for(int i = 0; i < arrSize; i++) {
            if (arr[i] < compare) {
                System.out.print(arr[i] + " ");
            }
        }
    }
}
