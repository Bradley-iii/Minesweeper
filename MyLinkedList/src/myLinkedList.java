

public class myLinkedList<Type> {

    private MyListNode<Type> front;
    private MyListNode<Type> end;
    private int size;


    public myLinkedList() {
        front = null;
        end = null;
        size = 0;
    }



    public void addToEnd(Type data) {
        if(front == null) {
            addToFront(data);
        } else {
            size++;
            MyListNode<Type> nodeToEnd = new MyListNode<>(data);
            end.setNext(nodeToEnd);
            end = nodeToEnd;
        }
    }

    public void add(Type data) {
        addToEnd(data);
    }


    /*
    public Type get(int index) {
        if(front == null) {
            throw new ArrayIndexOutOfBoundsException();
        }
        MyListNode<Type> curr = front;
        int c = 0;
        while(curr != null) {
            if(c != index) {
                curr = curr.getNext();
                c++;
            } else {
                return curr.getData();
            }
        }
        return null;
    }

     */

    public MyListNode<Type> get(int index) {
        if(front == null) {
            throw new ArrayIndexOutOfBoundsException();
        }
        MyListNode<Type> curr = front;
        int c = 0;
        while(curr != null) {
            if(c != index) {
                curr = curr.getNext();
                c++;
            } else {
                return curr;
            }
        }
        return null;
    }

    public Type remove(int index) {
        if(front == null) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if(index > size() - 1) {
            throw new IndexOutOfBoundsException();
        }

        MyListNode<Type> prev = null;
        MyListNode<Type> curr = front;
        MyListNode<Type> future = front.getNext();
        int c = 0;

        if(index == 0) {
            Type data = front.getData();
            front = future;
            return data;
        } // so that i don't loop

        while(c < index) {
                prev = curr;
                curr = curr.getNext();
                future = future.getNext();
                c++;
        } // loop and change my vars

        Type data = curr.getData();
        curr.setNext(null);
        if(prev != null) {
            prev.setNext(future);
        }

        return data;
    }






    public Type removeFront() {
        if(front == null) {
            throw new IndexOutOfBoundsException("LinkedList: attempt to remove from front on empty list");
        } else {
            Type data = front.getData();
            front = front.getNext();
            size--;
            return data;

        }
    }

    public Type removeEnd() { // i stole this from simon vo and i love it, simon cant fix it, i can lalallal
        if (front == null) {
            throw new IndexOutOfBoundsException("LinkedList: attempt to remove from end on empty list");
        } else {
            Type data = end.getData();
            MyListNode<Type> realCurrent = null;
            MyListNode<Type> prev = front;
            while (prev != null) {
                realCurrent = prev.getNext(); // way to get current
                if(prev == end) {
                    front = null;
                    end = null;
                    return data;
                }
                if (prev.getNext() == end) {
                    break;
                }
                prev = prev.getNext();
            }

            //System.out.println(realCurrent); // gets current
            end = prev;
            prev.setNext(null);
            size--;
            return data;
        }
    }

    public void addToFront(Type data) {
        // list is empty
        size++;
        if(front == null) {
            front = new MyListNode<Type>(data); // add data to front of list
            end = front; // end and front are now the same, only one thing in list
        } else // List is not empty
        {
            // create a new node to add
            MyListNode<Type> nodeToAdd = new MyListNode<Type>(data);
            // point node to front
            nodeToAdd.setNext(front);
            // change front to new node
            front = nodeToAdd;

            // draw it out, then code it, NEXT CLASS
        }



    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String output = "";

        MyListNode<Type> current = front;
        while (current != null) {
            output += current.getData() + " -> ";
            current = current.getNext();
        }
        output += "null";

        return output;

    }


}
