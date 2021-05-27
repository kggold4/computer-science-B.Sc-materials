package practice_hashtable;

public class HashNode {

    Integer id;
    Student student;

    // constructor
    public HashNode(Integer id, Student student) {
        this.id = id;
        this.student = student;
    }

    public String toString() { return "id: " + this.id + ", name: " + this.student.name; }
}