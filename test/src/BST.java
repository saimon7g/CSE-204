public class BST {

    Node BST_root;

    public BST() {
        BST_root = null ;
    }

    public BST(int item) {
        BST_root = new Node(item) ;
    }


    /** Find **/
    // helper method
    private Node Aux_Find (Node root, int key) {
        if(root == null || root.getKey() == key)
            return  root ;
        if(key > root.getKey())
            return Aux_Find(root.getRightChild() , key);

        return Aux_Find(root.getLeftChild(), key);
    }
    public String Find(int key){
        if(Aux_Find(BST_root,key) != null)
            return "True" ;
        else
            return "False";
    }

    /** Insert **/
    private Node Aux_Insert(Node root, int item){
        if(root == null){
            root = new Node(item);
            return root ;
        }
        if(item < root.getKey()){
            root.setLeftChild( Aux_Insert(root.getLeftChild(), item) );
        }
        else if(item > root.getKey()) {
            root.setRightChild( Aux_Insert(root.getRightChild() , item));
        }
        return  root;
    }

    public void Insert(int item) {
        Aux_Insert(BST_root, item);
        BST_Print(BST_root);
    }



    /** Delete **/
    public int getMinimum(Node root)  {

        int min_Value = root.getKey();

        while (root.getLeftChild() != null)  {
            min_Value = root.getLeftChild().getKey();
            root = root.getLeftChild();
        }
        return min_Value;
    }

    // helper methods
    private Node Aux_Delete(Node root , int key){

        // if tree is empty
        if(root == null)
            return root ;

        //otherwise
        if(key < root.getKey())
            root.setLeftChild( Aux_Delete(root.getLeftChild() , key) );
        else if(key < root.getKey())
            root.setRightChild( Aux_Delete(root.getRightChild() , key) );
        else{

            // exactly one child
            if(root.getLeftChild() == null)
                return root.getRightChild();
            else if(root.getRightChild() == null)
                return root.getLeftChild();

            // exactly two children
                // get minimum of right subtree
            root.setKey(getMinimum(root.getRightChild()));
            root.setRightChild(Aux_Delete(root.getRightChild(),root.getKey()) );
        }
        return root;
    }

    public void Delete(int key){
        BST_root = Aux_Delete(BST_root,key);
        BST_Print(BST_root);
    }


    /** Traversals **/

    // InOrder Traversal
    private void Aux_InOrderTraversal(Node root){
        if(root == null)
            return;

        Aux_InOrderTraversal(root.getLeftChild());
        System.out.print(root.getKey() + " " );
        Aux_InOrderTraversal(root.getRightChild());
    }
    public void InOrderTraversal(){
        Aux_InOrderTraversal(BST_root);
        System.out.println();
    }



    // PreOrder Traversal
    private void Aux_PreOrderTraversal(Node root){
        if(root == null)
            return;

        System.out.print(root.getKey() + " " );
        Aux_PreOrderTraversal(root.getLeftChild());
        Aux_PreOrderTraversal(root.getRightChild());

    }
    public void PreOrderTraversal(){
        Aux_PreOrderTraversal(BST_root);
        System.out.println();
    }




    // PostOrder Traversal
    private void Aux_PostOrderTraversal(Node root){
        if(root == null)
            return;

        Aux_PostOrderTraversal(root.getLeftChild());
        Aux_PostOrderTraversal(root.getRightChild());
        System.out.print(root.getKey() + " " );

    }

    public void PostOrderTraversal(){
        Aux_PostOrderTraversal(BST_root);
        System.out.println();

    }


    public void BST_Print(Node rootNode) {
        if (rootNode == null)
            return;

        System.out.print(rootNode.getKey());
        if (rootNode.getLeftChild() != null || rootNode.getRightChild() != null) {
            //System.out.print(rootNode.getKey());

            System.out.print("( ");
            if (rootNode.getLeftChild() != null) BST_Print(rootNode.getLeftChild());
            else System.out.print("");
            System.out.print(" )");

            System.out.print("( ");
            if (rootNode.getRightChild() != null) BST_Print(rootNode.getRightChild());
            else System.out.print("");
            System.out.print(" )");

        }
        /*else {
            System.out.print(rootNode.getKey());
        }*/
    }

}
