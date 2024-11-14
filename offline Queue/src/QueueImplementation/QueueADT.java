package QueueImplementation;

public interface QueueADT<T> {
    public void Clear();
    public void Enqueue(T item);
    public T Dequeue();
    public int Length();
    public T FrontValue();
    public T RearValue();
    public T LeaveQueue();
}
