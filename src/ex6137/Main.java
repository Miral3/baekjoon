package ex6137;

/*
문제 이름:
알고리즘:
자료구조:
*/

import java.io.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        char[] arr = new char[n];
        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine().charAt(0);
        }

        int left = 0;
        int right = n-1;
        ArrayList<Character> result = new ArrayList<>();
        while(left <= right) {
            if(arr[left] < arr[right]) {
                result.add(arr[left]);
                left++;
            } else if(arr[left] > arr[right]) {
                result.add(arr[right]);
                right--;
            } else {
                int tempL = left + 1;
                int tempR = right - 1;
                int size = result.size();

                while(tempL <= tempR) {
                    if(arr[tempL] < arr[tempR]) {
                        result.add(arr[left]);
                        left++;
                        break;
                    } else if(arr[tempL] > arr[tempR]) {
                        result.add(arr[right]);
                        right--;
                        break;
                    } else {
                        tempL++;
                        tempR--;
                    }
                }
                if(size == result.size()) {
                    result.add(arr[left]);
                    left++;
                }
            }
        }

        for (int i = 0; i < result.size(); i++) {
            if(i != 0 && i % 80 == 0) {
                bw.write("\n");
            }
            bw.write(result.get(i) + "");
        }
        br.close();
        bw.close();
    }
}
