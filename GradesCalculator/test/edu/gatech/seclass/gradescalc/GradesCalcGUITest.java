package edu.gatech.seclass.gradescalc;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.junit.Assert.assertTrue;

import java.awt.TextArea;
import java.io.File;
import java.lang.reflect.Field;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GradesCalcGUITest {

    GradesCalcGUI gui = null;
    static final String GRADES_DB_GOLDEN = "DB" + File.separator
            + "GradesDatabase6300-goldenversion.xlsx";
    static final String GRADES_DB = "DB" + File.separator
            + "GradesDatabase6300.xlsx";
    JComboBox<String> studentsComboBox = null;
    JTextField formulaField = null;
    TextArea studentInfoArea = null;
    JPanel formulaPanel = null;
    JButton updateFormulaButton = null;

    @Before
    public void setUp() throws Exception {
        FileSystem fs = FileSystems.getDefault();
        Path dbfilegolden = fs.getPath(GRADES_DB_GOLDEN);
        Path dbfile = fs.getPath(GRADES_DB);
        Files.copy(dbfilegolden, dbfile, REPLACE_EXISTING);
        gui = new GradesCalcGUI(GRADES_DB);
        // Getting the GUI elements
        Field field = null;
        field = gui.getClass().getDeclaredField("studentsComboBox");
        field.setAccessible(true);
        studentsComboBox = (JComboBox<String>) field.get(gui);
        field = gui.getClass().getDeclaredField("studentInfoArea");
        field.setAccessible(true);
        studentInfoArea = (TextArea) field.get(gui);
        field = gui.getClass().getDeclaredField("formulaField");
        field.setAccessible(true);
        formulaField = (JTextField) field.get(gui);
        field = gui.getClass().getDeclaredField("formulaPanel");
        field.setAccessible(true);
        formulaPanel = (JPanel) field.get(gui);
        field = gui.getClass().getDeclaredField("updateFormulaButton");
        field.setAccessible(true);
        updateFormulaButton = (JButton) field.get(gui);
    }

    @After
    public void tearDown() throws Exception {
        gui = null;
    }

    @Test
    public void testStudentsInfoGUI() throws InterruptedException {
        studentsComboBox.setSelectedItem("Rastus Kight");
        Thread.sleep(500);
        String output = studentInfoArea.getText().trim();
        String expectedOutput = "Name: Rastus Kight\nEmail: rk@gatech.edu\nGTID: 901234512\n\nAttendance: 97\nAverage assignments grade: 80\nAverage projects grade: 86\n\nOverall Grade: 86";
        assertTrue(output.equals(expectedOutput));
    }

    @Test(expected = GradeFormulaException.class)
    public void testIncorrectFormulaGUI() {
        formulaField.setText("a + b");
        updateFormulaButton.doClick();
    }

    @Test
    public void testFormulaUpdateGUI1() throws InterruptedException {
        formulaField.setText("AT * 0.2 + AS * 0.4 + PR * 0.4");
        updateFormulaButton.doClick();
        studentsComboBox.setSelectedItem("Freddie Catlay");
        Thread.sleep(500);
        String output = studentInfoArea.getText().trim();
        String expectedOutput = "Name: Freddie Catlay\nEmail: fc@gatech.edu\nGTID: 901234501\n\nAttendance: 93\nAverage assignments grade: 90\nAverage projects grade: 77\n\nOverall Grade: 85";
        assertTrue(output.equals(expectedOutput));
    }

    @Test
    public void testFormulaUpdateGUI2() throws InterruptedException {
        formulaField.setText("PR * 1");
        updateFormulaButton.doClick();
        studentsComboBox.setSelectedItem("Laraine Smith");
        Thread.sleep(500);
        String output = studentInfoArea.getText().trim();
        String expectedOutput = "Name: Laraine Smith\nEmail: ls@gatech.edu\nGTID: 901234505\n\nAttendance: 100\nAverage assignments grade: 100\nAverage projects grade: 96\n\nOverall Grade: 96";
        assertTrue(output.equals(expectedOutput));
    }
}
