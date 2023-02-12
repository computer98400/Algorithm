import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj1918 {
  public static Stack<Character> stack = new Stack<>();

  public static int returnNum(char t) {
    if (t == '(') {
      return 4;
    }

    if (t == '*' || t == '/') {
      return 3;
    }

    if (t == '+' || t == '-') {
      return 2;

    }

    return 0;
  }

  public static boolean checkPriority(char current) {
    if (stack.isEmpty()) {
    //  System.out.println("stack is empty");
      return false;
    }
    if (returnNum(stack.peek()) < returnNum(current)) {
    //  System.out.println("Current is Upper");
      return false;
    }
    if (returnNum(stack.peek()) == 4) {
     // System.out.println("Left opener");
      return false;
    }

    return true;
  }

public static void main(String[] args) throws IOException{
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


  String temp = br.readLine();
  
  StringBuilder sb = new StringBuilder();

  for (int i = 0; i < temp.length(); i++) {
    char a = temp.charAt(i);

    if (a >= 65 && a <= 90) {
      sb.append(a);
    } else if (a == ')') {
      while (stack.peek() != '(') {
        sb.append(stack.pop());
      }
      stack.pop();
    } else {
      while (checkPriority(a)) {
        sb.append(stack.pop());
      }
      stack.push(a);

    }


  }

 while(!stack.isEmpty())

  {
    sb.append(stack.pop());

  }
    System.out.println(sb);
}

 

}


