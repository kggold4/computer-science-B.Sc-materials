package practice_hashtable;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class LinkedListHash {

    private LinkedList<HashNode>[] studentsArray;

    // constructor
    public LinkedListHash(int size) {
        this.studentsArray = new LinkedList[size];
        Arrays.fill(this.studentsArray, new LinkedList<HashNode>());
    }

    // copy constructor
    public LinkedListHash(LinkedListHash other) {
        this.studentsArray = new LinkedList[other.size()];
        for(int i = 0; i < other.size(); i++) {
            HashNode[] temp = (HashNode[]) Arrays.copyOf(other.studentsArray[i].toArray(), other.studentsArray[i].size());
            this.studentsArray[i] = (LinkedList<HashNode>) Arrays.asList(temp);
        }
    }

    public int size() { return this.studentsArray.length; }

    public Integer insert(int id, Student student) {
        int h = Hash(id);
        //check if id is already present
        if(get(id) != null) {
            for(int i = 0; i < this.studentsArray[h].size(); i++) {
                if(this.studentsArray[h].get(i).id.equals(id)) this.studentsArray[h].get(i).student = student;
            }
        } else this.studentsArray[h].add(new HashNode(id, student));

        return id;
    }

    public Student get(int id) {
        int h = Hash(id);
        for(int i = 0; i < this.size(); i++) {
            if(this.studentsArray[h].get(i).id.equals(id)) return this.studentsArray[h].get(i).student;
        }
        throw new NoSuchElementException("student cannot be found on the hash table");
    }

    public void remove(int id) {
        if(get(id) == null) return;
        int h = Hash(id);
        for(int i = 0; i < this.studentsArray[h].size(); i++) {
            if(this.studentsArray[h].get(i).id.equals(id)) this.studentsArray[h].remove(i);
        }
    }

    private int Hash(int x) { return x % this.size(); }

    public String toString() {
        String s = "";
        for(int i = 0; i < this.size(); i++) {
            s += i + ": ";
            for(int j = 0; j < this.studentsArray[j].size(); j++) {
                s += studentsArray[i].get(j).student + " -> ";
            }
            s += "null\n";
        }
        return s;
    }

    public static void main(String[] args) {
    }
}