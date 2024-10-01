public class MyListNode<Type> {

    private Type data;
    private MyListNode<Type> next;

    public MyListNode(Type data) {
        this.data = data;
        this.next = null;
    }

    public MyListNode(Type data, MyListNode<Type> next) {
        this.data = data;
        this.next = next;
    }

    public Type getData() {
        return data;
    }



    public void setData(Type data) {
        this.data = data;
    }

    public MyListNode<Type> getNext() {
        return next;
    }

    public void setNext(MyListNode<Type> next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "MyListNode{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }


}
