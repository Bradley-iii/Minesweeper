public class MyDoubleListNode<Type> {

    private Type data;
    private MyDoubleListNode<Type> next;
    private MyDoubleListNode<Type> prev;

    public MyDoubleListNode(Type data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }


    public MyDoubleListNode(Type data, MyDoubleListNode<Type> prev, MyDoubleListNode<Type> next) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }

    public Type getData() {
        return data;
    }


    public MyDoubleListNode<Type> getPrev() {
        return prev;
    }

    public void setData(Type data) {
        this.data = data;
    }

    public MyDoubleListNode<Type> getNext() {
        return next;
    }

    public void setNext(MyDoubleListNode<Type> next) {
        this.next = next;
    }

    public void setPrev(MyDoubleListNode<Type> prev) {
        this.prev = prev;
    }

    @Override
    public String toString() {


        return "MyDoubleListNode{ prev = " + prev.getData() + " , current = " + data + ", next = " + next.getData() + "}";


    }
}
