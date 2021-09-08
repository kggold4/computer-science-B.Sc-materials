package common;

public class Student {
    public boolean reqAccessibility;
    public String firstName;
    public String lastName;
    public int id;
    public int age;
    public Address address;
    public String toString() {
        return "ID: " + id + "\nName: " + firstName + " " + lastName + "\nAge: " + age + "\nAddress: " + address + "\n";
    }
}