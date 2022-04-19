package algorithm0417;

import java.util.ArrayList;
import java.util.HashSet;

public class psnewscluster {
    public static int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        // System.out.println(str1 + " " + str2);

        ArrayList<String> test = new ArrayList<>();
        HashSet<String> hap = new HashSet<>();
        for (int i = 1; i < str1.length(); i++) {
            char temp1 = str1.charAt(i - 1);
            char temp2 = str1.charAt(i);
            String temp = "";
            if (temp1 >= 'A' && temp1 <= 'Z' && temp2 >= 'A' && temp2 <= 'Z') {
                temp = "" + temp1 + temp2;
            }
            hap.add(temp);
        }
        for (int i = 1; i < str2.length(); i++) {
            char temp1 = str2.charAt(i - 1);
            char temp2 = str2.charAt(i);
            String temp = "";
            if (temp1 >= 'A' && temp1 <= 'Z' && temp2 >= 'A' && temp2 <= 'Z') {
                temp = "" + temp1 + temp2;
            }
            hap.add(temp);
        }
        System.out.println(hap.toString());


        

        return answer;
    }



    public static void main(String[] args) {
        solution("FRANCE", "FRENCH");
        solution("E=M*C^2", "e=m*c^2");
        solution("shake hands", "handshake");

    }
}
