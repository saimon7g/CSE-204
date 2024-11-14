package QueueImplementation;

public class Queue_LLimp <T> implements QueueADT<T>{
    private LLitem<T> head;
    private LLitem<T> rear;


    public Queue_LLimp(int size) {
        this();
        //do nothing
    }
    public Queue_LLimp() {
        head=new LLitem<>(null);
    }

    @Override
    public void Clear() {
        head.setNext(null);
    }

    @Override
    public void Enqueue(T item) {
        if(head.getNext()==null){
            head.setNext(new LLitem(item,null));
            rear=head.getNext();
        }

        else{
            rear.setNext(new LLitem(item,null));
            rear=rear.getNext();
        }
    }

    @Override
    public T Dequeue() {
        if(head.getNext()!=null){
            T item=head.getNext().getElement();
            head.setNext(head.getNext().getNext());
            return item;
        }
        return null;
    }

    @Override
    public int Length() {
        int ret=0;
        LLitem tempP=head;
        while(tempP.getNext()!=null){
            tempP=tempP.getNext();
            ret++;
        }
        return ret;
    }

    @Override
    public T FrontValue() {
        if(head.getNext()!=null)
            return head.getNext().getElement();
        return null;
    }

    @Override
    public T RearValue() {
        if(head.getNext()!=null)
            return rear.getElement();
        return null;
    }

    @Override
    public T LeaveQueue() {
        if(head.getNext()!=null){
            T temp= rear.getElement();
            LLitem tempPoint=head;
            while(tempPoint.getNext()!=rear){
                tempPoint=tempPoint.getNext();
            }
            rear=tempPoint;
            rear.setNext(null);
            return temp;
        }
        return null;
    }
}
