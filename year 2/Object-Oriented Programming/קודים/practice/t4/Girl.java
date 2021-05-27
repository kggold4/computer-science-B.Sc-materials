package practice.t4;

import java.util.ArrayList;
import java.util.List;

public class Girl extends Thread {

    private List<String> questions;
    private Chat c;

    public Girl(Chat c) {
        this.c = c;
        this.questions = new ArrayList();
        this.questions.add("Hi Yaakov");
        this.questions.add("I am good, what about you?");
        this.questions.add("See you in the evening?");
    }

    @Override
    public void run() {

        for(String s : this.questions) {
            try {
                c.Answer(s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
