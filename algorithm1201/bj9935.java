package Algorithm.algorithm1201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class bj9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String c4 = br.readLine();
        String front = "";
        boolean flag = false;
        String back;
        StringBuilder sb;
        int pos = Integer.MIN_VALUE;
        
        while(!flag){
            pos = a.indexOf(c4);
            if(a.equals(c4)){
                System.out.println("FRULA");
                break;
            }
            if(pos == -1){
                System.out.println(a);
                break;
            }
             front = a.substring(0,pos);
            back = a.substring(pos+c4.length(),a.length());
            sb= new StringBuilder();
            
            sb.append(front);
            sb.append(back);
            a = sb.toString();
        }

    }
    
}