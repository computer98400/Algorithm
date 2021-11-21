package algorithm1117;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj10828 {
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            System.out.println(temp[0]+" "+ temp[1]);
        }


        

    }
}
