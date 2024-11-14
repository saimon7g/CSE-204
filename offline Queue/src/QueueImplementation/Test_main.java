package QueueImplementation;

import java.util.Scanner;

public class Test_main {
    public static void main(String[] args) {

        Scanner input= new Scanner(System.in);

        int len=input.nextInt();

        QueueADT<Integer> queueArr= new Queue_ArrayImp<>();
        //QueueADT<Integer> queueArr= new Queue_LLimp<>();
        //System.out.println(queueArr.Length());
        for(int i=0;i<len;i++){
            queueArr.Enqueue(input.nextInt());
        }
        PrintQueue(queueArr);
        while(true){
            int input1=input.nextInt();
            int input2=input.nextInt();
            if(input1==0)
                break;
            else if(input1==1)
                queueArr.Clear();
            else if(input1==2)
                queueArr.Enqueue(input2);
            else if(input1==3)
                System.out.println(queueArr.Dequeue());
            else if(input1==4)
                System.out.println(queueArr.Length());
            else if(input1==5)
                System.out.println(queueArr.FrontValue());
            else if(input1==6)
                System.out.println(queueArr.RearValue());
            else if(input1==7)
                System.out.println(queueArr.LeaveQueue());
            else
                ;
            PrintQueue(queueArr);
        }
    }

    private static void PrintQueue(QueueADT<Integer> queueArr) {
        int len=queueArr.Length();
        System.out.print("<");
        //System.out.println(len);
        for(int i=0;i<len;i++){
            int temp=queueArr.Dequeue();
            System.out.print(temp+", ");
            queueArr.Enqueue(temp);
        }
        System.out.println(">");
    }
}
