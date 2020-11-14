import java.io.*;
import java.util.*;

public class test {
    public static  void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));;
        HashMap<Integer, Integer> map = new HashMap<>();

        map.put(1, 1);
        map.put(2, 1);
        map.put(3, 9);
        map.put(4, 1);
        map.put(5, 1);
        map.put(6, 1);
        List<Integer> keySetList = new ArrayList<>(map.keySet());
        Collections.sort(keySetList, (o1, o2) -> (map.get(o2).compareTo(map.get(o1))));
        for(Integer key : keySetList) {
            System.out.println("key : " + key + " / " + "value : " + map.get(key));
        }
        bw.close();
    }
}
