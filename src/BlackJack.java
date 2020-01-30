import java.util.Scanner;

public class BlackJack {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int arr[] = new int[N];

        for(int i = 0; i < arr.length; i++)
            arr[i] = scanner.nextInt();

        int sum = 0;
        int max = 0;

        for(int a = 0; a < N-2; a++){
            for(int b = a+1; b < N-1; b++){
                for(int c = b+1; c < N; c++){
                    sum = arr[a] + arr[b] + arr[c];
                    if(sum > M)
                        continue;
                    else if(max < sum)
                        max = sum;
                }
            }
        }
        System.out.println(max);

    }
}
