package Algorithm.algorithm0502;

import java.util.Stack;

public class psbracket{

    //재귀를 잘못함.
    public static String solution(String p) {
        if(p.equals("")){
            return "";
        }
    
        StringBuilder u = new StringBuilder();
        StringBuilder v = new StringBuilder();

        int test = 0;         
        for(int i=0; i< p.length(); i++){
            if(p.charAt(i) == '('){
                test++;
            }else{
                test--;
            }
            if(test == 0){
                u.append(p.substring(0, i+1));
                v.append(p.substring(i+1,p.length()));
                
                if(verify(u.toString())){        
                    u.append( solution(v.toString()));
                }else{
                    
                    String temp = "";
                    temp += '(';
                    temp += solution(v.toString());
                    temp+= ')';
                    temp+= test(u.toString());
                    return temp;
                }
                break;
            }
        }
        return u.toString();
    }

    public static String test(String temp){
        StringBuilder sb =new StringBuilder();
        for(int i=1; i<temp.length()-1; i++){
            if(temp.charAt(i) == '('){
                sb.append(')');
            }else{
                sb.append('(');
            }
        }
        return sb.toString();
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
    public static void main(String[] args) {
        solution("()))((()");
    }


}