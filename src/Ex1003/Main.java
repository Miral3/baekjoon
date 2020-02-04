package Ex1003;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());
        long list1[] = new long[41];
        long list2[] = new long[41];

        list1[0] = 1; list1[1] = 0;
        list2[0] = 0; list2[1] = 1;

        for(int i = 2; i < list1.length; i++){
            list1[i] = list1[i-2] + list1[i-1];
            list2[i] = list2[i-2] + list2[i-1];
        }

        for(int i = 0; i < testCase; i++){
            int input = Integer.parseInt(br.readLine());
            System.out.println(list1[input] + " " + list2[input]);
        }
    }
}

//import java.io.*;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        int testCase = Integer.parseInt(br.readLine());
//        int inputArr[] = new int[testCase];
//
//        for(int i = 0; i < testCase; i++){
//            int input = Integer.parseInt(br.readLine());
//            inputArr[i] = input;
//        }
//
//        String count[] = new String[testCase+1];
//
//        for(int i = 0; i < testCase; i++){
//            long list1[] = new long[inputArr[i]+1];
//            long list2[] = new long[inputArr[i]+1];
//            list1[0] = 1;
//            list2[0] = 0;
//            if(inputArr[i] == 0) {
//                count[i] = list1[inputArr[i]] + " " + list2[inputArr[i]];
//                continue;
//            }
//            list1[1] = 0;
//            list2[1] = 1;
//            for(int j=2; j < list1.length; j++){
//                list1[j] = list1[j-2] + list1[j-1];
//                list2[j] = list2[j-2] + list2[j-1];
//            }
//            count[i] = list1[inputArr[i]] + " " + list2[inputArr[i]];
//        }
//
//        for(int i=0; i < testCase; i++){
//            System.out.println(count[i]);
//        }
//    }
//}
