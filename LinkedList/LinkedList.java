package LinkedList1;

import java.util.Scanner;

class Node{
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    } 
}
public class LinkedList{
    Node head;
    LinkedList(){
        this.head = null;
    }

    //Add Element into linkedlist
    public void addElement(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
    }

    // Add element at beginning
    public void addAtBeginning(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;       
    }

  //Add at specific position
    public void addAtPosition(int data, int position){
        if(position == 0){
            addAtBeginning(data);
            return ;
        }
        Node newNode = new Node(data);
        Node temp = head;
        for(int i=0; i<position-1 && temp != null; i++){
            temp = temp.next;
        }
        if(temp.next != null){
            newNode.next = temp.next;
            temp.next = newNode;
        }else{
            System.out.println("Invalid Position: ");
        }
    }


  //Search element by value
    public void search(int data){   
        if(head == null){
            System.out.println("List is Empty: ");
            return;
        }
        Node temp = head;
        while(temp != null){
            if(temp.data == data){
                 System.out.println("Element Found: ");
                 return;
            }
            temp = temp.next;
        }
        System.out.println("Element not Found: ");
    }

  //Delete element from beginning
    public void deleteFromBeginning(){
        if(head == null){
            System.out.println("List is already Empty: Nothing to delete! ");
            return;
        }
        System.out.println("Element Deleted Successfully: ");
        System.out.println("Deleted Element: "+head.data);
       head = head.next;
        return;
    }


  //Delete element from end 
    public void deleteFromEnd(){
        if(head == null){
            System.out.println("List is already Empty: Nothing to delete! ");
            return;
        }
        if(head.next == null){
            head = null;
            return;
        }
        Node temp = head;
        while(temp.next.next != null){
            temp = temp.next;
        }
        System.out.println("Deleted Element: "+ temp.next.data);
        temp.next = null;
    }



  // Delete element from specific position
    public void deleteFromPosition(int position){
       if(head == null){
            System.out.println("List is already Empty: Nothing to delete! ");
            return;
       }
       if(position == 0){
            head = head.next;
            return;
       }
       Node temp = head;
       for(int i=0; i<position-1 && temp != null; i++){
            temp = temp.next;
       }
       if(temp == null && temp.next == null){
            System.out.println("Position Out of Bonuds");
       }
       temp.next = temp.next.next;    
    }


  // Delete element by value 
    public void deleteByValue(int value){
       if(head == null){
            System.out.println("List is already Empty: Nothing to delete! ");
            return;
       }

       if(head.data == value){
            head = head.next;
            System.out.println("Element Deleted Successfully: ");
            return;
       }

       Node temp = head;
       while(temp != null && temp.next.data != value){
            temp = temp.next;
       }

       if(temp.next == null){
        System.out.println("Element not found : ");
        return;
       }
       temp.next = temp.next.next;
    }

  // Count number of element in linkedlist
    public void countElement(){
        if(head == null){
            System.out.println("List is empty: No element present!");
            return;
        }
        int count=0;
        Node temp = head;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        System.out.println("Number of elements : "+ count);
    }

  // Reverse the linked list
    public void reverseList(){
        Node prev = null;
        Node current = head;
        Node next = null;

        while(current != null){
            next = current.next;
            
            current.next = prev;

            prev = current;
            current = next;
        }
        head = prev;
        display();
    }

    //Display Element of linked list
    public void display(){
         if(head == null){
           System.out.println("List is Empty: ");
           return;
        }
        Node temp = head;
        System.out.println(" Linked List ");
        while(temp != null){
            System.out.print(temp.data+ " ");
            temp = temp.next;
        }
        System.out.println("\n----------------------------");
    }

//Main method
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        Scanner sc = new Scanner(System.in);
        //Insertion
        boolean bool = true;

        //manually adding some values to test
        list.addElement(10);
        list.addElement(20);
        list.addElement(30);
        list.addElement(40);
        list.addElement(50);

        while(bool){
            System.out.println("Linked List Operations: ");
            System.out.println("1.Add Element\n2.Display\n3.Add At Beginning\n4.Add at position\n5.Search by value\n6.Delete From Beginning\n7.Delete From end\n8.Delete By Position \n9.Delete by Value\n10. Count element\n11.Reverse List\n12.Exit ");
            System.out.println("Enter Your choice: ");
            System.out.println("------------");
            int choice  = sc.nextInt();
            switch(choice){
                case 1: 
                    System.out.println("Enter Element : ");
                    int data = sc.nextInt();
                    list.addElement(data);
                    break;
                
                case 2: 
                    list.display();
                    break;
                
                case 3: 
                    System.out.println("Enter element to insert at beginning: ");
                    int ele = sc.nextInt();
                    list.addAtBeginning(ele);
                    break;
                
                case 4:
                    System.out.println("Enter element to insert: ");
                    int num = sc.nextInt();
                    System.out.println("Enter Position where you want to insert: ");
                    int pos = sc.nextInt();
                    list.addAtPosition(num, pos);
                    break;

                case 5:
                    System.out.println("Enter value to search : ");
                    int value = sc.nextInt();
                    list.search(value);
                    break;
                
                case 6:
                    list.deleteFromBeginning();
                    break;
                
                case 7:
                    list.deleteFromEnd();
                    break;

                case 8:
                    System.out.println("Enter position to delete element: ");
                    int position = sc.nextInt();
                    list.deleteFromPosition(position);
                    break;

                case 9:
                    System.out.println("Enter value to delete: ");
                    int value1 = sc.nextInt();
                    list.deleteByValue(value1);
                    break;

                case 10: 
                    list.countElement();
                    break;

                case 11:
                    list.reverseList();
                    break;


                case 12:
                    bool = false;
                    System.exit(0);
                    break;              
            }
        }
    }
}
