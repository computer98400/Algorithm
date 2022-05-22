package Algorithm.algorithm0522;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10253 {

    public static long recur(long a,long b) {
		if(a% b == 0) {
			return b;
		}

		return recur(b,a%b);
	}
    public static void calc(long a, long b, long c){
        if( a == 1){
            System.out.println(b);
            return;
        }
        // System.out.println("a : "+a +" b : "+b+" c : "+c);
        // a/b - 1/c == 가능한지,
        long g  = recur(a,b);
        a /= g;
        b /= g;
        
        while(a*c < b){
            c++;
        }
        calc(a*c - b,  b*c, c);
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        for(int i =0; i<n; i++){
            StringTokenizer st= new StringTokenizer(br.readLine()," ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            calc(a,b,2);
        }
    }
}
