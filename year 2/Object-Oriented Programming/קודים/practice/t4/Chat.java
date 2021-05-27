package practice.t4;

public class Chat {

    private boolean answered;
    private boolean question;

    public Chat() {
        this.answered = true;
        this.question = false;
    }

    public void Question(String msg)  {
        synchronized(this) {
            if(!this.answered) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("boy: " + msg);
            question = true;
            notifyAll();
            answered = false;
        }
    }

    public void Answer(String msg) throws InterruptedException {
        synchronized(this) {
            if(this.answered) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("girl: " + msg);
            question = false;
            notifyAll();
            answered = true;
        }
    }

    public synchronized boolean getAnswered() {
        return this.answered && !this.question;
    }
}