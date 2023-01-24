package algorithm0904;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class bj17140 {
    
    static class node {
        ArrayList<ArrayList<Integer>> array;
        int maxSize;

        node(ArrayList<ArrayList<Integer>> arr, int max) {
            this.array = arr;
            this.maxSize = max;
        }
    }


    //1. R연산 C연산에 대한 코드
    //2. 줄단위로 연산을 시행해서 나오는 arraylist와 최대 사이즈 출력.
    
    public static ArrayList<ArrayList<Integer>> Rsort() {

        return new ArrayList<ArrayList<Integer>>();
    }

    public static ArrayList<ArrayList<Integer>> Csort() {

        return new ArrayList<ArrayList<Integer>>();
    }

    


    //3. 해당 ArrayList를 통해서 2차원배열 만들기.

    public static void ALtoArray(ArrayList<ArrayList<Integer>> al) {
        System.out.println(al.size());
        System.out.println(al.get(0).size());
        for (int i = 0; i < al.size(); i++) {
            for (int j = 0; j < al.get(i).size(); j++){
            }
        }
    }


    
    
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        
        int count = 0;
        
        //4. 만들어진  2차원배열에서 존재하는지 확인.
        while (count > 100) {
            if (origin[r][c] == K) {
                System.out.println(count);
                break;
            }


            
            count++;

        }


    }
}
