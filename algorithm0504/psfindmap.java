package algorithm0504;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class psfindmap {

    static class tr {
        private int[] root;
        private int size;

        public tr() {
            this(null);
        }

        public tr(int[] root) {
            this.root = root;
            if (root != null) {
                size = 1;
            }
        }

        public tr setRoot(int[] element) {
            if (root == null)
                size = 1;
            
            this.root = new int[3];
            return this;
        }
        

    }

    

    public static int[][]  solution(int[][] nodeinfo) {
        int[][] answer = {};

        Arrays.sort(nodeinfo, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]){
                    return Integer.compare(o1[0], o2[0]);
                }else{
                    return Integer.compare(o2[1], o1[1]);
                }
            }
        });

        for (int i = 0; i < nodeinfo.length; i++) {
            System.out.println(Arrays.toString(nodeinfo[i]));
        }




        //트리 탐색 문제

        //전회 순회
        //후위 순회를 구현해야함.

        //처음부터 값을 넣었을때 트리가 어떻게 생성될지를 만들어야함.
        //x,y값에 대한 정렬도 필요함






        return answer;
    }

    
    
    public static void main(String[] args) {
        solution(new int[][] {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}});

    }
}
