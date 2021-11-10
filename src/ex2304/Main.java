package ex2304;

/*
문제 이름: 창고 다각형
알고리즘: 구현
자료구조: 배열 리스트
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Node {
    int location;
    int height;

    public Node(int location, int height) {
        this.location = location;
        this.height = height;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Node> list = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            int idx = Integer.parseInt(input[0]);
            int num = Integer.parseInt(input[1]);

            list.add(new Node(idx, num));
        }

        if(n == 1) {
            System.out.println(list.get(0).height);
            return;
        }

        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o1.location - o2.location;
            }
        });

        int result = 0;
        int max = 0;
        int maxIdx = 0;
        int height = list.get(0).height;
        int location = list.get(0).location;
        for(int i = 1; i < list.size(); i++) {
            int curHeight = list.get(i).height;
            int curLocation = list.get(i).location;

            if(height <= curHeight) {
                result += height * (curLocation - location);

                height = curHeight;
                location = curLocation;

                max = curHeight;
                maxIdx = i;
            }
        }

        height = list.get(list.size()-1).height;
        location = list.get(list.size()-1).location;
        for(int j = list.size()-2; j >= maxIdx; j--) {
            int curHeight = list.get(j).height;
            int curLocation = list.get(j).location;

            if(height <= curHeight) {
                result += height * (location - curLocation);

                height = curHeight;
                location = curLocation;
            }
        }

        bw.write(result + max + "\n");
        br.close();
        bw.close();
    }
}
