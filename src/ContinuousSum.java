import java.util.Vector;
import java.util.Scanner;

public class ContinuousSum {
    public static void main(String[] args){
        Vector<Integer> v = new Vector<Integer>();
        Scanner scan = new Scanner(System.in);
        int n;
        int m;
        int max1 = 0, max2 = 0;

        n = scan.nextInt();

        for(int i = 0; i < n; i++){
            m = scan.nextInt();
            v.add(m);
        }
        for(int i = 0; i < v.size(); i++){
            int k = v.get(i);
            if(max1 < k) {
                max1 = k;
                v.remove(i);
            }
        }
        for(int i = 0; i < v.size(); i++){
            int k = v.get(i);
            if(max2 < k) {
                max2 = k;
                v.remove(i);
            }
        }

        System.out.println(max1 + max2);

    }
}
