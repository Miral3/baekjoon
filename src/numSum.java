import java.util.Scanner; //11720
public class numSum {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String line = sc.next();
        int sum = 0;

        for(int i = 0; i < n; i++)
        {
            sum += line.charAt(i) - '0';
        }

        System.out.println(sum);
    }
}


