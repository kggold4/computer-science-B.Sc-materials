package streams.learn_streams;

import common.Student;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Learn8 {
    public static void main(String[] args) {

        // without JavaStreams
        List<String> roomsReqAccess1 = new LinkedList<>();
        Map<String, List<Student>> classrooms1 = new HashMap<>();
        for(Map.Entry<String, List<Student>> classroom: classrooms1.entrySet()) {
            for(Student student : classroom.getValue()) {
                if(student.reqAccessibility) {
                    roomsReqAccess1.add(classroom.getKey());
                    break;
                }
            }
        }

        // with JavaStreams
        Map<String, List<Student>> classrooms2 = new HashMap<>();
//        List<String> roomsReqAccess2 = classrooms2.entrySet()
//                .stream()
//                .filter(a -> a.getValue()
//                        .stream()
//                        .anyMatch(x -> x.reqAccessibility))
//                .collect(Collectors.toList(c -> c.getKey()));
    }
}
