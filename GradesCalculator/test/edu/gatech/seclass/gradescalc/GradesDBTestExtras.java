package edu.gatech.seclass.gradescalc;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.junit.Assert.*;

import java.io.File;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradesDBTestExtras {

	
    @Test
    public void testAddProject() {
        db.addProject("PROJECT 4");
        db = new GradesDB(GRADES_DB);
        assertEquals(4, db.getNumProjects());
        db.addProject("PROJECT 5");
        db = new GradesDB(GRADES_DB);
        assertEquals(5, db.getNumProjects());
    }

    @Test
    public void testAddGradesForProject() {
        String projectName = "PROJECT: Extra Credit";
        Student student1 = new Student("Ernesta Anderson", "901234510", db);
        Student student2 = new Student("Josepha Jube", "901234502", db);
        Student student3 = new Student("Genista Parrish","901234509", db);
        db.addProject(projectName);
        db = new GradesDB(GRADES_DB);
        HashMap<Student, Integer> contributions = new HashMap<Student, Integer>();
        contributions.put(student1, 96);
        contributions.put(student2, 87);
        contributions.put(student3, 92);
        db.addIndividualContributions(projectName, contributions);
        HashMap<String, Integer> grades = new HashMap<String, Integer>();
        grades.put("Team 1", 87);
        grades.put("Team 2", 94);
        grades.put("Team 3", 100);
        db.addGradesForProject(projectName, grades);
        db = new GradesDB(GRADES_DB);
        assertEquals(87, db.getAverageProjectsGrade(student1), 1);
        assertEquals(83, db.getAverageProjectsGrade(student2), 1);
        assertEquals(89, db.getAverageProjectsGrade(student3), 1);
    }

    @Test
    public void testAddStudent() {
    	
    	db.addStudent("Marky Mark","901234515","mm@gatech.edu",2,1,3,"N");
        db = new GradesDB(GRADES_DB);
        assertEquals(15, db.getNumStudents());
        Student student = db.getStudentByID("901234515");
        assertTrue(student.getName().compareTo("Marky Mark") == 0);
        db.addStudent("Funky Bunch","901234516","fb@gatech.edu",1,2,3,"Y");
        db = new GradesDB(GRADES_DB);
        assertEquals(16, db.getNumStudents());
        Student student = db.getStudentByID("901234516");
        assertTrue(student.getName().compareTo("Funky Bunch") == 0);
    
    }

}
