package edu.gatech.seclass.gradescalc;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GradesCalcGUI {

    private GradesDB db = null;
    private JFrame mainwindow = null;
    private JComboBox<String> studentsComboBox = null;
    private JTextField formulaField = null;
    private TextArea studentInfoArea = null;
    private JPanel formulaPanel = null;
    private JButton updateFormulaButton = null;

    public static void main(String[] args) {
        String defaultdb = "DB" + File.separator + "GradesDatabase6300.xlsx";
        GradesCalcGUI window = null;
        if (args.length < 1) {
            window = new GradesCalcGUI(defaultdb);
            System.out.println("Using default spreadsheet: " + defaultdb);
        } else {
            window = new GradesCalcGUI(args[0]);
        }
        window.mainwindow.setVisible(true);
    }

    public GradesCalcGUI(String dbfile) {
        db = new GradesDB();
        db.loadSpreadsheet(dbfile);
        mainwindow = new JFrame();
        mainwindow.setTitle("Grades Calculator");
        mainwindow.setBounds(100, 100, 600, 400);
        mainwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainwindow.getContentPane().setLayout(new BorderLayout());
        //
        studentInfoArea = new TextArea();
        studentInfoArea.setEditable(false);
        studentInfoArea.setSize(400, 200);
        studentInfoArea.setColumns(10);
        mainwindow.getContentPane().add(studentInfoArea, BorderLayout.CENTER);
        //
        studentsComboBox = new JComboBox<String>();
        studentsComboBox.setSize(389, 20);
        studentsComboBox.addItemListener(new ItemChangeListener());
        mainwindow.getContentPane().add(studentsComboBox, BorderLayout.NORTH);
        fillComboBox();
        //
        JPanel buffer1 = new JPanel();
        JPanel buffer2 = new JPanel();
        buffer1.setSize(10, 100);
        buffer2.setSize(10, 100);
        mainwindow.getContentPane().add(buffer1, BorderLayout.WEST);
        mainwindow.getContentPane().add(buffer2, BorderLayout.EAST);
        //
        formulaPanel = new JPanel();
        formulaPanel.setLayout(new FlowLayout());
        JLabel formulaLabel = new JLabel("Formula");
        formulaLabel.setSize(46, 14);
        formulaPanel.add(formulaLabel);
        formulaField = new JTextField();
        formulaField.setSize(340, 20);
        formulaField.setColumns(30);
        formulaField.setText(db.getFormula());
        formulaPanel.add(formulaField);
        updateFormulaButton = new JButton("Update Formula");
        updateFormulaButton.setSize(130, 20);
        updateFormulaButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                updateFormula();
            }
        });
        formulaPanel.add(updateFormulaButton);
        mainwindow.getContentPane().add(formulaPanel, BorderLayout.SOUTH);
    }

    protected void updateFormula() {
        db.setFormula(formulaField.getText());
        refreshStudentInfo();
    }

    private void refreshStudentInfo() {
        String studentInfo = getStudentInfo();
        studentInfoArea.setText(studentInfo);
    }

    private void fillComboBox() {
        HashSet<Student> students = db.getStudents();
        ArrayList<String> names = new ArrayList<String>();
        for (Student student : students) {
            names.add(student.getName());
        }
        Collections.sort(names);
        for (String name : names) {
            studentsComboBox.addItem(name);
        }
    }

    private String getStudentInfo() {
        String selected = (String) studentsComboBox.getSelectedItem();
        Student student = db.getStudentByName(selected);
        String output = "Name: " + student.getName() + "\n" + "Email: "
                + student.getEmail() + "\n" + "GTID: " + student.getGtid()
                + "\n\n" + "Attendance: " + student.getAttendance() + "\n"
                + "Average assignments grade: "
                + student.getAverageAssignmentsGrade() + "\n"
                + "Average projects grade: "
                + student.getAverageProjectsGrade() + "\n\n"
                + "Overall Grade: " + student.getOverallGrade() + "\n";
        return output;
    }

    private class ItemChangeListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent event) {
            if (event.getStateChange() == ItemEvent.SELECTED) {
                refreshStudentInfo();
            }
        }
    }
}
