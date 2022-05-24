package Algorithm.algorithm0525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class bj5635 {
    
    static class data implements Comparable<data>{
        String name;
        int day;
        int month;
        int year;

        data(String name, int day, int month, int year){
            this.name = name;
            this.day = day;
            this.month = month;
            this.year = year;
        }

        @Override
        public int compareTo(data o1) {
            if(this.year < o1.year){
                return -1;
            }else if(this.year == o1.year){
                if(this.month < o1.month){
                    return -1;
                }else if(this.month == o1.month){
                    if(this.day < o1.day){
                        return -1;
                    }
                }
            }


            return 0;
        }
        @Override
        public String toString() {
            return this.name+" "+this.year+" "+this.month+" "+this.day;
        }
    }


    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<data> test = new ArrayList<>();

        for(int i =0; i< N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            test.add(new data(st.nextToken(), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(test);

        System.out.println(test.get(test.size()-1).name);
        System.out.println(test.get(0).name);
    }
}
