package Stackimplementation;

import java.util.Scanner;

public class TestMain {
    public static void main(String[] args) {

        Scanner input= new Scanner(System.in);

        int size=input.nextInt();

        //StackADT<Integer> stackArr= new ArrBasedStack<>(size);
        StackADT<Integer> stackArr= new LLBasedStack<>();
        for(int i=0;i<size;i++){
            stackArr.Push(input.nextInt());
        }

        PrintStack(stackArr);

        while(true){
            int input1=input.nextInt();
            int input2=input.nextInt();
            if(input1==0)
                break;
            else if(input1==1)
                stackArr.Clear();
            else if(input1==2)
                stackArr.Push(input2);
            else if(input1==3)
                System.out.println(stackArr.Pop());
            else if(input1==4)
                System.out.println(stackArr.Length());
            else if(input1==5)
                System.out.println(stackArr.TopValue());
            else if(input1==6)
                stackArr.SetDirection(input2);
            PrintStack(stackArr);
        }
    }

    private static void PrintStack(StackADT<Integer> stackArr) {
        StackADT<Integer> temp=new LLBasedStack<>();
        while(stackArr.TopValue()!=null)
            temp.Push(stackArr.Pop());
        while(temp.TopValue()!=null){
            Integer tempItem=temp.Pop();
            System.out.print(tempItem + " ");
            stackArr.Push(tempItem);
        }
        System.out.println();
    }
}