package edu.gatech.seclass.gradescalc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.HashSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradesDBTest {

    GradesDB db = null;
    static final String GRADES_DB = "DB/GradesDatabase6300.xlsx";

    @Before
    public void setUp() throws Exception {
        db = new GradesDB(GRADES_DB);
    }

    @After
    public void tearDown() throws Exception {
        db = null;
    }

    @Test
    public void testGetNumStudents() {
        try {
            int numStudents = db.getNumStudents();
            assertEquals(14, numStudents);
        } catch (Exception e) {
            fail("Exception");
        }
    }

    @Test
    public void testGetNumAssignments() {
        try {
            int numAssignments = db.getNumAssignments();
            assertEquals(3, numAssignments);
        } catch (Exception e) {
            fail("Exception");
        }
    }

    @Test
    public void testGetNumProjects() {
        int numProjects;
        try {
            numProjects = db.getNumProjects();
            assertEquals(3, numProjects);
        } catch (Exception e) {
            fail("Exception");
        }
    }

    @Test
    public void testGetStudents1() {
        HashSet<Student> students = null;
        try {
            students = db.getStudents();
        } catch (Exception e) {
            fail("Exception");
        }
        assertEquals(14, students.size());
    }

    @Test
    public void testGetStudents2() {
        HashSet<Student> students = null;
        try {
            students = db.getStudents();
        } catch (Exception e) {
            fail("Exception");
        }
        boolean found = false;
        for (Student s : students) {
            if (s.getName().compareTo("Cynthia Faast") == 0
                    && s.getGtid().compareTo("901234514") == 0) {
                found = true;
                break;
            }
        }
        assertTrue(found);
    }

    @Test
    public void testGetStudentsByName1() {
        Student student = null;
        try {
            student = db.getStudentByName("Rastus Kight");
        } catch (Exception e) {
            fail("Exception");
        }
        assertTrue(student.getGtid().compareTo("901234512") == 0);
    }

    @Test
    public void testGetStudentsByName2() {
        Student student = null;
        try {
            student = db.getStudentByName("Grier Nehling");
        } catch (Exception e) {
            fail("Exception");
        }
        assertEquals(96, student.getAttendance());
    }

    @Test
    public void testGetStudentsByID() {
        try {
            Student student = db.getStudentByID("901234504");
            assertTrue(student.getName().compareTo("Shevon Wise") == 0);
        } catch (Exception e) {
            fail("Exception");
        }
    }
}
