package algorithm0116;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj10866 {

    static int[] arr = new int[20000];
    static int front = 10000;
    static int back = 10001;
    static int size = 0;

    static void push_front(int N) {
        arr[front--] = N;
        size++;
    }

    static void push_back(int N) {
        arr[back++] = N;
        size++;
    }

    static int pop_front() {
        if (size == 0) {
            return -1;
        }

        size--;
        front++;
        return arr[front];
    }

    static int pop_back() {
        if (size  == 0) {
            return -1;
        }
        size--;
        back--;
        return arr[back];
    }

    static int size() {
        return size;
    }
    
    static int empty() {
        return size == 0 ? 1 : 0;
    }

    static int front() {
        if (size == 0) {
            return -1;
        }
        return arr[front + 1];
    }
    
    static int back() {
        if (size == 0) {
            return -1;
        }
        return arr[back - 1];
    }
    

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String temp = st.nextToken();
            if (temp.equals("push_back")) {
                push_back(Integer.parseInt(st.nextToken()));
                continue;
            }else if (temp.equals("push_front")) {
                push_front(Integer.parseInt(st.nextToken()));
                continue;
            }else if (temp.equals("pop_back")) {
                sb.append(pop_back()).append("\n");
                continue;
            }else if (temp.equals("pop_front")) {
                sb.append(pop_front()).append("\n");
                continue;
            }else if (temp.equals("size")) {
                sb.append(size()).append("\n");
                continue;
            }else if (temp.equals("empty")) {
                if(empty() == 1){
                    sb.append(1).append("\n");
                } else {
                    sb.append(0).append("\n");
                }
                continue;
            }else if (temp.equals("front")) {
                sb.append(front()).append("\n");
                continue;
            }else  if (temp.equals("back")) {
                sb.append(back()).append("\n");
                continue;
            }
        }
        System.out.println(sb);
    }
}
