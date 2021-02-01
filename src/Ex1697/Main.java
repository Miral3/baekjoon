package Ex1697;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    static int max = 100001;
    static boolean[] isVisted = new boolean[max];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int cnt = 0;
        LinkedList<Integer> que = new LinkedList<>();

        que.add(N);
        isVisted[N] = true;
        while(!que.isEmpty()) {
            int size = que.size();
            for(int i = 0; i < size; i++) {
                int rm = que.remove();
                if (rm - 1 >= 0 && !isVisted[rm - 1]) {
                    que.add(rm - 1);
                    isVisted[rm - 1] = true;
                }
                if (rm + 1 < max && !isVisted[rm + 1]) {
                    que.add(rm + 1);
                    isVisted[rm + 1] = true;
                }
                if (rm * 2 < max && !isVisted[rm * 2]) {
                    que.add(rm * 2);
                    isVisted[rm * 2] = true;
                }
                if(rm == K) {
                    System.out.println(cnt);
                    break;
                }
            }
            cnt++;
        }
    }
}
