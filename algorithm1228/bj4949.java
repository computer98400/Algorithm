package Algorithm.algorithm1228;

import java.util.Scanner;
import java.util.Stack;

public class bj4949{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        Stack<Character> st;

       while(true){
            st = new Stack<>();

            String temp = sc.nextLine();

            if(temp.charAt(0) == '.'){
                break;
            }

            boolean flag = true;
            for (int i = 0; i < temp.length(); i++) {
                if(temp.charAt(i)== '(' || temp.charAt(i)== '['){
                    st.push(temp.charAt(i));
                   // System.out.println("push : "+ i);
                }else if(temp.charAt(i)== ']' || temp.charAt(i)== ')' ){
                    if(!st.isEmpty()){
                        char check  = st.pop();
                        //  System.out.println(check +" "+temp.charAt(i));
                        if(check == '(' && temp.charAt(i)== ')'){
                            continue;
                        }else if(check == '[' && temp.charAt(i) == ']'){
                            continue;
                        }else{
                            flag = false;
                            break;
                        }
                    }else{
                        flag = false;
                        break;
                    }
                }
            }
           // System.out.println("pop :"+ st.size());
            if(!flag || !st.isEmpty()){
                System.out.println("no");
            }else{
                System.out.println("yes");
            }
       }


    }

}