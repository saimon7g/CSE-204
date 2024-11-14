import java.io.File;
import java.io.IOException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws IOException {
        BST binarySearchTree = null ;
        Scanner scn = null ;


        File file = new File("D:\\Study\\2-1\\CSE 204\\test\\src\\TXT_File.txt");
        scn = new Scanner(file);


        while (scn.hasNext()) {
            String operation = scn.next();
            System.out.print("Operation : " + operation);

            // Insert Operation
            if(operation.equalsIgnoreCase("I")){
                int item = scn.nextInt();
                System.out.println(" " + item);

                if(binarySearchTree == null)
                    binarySearchTree = new BST(item);
                else
                    binarySearchTree.Insert(item);

                System.out.println();
            }

            else if(operation.equalsIgnoreCase("D")){
                int item = scn.nextInt();
                System.out.println(" " + item);

                if(binarySearchTree == null)
                    System.out.println("Empty BST");
                else
                    binarySearchTree.Delete(item);

                System.out.println();
            }


            else if(operation.equalsIgnoreCase("F")){
                int item = scn.nextInt();
                System.out.println(" " + item);

                if(binarySearchTree == null)
                    System.out.println("False");
                else
                    System.out.println(binarySearchTree.Find(item));

            }
            else if(operation.equalsIgnoreCase("T")){
                String traversal = scn.next();
                System.out.println(" " + traversal);

                if (binarySearchTree == null)
                    System.out.println("Empty tree");
                else if(traversal.equalsIgnoreCase("In"))
                    binarySearchTree.InOrderTraversal();
                else if(traversal.equalsIgnoreCase("Pre"))
                    binarySearchTree.PreOrderTraversal();
                else if(traversal.equalsIgnoreCase("Post"))
                    binarySearchTree.PostOrderTraversal();
            }
        }


    }
}
