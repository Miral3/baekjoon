package Ex1991;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.*;
import java.io.*;

public class Main {
    static Map<String, Node> listMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String key = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            listMap.put(key, new Node(left, right));
        }
        preOrder("A");
        System.out.println();
        inOrder("A");
        System.out.println();
        postOrder("A");
    }
    public static void preOrder(String node) {
        if (!(node.equals("."))) {
            System.out.print(node);
            preOrder(listMap.get(node).left);
            preOrder(listMap.get(node).right);
        }
    }

    public static void inOrder(String node) {
        if (!(node.equals("."))) {
            inOrder(listMap.get(node).left);
            System.out.print(node);
            inOrder(listMap.get(node).right);
        }
    }

    public static void postOrder(String node) {
        if (!(node.equals("."))) {
            postOrder(listMap.get(node).left);
            postOrder(listMap.get(node).right);
            System.out.print(node);
        }
    }
}
class Node {
    String left, right;
    public Node(String left, String right){
        this.left = left;
        this.right = right;
    }
}
