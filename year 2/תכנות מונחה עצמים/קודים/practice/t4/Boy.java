package practice.t4;

import java.util.ArrayList;
import java.util.List;

public class Boy extends Thread {

    private List<String> questions;
    private Chat c;

    public Boy(Chat c) {
        this.c = c;
        this.questions = new ArrayList();
        this.questions.add("Hi Rachel");
        this.questions.add("How are you?");
        this.questions.add("I am also doing fine!");
        this.questions.add("Surely");
    }

    @Override
    public void run() {

        for(String s : this.questions) {
            c.Question(s);
        }
    }
}
