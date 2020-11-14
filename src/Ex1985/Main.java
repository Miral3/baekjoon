package Ex1985;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i = 0; i < 3; i++) {
            String relationship = "friends";
            String[] input = br.readLine().split(" ");
            String x = input[0];
            String y = input[1];

            LinkedList<Character> list = new LinkedList<>();
            for(int j = 0; j < x.length(); j++){
                list.add(x.charAt(j));
            }

            for(int j = 0; j < y.length(); j++) {
                if(!list.contains(y.charAt(j))) {
                    if(j < y.length()-1 && y.charAt(j) - '0' > 0 &&
                    list.contains((char)(y.charAt(j)-1)) && list.contains((char)(y.charAt(j+1) - '0'+1))) {
                        if(j == 0 && y.charAt(j) == '1') {
                            relationship = "nothing";
                            break;
                        }
                        relationship = "almost friends";
                        j+=2;
                    }
                    else if( j < y.length()-1 && y.charAt(j+1) - '0' > 0 &&
                            list.contains((char)(y.charAt(j) +1)) && list.contains((char)(y.charAt(j+1)-1))) {
                        relationship = "almost friends";
                        j+=2;
                    }
                    else {
                        relationship = "nothing";
                        break;
                    }
                }
            }
            if(relationship != "nothing") {
                System.out.println(relationship);
                continue;
            }

            list.clear();
            for(int j = 0; j < y.length(); j++){
                list.add(y.charAt(j));
            }

            for(int j = 0; j < x.length(); j++) {
                if(!list.contains(x.charAt(j))) {
                    if(j < x.length()-1 && x.charAt(j) - '0' > 0 &&
                            list.contains((char)(x.charAt(j) -1)) && list.contains((char)(x.charAt(j+1)+1))) {
                        if(j == 0 && x.charAt(j) == '1') {
                            relationship = "nothing";
                            break;
                        }
                        relationship = "almost friends";
                        j +=2;
                    }
                    else if(j < x.length()-1 && x.charAt(j+1) - '0' > 0 &&
                            list.contains((char)(x.charAt(j)+1)) && list.contains((char)(x.charAt(j+1) -1))) {
                        relationship = "almost friends";
                        j+=2;
                    }
                    else {
                        relationship = "nothing";
                    }
                }
            }
            System.out.println(relationship);
            list.clear();
        }
    }
}
