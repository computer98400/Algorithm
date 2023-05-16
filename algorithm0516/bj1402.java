import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj1402{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String origin = br.readLine();
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        
        for(int i=0; i< origin.length();i++){
            left.push(origin.charAt(i));
        }
        int count = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i< count;i++){
            st = new StringTokenizer(br.readLine()," ");
            String order = st.nextToken();
            String input = "";
            if(st.hasMoreTokens()){
                input = st.nextToken();
            }


            if(order.equals("L") && !left.isEmpty()){
                right.push(left.pop());
            }else if(order.equals("D") && !right.isEmpty()){
                left.push(right.pop());
            }else if(order.equals("B") && !left.isEmpty()){
                left.pop();
            }else if(order.equals("P")){
                left.push(input.charAt(0));
            }
        }
        StringBuilder sb = new StringBuilder();

        while(!left.isEmpty()){
            sb.append(left.pop());
        }
        sb = sb.reverse();
        while(!right.isEmpty()){
            sb.append(right.pop());
        }
        System.out.println(sb);

    }
}