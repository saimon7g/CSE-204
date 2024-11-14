public class Node {

    private int key ;
    private Node left ;
    private Node right ;

    public Node(int data){
        key = data ;
        left = right = null ;
    }

    public int getKey() { return key; }

    public void setKey(int key) { this.key = key; }

    public Node getLeftChild() { return left; }

    public void setLeftChild(Node left) { this.left = left; }

    public Node getRightChild() { return right; }

    public void setRightChild(Node right) { this.right = right; }
}
