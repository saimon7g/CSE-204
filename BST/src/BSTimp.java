public class BSTimp {
    private Node BSTroot;

    public BSTimp(int item) {
        this.BSTroot =new Node(item) ;
        Print(BSTroot);
        System.out.println();
//        System.out.println(" constructor called " + item);
    }


    public void Insert(int item){
        InsertHelp(item,BSTroot);
        Print(BSTroot);
        System.out.println();
    }
    private Node InsertHelp(int item,Node node) {
        if(node==null){
            Node temp=new Node(item);
 //           System.out.println(" Inserted " + item);
            return temp;
        }else if(item<=node.getValue()){
//            System.out.println("going left");
            node.setLeft_node(InsertHelp(item,node.getLeft_node()));
        }else{
//            System.out.println("going right");
            node.setRight_node(InsertHelp(item,node.getRight_node()));
        }
        return node;
    }


    public String Find(int val) {
        return FindHelp(val,BSTroot);
    }
    private String FindHelp(int val,Node rootNode) {
        String ret="False";
        if(rootNode.getValue()==val)
            ret="True";
        else if(val< rootNode.getValue() && rootNode.getLeft_node()!=null ){
            ret=FindHelp(val,rootNode.getLeft_node());
        }
        else if(val> rootNode.getValue() && rootNode.getRight_node()!=null ){
            ret=FindHelp(val,rootNode.getRight_node());
        }
        return ret;
    }


    public void PreOrderTraversal() {
        PreOrderTraversalHelp(BSTroot);
        System.out.println();
    }
    private void PreOrderTraversalHelp(Node rootNode) {
        if(rootNode==null)
            return;
        System.out.print(rootNode.getValue()+" ");
        PreOrderTraversalHelp(rootNode.getLeft_node());
        PreOrderTraversalHelp(rootNode.getRight_node());
    }


    public void InOrderTraversal() {
        InOrderTraversalHelp(BSTroot);
        System.out.println();
    }
    private void InOrderTraversalHelp(Node rootNode) {
        if(rootNode==null)
            return;
        InOrderTraversalHelp(rootNode.getLeft_node());
        System.out.print(rootNode.getValue()+" ");
        InOrderTraversalHelp(rootNode.getRight_node());
    }

    public void PostOrderTraversal() {
        PostOrderTraversalHelp(BSTroot);
        System.out.println();
    }
    private void PostOrderTraversalHelp(Node rootNode) {
        if(rootNode==null)
            return;
        PostOrderTraversalHelp(rootNode.getLeft_node());
        PostOrderTraversalHelp(rootNode.getRight_node());
        System.out.print(rootNode.getValue()+" ");
    }

    public void Delete(int val) {
        DeleteNodeHelp(val,BSTroot);
        Print(BSTroot);
        System.out.println();
    }
    private Node DeleteNodeHelp(int num,Node rootNode){
        if (rootNode==null){
            System.out.println("Invalid Operation");
            return null;
        }
        if(num<rootNode.getValue()){
            rootNode.setLeft_node(DeleteNodeHelp(num,rootNode.getLeft_node()));
        }
        else if(num>rootNode.getValue()){
            rootNode.setRight_node(DeleteNodeHelp(num,rootNode.getRight_node()));
        }
        else{
            if(rootNode.getLeft_node()==null && rootNode.getRight_node()==null){
                rootNode=null;
            }
            else if(rootNode.getLeft_node()!=null && rootNode.getRight_node()==null){
                rootNode=rootNode.getLeft_node();
            }else if(rootNode.getRight_node()!=null && rootNode.getLeft_node()==null){
                rootNode=rootNode.getRight_node();
            }else{
                int val=Find_Maximum(rootNode.getLeft_node());
                rootNode.setValue(val);
                rootNode.setLeft_node(DeleteNodeHelp(val,rootNode.getLeft_node()));
            }
        }
        return rootNode;
    }
    private int Find_Maximum(Node rootNode){
        if(rootNode.getRight_node()==null){
            return rootNode.getValue();
        }
        return Find_Maximum(rootNode.getRight_node());
    }


    private void Print(Node rootNode) {
        if(rootNode==null)
            return;
        System.out.print(rootNode.getValue());
        if(rootNode.getLeft_node()!=null || rootNode.getRight_node()!=null){
            System.out.print("(");
            Print(rootNode.getLeft_node());
            System.out.print(")");
        }
        if(rootNode.getLeft_node()!=null || rootNode.getRight_node()!=null) {
            System.out.print("(");
            Print(rootNode.getRight_node());
            System.out.print(")");
        }
    }
}