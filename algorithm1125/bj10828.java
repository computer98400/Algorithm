package algorithm1125;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj10828 {
       
    public static void main(String[] args) throws Exception {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int Tc = Integer.parseInt(sc.readLine());

        stackTest tt = new stackTest();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Tc; i++) {
            String st = sc.readLine();
            if (st.equals("top")) {
                sb.append(tt.top() + "\n");
            } else if (st.equals("pop")) {
                sb.append(tt.pop() + "\n");
            } else if (st.equals("size")) {
                sb.append(tt.size() + "\n");
            } else if (st.equals("empty")) {
                sb.append(tt.empty() + "\n");
            } else {
                String[] temp = st.split(" ");
                tt.push(Integer.parseInt(temp[1]));
            }
        }
        System.out.println(sb.toString());
    }
}

class stackTest {
    int[] arr = new int[10005];
    int size = 0;

    int top() {
        if (this.size == 0) {
            return -1;
        }
        return this.arr[this.size];
    }

    int size() {
        return this.size;
    }

    void push(int x) {
        this.size++;
        this.arr[this.size] = x;
    }
    

    int empty() {
        if(this.size == 0)
            return 1;
        return 0;
    }
    
    int pop() {
        if (this.size == 0) {
            return -1;
        } else {
            int temp = this.arr[this.size];
            this.arr[this.size] = 0;
            this.size--;
            return temp; 
        }
        
    }
}