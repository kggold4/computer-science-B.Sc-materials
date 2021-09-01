package json;

import common.Address;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import common.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JsonParse {
    public static void main(String[] args) throws IOException, JSONException {

        // Students list
        List<Student> studentList = new ArrayList<>();

        String jsonText = new String(Files.readAllBytes(Paths.get("src/json/students.json")));
        JSONObject json = new JSONObject(jsonText);
        JSONArray jsonStudentArray = json.getJSONObject("University").getJSONArray("Student");
        for(int studentIdx = 0; studentIdx < jsonStudentArray.length(); studentIdx++) {
            JSONObject currentStudent = jsonStudentArray.getJSONObject(studentIdx);
            Student student = new Student();
            studentList.add(student);
            JSONArray studentInner = currentStudent.names(); // array of keys only
            for(int stInnerIdx = 0; stInnerIdx < studentInner.length(); stInnerIdx++) {
                String currentKey= studentInner.getString(stInnerIdx);
                switch(currentKey) {
                    case "FirstName":
                        student.firstName = currentStudent.getString(currentKey);
                        break;
                    case "LastName":
                        student.lastName = currentStudent.getString(currentKey);
                        break;
                    case "id":
                        student.id = currentStudent.getInt(currentKey);
                        break;
                    case "age":
                        student.age = currentStudent.getInt(currentKey);
                        break;
                    case "Address":
                        Address address = new Address();
                        student.address = address;
                        JSONObject addressObject = currentStudent.getJSONObject(currentKey);
                        if(addressObject.has("Street")) address.street = addressObject.getString("Street");
                        if(addressObject.has("City")) address.street = addressObject.getString("City");
                        if(addressObject.has("Zip")) address.street = addressObject.getString("Zip");
                        break;
                }
            }
        }

        System.out.println();
        for(Student st : studentList) {
            System.out.println(st);
        }

        System.out.println(studentList.get(0).lastName);
        System.out.println(studentList.get(1).address.zip);
    }
}
