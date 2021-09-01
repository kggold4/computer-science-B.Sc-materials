package common;

public class Address {
    public String street;
    public String city;
    public String zip;
    public String toString() {
        return street + " " + city + " " + zip;
    }
}