package Ex4673;

public class Main {
    static boolean[] num = new boolean[10001];
    public static void main(String[] args) {
        for(int i = 0; i < 10000; i++) {
            int idx = selfNum(i);
            if(idx <= 10000) {
                num[idx] = true;
            }
        }
        for(int i = 0; i < 10000; i++) {
            if(!num[i]) {
                System.out.println(i);
            }
        }
    }

    public static int selfNum(int n) {
        int sum = n;
        while(true) {
            if(n == 0) {
                break;
            }
            sum += n%10;
            n = n/10;
        }
        return sum;
    }
}
