package Stackimplementation;

import java.util.Objects;

public class ArrBasedStack <T> implements StackADT<T>{
    private int dir;
    private int top;
    private int CurrSize=10;
    private T[] array;
    private int size=10;

    public ArrBasedStack(int size,int length) {
        this.size = size;
        CurrSize=size;
        array=(T[])new Object[size];
        dir=1;
        top=-1;
    }
    public ArrBasedStack(int size) {
        this.size = size;
        CurrSize=size;
        array= (T[]) new Object[size];
        dir=1;
        top=-1;
    }
    public ArrBasedStack(T[] arrPointer,int dirr) {
        dir=dirr;
        array=arrPointer;
        size=arrPointer.length;
        //System.out.println(size +" "+ dir);
        CurrSize=size;
        if(dirr==1)
            top=-1;
        else
            top=size;
    }

    @Override
    public void Clear() {
        if(dir==1){
            top=-1;
        }
        else
            top=CurrSize;
    }

    @Override
    public void Push(T item) {
        if(dir==1){
            if((top+1)==CurrSize){
                T[] temp=(T[])new Object[CurrSize+size];
                for(int i=0;i<CurrSize;i++){
                    temp[i]=array[i];
                }
                array=temp;
                CurrSize+=size;
            }
            top++;
            array[top]=item;
        }
        else {
            if(top==0){
                T[] temp=(T[])new Object[CurrSize+size];
                for(int i=0;i<CurrSize;i++){
                temp[i+size]=array[i];
            }
                array=temp;
                CurrSize+=size;
                top=size;
            }
            top--;
            array[top]=item;
        }
    }

    @Override
    public T Pop() {
        T temp=null;
        if(dir==1 && top!=-1){
            temp=array[top];
            top--;
        }
        else if(dir==-1 && top!=CurrSize){
            temp=array[top];
            top++;
        }
        return temp;
    }

    @Override
    public int Length() {
        int ret=-1;
        if(dir==1){
            ret=top+1;
        }
        else ret=CurrSize-top;
        return ret;
    }

    @Override
    public T TopValue() {
        if(top!=-1 && top!=CurrSize)
            return array[top];
        return null;
    }

    @Override
    public void SetDirection(int dir) {
        if(Length()==0){
           if(dir==1){
               this.dir=dir;
               top=-1;
           }
           else{
               this.dir=dir;
               top=CurrSize;
           }
        }
    }
}
