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
}

class node {
    int data;
    node right;
    node left;
}