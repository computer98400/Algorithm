package algorithm0423;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj9935 {


    public static String boom(String test, String c4, int c4len){
        
        Stack<Character> temp = new Stack<>();

        for(int i=0; i< test.length(); i++){
            temp.push(test.charAt(i));
            if(temp.size() >= c4len){
                if(checkBoom(temp, c4, c4len)){
                    for(int j =0; j< c4len; j++){
                        temp.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i =0; i<temp.size(); i++){
            sb.append(temp.get(i));
        }

        return sb.toString();
    }

    public static boolean checkBoom(Stack<Character> temp,String c4, int c4len ){
        for(int j=0; j< c4len; j++){
            if(temp.get(temp.size()- c4len +j) != c4.charAt(j)){
                return false;
            }
        }
        
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        String result = boom(a,b,b.length());


        
        if(result.equals("")){
            System.out.println("FRULA");
        }else{
            System.out.println(result);
        }
    }
}
