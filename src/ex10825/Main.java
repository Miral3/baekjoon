package ex10825;

/*
문제 이름: 국영수
알고리즘: 정렬
자료구조: 연결 리스트
*/

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

class Node {
    String name;
    int kor, eng, math;

    public Node(String name, int kor, int eng, int math) {
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        LinkedList<Node> list = new LinkedList();
        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            String name = input[0];
            int kor = Integer.parseInt(input[1]);
            int eng = Integer.parseInt(input[2]);
            int math = Integer.parseInt(input[3]);

            list.add(new Node(name, kor, eng, math));
        }

        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if (o1.kor < o2.kor) {
                    return 1;
                } else if(o1.kor == o2.kor) {
                    if(o1.eng < o2.eng) {
                        return -1;
                    } else if(o1.eng == o2.eng) {
                        if(o1.math < o2.math) {
                            return 1;
                        } else if(o1.math == o2.math) {
                            if(o1.name.compareTo(o2.name) < 0) {
                                return -1;
                            }
                            return 1;
                        }
                        return -1;
                    }
                    return 1;
                }
                return -1;
            }
        });

        for(Node o : list) {
            bw.write(o.name + "\n");
        }

        br.close();
        bw.close();
    }
}
