package ku.cs.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    private StudentList studentList;

    @BeforeEach
    void setUp() {
        studentList = new StudentList();
    }

    @Test
    void addNewStudent() {
        for (int i =0; i < 10; i++) {
            studentList.addNewStudent("670000000" + i, Integer.toString(i));
        }
    }

    @Test
    void addNewStudentWithScore() {
        for (int i =0; i < 10; i++) {
            studentList.addNewStudent("670000000" + i, Integer.toString(i), i);
        }
        assertEquals(10, studentList.getStudents().size());
    }

    @Test
    void findStudentById() {
        for (int i =0; i < 10; i++) {
            studentList.addNewStudent("670000000" + i, Integer.toString(i));
        }
        assert(studentList.findStudentById("6700000009").isId("6700000009"));
    }

    @Test
    void filterByName() {
        for (int i =0; i < 10; i++)
            studentList.addNewStudent("670000000" + i, Integer.toString(i%2));

        StudentList newStudentList = studentList.filterByName("1");
        assertEquals(5, newStudentList.getStudents().size());
        for (int i =0; i < 5; i++) {
            assertEquals("1", newStudentList.getStudents().get(i).getName());
        }
    }

    @Test
    void giveScoreToId() {
        studentList.addNewStudent("6700000001", Integer.toString(1));
        studentList.giveScoreToId("6700000001", 100);
        assertEquals(100, studentList.findStudentById("6700000001").getScore());
    }

    @Test
    void viewGradeOfId() {
        studentList.addNewStudent("6700000001", Integer.toString(1), 60);
        assertEquals(studentList.findStudentById("6700000001").getGrade(), studentList.viewGradeOfId("6700000001"));
    }
}