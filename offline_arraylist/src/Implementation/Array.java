package Implementation;

public class Array<T> implements ListADT<T> {
    private T []list;
    private int length=0;
    private int initSize;
    private int size;
    private int currPos=0;



    public Array(int size ){
        this.size=size;
        initSize=size;
        list=(T[])new Object[size];
    }
    public Array(int size,int length ){
        this.size=size;
        initSize=size;
        this.length=length;
        list=(T[])new Object[size];
    }
    public Array( int size, T[] objarray){
        this.size=size;
        initSize=size;
        list= objarray;
    }





    public int Clear() {
        length=0;
        currPos=0;
        return -1;
    }
    public int Insert(T item) {
        if(length==size)
            expand();
        for(int i=length;i>currPos;i--){
            list[i]=list[i-1];
        }
        length++;
        list[currPos]= item;
        return -1;
    }
     public int Append(T item) {
        if(length==size)
            expand();
        list[length]=item;
        length++;
        return -1;
    }
    public T Remove() {
        T temp=list[currPos];
        for(int i=currPos;i<length-1;i++)
            list[i]=list[i+1];
        length--;
        return temp;
    }
    public int MoveToStart(){
        currPos=0;
        return -1;
    }
    public int MoveToEnd(){
        currPos=(length-1);
        return -1;
    }
    public int Prev(){
        if(currPos!=0)
            currPos--;
        return -1;
    }
    public int Next(){
        if(currPos!=(length-1))
        {currPos++;}
        return -1;
    }
    public int Length(){
        return length;
    }
    public int CurrPos(){
        return currPos;
    }
    public int MoveToPos(Integer i){
        if( currPos>=0 && currPos<length)
            currPos=i;
        return -1;
    }
    public T GetValue(){
        return list[currPos];
    }
    public int Search(T item){
        for(int i=0;i<length;i++) {
            if (list[i].equals(item))
                return i;
        }
        return -1;
    }




    private void expand(){
        T []tempList=(T[])new Object[size+initSize];
        for(int i=0;i<length;i++){
            tempList[i]=list[i];
        }
        list=tempList;
    }
}
