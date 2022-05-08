package algorithm0504;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class psfindmap {

    static class Node {
        private Node left;
        private Node right;
        private int key;
        private int value;

        public Node(int value, int key) {
            this.value = value;
            this.key = key;
            this.left = null;
            this.right = null;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public int getValue() {
            return this.value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getKey() {
            return this.key;
        }


        // public void getCurrentKV() {
        //     System.out.println(this.value + " " + this.key);
        // }
    }

    public static Node test;
    public static StringBuilder sb = new StringBuilder();
    
    public static int[] preresult;
    public static int[] afterresult;
    public static int count = 0;


    public static void pre(Node temp) {
        if (temp != null) {
            answer[0][count] = temp.getKey();
            count++;
            pre(temp.getLeft());
            pre(temp.getRight());
        }
    }

    public static void after(Node temp) {
        if (temp != null) {
            after(temp.getLeft());
            after(temp.getRight());
            answer[1][count] = temp.getKey();
            count++;
        }
    }
    
    public static void insert(int value, int key) {
        Node newNode = new Node(value, key);
        if (test == null) {
            test = newNode;
            return;
        }
        Node currentNode = test;
        Node parent;

        while (true) {
            parent = currentNode;
            // if (currentNode == null) {

            //     System.out.println("value : "+value+" key : "+key+" null 입니다!");
            //     return;
            // }
            if (value < currentNode.getValue()) {
                currentNode = currentNode.getLeft();
                if (currentNode == null) {
                    parent.setLeft(newNode);
                    return;
                }
            } else {
                currentNode = currentNode.getRight();
                if (currentNode == null) {
                    parent.setRight(newNode);
                    return;
                }
            }
        }
    }
    public static int[][] answer;

    public static int[][] solution(int[][] nodeinfo) {
        answer = new int[2][nodeinfo.length];
        preresult = new int[nodeinfo.length];
        afterresult = new int[nodeinfo.length];
        // 5 , 3, 1 
        // 11, 5, 2 
        int[][] temp = new int[nodeinfo.length][3];
        for (int i = 0; i < nodeinfo.length; i++){
            temp[i][0] = nodeinfo[i][0];
            temp[i][1] = nodeinfo[i][1];
            temp[i][2] = i+1;
        }
        Arrays.sort(temp, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return Integer.compare(o1[0], o2[0]);
                } else {
                    return Integer.compare(o2[1], o1[1]);
                }
            }
        });

        for (int i = 0; i < nodeinfo.length; i++) {
            System.out.println(Arrays.toString(temp[i]));
        }
        for (int i = 0; i < nodeinfo.length; i++) {
            // System.out.println(i + " value : " + nodeinfo[i][0] + " key : " + nodeinfo[i][1]);
            insert(temp[i][0], temp[i][2]);
        }
        //트리 탐색 문제



        pre(test);
        // System.out.println(sb);
        count = 0;
        after(test);
        // System.out.println(Arrays.deepToString(answer));
        // sb.setLength(sb.length() - 1);
        // System.out.println(sb.toString());

        //전회 순회
        //후위 순회를 구현해야함.

        //처음부터 값을 넣었을때 트리가 어떻게 생성될지를 만들어야함.
        //x,y값에 대한 정렬도 필요함

        return answer;
    }

    public static void main(String[] args) {
        solution(new int[][] { { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 }, { 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 },
                { 2, 2 } });

    }
}
