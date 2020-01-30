import java.util.Scanner; //2675

public class StringIteration {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int r = 0;
        String s;

        for(int i = 0; i < t; i++){
            r = sc.nextInt();
            s = sc.next();
            for(int j = 0; j < s.length(); j++){
                for(int k = 0; k < r; k++){
                    System.out.print(s.charAt(j));
                }
            }
            System.out.println("");
        }


    }
}
