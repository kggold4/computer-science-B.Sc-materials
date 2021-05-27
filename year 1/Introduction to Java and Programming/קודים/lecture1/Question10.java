package lecture1;

//question 10
public class Question10 {
    public static void main(String[] args) {

        int num = MyConsole.readInt("Insert seconds:");
        double hours = Math.floor(num / 60 / 60);
        double minutes = (num / 60) - (hours * 60);
        double seconds = num - hours * 3600 - minutes * 60;

        System.out.println("Seconds: " + seconds + ", Minutes: " + minutes + ", Hours: " + hours);
    }
}
