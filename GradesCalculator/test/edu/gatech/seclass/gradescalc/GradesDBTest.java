package edu.gatech.seclass.gradescalc;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradesDBTest {

    GradesDB db = null;
    static final String GRADES_DB_GOLDEN = "DB" + File.separator
            + "GradesDatabase6300-goldenversion.xlsx";
    static final String GRADES_DB = "DB" + File.separator
            + "GradesDatabase6300.xlsx";

    @Before
    public void setUp() throws Exception {
        FileSystem fs = FileSystems.getDefault();
        Path dbfilegolden = fs.getPath(GRADES_DB_GOLDEN);
        Path dbfile = fs.getPath(GRADES_DB);
        Files.copy(dbfilegolden, dbfile, REPLACE_EXISTING);
        db = new GradesDB();
        db.loadSpreadsheet(GRADES_DB);
    }

    @After
    public void tearDown() throws Exception {
        db = null;
    }

    @Test
    public void testGetNumStudents() {
        int numStudents = db.getNumStudents();
        assertEquals(14, numStudents);
    }

    @Test
    public void testGetNumAssignments() {
        int numAssignments = db.getNumAssignments();
        assertEquals(3, numAssignments);
    }

    @Test
    public void testGetNumProjects() {
        int numProjects;
        numProjects = db.getNumProjects();
        assertEquals(3, numProjects);
    }

    @Test
    public void testGetStudents1() {
        HashSet<Student> students = null;
        students = db.getStudents();
        assertEquals(14, students.size());
    }

    @Test
    public void testGetStudents2() {
        HashSet<Student> students = null;
        students = db.getStudents();
        assertTrue(students.contains(new Student("Cynthia Faast", "901234514",
                db)));
    }

    @Test
    public void testGetStudentsByName1() {
        Student student = null;
        student = db.getStudentByName("Rastus Kight");
        assertTrue(student.getGtid().compareTo("901234512") == 0);
    }

    @Test
    public void testGetStudentsByName2() {
        Student student = null;
        student = db.getStudentByName("Grier Nehling");
        assertEquals(96, student.getAttendance());
    }

    @Test
    public void testGetStudentsByID() {
        Student student = db.getStudentByID("901234504");
        assertTrue(student.getName().compareTo("Shevon Wise") == 0);
    }

    // New tests
    @Test
    public void testAddAssignment() {
        db.addAssignment("ASSIGNMENT: black-box testing");
        db.loadSpreadsheet(GRADES_DB);
        assertEquals(4, db.getNumAssignments());
        db.addAssignment("ASSIGNMENT: white-box testing");
        db.loadSpreadsheet(GRADES_DB);
        assertEquals(5, db.getNumAssignments());
    }

    @Test
    public void testAddGradesForAssignment() {
        String assignmentName = "ASSIGNMENT: category partition";
        Student student1 = new Student("Josepha Jube", "901234502", db);
        Student student2 = new Student("Christine Schaeffer", "901234508", db);
        Student student3 = new Student("Ernesta Anderson", "901234510", db);
        db.addAssignment(assignmentName);
        db.loadSpreadsheet(GRADES_DB);
        HashMap<Student, Integer> grades = new HashMap<Student, Integer>();
        grades.put(student1, 87);
        grades.put(student2, 94);
        grades.put(student3, 100);
        db.addGradesForAssignment(assignmentName, grades);
        db.loadSpreadsheet(GRADES_DB);
        assertEquals(90, db.getAverageAssignmentsGrade(student1), 1);
        assertEquals(94, db.getAverageAssignmentsGrade(student2), 1);
        assertEquals(93, db.getAverageAssignmentsGrade(student3), 1);
    }

    @Test
    public void testGetAverageAssignmentsGrade() {
        // Rounded to the closest integer
        Student student = new Student("Ernesta Anderson", "901234510", db);
        assertEquals(90, db.getAverageAssignmentsGrade(student), 1);
    }

    @Test
    public void testGetAverageProjectsGrade() {
        // Rounded to the closest integer
        Student student = new Student("Rastus Kight", "901234512", db);
        assertEquals(86, db.getAverageProjectsGrade(student), 1);
    }

    @Test
    public void testAddIndividualContributions() {
        String projectName1 = "PROJECT 2";
        Student student1 = new Student("Josepha Jube", "901234502", db);
        Student student2 = new Student("Grier Nehling", "901234503", db);
        HashMap<Student, Integer> contributions1 = new HashMap<Student, Integer>();
        contributions1.put(student1, 96);
        contributions1.put(student2, 87);
        db.addIndividualContributions(projectName1, contributions1);
        db.loadSpreadsheet(GRADES_DB);
        String projectName2 = "PROJECT 3";
        HashMap<Student, Integer> contributions2 = new HashMap<Student, Integer>();
        contributions2.put(student1, 98);
        contributions2.put(student2, 100);
        db.addIndividualContributions(projectName2, contributions2);
        assertEquals(90, db.getAverageProjectsGrade(student1), 1);
        assertEquals(84, db.getAverageProjectsGrade(student2), 1);
    }
}
