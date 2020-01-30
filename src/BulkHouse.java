import java.util.Scanner;

public class BulkHouse {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int min = 2;
        int max = 0;
        int N;
        int i = 0;

        N = scan.nextInt();

        while(true){
            if(N>=min && N<=max)
                break;
            else if(N == 1) {
                break;
            }
            min = min + (6*i);
            max = min + ((6*(i+1))-1);

            i++;
        }
        System.out.println(i+1);
    }
}
