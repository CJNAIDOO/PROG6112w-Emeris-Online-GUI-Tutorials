package com.mycompany.studentregeg;
   
import javax.swing.*;
import java.awt.*;

public class StudentRegEg extends JFrame {

    public StudentRegEg() {
        
        // ---- Frame setup ----
        setTitle("Student Registration Form");
        setSize(720, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);   // centre on screen

        // ---- Content pane: everything is added to this, not the JFrame itself ----
        JPanel contentPane = (JPanel) getContentPane();
        contentPane.setLayout(new BorderLayout(15, 15));               // gaps between regions
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 15, 15, 15)); // padding

        // ---- Menu bar ----
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        fileMenu.add(new JMenuItem("New"));
        fileMenu.add(new JMenuItem("Exit"));
        JMenu helpMenu = new JMenu("Help");
        helpMenu.add(new JMenuItem("About"));
        menuBar.add(fileMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);

        // =================North: heading =================
        JLabel lblHeading = new JLabel("Student Registration Form", SwingConstants.CENTER);
        lblHeading.setFont(new Font("SansSerif", Font.BOLD, 22));
        contentPane.add(lblHeading, BorderLayout.NORTH);

        // =================Centre: two columns =================
        JPanel pnlCenter = new JPanel(new GridLayout(1, 2, 15, 0));   // 1 row, 2 columns

        // ---------- Left column: name, address, course ----------
        JPanel pnlLeft = new JPanel(new BorderLayout(0, 10));

        // Name row: label on the left (WEST), text field fills the rest (CENTER)
        JPanel pnlName = new JPanel(new BorderLayout(10, 0));
        JLabel lblName = new JLabel("Name:");
        lblName.setPreferredSize(new Dimension(70, 25));   // same width as Address label
        JTextField txtName = new JTextField();
        txtName.setToolTipText("Enter your full name");
        pnlName.add(lblName, BorderLayout.WEST);
        pnlName.add(txtName, BorderLayout.CENTER);

        // Address row: label + text area -inside a scroll pane
        JPanel pnlAddress = new JPanel(new BorderLayout(10, 0));
        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setPreferredSize(new Dimension(70, 25));
        lblAddress.setVerticalAlignment(SwingConstants.TOP);
        JTextArea txtAddress = new JTextArea(5, 20);
        txtAddress.setLineWrap(true);
        txtAddress.setToolTipText("Enter your residential address");
        pnlAddress.add(lblAddress, BorderLayout.WEST);
        pnlAddress.add(new JScrollPane(txtAddress), BorderLayout.CENTER);

        JPanel pnlTop = new JPanel(new BorderLayout(0, 10));
        pnlTop.add(pnlName, BorderLayout.NORTH);
        pnlTop.add(pnlAddress, BorderLayout.CENTER);

        // Course list
        JPanel pnlCourse = new JPanel(new BorderLayout(0, 5));
        String[] courses = {"Computer Science", "Business Studies",
                            "Information Technology", "Graphic Design"};
        JList<String> lstCourses = new JList<>(courses);
        lstCourses.setSelectedIndex(0);
        pnlCourse.add(new JLabel("Select Course:"), BorderLayout.NORTH);
        pnlCourse.add(new JScrollPane(lstCourses), BorderLayout.CENTER);

        pnlLeft.add(pnlTop, BorderLayout.CENTER);
        pnlLeft.add(pnlCourse, BorderLayout.SOUTH);

        // ---------- Right column: study mode, options, submit ----------
        JPanel pnlRight = new JPanel(new GridLayout(3, 1, 0, 15));    // 3 rows, 1 column

        // Study Mode: radio buttons
        JPanel pnlStudyMode = new JPanel(new GridLayout(2, 1));
        pnlStudyMode.setBorder(BorderFactory.createTitledBorder("Study Mode"));
        JRadioButton rbFullTime = new JRadioButton("Full Time", true);
        JRadioButton rbPartTime = new JRadioButton("Part Time");
        ButtonGroup studyModeGroup = new ButtonGroup();   // only one can be selected
        studyModeGroup.add(rbFullTime);
        studyModeGroup.add(rbPartTime);
        pnlStudyMode.add(rbFullTime);
        pnlStudyMode.add(rbPartTime);

        // Options: check box
        JPanel pnlOptions = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlOptions.setBorder(BorderFactory.createTitledBorder("Options"));
        pnlOptions.add(new JCheckBox("I accept the terms and conditions"));

        // Submit button 
        JPanel pnlButton = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 30));
        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setPreferredSize(new Dimension(140, 40));
        btnSubmit.setToolTipText("Submit your registration");
        pnlButton.add(btnSubmit);

        pnlRight.add(pnlStudyMode);
        pnlRight.add(pnlOptions);
        pnlRight.add(pnlButton);

        pnlCenter.add(pnlLeft);
        pnlCenter.add(pnlRight);
        contentPane.add(pnlCenter, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new StudentRegEg().setVisible(true));
    }
}