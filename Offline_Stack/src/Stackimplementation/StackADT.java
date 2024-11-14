package Stackimplementation;

public interface StackADT<T> {
    public void Clear();
    public void Push(T item);
    public T Pop();
    public int Length();
    public T TopValue();
    public void SetDirection(int dir);
}
