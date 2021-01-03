package practice_hashtable;

import java.util.Arrays;

public class LinearHash {

    private HashNode[] studentsArrays;
    private int size;

    // constructor
    public LinearHash(int length) {
        this.studentsArrays = new HashNode[length];
        Arrays.fill(this.studentsArrays, null);
        this.size = 0;
    }

    // deep copy constructor
    public LinearHash(LinearHash lh) {
        this.studentsArrays = new HashNode[lh.length()];
        for(int i = 0; i < this.length(); i++) {
            this.studentsArrays[i] = new HashNode(lh.studentsArrays[i].id, lh.studentsArrays[i].student);
        }
        this.size = lh.size;
    }

    // constructor from array - assume list array is full (no null objects)
    public LinearHash(HashNode[] list) {
        this.studentsArrays = new HashNode[list.length];
        this.studentsArrays = list;
        this.size = list.length;
    }

    // hashing function
    private int Hash(int x) { return x % this.length(); }

    // size
    public int size() { return this.size; }

    public int length() { return this.studentsArrays.length; }

    // inserting
    public int insert(int id, Student student) {

        int h = Hash(id);
        if(this.size == this.length() - 1) ensureCapacity();


        // place in array is empty - null
        if(this.studentsArrays[h] == null) {
            this.studentsArrays[h] = new HashNode(id, student);

        // place in array is taken
        } else {
            // search for empty place
            while(this.studentsArrays[h].equals(null)) {
                h++;
                if(h == this.length() - 1) h = 0;
            }
            // found new place
            this.studentsArrays[h] = new HashNode(id, student);
        }

        this.size++;

        return id;
    }

    private void ensureCapacity() {
        HashNode[] temp = new HashNode[this.length() * 2 + 1];
        for(int i = 0; i < this.length(); i++) {
            temp[i] = this.studentsArrays[i];
        }
        this.studentsArrays = temp;
    }

    public String toString() { return Arrays.toString(this.studentsArrays); }

    public void print() { System.out.println(this); }

    public static void main(String[] args) {
        Student s1 = new Student("kfir", 24);
        Student s2 = new Student("yosi", 20);
        Student s3 = new Student("amit", 19);
        Student s4 = new Student("dvir", 32);
        Student s5 = new Student("noa", 21);
        Student s6 = new Student("asher", 31);
        Student s7 = new Student("jackson", 17);
        Student s8 = new Student("holt", 26);
        Student s9 = new Student("emmy", 28);
        Student s10 = new Student("don", 27);

        LinearHash list = new LinearHash(10);
        list.print();
        list.insert(1,s1);
        list.print();
        list.insert(1,s2);
        list.print();
    }

}
