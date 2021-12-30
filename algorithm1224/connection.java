package algorithm1224;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import DataStructure.mkcheck;

public class connection {

    private static mkcheck test;
    
    public void method1(){
        System.out.println(test.N4);
        
    }

    public void method2(){
        System.out.println(test.N4);
    
    }

    public static void main(String[] args) {
    
        mkcheck test = new mkcheck();

        Stack<Integer> st = new Stack<>();
        
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.push(5);
        st.push(2);
        while(!st.isEmpty()){
            System.out.print(st.pop()+" ");
        }
        System.out.println();
        System.out.println("=====================================");
        Queue<Integer> qu = new LinkedList<>();
        
        qu.add(1);
        qu.add(2);
        qu.add(3);
        qu.add(4);
        qu.add(5);
        qu.add(2);

        while(!qu.isEmpty()){
            
            System.out.print(qu.poll()+" ");
            
        }
        System.out.println();


        HashSet<Integer> set = new HashSet<>();
        
        set.add(3);
        set.add(-4533451);
        set.add(1);
        set.add(2564564);
        set.add(1);
        
        System.out.println(set.toString());

        HashMap<Integer,String> map = new HashMap<>();

        //보안 + 탐색속도 극대화x
        //일정한 값으로 나눠서 처리. == 100000000000000000...
        //N = 1


    }



}
