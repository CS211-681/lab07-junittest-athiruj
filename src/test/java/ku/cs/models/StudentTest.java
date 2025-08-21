package ku.cs.models;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    private Student student;

    @BeforeEach
    void beforeEach() {
        student = new Student("67XXXXXXXX", "Test");
    }

    @Test
    void changeName() {
        student.changeName("NewName");
        assertEquals("NewName", student.getName());
    }

    @Test
    void addScore() {
        student.addScore(50);
        assertEquals(50, student.getScore());
    }

    @Test
    void gradeF() {
        student.addScore(60);
        assertEquals("F", student.grade());
    }

    @Test
    void gradeP() {
        student.addScore(61);
        assertEquals("P", student.grade());
    }

    @Test
    void isId() {
        assert(student.isId("67XXXXXXXX"));
    }

    @Test
    void isNameContains() {
        assert (student.isNameContains("Test"));
    }

    @Test
    void getId() {
        assert(student.getId().equals("67XXXXXXXX"));
    }

    @Test
    void getName() {
        assert(student.getName().equals("Test"));
    }

    @Test
    void getScore() {
        student.addScore(50);
        assertEquals(50, student.getScore());
    }

    @Test
    void getGrade() {
        student.addScore(60);
        assertEquals("F", student.grade());
    }
}