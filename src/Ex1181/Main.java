package Ex1181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        String[] arr = new String[testCase];

        for(int i = 0; i < testCase; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });
        int j;
        for(int i = 0; i < testCase; i++) {
            for(j = i+1; j < testCase; j++) {
                if(arr[i].length() != arr[j].length()) {
                    break;
                }
            }
            Arrays.sort(arr,i,j);
            i = j-1;
        }

        System.out.println(arr[0]);
        for(int i = 1; i < testCase; i++) {
            if(arr[i-1].equals(arr[i])) {
                continue;
            }
            System.out.println(arr[i]);
        }
    }
}
