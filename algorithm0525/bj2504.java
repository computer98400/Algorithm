package Algorithm.algorithm0525;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj2504 {
    
    public static void recur(char wrap, String divide){
        if(divide.equals("[]")){
            System.out.println(3);
            return;
        }

        if(divide.equals("()")){
            System.out.println(2);
            return;
        }

        Stack<Character> test = new Stack<>();
        int socount = 0;
        int decount = 0;
        System.out.println(divide);
        for(int i=0; i< divide.length(); i++){
            if(divide.charAt(i) == '('){
                socount++;
            }else if(divide.charAt(i)=='['){
                decount++;
            }else if(divide.charAt(i)==')'){
                socount--;
            }else if(divide.charAt(i)==']'){
                decount--;
            }
            
            if(socount == 0 && decount == 0){
                String first = divide.substring(0, i+1);
                recur(first.charAt(0),divide.substring(0, i+1));
                String second = divide.substring(i+1);
                recur(second.charAt(0),divide.substring(i+1));
            }
        }

    }


    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();


        recur(' ',input);

    }
}
