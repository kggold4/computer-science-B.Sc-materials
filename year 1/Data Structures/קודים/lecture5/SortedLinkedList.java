package lecture5;

public class SortedLinkedList {

    private Node head;
    private int size;

    //constructor
    public SortedLinkedList() {
        this.head = null;
        this.size = 0;
    }

    //adding element
    public void add(Integer data) {
        //if list is empty
        if(this.empty()) {
            this.head = new Node(data, null);

        //if list only have head
        } else if(data < this.head.data) {
            Node n = new Node(data, head);
            this.head = n;

        //find place
        } else {
            Node n = this.head.next, prev = this.head;
            while(n != null && n.data < data) {
                prev = n;
                n = n.next;
            }
            prev.next = new Node(data, n);
        }
            
        size++;
    }

    //remove element
    public Integer remove(Integer data) {
        //answer the data of the element that removed
        Integer ans = null;

        //if list is empty
        if(this.empty()) ans = null;

        //if remove the first element
        else if(this.head.data.equals(data)) {
            ans = head.data;
            head = head.next;
            size--;

        //if remove other element
        } else {
            Node prev = this.head, n = this.head;
            while(n.next != null && !n.data.equals(data) && data > n.data) {
                prev = n;
                n = n.next;
                if(n.data.equals(data)) {
                    ans = n.data;
                    prev.next = n.next;
                    size--;
                    break;
                }
            }
        }

        return ans;
    }

    //contains method
    public boolean contains(Integer data) {
        boolean ans = true;
        Node n = this.head;
        while(n != null && !n.data.equals(data) && data > n.data){
            n = n.next;
        }
        if(n == null || data < n.data) ans = false;
        return ans;
    }
    
    //if the list is empty
    public boolean empty() {
        return (this.head == null || size == 0);
    }

    //get head method
    public Integer getHead() {
        return this.head.data;
    }
    
    //get size method
    public int size() {
        return this.size;
    }

    //to string method
    public String toString() {

        //if list is empty
        if(this.empty()) return "[]";

        //if list only have head
        else if(this.head.next == null) return "[" + this.head.data + "]";

        //if list have al least 2 elements
        else {
            String ans = "[";
            Node n = this.head;
            while(n != null) {
                ans += n.toString();
                if(n.next != null) ans += ", ";
                n = n.next;
            }
            return ans + "]";
        }
    }

    //print out using to string method
    public void print() {
        System.out.println("list: " + this);
    }
}