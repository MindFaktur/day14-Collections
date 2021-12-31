import java.util.Scanner;

class Node{
    private int data;
    private Node next;

    public Node(int data){
        this.data = data;
        this.next = null;
    }

    public int getData(){
        return data;
    }
    public void setData(int data){
        this.data = data;
    }
    public Node getNext(){
        return next;
    }
    public void setNext(Node item){
        this.next = item;
    }


}

class LinkedListOperations {

    Node head;
    Node temp;
    int counter;

    void addFirst(int data) {
        Node newNode = new Node(data);
        if( head == null ){
            System.out.println("List is empty given data will be the only item");
            head = newNode;
        }else {
            newNode.setNext(head);
            head = newNode;
        }
        counter++;
    }

    public void removeFirst() {
        if (head == null)
            System.out.println("List Empty");
        else if (head.getNext() == null) {
            System.out.println(head.getData() + " Removed...");
            head = null;
            counter--;
        } else {
            Node temp = head;
            System.out.println(temp.getData() + " Removed...");
            head = head.getNext();
            temp.setNext(null);
            counter--;
        }
    }

    public void removeLast() {
        if (head == null)
            System.out.println("List Empty");
        else if (head.getNext() == null) {
            System.out.println(head.getData() + " Removed...");
            head = null;
            counter--;
        } else {
            Node temp = head;
            Node prev = head;
            while (temp.getNext() != null) {
                prev = temp;
                temp = temp.getNext();
            }
            System.out.println(temp.getData() + " Removed...");
            prev.setNext(null);
            counter--;
        }
    }

    public void removeNthPos(int pos) {
        int countNode = 0;
        if (head == null)
            System.out.println("List Empty");
        else if (head.getNext() == null) {
            System.out.println(head.getData() + " Removed...");
            head = null;
            counter--;
        } else if (pos < 0 || pos > counter) {
            System.out.println("Invalid Position");
        } else if (pos - 1 == 0) {
            removeFirst();
        } else {
            Node prev = head;
            Node temp = head;
            while (countNode < pos - 1) {
                prev = temp;
                temp = temp.getNext();
                countNode++;
            }
            System.out.println(temp.getData() + " Removed...");
            prev.setNext(temp.getNext());
            temp.setNext(null);
            counter--;
        }
    }


    void addLast(int data){
        Node newNode = new Node(data);
        if( head == null ){
            System.out.println("List is empty, given data will be the only item");
            head = newNode;
        }else {
            temp = head;
            while ( temp.getNext() != null ){
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
        counter++;
    }
    void nthPosition(int data, int pos){
        Node newNode = new Node(data);
        if( head == null ){
            System.out.println("List is empty, given item will be the only item");
            head = newNode;
        } else if (pos < 0 || pos > counter) {
            System.out.println("Invalid Position");
        } else if (pos - 1 == 0) {
            addFirst(data);
        }else{
            int countNode = 0;
            temp = head;
            Node prev = temp;
            while( countNode < pos-1 ){
                prev = temp;
                temp = temp.getNext();
                countNode++;
            }
            prev.setNext(newNode);
            newNode.setNext(temp);
        }
        counter++;
    }
    void printList(){
        temp = head;
        while ( temp != null ){
            System.out.print(temp.getData() + " -> ");
            temp = temp.getNext();
        }
    }

}

public class LinkedListExample{
    static Scanner obj = new Scanner(System.in);
    static LinkedListOperations llo = new LinkedListOperations();
    public static void main(String[] args) {
        int option = 0;
        while(option != 7){
            option = menu();
            switch (option){
                case 1:
                    System.out.println("enter data");
                    llo.addFirst(obj.nextInt());
                    llo.printList();
                    break;
                case 2:
                    System.out.println("enter data");
                    llo.addLast(obj.nextInt());
                    llo.printList();
                    break;
                case 3:
                    System.out.println("enter data");
                    int newData = obj.nextInt();
                    System.out.println("enter position");
                    int position = obj.nextInt();
                    llo.nthPosition(newData,position);
                    llo.printList();
                    break;
                case 4:
                    llo.removeFirst();
                    llo.printList();
                    break;
                case 5:
                    llo.removeLast();
                    llo.printList();
                    break;
                case 6:
                    System.out.println("enter position");
                    int pos = obj.nextInt();
                    llo.removeNthPos(pos);
                    llo.printList();
                    break;

            }
        }
    }
    public static int menu(){
        System.out.println("Press" +
                "\n 1) Add item at first" +
                "\n 2) Add item at last" +
                "\n 3) Add item at nth position" +
                "\n 4) Remove item at first" +
                "\n 5) Remove item at last" +
                "\n 6) Remove item at nth position" +
                "\n 7) quit"
                );
        return obj.nextInt();

    }

}

