package LinkedList1;

import java.util.Scanner;

class Node{
    int data;
    Node next;
    Node prev;

    Node(int data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}
class DoublyLinkedList {

    Node head;
    Node tail;
    DoublyLinkedList(){
        this.head = null;
        this.tail = null;
    }

    //Insert at Head
   public void insertAtHead(int data){
    Node newNode = new Node(data);
        if(head == null){
            head=tail= newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
   }   

   //Inserting at last or tail
   public void insertAtTail(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void insertAtPosition(int position, int data){
        
        if(position == 1){
            insertAtHead(data);
            return;
        }
        Node temp = head;
        for(int i = 1; i<position - 1 && temp != null; i++){
            temp = temp.next;
        }
        if(temp == null){
            System.out.println("Position out of Bound: ");
            return;
        }
        if(temp == tail){
            insertAtTail(data);
            return;
        }
        Node newNode = new Node(data);
        newNode.next = temp.next;
        newNode.prev = temp;
        temp.next.prev = newNode;
        temp.next = newNode;
    }

    //Display Method to display all Element of List
    public void displayForward(){
        if(head == null){
            System.out.println("List is Empty : Nothing to display!");
            return;
        }
        Node temp = head;
        while(temp !=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
    }

    public void displayBackword(){
        Node temp = tail;
        while(temp != null){
            System.out.print(temp.data+" ");
            temp = temp.prev;
        }
    }

    public void deleteFromHead(){
        if(head == null){
            System.out.println("List is empty:  Nothing to delete !");
            return;
        }
        if(head == tail){
            head = null;
            tail = null;
            return;
        }
        head = head.next;
        head.prev = null;        
    }

    public void deleteFromTail(){
        if(head == null){
            System.out.println("List is empty:  Nothing to delete !");
            return;
        }
        if(head == tail){
            head = null;
            tail = null;
            return;
        }

        Node temp = head;
        while(temp != tail){
            temp = temp.next;
        }
        tail = tail.prev;
        tail.next = null;
    }

    public void deleteByValue(int value){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        while(temp != null && temp.data != value){
            temp = temp.next;
        }
        if(temp == null){
            System.out.println("Value Not Found: ");
        }
        else if(temp == head){
            deleteFromHead();
        }
        else if(temp == tail){
            deleteFromTail();
        }else{
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }


    public void deleteByIndex(int position){
        if(head == null){
            System.out.println("List is empty");
            return;
        }
        Node temp = head;
        for(int i=0; i<position && temp!= null; i++){
            temp = temp.next;
        }
        if(temp == head){
           deleteFromHead();
           return;
        }else if(temp == tail){
            deleteFromTail();
            return; 
        }else{
            temp.prev.next = temp.next;
            temp.next.prev = temp.prev;
        }
    }

    public void reverseList(){
        if(head == null || head.next == null){
            return;
        }
        Node current  = head;
        Node temp = null;
        while(current != null){
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current  = current.prev;
        }

        if(temp != null){
            head = temp.prev;
        }

    }

    public void countElement(){
        int count =0;
        if(head == null){
            System.out.println("List is empty : ");
            return;
        }

        Node temp = head;
        while(temp != null){
            count ++;
            temp = temp.next;
        }
        System.out.println("Number of Element : "+count);
    }

    public void serachByValue(int data){
        if(head == null){
            System.out.println("List is empty: ");
            return;
        }
        Node temp = head;
        while(temp != null){
            if(temp.data == data){
                System.out.println("Element Found");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Element not found ");
    }

}

public class DoublyLinkedListMain{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoublyLinkedList list = new DoublyLinkedList();
        boolean bool = true;

        list.insertAtTail(20);
        list.insertAtHead(10);
        list.insertAtTail(30);
        list.insertAtTail(40);
        list.insertAtTail(50);

        while(bool){
            System.out.println("---------------------Doubly Linked List Operations :------------------ ");
            System.out.println("1.Insert At Head\n2.Insert At tail\n3.Display Forward\n4.Display backword\n5.Add by position\n6.Delete From Head\n7.Delete From tail\n8.Delete by value\n9.Delete by indexs\n10.Reverse Linked list\n11.Count Element\n12.Search by value\n13.Exit");
            System.out.println("Enter Your choice: ");
            int ch  = sc.nextInt();
            switch(ch){
                case 1:
                    System.out.println("Enter value to insert: ");
                    int value = sc.nextInt();
                    list.insertAtHead(value);
                    break;
            

                case 2: 
                    System.out.println("Enter Value to insert: ");
                    int value1 = sc.nextInt();
                    list.insertAtTail(value1);
                    break;
            
                case 3: 
                    list.displayForward();
                    break;
                
                case 4:
                    list.displayBackword();
                    break;

                case 5:
                    System.out.println("Enter position where you want to insert: ");
                    int position = sc.nextInt();
                    System.out.println("Enter data to insert: ");
                    int data = sc.nextInt();
                    list.insertAtPosition(position, data);
                    break;

                case 6:
                    list.deleteFromHead();
                    break;
                
                case 7:
                    list.deleteFromTail();
                    break;
                
                case 8:
                    System.out.println("Enter value to delete: ");
                    int val = sc.nextInt();
                    list.deleteByValue(val);
                    break;
                
                case 9:
                    System.out.println("Enter index to delete: ");
                    int index = sc.nextInt();
                    list.deleteByIndex(index);
                    break;
            
                case 10:
                    list.reverseList();
                    break; 
                
                case 11:
                    list.countElement();
                    break;
                
                case 12:
                    System.out.println("Enter value to search : ");
                    list.serachByValue(sc.nextInt());
                    break;

                case 13:
                    bool = false;
                    System.out.println("Exiting..............");
                    break;
                    
                
            }
        }
    }
}
