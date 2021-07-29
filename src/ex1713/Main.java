package ex1713;

/*
문제 이름: 후보 추천하기
알고리즘: 배열 리스트
자료구조: 구현
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Node {
    int idx, value, rec;

    public Node(int idx, int value, int rec) {
        this.idx = idx;
        this.value = value;
        this.rec = rec;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int r = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        ArrayList<Node> list = new ArrayList<>();
        for(int i = 0; i < r; i++) {
            int value = Integer.parseInt(input[i]);
            boolean isContain = false;

            for(Node o : list) {
                if(o.value == value) {
                    isContain = true;
                    o.rec++;
                    break;
                }
            }

            if (!isContain) {
                if(list.size() < n) {
                    list.add(new Node(i, value, 0));
                } else if(list.size() == n) {
                    ArrayList<Node> copy = new ArrayList<>(list);

                    Collections.sort(copy, new Comparator<Node>() {
                        @Override
                        public int compare(Node o1, Node o2) {
                            if(o1.rec < o2.rec) {
                                return -1;
                            } else if(o1.rec > o2.rec) {
                                return 1;
                            } else {
                                if(o1.idx < o2.idx) {
                                    return -1;
                                } else {
                                    return 1;
                                }
                            }
                        }
                    });

                    int idx = list.indexOf(copy.get(0));
                    list.remove(idx);
                    list.add(idx, new Node(i, value, 0));
                }
            }
        }

        Collections.sort(list, new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.value < o2.value) {
                    return -1;
                } else {
                    return 1;
                }
            }
        });

        for(int i = 0; i < list.size(); i++) {
            bw.write(list.get(i).value + " ");
        }
        bw.write("\n");

        br.close();
        bw.close();
    }
}
