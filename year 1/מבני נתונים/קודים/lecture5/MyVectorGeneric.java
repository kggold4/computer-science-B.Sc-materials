package lecture5;

//generic class:
public class MyVectorGeneric<T> {

    private int size;
    private final int INTI_SIZE = 10;
    private T[] data;

    //constructor
    @SuppressWarnings("unckecked")
    public MyVectorGeneric() {
        this.size = 0;
        data = (T[])(new Object[INTI_SIZE]);
    }

    //adding method
    public void add(T value) {
        if(size == data.length) resize();
        data[size++] = value;
    }

    //resize data
    @SuppressWarnings("unckecked")
    private void resize() {
        T[] temp = (T[])(new Object[this.data.length + INTI_SIZE]);
        for(int i = 0; i < this.data.length; i++) {
            temp[i] = this.data[i];
        }
        this.data = temp;
    }

    //get size
    public int size() {
        return this.size;
    }

    //get element by index
    public T elementAt(int i) {
        return this.data[i];
    }

    //get data capacity
    public int capacity() {
        return this.data.length;
    }

    //to string method
    public String toString() {
        if(size == 0) return "[]";
        else {
            String str = "[";
            for(int i = 0; i < this.size; i ++) {
                str += data[i];
                if(i != size - 1) str += ", ";
            }
            str += "]";
            return str;
        }
    }

    //only print method
    public void print() {
        System.out.println("list: " + this);
    }

    public static void main(String[] args) {

        MyVectorGeneric<Object> list = new MyVectorGeneric<Object>();
        list.print();
        list.add("ad");
        list.print();
        list.add("fh");
        list.add(15);
        list.add(3.14);
        list.print();
        System.out.println(list.elementAt(1));

    }
}