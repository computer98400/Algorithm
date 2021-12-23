package algorithm1223;

import java.util.Scanner;

public class bj10866 {
    
    static class test {
        int front;
        int back;
        int[] arr;

        test() {
            arr = new int[20000];
            front = 10000;
            back = 10000;
        }

        void push_front(int number) {
            if (arr[front] != 0) {
                arr[front] = number;
            } else {
                front--;
                arr[front] = number;
            }
        }

        void push_back(int number) {
            if (arr[back] != 0) {
                arr[back] = number;
            } else {
                back++;
                arr[back] = number;
            }
        }

        int pop_front() {
            if (front == back) {
                if (arr[front] != 0) {
                    int temp = arr[front];
                    arr[front] = 0;
                    return temp;
                } else {
                    return -1;
                }
            } else {
                int temp = arr[front];
                arr[front] = 0;
                front++;
                return temp;
            }
        }

        int pop_back() {
            if (front == back) {
                if (arr[front] != 0) {
                    int temp = arr[front];
                    arr[front] = 0;
                    return temp;
                } else {
                    return -1;
                }
            } else {
                int temp = arr[back];
                arr[back] = 0;
                back--;
                return temp;
            }
        }
        
        int size() {
            return Math.abs(front - back);
        }

        int empty() {
            if (front == back) {
                if (arr[front] != 0) {
                    return 0;
                } else {
                    return 1;
                }
            } else {
                return 0;
            }
        }

        int front() {
            if (arr[front] == 0) {
                return -1; 
            }
            return arr[front];
        }

        int back() {
            if (arr[back] == 0) {
                return -1;
            }
            return arr[back]; 
        }
    }
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        test show = new test();


        int N = sc.nextInt();
        sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {

            String[] temp = sc.nextLine().split(" ");

            if (temp[0].equals("push_back")) {
                show.push_back(Integer.parseInt(temp[1]));
            }else if (temp[0].equals("push_front")) {
                show.push_front(Integer.parseInt(temp[1]));
            }else if (temp[0].equals("pop_back")) {
                sb.append(show.pop_back());
            }else if (temp[0].equals("pop_front")) {
                sb.append(show.pop_front());
            }else if (temp[0].equals("size")) {
                sb.append(show.size());
            }else if (temp[0].equals("empty")) {
                sb.append(show.empty());
            }else if (temp[0].equals("front")) {
                sb.append(show.front());
            } else if (temp[0].equals("back")) {
                sb.append(show.back());
            }

            sb.append("\n");
        }
        System.out.println(sb);


    }
}
