package algorithm0120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class bj10814 {
    static class node {
        int idx;
        int age;
        String name;

        node(int idx, int age, String name) {
            this.idx = idx;
            this.age = age;
            this.name = name;
        }

        @Override
        public String toString() {
            return age +" " + name;
        }

        
    }
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        ArrayList<node> test = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            test.add(new node(i, Integer.parseInt(st.nextToken()), st.nextToken()));
        }
        test.sort(new Comparator<node>() {

            @Override
            public int compare(node o1, node o2) {
                if (o1.age == o2.age) {
                    return o1.idx - o2.idx;
                }
                return o1.age - o2.age;
            }
            
        });
        for (int i = 0; i < test.size(); i++) {
            System.out.println(test.get(i).toString());

        }
        
    }
}
