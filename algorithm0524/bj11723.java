package Algorithm.algorithm0524;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class bj11723 {
    static class arr{
        int[] list;
        int size;

        arr(){
            this.list = new int[20];
        }
        
        void add(int i){
            if(check(i)) return;

            this.list[i-1] = 1;
        }

        void remove(int i){
            if(!check(i)) return;

            this.list[i-1] = 0;
        }

        void toggle(int i){
            if(check(i)){
                this.list[i-1] = 0;
            }else{
                this.list[i-1] = 1;
            }
        }

        void empty(){
            this.list = new int[20];
        }

        void all(){            
            for(int i =1; i< 21; i++){
                this.list[i-1] =1;
            }
        }

        boolean check(int i){
            if(this.list[i-1] != 0) {
                return true;
            }
            return false;
        }


    }



    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        arr test = new arr();
        StringBuilder sb = new StringBuilder();
        for(int i =0; i< N; i++){
            String[] st =br.readLine().split(" ");
            String order = st[0];
            int num = -1;
            if(st.length != 1){
                num = Integer.parseInt(st[1]);
            }
            if(order.equals("add")){
                test.add(num);
            }else if(order.equals("remove")){
                test.remove(num);
            }else if(order.equals("check")){
                if(test.check(num)){
                   sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }else if(order.equals("toggle")){
                test.toggle(num);
            }else if(order.equals("all")){
                test.all();
            }else if(order.equals("empty")){
                test.empty();
            }
        }
        System.out.println(sb);
    }
}
