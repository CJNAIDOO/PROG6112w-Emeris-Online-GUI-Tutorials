package com.mycompany.employeedetails;

import javax.swing.*;
import java.awt.*;

public class EmployeeDetails extends JFrame {

    public EmployeeDetails() {
        // ---- Frame setup ----
        setTitle("Employee Details");
        setSize(760, 460);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // ---- Content pane with a BorderLayout ----
        JPanel contentPane = (JPanel) getContentPane();
        contentPane.setLayout(new BorderLayout(15, 15));
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        // ---- Menu bar (JMenuBar > JMenu > JMenuItem) ----
        JMenuBar menuBar = new JMenuBar();
        JMenu employeeMenu = new JMenu("Employee");
        employeeMenu.add(new JMenuItem("New"));
        employeeMenu.addSeparator();
        employeeMenu.add(new JMenuItem("Exit"));
        JMenu helpMenu = new JMenu("Help");
        helpMenu.add(new JMenuItem("About"));
        menuBar.add(employeeMenu);
        menuBar.add(helpMenu);
        setJMenuBar(menuBar);

        // ================= NORTH: coloured heading banner =================
        JLabel lblHeading = new JLabel("Employee Details", SwingConstants.CENTER);
        lblHeading.setFont(new Font("SansSerif", Font.BOLD, 22));
        lblHeading.setOpaque(true);                          // needed for background colour
        lblHeading.setBackground(new Color(190, 215, 245));
        lblHeading.setPreferredSize(new Dimension(0, 40));
        contentPane.add(lblHeading, BorderLayout.NORTH);

        // ================= CENTER: form (left) + options (right) =================
        JPanel pnlCenter = new JPanel(new GridLayout(1, 2, 20, 0));
        Font labelFont = new Font("SansSerif", Font.BOLD, 13);

        // ---------- Left: labels paired with their inputs ----------
        // Each row is its own panel: label on the WEST, input fills the CENTER.
        // Every label gets the same width so all the inputs line up.
        Dimension labelSize = new Dimension(140, 28);

        JPanel pnlName = new JPanel(new BorderLayout(10, 0));
        JLabel lblName = new JLabel("Employee Name:");
        lblName.setFont(labelFont);
        lblName.setPreferredSize(labelSize);
        JTextField txtName = new JTextField();
        txtName.setToolTipText("Enter the employee's full name");
        pnlName.add(lblName, BorderLayout.WEST);
        pnlName.add(txtName, BorderLayout.CENTER);

        JPanel pnlNumber = new JPanel(new BorderLayout(10, 0));
        JLabel lblNumber = new JLabel("Employee Number:");
        lblNumber.setFont(labelFont);
        lblNumber.setPreferredSize(labelSize);
        JTextField txtNumber = new JTextField();
        txtNumber.setToolTipText("Enter the employee number, e.g. EMP001");
        pnlNumber.add(lblNumber, BorderLayout.WEST);
        pnlNumber.add(txtNumber, BorderLayout.CENTER);

        // Stack the two text-field rows: GridLayout(2, 1) = 2 rows, 1 column
        JPanel pnlFields = new JPanel(new GridLayout(2, 1, 0, 10));
        pnlFields.add(pnlName);
        pnlFields.add(pnlNumber);

        JPanel pnlAddress = new JPanel(new BorderLayout(10, 0));
        JLabel lblAddress = new JLabel("Address:");
        lblAddress.setFont(labelFont);
        lblAddress.setPreferredSize(labelSize);
        lblAddress.setVerticalAlignment(SwingConstants.TOP);
        JTextArea txtAddress = new JTextArea();
        txtAddress.setLineWrap(true);
        txtAddress.setWrapStyleWord(true);
        txtAddress.setToolTipText("Enter the employee's home address");
        pnlAddress.add(lblAddress, BorderLayout.WEST);
        pnlAddress.add(new JScrollPane(txtAddress), BorderLayout.CENTER);

        JPanel pnlLeft = new JPanel(new BorderLayout(0, 10));
        pnlLeft.add(pnlFields, BorderLayout.NORTH);
        pnlLeft.add(pnlAddress, BorderLayout.CENTER);

        // ---------- Right: department, employment type, status ----------
        JPanel pnlRight = new JPanel(new BorderLayout(0, 10));

        // Department (JList in JScrollPane)
        JPanel pnlDepartment = new JPanel(new BorderLayout());
        pnlDepartment.setBorder(BorderFactory.createTitledBorder("Department"));
        String[] departments = {"IT", "Finance", "Human Resources", "Marketing", "Operations"};
        JList<String> lstDepartments = new JList<>(departments);
        lstDepartments.setSelectedIndex(0);
        lstDepartments.setToolTipText("Select the employee's department");
        pnlDepartment.add(new JScrollPane(lstDepartments), BorderLayout.CENTER);

        // Employment Type (JRadioButtons + ButtonGroup)
        JPanel pnlType = new JPanel(new GridLayout(2, 1));
        pnlType.setBorder(BorderFactory.createTitledBorder("Employment Type"));
        JRadioButton rbFullTime = new JRadioButton("Full Time", true);
        JRadioButton rbPartTime = new JRadioButton("Part Time");
        ButtonGroup typeGroup = new ButtonGroup();
        typeGroup.add(rbFullTime);
        typeGroup.add(rbPartTime);
        pnlType.add(rbFullTime);
        pnlType.add(rbPartTime);

        // Status (JCheckBox)
        JPanel pnlStatus = new JPanel(new FlowLayout(FlowLayout.LEFT));
        pnlStatus.setBorder(BorderFactory.createTitledBorder("Status"));
        pnlStatus.add(new JCheckBox("Currently Employed"));

        JPanel pnlTypeStatus = new JPanel(new GridLayout(2, 1, 0, 10));
        pnlTypeStatus.add(pnlType);
        pnlTypeStatus.add(pnlStatus);

        pnlRight.add(pnlDepartment, BorderLayout.CENTER);
        pnlRight.add(pnlTypeStatus, BorderLayout.SOUTH);

        pnlCenter.add(pnlLeft);
        pnlCenter.add(pnlRight);
        contentPane.add(pnlCenter, BorderLayout.CENTER);

        // ================= SOUTH: buttons =================
        JPanel pnlButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));
        JButton btnSave = new JButton("Save");
        JButton btnClear = new JButton("Clear");
        btnSave.setPreferredSize(new Dimension(120, 35));
        btnClear.setPreferredSize(new Dimension(120, 35));
        btnSave.setToolTipText("Save the employee details");
        btnClear.setToolTipText("Clear all fields");
        pnlButtons.add(btnSave);
        pnlButtons.add(btnClear);
        contentPane.add(pnlButtons, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EmployeeDetails().setVisible(true));
    }
}