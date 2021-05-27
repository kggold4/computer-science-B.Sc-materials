package lecture10;

public class MyString {
    private char[] data;
    private int length;
    //private static final int INIT_SIZE = 256;

    public MyString(char[] c) {
        this.data = c;
        this.length = c.length;
    }

    public MyString(MyString ms) {
        this.data = ms.data;
        this.length = ms.length;
    }

    public int length() {
        return this.length;
    }

    public void concat(MyString s) {
        int newLength = this.length + s.length;
        char[] newData = new char[newLength];
        for(int i = 0; i < this.length; i++) {
            newData[i] = this.data[i];
        }
        int j = 0;
        for(int i = this.length; i < newData.length; i++) {
            newData[i] = s.data[j];
            j++;
        }
        setData(newData);
    }

    private void setData(char[] data) {
        this.length = data.length;
        this.data = data;
    }

    public char charAt(int index) {
        return this.data[index];
    }

    public String toString() {
        String str = "";
        for(int i = 0; i < this.length; i++) {
            str += this.data[i];
        }
        return str;
    }

    public MyString substr(int beg, int end) {
        char[] subArray = new char[end - beg];

        int i = beg;
        int index = 0;
        while(i < end) {
            subArray[index] = this.data[i];
            i++;
        }

        MyString sub = new MyString(subArray);
        return sub;
    }

    public boolean equals(MyString s) {
        boolean isEquals = false;
        if(this.length != s.length) {
            isEquals = false;
        } else {
            for(int i = 0; i < this.length; i++) {
                if(this.data[i] == s.data[i]) {
                    isEquals = true;
                    break;
                }
            }
        }
        return isEquals;
    }

    public int compare(MyString s) {
        if(this.length == s.length) {
            return 0;
        } else if(this.length < s.length) {
            return -1;
        } else {
            return 1;
        }
    }

    public static void main(String args[]) {
        char[] sc1 = {'a','b','b'};
        MyString s1 = new MyString(sc1);
        System.out.println(s1);

        char[] sc2 = {'z','p','t','q','5','@'};
        MyString s2 = new MyString(sc2);
        s1.concat(s2);
        System.out.println(s1);
    }
}
