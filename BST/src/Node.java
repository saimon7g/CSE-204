public class Node {
    private int value;
    private Node left_node;
    private Node right_node;

    public Node(int item){
        value=item;
        left_node=null;
        right_node=null;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft_node() {
        return left_node;
    }

    public void setLeft_node(Node left_node) {
        this.left_node = left_node;
    }

    public Node getRight_node() {
        return right_node;
    }

    public void setRight_node(Node right_node) {
        this.right_node = right_node;
    }
}
