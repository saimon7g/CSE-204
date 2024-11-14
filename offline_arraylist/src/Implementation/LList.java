package Implementation;

public class LList <T> implements ListADT<T> {
    private Item<T> head;
    private Item<T> tail;
    private Item<T> curr;
    private int size;
    private int length=0;


    public LList(int size) {
        this();
        //do nothing
    }
    public LList() {
        curr=head=tail= new Item<T>(null);
        this.size=0;
    }


    public int Clear() {
        curr=head=tail= new Item<T>(null);
        length=0;
        return -1;
    }
    public int Insert(T it) {
        Item temp= new Item(it,curr.getNext());
        curr.setNext(temp);
        if(curr==tail)
            tail=curr.getNext();
        length++;
        return -1;
    }
    public int Append(T it) {
        Item temp= new Item(it,null);
        tail.setNext(temp);
        tail=temp;
        length++;
        return -1;
    }
    public T Remove() {
        T temp= curr.getNext().getElement();
        curr.setNext(curr.getNext().getNext());
        length--;
        return temp;
    }
    public int MoveToStart() {
        curr=head;
        return -1;
    }
    public int MoveToEnd() {
        Item temp=head;
        while (temp.getNext() != tail){
            temp=temp.getNext();
           //System.out.println("8908900");
        }
          curr=temp;
        return -1;
    }
    public int Prev() {
        if(curr==head){
            return -1;
        }
        Item temp=head;
        while (temp.getNext() != curr){
            temp=temp.getNext();
        }
        curr=temp;
        return -1;
    }
    public int Next() {
        if(curr.getNext() != tail)
            curr=curr.getNext();
        return -1;
    }
    public int Length() {
        int i=0;
        Item temp=head;
        while (temp != tail){
            temp=temp.getNext();
            i++;
        }
        return i;
    }
    public int CurrPos() {
        int i=0;
        Item temp=head;
        while (temp != curr){
            temp=temp.getNext();
            i++;
        }
        return i;
    }
    public int MoveToPos(Integer tar) {
        if(tar>=length && tar<0)
            return -1;
        Item temp=head;
        int i=0;
        while(i<tar){
            temp=temp.getNext();
            i++;
        }
        curr=temp;
        return -1;
    }
    public T GetValue() {
        T temp=null;
        if(curr==tail){
        }
        else{
            temp= curr.getNext().getElement();
        }
        return temp;
    }
    public int Search(T comp) {
        int i=0;
        Item temp=head;
        while (temp!=tail){
            if(temp.getNext().getElement().equals(comp))
                return i;
            temp=temp.getNext();
            i++;
        }
        return -1;
    }
}