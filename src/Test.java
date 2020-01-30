import java.io.*;
import java.util.*;

public class Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

//        String[] arr = br.readLine().split(" ");
//        String ps = "(";
//
//        for(int i = 0; i < arr.length; i++){
//            if(arr[i].equals(ps))
//                bw.write("lajflasnrglwnrlg");
//        }
        // todo 첫번째 방법
//        char[] testCase=br.readLine().toCharArray();
//        char ps='(';
//        for(int i=0; i<testCase.length; i++){
//            if(testCase[i]==ps){
//                System.out.println("왼쪽괄호");
//            }
//        }

        // todo 두번째 방법
        String tc=br.readLine();
        char ps='(';
        for(int i=0; i<tc.length(); i++){
            if(tc.charAt(i)==ps){
                System.out.println("왼쪽괄호");
            }
        }


        bw.flush();
        br.close();
        bw.close();
    }
}
