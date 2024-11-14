package QueueImplementation;

public class LLitem<T> {

        private T element;
        private LLitem next;

        public LLitem(T element, LLitem <T> next) {
            this.element=element;
            this.next=next;
        }
        public LLitem(LLitem <T> next){
            this.next=next;
        }

        public T getElement() {
            return element;
        }
        public LLitem<T> getNext() {
            return next;
        }
        public void setElement(T element) {
            this.element = element;
        }
        public void setNext(LLitem next) {
            this.next = next;
        }
}
