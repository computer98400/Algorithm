package Algorithm.algorithm0524;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class bj1316 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        int count = 0;
        for(int i =0; i< N; i++){
            Set<Character> test  =new HashSet<>();
            String temp = br.readLine();
            boolean flag = false;
            char temp2= ' ';
            for(int j=0; j< temp.length(); j++){
                if(!test.contains(temp.charAt(j))){
                    test.add(temp.charAt(j));
                    temp2 = temp.charAt(j);
                }else{
                    if(temp2 == temp.charAt(j)){
                        continue;
                    }else{
                        flag =true;
                        break;
                    }
                }
            }
            if(!flag){
                count++;
            }
        }
        System.out.println(count);

    }
}
