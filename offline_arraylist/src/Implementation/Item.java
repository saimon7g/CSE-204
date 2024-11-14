package Implementation;

public class Item <T>{

    private T element;
    private Item next;

    public Item(T element, Item <T> next) {
        this.element=element;
        this.next=next;
    }
    public Item(Item <T> next){
        this.next=next;
    }

    public T getElement() {
        return element;
    }
    public Item<T> getNext() {
        return next;
    }
    public void setElement(T element) {
        this.element = element;
    }
    public void setNext(Item next) {
        this.next = next;
    }
}
