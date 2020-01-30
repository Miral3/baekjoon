import java.util.Scanner;

public class Three {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int arr[] = new int[3];

        for(int i = 0; i < arr.length; i++)
            arr[i] = scan.nextInt();

        if(arr[0] < arr[1]){
            if(arr[1] < arr[2])
                System.out.println(arr[1]);
            else if(arr[0] < arr[2])
                System.out.println(arr[2]);
            else
                System.out.println(arr[0]);
        }
        else{
            if(arr[1] > arr[2])
                System.out.println(arr[1]);
            else if(arr[0] > arr[2])
                System.out.println(arr[2]);
            else
                System.out.println(arr[0]);
        }


    }
}
