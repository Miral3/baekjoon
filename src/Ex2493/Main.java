//package Ex2493;
//
//import kotlin.Pair;
//
//import java.io.IOException;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.StringTokenizer;
//import java.util.Stack;
//
//public class Main {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int testCase = Integer.parseInt(br.readLine());
//        Stack <Pair<Long, Long>> top = new Stack<>();
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        for(long i = 0; i < testCase; i++){
//            long input = Long.parseLong(st.nextToken());
//            while(!top.isEmpty()){
//                if(top.peek().getSecond() > input){
//                    System.out.print(top.peek().getFirst()+" ");
//                    break;
//                }
//                top.pop();
//            }
//            if(top.isEmpty())
//                System.out.print("0 ");
//
//            top.push(new Pair<>(i+1, input));
//        }
//    }
//}
//
