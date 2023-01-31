import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;


public class bj1918{

  public static Stack<Character> stack = new Stack<>();

  public static boolean first(char current, char before){
    System.out.println("search");
    if(current == '*' || current == '/'){
      if(before == '+' || before == '-'){
        return false;
      }
    }
    return true;
  }
  public static String test1(String input){
    StringBuilder sb = new StringBuilder();
    for(int i =0; i< input.length(); i++){
      if(input.charAt(i) >= 65 && input.charAt(i) < 91){
        sb.append(input.charAt(i));
      }else if(input.charAt(i) == ')'){
        while(stack.peek() != '('){
          sb.append(stack.pop());
        }
      }else{
        System.out.println("before : "+(stack.isEmpty() ? "": stack.peek())+" current : "+input.charAt(i));
        while(!stack.isEmpty() && first(input.charAt(i), stack.peek()) && stack.peek() == '('){
            sb.append(stack.pop());
          }
          stack.push(input.charAt(i));
      }
      System.out.println(sb);
    }
    while(!stack.isEmpty()){
      sb.append(stack.pop());
    }
    return sb.toString();
  }


  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    System.out.println(test1(br.readLine()));
  }
}