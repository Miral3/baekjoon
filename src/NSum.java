import java.util.Scanner;

public class NSum { //15596
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int arr[] = new int[N];

        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        System.out.println(sum(arr));

    }
    public static long sum(int[] a){
        int Sum = 0;

        for(int i = 0; i < a.length; i++)
            Sum += a[i];

        return Sum;
    }
}

