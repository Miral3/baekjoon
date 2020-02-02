import kotlin.Pair;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Stack;

public class Test_ {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        Stack <Pair<Long, Long>> top = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(long i = 0; i < testCase; i++){
            long input = Long.parseLong(st.nextToken());
            while(!top.isEmpty()){
                if(top.peek().getSecond() > input){
                    System.out.println(top.peek().getFirst());
                    break;
                }
                top.pop();
            }
            if(top.isEmpty())
                System.out.println("0 ");

            top.push(new Pair<>(input, i));
        }
    }
}

