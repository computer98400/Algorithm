package algorithm0116;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class bj18258 {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(sc.readLine());
        madeQueue test = new madeQueue(a);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a; i++) {
            String temp = sc.readLine();
            if (temp.equals("pop")) {
                sb.append(test.pop()).append("\n");
            } else if (temp.equals("size")) {
                sb.append(test.size()).append("\n");
            } else if (temp.equals("empty")) {
                sb.append(test.empty()).append("\n");
            } else if (temp.equals("front")) {
                sb.append(test.front()).append("\n");
            } else if (temp.equals("back")) {
                sb.append(test.back()).append("\n");
            } else {
                String[] push2 = temp.split(" ");
                test.push(Integer.parseInt(push2[1]));
            }
        }
        System.out.println(sb);
    }    
}

class madeQueue{
    int[] arr;
    int size;
    int frontidx;
    int backidx;

    public madeQueue(int x){
        this.arr = new int[x];
    }
    void push(int x){
        this.arr[this.backidx] = x;
        this.backidx++;
        this.size++;
    }

    int pop(){

        if(this.size == 0){
            return -1;
        }
        int temp = this.arr[this.frontidx]; 
        this.frontidx++;
        this.size--;
        return temp;
    }

    int size(){
        return this.size;
    }

    int empty(){
        return (this.size == 0 ? 1 : 0);
    }

    int front(){
        return this.size == 0 ? -1 : this.arr[this.frontidx];
    }
    int back(){
        return this.size == 0 ? -1 : this.arr[this.backidx-1];
    }
}