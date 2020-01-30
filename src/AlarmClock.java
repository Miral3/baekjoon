import java.util.Scanner;

public class AlarmClock {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int H = scan.nextInt();
        int M = scan.nextInt();

        if(M - 45 < 0) {
            H = H - 1;
            M = 15 + M;
        }
        else
            M = M - 45;
        if(H < 0 )
            H = 23;

        System.out.println(H+" "+M);
    }
}
