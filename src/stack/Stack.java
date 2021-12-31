package stack;

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

class StackOperations {

    Node head;
    Node temp;
    int counter;

    void push(int data) {
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

    void pop() {
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

    public void emptyTheStack() {
        if (head == null)
            System.out.println("List Empty");
        else if (head.getNext() == null) {
            System.out.println(head.getData() + " Removed...");
            head = null;
            counter--;
        }else {
            Node temp = head;
            while ( head != null ) {
                Node newTemp = temp;
                if( newTemp.getNext() != null ){
                    newTemp = temp.getNext();
                }
                System.out.println(newTemp.getData());
                pop();
                counter--;
            }
        }
    }

    void printStack(){
        temp = head;
        while ( temp != null ){
            System.out.print(temp.getData() + " -> ");
            temp = temp.getNext();
        }
    }

}

public class Stack{
    static Scanner obj = new Scanner(System.in);
    static StackOperations sto = new StackOperations();
    public static void main(String[] args) {
        int option = 0;
        while(option != 7){
            option = menu();
            switch (option){
                case 1:
                    System.out.println("enter data");
                    sto.push(obj.nextInt());
                    sto.printStack();
                    break;
                case 2:
                    sto.pop();
                    sto.printStack();
                    break;
                case 3:
                    sto.emptyTheStack();
                    sto.printStack();
                    break;
            }
        }
    }
    public static int menu(){
        System.out.println("Press" +
                "\n 1) Add item at first" +
                "\n 2) Remove item at last" +
                "\n 3) Empty the stack" +
                "\n 4) quit"
        );
        return obj.nextInt();

    }

}

