package Implementation;

import Implementation.LList;
import Implementation.ListADT;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {

        Scanner input= new Scanner(System.in);

        int length= input.nextInt();
        int size= input.nextInt();

        //Implementation.ListADT<Integer> list= new Implementation.Array(size);
        ListADT<Integer> list= new LList(size);

        for(int i=0;i<length;i++)
            list.Append(input.nextInt());
        Print(list);

        while (true){
            int instruction=input.nextInt();
            int value=input.nextInt();
            if(instruction==0)
                break;
            else if(instruction==1){
                System.out.println(list.Clear());
            }
            else if(instruction==2){
                int x= list.Insert(value);
                Print(list);
                System.out.println(x);
            }
            else if(instruction==3){
                int x=list.Append(value);
                Print(list);
                System.out.println(x);
            }
            else if(instruction==4){
               Integer x =list.Remove();
                Print(list);
                System.out.println(x);
            }
            else if(instruction==5){
                int x=list.MoveToStart();
                Print(list);
                System.out.println(x);
            }
            else if(instruction==6){
                int x=list.MoveToEnd();
                Print(list);
                System.out.println(x);
            }
            else if(instruction==7){
                int x=list.Prev();
                Print(list);
                System.out.println(x);
            }
            else if(instruction==8){
                int x=list.Next();
                Print(list);
                System.out.println(x);
            }
            else if(instruction==9){
                int x=list.Length();
                Print(list);
                System.out.println(x);
            }
            else if(instruction==10){
                int x=list.CurrPos();
                Print(list);
                System.out.println(x);
            }
            else if(instruction==11){
                try {
                    Integer i = value;
                }catch (Exception e){

                }
                int x=list.MoveToPos(value);
                Print(list);
                System.out.println(x);
            }
            else if(instruction==12){
               Integer x= list.GetValue();
                Print(list);
                System.out.println(x);
            }
            else if(instruction==13){
                System.out.println(list.Search(value));
            }
        }
    }

    public static void Print(ListADT<Integer> list) {
        int l=list.Length();
        int currentpos =list.CurrPos();
        list.MoveToStart();
        System.out.print("<");
        for (int i = 0; i < l; i++) {
            if (i == currentpos){
                System.out.print("|");
            }
            System.out.print(list.GetValue() + " ");
            list.Next();
        }
        System.out.print(">");
        System.out.println();
        list.MoveToPos(currentpos);
    }
}