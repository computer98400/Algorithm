package Algorithm.algorithm1203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class bj1406 {
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String origin = br.readLine();
        
        ArrayList<Character> test = new ArrayList<>();

        for (int i = 0; i < origin.length(); i++) {
            test.add(origin.charAt(i));
        }
        System.out.println(test.toString());
    
    }
}
class editor{

    char[] temp;
    int cursor;

    editor(String a){
        temp = new char[100000];
        cursor = a.length();
        for (int i = 0; i < a.length(); i++) {
            temp[i] = a.charAt(i);
        }
    }
    void L(){
        cursor--;
    }
    void D(){
        cursor++;
    }

    void B(){
        if(cursor == 0){
            return;
        }
        temp[cursor] = ' ';
        cursor--;

    }
}