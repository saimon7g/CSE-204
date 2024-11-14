package Stackimplementation;

public class LLBasedStack<T> implements StackADT<T> {
    private LLitem<T> head;

    public LLBasedStack(int size) {
        this();
        //do nothing
    }
    public LLBasedStack() {
        head= new LLitem<>(null);
    }


    @Override
    public void Clear() {
        head.setNext(null);
    }

    @Override
    public void Push(T item) {
        LLitem temp= new LLitem(item,head.getNext());
        head.setNext(temp);
    }

    @Override
    public T Pop() {
        T temp=null;
        if(head.getNext()!=null) {
            temp = head.getNext().getElement();
            head.setNext(head.getNext().getNext());
        }
        return temp;
    }

    @Override
    public int Length() {
        int i=0;
        LLitem temp=head;
        while (temp.getNext()!=null){
            temp=temp.getNext();
            i++;
        }
        return i;
    }

    @Override
    public T TopValue() {
        if(head.getNext()!=null)
            return head.getNext().getElement();
        else
            return null;
    }

    @Override
    public void SetDirection(int dir) {
    }
}