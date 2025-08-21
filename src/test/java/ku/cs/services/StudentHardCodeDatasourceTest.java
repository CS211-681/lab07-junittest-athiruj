package ku.cs.services;

import ku.cs.models.Student;
import ku.cs.models.StudentList;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentHardCodeDatasourceTest {
    private String[] studentIDs = {
            "6710400001",
            "6710400002",
            "6710400003",
            "6710400004",
    };

    private final String[] studentNames = {
            "First",
            "Second",
            "Third",
            "Fourth",
    };

    @Test
    void readData() {
        StudentList studentList = new StudentHardCodeDatasource().readData();
        for (int i = 0; i < studentIDs.length; i++) {
            assert(studentList.getStudents().get(i).isId(studentIDs[i]));
            assertEquals(studentNames[i], studentList.getStudents().get(i).getName());
        }
    }
}