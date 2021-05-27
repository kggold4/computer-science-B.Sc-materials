package lecture6;

public class Panel4 {
    public static void main(String args[]) {

        StringBuilder first = new StringBuilder("hello");
        StringBuilder second = new StringBuilder("World");
        StringBuilder firstSpace = first.append(" ");
        StringBuilder comb = firstSpace.append(second);
        System.out.println(comb.replace(3, 7, "12345"));
        System.out.println(comb.capacity());
        System.out.println(comb.length());
        System.out.println(comb.delete(2, 8));


        StringBuilder textA = new StringBuilder("java");
        StringBuilder textB = new StringBuilder("java");
        boolean isEqual1 = (textA.equals(textB));
        System.out.println(isEqual1);
        String A = textA.toString();
        String B = textB.toString();
        boolean isEqual2 = (A.equals(B));
        System.out.println(isEqual2);

        StringBuilder textC = new StringBuilder("kfi");
        textC.insert(3, "r");
        System.out.println(textC);

    }
}
