package Implementation;

public interface ListADT<T> {
    public int Clear() ;
    public int Insert(T item);
    public int Append(T item);
    public T Remove();
    public int MoveToStart();
    public int MoveToEnd();
    public int Prev();
    public int Next();
    public int Length();
    public int CurrPos();
    public int MoveToPos(Integer i);
    public T GetValue();
    public int Search(T item);
}
