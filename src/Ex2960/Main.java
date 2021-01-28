package Ex2960;

import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        LinkedList<Integer> list = new LinkedList<>();

        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int cnt = 0;
        int rm = 0;

        for(int i = 2; i <= N; i++) {
            list.add(i);
        }

        while(!list.isEmpty()) {
            int target = list.get(0);
            if(isPrime(target)) {
                rm = list.removeFirst();
                cnt++;
            }
            if(cnt == K) {
                System.out.println(rm);
                break;
            }
            int j = 2;
            while (true){
                if(list.contains(target*j)) {
                    list.remove((Integer)(target*j));
                    cnt++;
                }
                if(cnt == K) {
                    System.out.println(target*j);
                    return;
                }
                if(target * j > list.getLast()){
                    break;
                }
                j++;
            }
        }

    }
    public static boolean isPrime(int n) {
        for(int i = 2; i  <= n; i++) {
            if(n % i == 0) {
                return true;
            }
        }
        return false;
    }
}
