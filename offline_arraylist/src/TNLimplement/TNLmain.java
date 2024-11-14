package TNLimplement;

import Implementation.Array;
import Implementation.LList;
import Implementation.ListADT;

import java.util.Scanner;

public class TNLmain {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int size = input.nextInt();

        ListADT<Integer> rickshow= new LList(size);
        ListADT<Integer> bus= new LList(size);
        ListADT<Integer> train= new LList(size);

//        ListADT<Integer> rickshow= new Array(size);
//        ListADT<Integer> bus= new Array(size);
//        ListADT<Integer> train= new Array(size);



        for(int i=0;i<size;i++){
            rickshow.Append(i);
        }
        //System.out.println("98458+456");
        int busCount=input.nextInt();
        for(int i=0;i<size;i++)
            bus.Append(-1);
        for(int i=0;i<busCount;i++){
           int val=input.nextInt();
           bus.MoveToPos(val);
           bus.Remove();
           bus.Insert(val);
        }
        int trainCount=input.nextInt();
        for(int i=0;i<size;i++)
            train.Append(-1);
        for(int i=0;i<trainCount;i++){
            int val=input.nextInt();
            train.MoveToPos(val);
            train.Remove();
            train.Insert(val);
        }

        while(true){
            int task=input.nextInt();
            if(task==0)
                break;
            else if(task==1){
                performTask(rickshow,bus,train,size);
            }


        }
    }

    private static void performTask(ListADT<Integer> rickshow, ListADT<Integer> bus, ListADT<Integer> train,int size) {

        rickshow.MoveToStart();
        for(int i=0;i<size;i++){
            System.out.print(rickshow.GetValue());
            if(i!=size-1){
                System.out.print(",");
            }
            rickshow.Next();
        }
        System.out.println();

        bus.MoveToStart();
        for(int i=0;i<size;i++){
            if(bus.GetValue()!=-1) {
                System.out.print(bus.GetValue());
            }
            if(i!=size-1){
                System.out.print(",");
            }
            bus.Next();
        }
        System.out.println();

        train.MoveToStart();
        for(int i=0;i<size;i++){
            if(train.GetValue()!=-1)
            {
                System.out.print(train.GetValue());
            }
            if(i!=size-1){
                System.out.print(",");
            }
            train.Next();
        }
        System.out.println();

        rickshow.MoveToStart();
        bus.MoveToStart();
        train.MoveToStart();
    }
}