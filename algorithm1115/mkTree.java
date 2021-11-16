package algorithm1115;

public class mkTree {

}

class Tree {
    public node root;

    public void setRoot(node node) {

        this.root = node;
    }

    public node getRoot() {

        return root;
    }

    public node createNode(node left, int data, node right) {
        node node = new node();
        node.data = data;
        node.left = left;
        node.right = right;

        return node;
    }

    // 중위 순회 Inorder = Left -> Root -> Right
    // 4 -> 2 -> 5 -> 1 -> 3
    public void inOrder(node node) {
        if (node != null) {
            inOrder(node.left);
            System.out.println(node.data);
            inOrder(node.right);
        }
    }

    // 전위순회 Preorder = Root -> Left -> Right
    // 1 -> 2 -> 4 -> 5 -> 3
    public void preOrder(node node) {
        if (node != null) {
            System.out.println(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // 후위순회 Postorder = Left -> Right -> Root
    // 4 -> 5 -> 2 -> 3 -> 1
    public void postOrder(node node) {
        if (node != null) {
            preOrder(node.left);
            preOrder(node.right);
            System.out.println(node.data);
        }
    }
}

class node {
    String data;
    node[] list;

}