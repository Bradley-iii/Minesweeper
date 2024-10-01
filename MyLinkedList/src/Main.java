import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        myDoubleLinkedList<Integer> arr = new myDoubleLinkedList<>();
        for(int i = 0; i < 10; i++) {
            arr.add(i);
        }
        System.out.println(arr);
        System.out.println(arr.get(8)); // doesnt work on 9, null pointer exception



    }
}