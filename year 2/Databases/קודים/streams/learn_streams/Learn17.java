package streams.learn_streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class student {
    public String name;
    public List<Double> grades;
    public student() {
        this.name = "";
        this.grades = new ArrayList<>();
    }
    public student(String name) {
        this.name = name;
        this.grades = new ArrayList<>();
    }
    public student(String name, Double[] grades) {
        this.name = name;
        this.grades = new ArrayList<>(Arrays.asList(grades));
    }

    public student(String name, ArrayList grades) {
        this.name = name;
        this.grades = new ArrayList<>(grades);
    }

    public String getName() {
        return this.name;
    }

    public List<Double> getGrades() {
        return this.grades;
    }
}

public class Learn17 {
    public static void main(String[] args) {
        List<student> students = new ArrayList<>();
        student s1 = new student("Noam", new ArrayList(Arrays.asList(new Double[]{75.2, 63.5, 99.0})));
        student s2 = new student("Arie", new ArrayList(Arrays.asList(new Double[]{79.0, 89.0, 100.0})));
        student s3 = new student("Yossi", new ArrayList(Arrays.asList(new Double[]{91.0, 90.0, 95.0})));
        student s4 = new student("David", new ArrayList(Arrays.asList(new Double[]{53.0, 68.0, 91.0})));
        student s5 = new student("Yaron", new ArrayList(Arrays.asList(new Double[]{89.0, 65.0, 71.0})));
        student s6 = new student("Shalom", new ArrayList(Arrays.asList(new Double[]{87.0, 73.0, 86.0})));
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);
        students.add(s5);
        students.add(s6);

        students.stream()
                .forEach(s -> {Double average = s.getGrades().stream()
                        .mapToDouble(g -> g.doubleValue())
                        .average().getAsDouble();
                    System.out.println(s.getName() + " average: " + average);
                });
    }
}

/**
 * output:
 * Noam average: 79.23333333333333
 * Arie average: 89.33333333333333
 * Yossi average: 92.0
 * David average: 70.66666666666667
 * Yaron average: 75.0
 * Shalom average: 82.0
 */
