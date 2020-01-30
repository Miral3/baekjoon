import java.util.Scanner;

public class Hansoo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println(Han(N));
    }

    public static int Han(int n){
        int cnt = 0, units, tens, hunds;
        if(n > 0 && n < 1000)
            return n;
        else{
            for(int i = 100; i <= n; i++){
                hunds = i/100;
                tens = (i%100)/10;
                units = (i%100)%10;
                if((hunds - tens) == (tens - units))
                    cnt++;
            }
            return (99+cnt);
        }
    }
}