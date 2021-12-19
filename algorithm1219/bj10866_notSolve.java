package algorithm1219;

import java.util.Scanner;
import java.util.StringTokenizer;

public class bj10866_notSolve {
    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);
        
        int N = sc.nextInt();
        sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");

            String tempString = st.nextToken();

            deck test = new deck();

            int tempInt = 0;

            switch (tempString) {
                
                case "push_back":
                    tempInt = Integer.parseInt(st.nextToken());
                    test.push_back(tempInt);
                    break;

                case "push_front":
                    tempInt = Integer.parseInt(st.nextToken());
                    test.push_front(tempInt);
                    break;

                case "pop_front":
                    sb.append("pop_front : "+test.pop_front() + " \n");
                    break;

                case "pop_back":
                    sb.append("pop_back : "+test.pop_back() + " \n");
                    break;

                case "front":
                    sb.append("front : "+test.front+" "+test.front() + " \n");
                    break;

                case "back":
                    sb.append("back : "+test.front+" "+test.back()+" \n");
                    break;

                case "size":
                    sb.append("size : front : "+test.front+" back : "+test.back+" "+test.size()+" \n");
                    break;
                    
                case "empty":
                    sb.append("empty : "+test.empty()+" \n");
                    break;

            }

        }
        System.out.println(sb);
    }

}

class deck {
    int[] arr;
    int front;
    int back;

    deck() {
        arr = new int[20000];
        front = 10000;
        back = 10000;
    }
    
    String pop_front() {
        if (empty() == 1) {
            return "-1";
        } else {
            String temp = Integer.toString(arr[this.front-1]);
            this.front--;
            return temp;
        }
    }

    String pop_back() {
        if (empty() == 1) {
            return "-1";
        } else {
            String temp = Integer.toString(arr[this.back+1]);
            this.back++;
            return temp;
        }
    }
    
    void push_front(int temp) {
        this.front++;
        System.out.println(front);
        arr[this.front] = temp;
    }
    
    void push_back(int temp) {
        back--;
        System.out.println(this.back);
        arr[this.back] = temp;
    }

    int size() {
        System.out.println(this.front + " " + this.back);
        return Math.abs(this.front - this.back);
    }

    int empty() {
        if (this.front - this.back == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    int front() {
        if (empty() == 1) {
            return -1;
        } else {
            System.out.println(this.front);
            return arr[this.front];
        }
    }
    int back() {
        if (empty() == 1) {
            return -1;
        } else {
            System.out.println(this.back);
            return arr[this.back];
        }
    }


}
