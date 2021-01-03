package practice_binomial;

public class BinomialTree {
    private void linkTress(Node h1, Node h2) {
        h1.parent = h2;
        h1.sibling =h2.child;
        h2.child = h1;
        h2.degree++;
    }
}