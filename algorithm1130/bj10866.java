package Algorithm.algorithm1130;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;

public class bj10866 {



    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int orders = Integer.parseInt(br.readLine()); 
        for (int i = 0; i < orders; i++) {
            String[] temp2 = br.readLine().split(" ");
       
        switch (temp2[0]) {
            case "pubhcback":
            System.out.println("test");
            case "push_front":
            System.out.println("test");
            break;
            case "pop_front":
            System.out.println("test");
            break;
            case "pop_back":
            
            break;
            case "size":
            break;
            case "empty":
            System.out.println("test");
            break;
            case "front":
            System.out.println("test");
            break;
            case "back":
            System.out.println("test");
            break;


            }
        }

    }

}
class deck{
    int[] test = new int[20001];
    int front = 10000;
    int back = 10000;
    int size = 0;
    public deck(int len){
        test = new int[len];
    }

    void pushBack(){
        this.back = (this.back+1 + this.test.length)% this.test.length;
        System.out.println(this.test[this.back]);
        size++;
    }
    void pushFront(){
        this.front = (this.front-1 + this.test.length)% this.test.length;
        System.out.println(this.test[this.front]);
        size++;
    }
    void popBack(){
        this.back = (this.back-1 + this.test.length)% this.test.length;
        System.out.println(this.test[this.back]);
        size--;
    }
    void popFront(){
        this.front = (this.front+1 + this.test.length)% this.test.length;
        System.out.println(this.test[this.back]);
        size--;
    }
    int size(){
        return this.size;
    }
    int empty(){
        if(this.size == 0){
            return 1;
        }
        return 0;
    }
    int front(){
        if(this.size == 0){
            return -1;
        }
        return this.test[this.front];
    }
    int back(){
        if(this.size == 0){
            return -1;
        }
        return this.test[this.back];
    }

}