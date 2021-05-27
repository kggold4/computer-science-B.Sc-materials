public class LinkedListPoint {
	
	public Node head, tail;
	private int size;
	
	//empty constructor
	public LinkedListPoint() {
		this.head = this.tail = null;
		this.size = 0;
	}

	//regular constructor
	public LinkedListPoint(Node next, Point p) {
		this.head = new Node(null, p);
	}
	
	public void add(Point p) {

		//if list is empty
        if(this.isEmpty()) {
            this.head = this.tail = new Node(null, p);

        //if list is not empty
        } else {
            Node n = new Node(null, p);
            this.tail.setNext(n);
            this.tail = n;
		}
		
		//this.sort();
        this.size++;
	}

	public void remove(Point p) {

        //if list is empty
        if(this.isEmpty()) {
            System.out.println(p + " the list is empty");
        
        //if remove the head
        } else if(this.head.getData().equals(p)) {
            this.head = this.head.getNext();
            this.size--;
        
        //remove the middle or the last element
        } else {
            Node prev = this.head, temp = this.head;
            while(temp.getNext() != null && !temp.getData().equals(p)) {
                prev = temp;
                temp = temp.getNext();
            }

            //remove the last element
            if(temp.getNext() == null && temp.getData().equals(p)) {
                prev.setNext(null);
                tail = prev;
                this.size--;

            //remove the middle item
            } else if(temp.getNext() != null) {
                prev.setNext(temp.getNext());
                this.size--;
            }
		}
		
		while(this.contains(p)) remove(p);
	}
	
	public int size() {
		return this.size;
	}
	
	
	public boolean contains(Point p) {
		boolean isIn = false;

        for(Node n = this.head; n != null; n = n.getNext()) {
            if(n.getData().equals(p)) {
                isIn = true;
            }
        }

        return isIn; 
	}

	public boolean isEmpty() {
		return this.head == null;
	}

	public void sort() {
		//create middle point for calculate distance with other points
		Point m = new Point();

		for(Node n = this.head; n != null; n = n.getNext()) {
			for(Node k = this.head; k.getNext() != null; k = k.getNext()) {
				Node l = k;
				if(l.getData().distance(m) > l.getNext().getData().distance(m)) {

					System.out.println(l);
					//swap
					Node temp = l;
					l = l.getNext();
					l.setNext(temp);
				}
			}
		}
	}
	
	@Override
	public String toString() {
		String s="";
		Node t=head;
		while(t!=null) {
			s+=" "+t.toString();
			t=t.getNext();
		}
		return "LinkedListPoint ["+s+"]";
	}
	
	
	public static void main(String[] args) {
		Point p1 = new Point(1,0);
		Point p2 = new Point(2,0);
		Point p3 = new Point(3,0);
		Point p4 = new Point(4,0);
		Point p5 = new Point(5,0);
		Point p6 = new Point(6,0);
		LinkedListPoint ll= new LinkedListPoint();
		ll.add(p2);
		ll.add(p1);
		ll.add(p3);
		ll.add(p5);
		ll.add(p4);
		System.out.println("after adding 5 points: "+ ll);
		System.out.println("list size: " +ll.size());
		System.out.println("does the list contains p1? "+ ll.contains(p1));
		System.out.println("does the list contains p6? "+ ll.contains(p6));
		ll.remove(p1);
		ll.remove(p5);
		System.out.println("after removing  2 points: "+ ll);
		System.out.println("list size: " +ll.size());
	}

}