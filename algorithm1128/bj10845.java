package Algorithm.algorithm1128;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class bj10845 {

    public static void main(String[] args) throws IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(sc.readLine());
        madeQueue test = new madeQueue(a);
        for (int i = 0; i < a; i++) {
            String temp = sc.readLine();
            if(temp.equals("pop")){
                System.out.println(test.pop());
            }else if(temp.equals("size")){
                System.out.println(test.size());
            }else if(temp.equals("empty")){
                System.out.println(test.empty());
            }else if(temp.equals("front")){
                System.out.println(test.front());
            }else if(temp.equals("back")){
                System.out.println(test.back());
            }else{
                String[] push2 = temp.split(" ");
                test.push(Integer.parseInt(push2[1]));
            }
        }
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