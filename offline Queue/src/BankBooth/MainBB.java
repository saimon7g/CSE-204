package BankBooth;

import QueueImplementation.QueueADT;
import QueueImplementation.Queue_ArrayImp;
import QueueImplementation.Queue_LLimp;

import java.util.Scanner;

public class MainBB {
    public static void main(String[] args) {

//        QueueADT<Integer> queue1= new Queue_LLimp<>();
//        QueueADT<Integer> queue2= new Queue_LLimp<>();
        QueueADT<Integer> queue1= new Queue_ArrayImp<>(10);
        QueueADT<Integer> queue2= new Queue_ArrayImp<>(10);

        Scanner input=new Scanner(System.in);
        int numOfCustomer=input.nextInt();
        int timer1=0;
        int timer2=0;
        for(int x=0;x<numOfCustomer;x++){
            int inTime=input.nextInt();
            int serviceTime=input.nextInt();

            if ((queue1.Length() < (queue2.Length() + 1) || queue1.Length()==0) && queue2.Length()!=0 && timer1<inTime)
                queue1.Enqueue(queue2.LeaveQueue());
            else if ((queue2.Length() < (queue1.Length() + 1) || queue2.Length()==0) && queue2.Length()!=0 && timer2<inTime)
                queue2.Enqueue(queue1.LeaveQueue());

            if(timer1<=inTime && queue1.Length()!=0){
                timer1+=queue1.Dequeue();
            }
            if(timer2<=inTime && queue2.Length()!=0){
                timer2+=queue2.Dequeue();
            }

            if(queue1.Length()<=queue2.Length() && timer1<=inTime){
               // System.out.println("inside if 1  -24");
                if(queue1.Length()==0)
                    timer1=inTime+serviceTime;
                else
                    queue1.Enqueue(serviceTime);
            }
            else if(timer1>inTime && (queue1.Length()+1)<=queue2.Length()){
             //   System.out.println("inside if 2  -31");
                    queue1.Enqueue(serviceTime);
            }
            else if(queue2.Length()<=queue1.Length() && timer2<=inTime){
            //    System.out.println("inside  else 3  -38");
                if(queue2.Length()==0 )
                    timer2=inTime+serviceTime;
                else
                    queue2.Enqueue(serviceTime);
            }
            else{
      //          System.out.println("inside if 1  -42");
                    queue2.Enqueue(serviceTime);
            }


//            System.out.println( "length 1 " + queue1.Length() +" length 2 " + queue2.Length());
            while(timer1<inTime || timer2<inTime) {
 //               System.out.println("inside while 1   -35");
                if (queue1.Length() < (queue2.Length() + 1) && queue2.Length()!=0)
                    queue1.Enqueue(queue2.LeaveQueue());
                if (queue2.Length() < (queue1.Length() + 1)&& queue1.Length()!=0)
                    queue2.Enqueue(queue1.LeaveQueue());
 //               System.out.println( "length 1 " + queue1.Length() +" length 2 " + queue2.Length());
                if(timer1<=timer2 && queue1.Length()!=0 ){
                    timer1+=queue1.Dequeue();
//                    System.out.println("inside timer  of q1   --57");
                }
                else if(timer2<timer1 && queue2.Length()!=0 ){
                    PrintQueue(queue2);
                    timer2+=queue2.Dequeue();
 //                   System.out.println("inside timer  of q2    -61");
                }
                if(queue1.Length()==0 || queue2.Length()==0)
                    break;
            }
        }

        while((queue1.Length()+queue2.Length())!=0) {
            if (queue1.Length() < (queue2.Length() + 1) || queue1.Length()==0)
                queue1.Enqueue(queue2.LeaveQueue());
            else if (queue2.Length() < (queue1.Length() + 1) || queue2.Length()==0)
                queue2.Enqueue(queue1.LeaveQueue());
            if (timer1<=timer2 && queue1.Length() != 0)
                timer1 += queue1.Dequeue();
            if (timer2<timer1 && queue2.Length() != 0)
                    timer2 += queue2.Dequeue();
        }
        System.out.println(" Booth one end time : "+ timer1 +" Booth two end time : "+  "   " +timer2);
    }

    private static void PrintQueue(QueueADT<Integer> queue) {
        int len=queue.Length();
        System.out.print("<");
        //System.out.println(len);
        for(int i=0;i<len;i++){
            int temp=queue.Dequeue();
            System.out.print(temp+", ");
            queue.Enqueue(temp);
        }
        System.out.println(">");
    }
}
