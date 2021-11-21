package algorithm1121;
import java.util.Scanner;
import java.util.StringTokenizer;

public class bj1991 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();

        tree tt = new tree();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(sc.nextLine(), " ");
            tt.add(st.nextToken(),st.nextToken(), st.nextToken());
        }
        tt.pre(tt.root);
        System.out.println();
        tt.inorder(tt.root);
        System.out.println();
        tt.post(tt.root);

        sc.close();

    }
}

class tree {
    public node root;

    public void add(String data, String left, String right) {
        if (root == null) {
            root = new node(data);
            if (!left.equals(".")) {
                root.left = new node(left);
            }
            if (!right.equals(".")) {
                root.right = new node(right);
            }
        } else {
            //루트에 값 존재시 검색 부분 + 재귀를 통해서 값이 존재하지않을때 입력
            search(root, data, left, right);
        }
    }

    public void search(node root2, String data, String left, String right) {
        if (root2 == null) {
            return;
        } else if (root2.data.equals(data)) {
            if (!left.equals(".")) {
                root2.left = new node(left);
            }
            if (!right.equals(".")) {
                root2.right = new node(right);
            }
        } else {
            search(root2.left, data, left, right);
            search(root2.right, data, left, right);
        }
    }
    
    //전위
    public void pre(node root2) {
        if (root2 != null) {
            System.out.print(root2.data);
            pre(root2.left);
            pre(root2.right);
        }
    }


    //중위
    public void inorder(node root2) {
        if (root2 != null) {
            inorder(root2.left);
            System.out.print(root2.data);
            inorder(root2.right);
        }
    }


    //후위
    public void post(node root2) {
        if (root2 != null) {
            post(root2.left);
            post(root2.right);
            System.out.print(root2.data);
        }
    }

}

class node{
    String data;
    node left;  //이후 값들을 집어넣는다.
    node right;

    public node(String value) {
        this.data = value;
    }
}