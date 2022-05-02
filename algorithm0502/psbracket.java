package Algorithm.algorithm0502;

import java.util.Stack;

public class psbracket{
    public static String total = "";
    public static String solution(String p) {
        if(p.equals("")){
            return "";
        }
        
        int test = 0;            
        for(int i=0; i< p.length(); i++){
            if(p.charAt(i) == '('){
                test++;
            }else{
                test--;
            }

            if(test == 0){
                String u = p.substring(0, i+1);
                String v = p.substring(i+1);

                //(0~i), (i+1~end)
                if(verify(u)){
                    total+= u;
                    solution(v);
                }else{
                    String check1 = "";

                }
            }
        }
        return "";
    }

    public static void test(String temp){
        String trans = "(";


        return;
    }


    public static boolean verify(String temp){
        Stack<Character> list = new Stack<>();


        for(int i =0; i<temp.length(); i++){

            //스택이 비어있을 경우 들어오는 값이 ')'라면 끝.
            if(temp.charAt(i) == ')'){
                if(list.isEmpty()){
                    return false;
                }else{
                    list.pop();
                    continue;
                }
            }else{
                list.push(temp.charAt(i));
            }
        }

        if(list.isEmpty()){
            return true;
        }else{
            return false;
        }
    }

    public static String step(){
        return "";
    }


    public static void main(String[] args) {
        solution("(()())()");
    }


}