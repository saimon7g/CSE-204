package DishWasher;

import Stackimplementation.ArrBasedStack;
import Stackimplementation.LLBasedStack;
import Stackimplementation.StackADT;

import java.util.Scanner;

public class MainDishWash {
    public static void main(String[] args) {
        int washTimer=-1;

        Scanner input=new Scanner(System.in);

        int friendNum= input.nextInt();
        int dishNum= input.nextInt();

        int[] perDishWashTime= new int[dishNum];
        int[] friendArray= new int[friendNum];

        for(int i=0;i<dishNum;i++){
            perDishWashTime[i]=input.nextInt();
        }

        StackADT<Dish> dirtyStack = new ArrBasedStack<>(friendNum*dishNum);
        StackADT<Dish> cleanStack = new ArrBasedStack<>(friendNum*dishNum);
        StackADT<Integer> FullMenuComplete = new ArrBasedStack<>(friendNum);

//        StackADT<Dish> dirtyStack = new LLBasedStack<>(friendNum*dishNum);
//        StackADT<Dish> cleanStack = new LLBasedStack<>(friendNum*dishNum);
//        StackADT<Integer> FullMenuComplete = new LLBasedStack<>();

//        Dish[] oneArray2stack=new Dish[friendNum*dishNum];
//        StackADT<Dish> dirtyStack = new ArrBasedStack<>(oneArray2stack, 1);
//        StackADT<Dish> cleanStack = new ArrBasedStack<>(oneArray2stack, -1);
//        StackADT<Integer> FullMenuComplete = new ArrBasedStack<>(friendNum);


        while(true){

            int friend=input.nextInt();
            int pushTime=input.nextInt();
            int dishIndex=input.nextInt();

            if(friend==0)
                break;

            if(dishIndex>friendArray[friend-1]+1){
                System.out.println(" friend" + friend + "tried to break rules");
            }
            else{
                friendArray[friend-1]=dishIndex;
                if(dishIndex==dishNum)
                    FullMenuComplete.Push(friend);
            }

            Dish plate=new Dish(perDishWashTime[dishIndex-1]);

            if(dirtyStack.TopValue()==null && pushTime>washTimer){
                washTimer=pushTime-1;
                washTimer=washTimer+(perDishWashTime[dishIndex-1]);
                cleanStack.Push(new Dish(washTimer));
                //System.out.println("In 1st if "+ washTimer);
            }
            else if(washTimer==pushTime){
                washTimer+=perDishWashTime[dishIndex-1];
                cleanStack.Push(new Dish(washTimer));
                //System.out.println("In 2nd if "+ washTimer);
            }
            else if(washTimer>pushTime){
                dirtyStack.Push(plate);
               // System.out.println("In 3rd if "+ washTimer);
            }
            else{
                while(dirtyStack.TopValue()!=null && washTimer<pushTime){
                    Dish temp=dirtyStack.Pop();
                    washTimer+=temp.getTime();
                    cleanStack.Push(new Dish(washTimer));
                   // System.out.println("In 4th if "+ washTimer);
                }
                dirtyStack.Push(plate);
            }
            while(dirtyStack.TopValue()!=null && washTimer<pushTime){
                Dish temp=dirtyStack.Pop();
                if(washTimer<pushTime)
                    washTimer=pushTime-1;
                washTimer+=temp.getTime();
                cleanStack.Push(new Dish(washTimer));
                //System.out.println("outside ifff"+ washTimer);
            }
        }
        while(dirtyStack.TopValue()!=null){
            Dish temp=dirtyStack.Pop();
            washTimer+=temp.getTime();
            cleanStack.Push(new Dish(washTimer));
           // System.out.println("outside loop"+ washTimer);
        }


        System.out.println(washTimer);
        StackADT<Dish> temp1=new LLBasedStack<>();
        while (cleanStack.TopValue()!=null)
            temp1.Push(cleanStack.Pop());
        while(temp1.TopValue()!=null){
            Dish tempItem=temp1.Pop();
            System.out.print(tempItem.getTime()+", ");
            cleanStack.Push(tempItem);
        }
        System.out.println();

        boolean flag=true;
        for(int i=0;i<friendNum;i++){
            if(friendArray[i]!=dishNum)
                flag=false;
        }
        if(flag)
            System.out.println("Y");
        else
            System.out.println("N");

        while(FullMenuComplete.TopValue()!=null){
            System.out.print(FullMenuComplete.TopValue()+", ");
            FullMenuComplete.Pop();
        }
        System.out.println();
    }
}
