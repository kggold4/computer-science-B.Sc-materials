package lecture5;

public class LinkedListCycle {
    private NodeCycle head;
    private int size;

    //constructor
    public LinkedListCycle() {
        head = null;
        size = 0;
    }

    public void add(int data) {

        //if list is empty
        if(this.empty() && size == 0) {
            this.head = new NodeCycle(data, this.head);

        //if list only have head
        } else if(size == 1) {
            NodeCycle n = new NodeCycle(data, this.head);
            head.next = n;

        //if list have at least 2 items
        } else {
            NodeCycle n = new NodeCycle(data, this.head);
            NodeCycle t = this.head.next;
            while(t.next != this.head) t = t.next; //O(n)
            t.next = n;
        }

        //size + 1 after adding item
        this.size++;
    }

    public Integer remove(Integer data) {

        //answer
        Integer ans = null;

        //if list is empty
        if(this.empty()) ans = null;

        //if data is head data
        else if(this.head.data.equals(data)) {

            ans = this.head.data;

            //if list only have head
            if(size == 1) {
                this.head = null;
                
            //if list have at least 2 items and data equals to head data
            } else {

                NodeCycle t = this.head;
                this.head = this.head.next;
                NodeCycle n = this.head;
                
                while(n.next != t) {
                    n = n.next;
                }
                n.next = this.head;
            }

        this.size--;

        //if list have at least 2 items
        } else {
            NodeCycle prev = this.head, n = head.next;
            while(!n.data.equals(data)) {
                prev = n;
                n = n.next;
            }
            prev.next = n.next;
            this.size--;
            ans = n.data;
        }

        //return removed item data
        return ans;
    }

    public boolean contains(Integer data) {

        if(this.empty()) return false;
        else if(head.next == head) {
            if(head.data.equals(data)) return true;
            else return false;
        }

        NodeCycle n = this.head;
        while(n.next != this.head) {
            if(n.data.equals(data)) return true;
            n = n.next;
        }
        return false;
    }

    //get head method
    public Integer getHead() {
        if(this.empty()) return null;
        else return this.head.data;
    }

    //get size
    public int size() {
        return this.size;
    }

    //is empty method
    public boolean empty() {
        return (head == null);
    }

    //to string method
    public String toString() {

        if(this.empty()) return "[]";
        else if(this.size == 1) return "[" + this.getHead() + "]";

        String ans = "[";
        if(size > 1) ans += this.head.data + ", ";

        NodeCycle n = this.head.next;
        while(n != this.head) {
            ans += n.data;
            n = n.next;
            if(n != this.head) ans += ", ";
        }

        ans += "]";

        return ans;
    }

    public void print() {
        System.out.println(this.toString());
    }
}