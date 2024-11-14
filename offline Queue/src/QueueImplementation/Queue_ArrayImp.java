package QueueImplementation;

public class Queue_ArrayImp <T> implements QueueADT<T>{
    private int front;
    private int rear;
  //  private int length;
    private T[] array;
    private int size=10;
    public Queue_ArrayImp() {
        this.size = size+1;
        rear = 1; front = 2;
        array = (T[])new Object[this.size];
    }

    public Queue_ArrayImp(int size) {
        this.size = size+1;
        rear = 1; front = 2;
        array = (T[])new Object[this.size];
    }

    public Queue_ArrayImp(T[] arraPointer) {
        this.size = arraPointer.length;
        size--;
        rear = 1; front = 2;
        array =arraPointer;
    }

    @Override
    public void Clear() {
        rear = -1; front = 0;
        //length=0;
    }

    @Override
    public void Enqueue(T item) {
        if ((front-2+size) % size == rear) {
            //doubleSize
           // System.out.println("Size over");
            T[] temp=(T[])new Object[size+size-1];
            for(int i=1;i<size;i++){
                temp[i]=array[front];
                front=(front+1)%size;

            }
            rear=size-1;
            front=1;
            size*=2;
            size--;
            array=temp;

        }
        rear = (rear+1) % size; // Circular increment
        array[rear] = item;

 //       System.out.println(array[rear]);
        //length++;
    }

    @Override
    public T Dequeue() {
        if ((rear+1) % size == front) {
            //null
            return null;
        }
        T ret = array[front];
        front = (front+1) % size; // Circular increment
//        length--;
        return ret;
    }

    @Override
    public int Length() {
        return (rear+size-front+1)%size;
    }

    @Override
    public T FrontValue() {
        T ret=null;
        if(((rear+1) % size != front))
            ret=array[front];
        return ret;
    }

    @Override
    public T RearValue() {
        T ret=null;
        if(((rear+1) % size != front))
            ret=array[rear];
        return ret;
    }

    @Override
    public T LeaveQueue() {
        T ret=null;
        if(((rear+1) % size != front)){
            ret=array[rear];
            rear = (rear+size-1) % size;
        }
        return ret;
    }
}