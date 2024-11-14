import java.io.*;
import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {
        BSTimp bst=null;
        Scanner input= null;
        File file = new File("D:\\Study\\2-1\\CSE 204\\BST\\src\\TextFile.txt");
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println( " In file opening ,in try catch in main");
        }
        while(input.hasNext()!=false){
            String dirrection=input.next();

            if(dirrection.equalsIgnoreCase("I")){
                if(bst==null)
                    bst=new BSTimp(input.nextInt());
                else
                    bst.Insert(input.nextInt());
            }
            else if(dirrection.equalsIgnoreCase("F")){
                if(bst==null)
                    System.out.println("Empty tree");
                else
                    System.out.println(bst.Find(input.nextInt()));
            }
            else if(dirrection.equalsIgnoreCase("T")){
                String traversal=input.next();
                if(bst==null)
                    System.out.println("Empty tree");
                else if(traversal.equalsIgnoreCase("Pre"))
                    bst.PreOrderTraversal();
                else if(traversal.equalsIgnoreCase("In"))
                    bst.InOrderTraversal();
                else if(traversal.equalsIgnoreCase("Post"))
                    bst.PostOrderTraversal();
            }
            else if(dirrection.equalsIgnoreCase("D")){
                if(bst==null)
                    System.out.println("Empty Tree");
                else
                    bst.Delete(input.nextInt());
            }
        }
    }
}