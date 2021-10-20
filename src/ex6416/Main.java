package ex6416;

/*
문제 이름: 트리인가?
알고리즘: 트리
자료구조: 해시맵
*/

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> map;
        int idx = 1;

        while(true) {
            map = new HashMap<>();
            int edge = 0;
            while(true) {
                int start = sc.nextInt();
                int end = sc.nextInt();
                if(start == -1 && end == -1) {
                    return;
                }
                if(start == 0 && end == 0) {
                    break;
                }

                map.put(start, map.getOrDefault(start, 0));
                map.put(end, map.getOrDefault(end, 0) + 1);
                edge++;
            }
            boolean hasRoot = false;
            boolean isTree = true;

            Iterator<Integer> keys = map.keySet().iterator();
            while(keys.hasNext()) {
                int key = keys.next();
                if(map.get(key) == 0) {
                    if(hasRoot) {
                        isTree = false;
                        break;
                    }
                    hasRoot = true;
                } else if(map.get(key) > 1) {
                    isTree = false;
                    break;
                }
            }
            if(map.size() == 0) {
                System.out.println("Case " + idx + " is a tree.");
            }
            else if(!isTree || edge != map.size() - 1) {
                System.out.println("Case " + idx + " is not a tree.");
            } else {
                System.out.println("Case " + idx + " is a tree.");
            }
            idx++;
        }
    }
}
