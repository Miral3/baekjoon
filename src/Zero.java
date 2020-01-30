import java.util.*;

public class Zero {
    public static void main(String[] args){
        int k, n;
        int sum = 0;

        Vector<Integer> v = new Vector<>();
        Scanner scan = new Scanner(System.in);
        k = scan.nextInt();


        for(int i = 0; i < k; i++){
            n = scan.nextInt();
            if(n > 0)
                v.add(n);
            else if(n == 0)
                v.remove(v.size()-1);
        }
        for(int i = 0; i < v.size(); i++) {
            sum += v.get(i);
        }
        System.out.println(sum);
    }
}
