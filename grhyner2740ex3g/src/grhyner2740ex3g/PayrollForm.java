package grhyner2740ex3g;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.text.DecimalFormat;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.ActionEvent;

public class PayrollForm extends JFrame {

	private JPanel contentPane;
	private JList employeeList;
	private JTextField hoursTextField;
	private JLabel totalHoursLabel;
	private JLabel grossPayLabel;
	private DefaultListModel employeeListModel;
	private JTextField empIdTextField;
	private JTextField empNameTextField;
	private JTextField payRateTextField;
	private JButton addHoursButton;
	private JButton clearHoursButton;
	private JButton btnUpdate;
	private JButton clearFormButton;
	private PayrollObjMapper payrollObjMapper;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PayrollForm frame = new PayrollForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PayrollForm() {
		setTitle("GRhyner 2740 Ex3G Payroll");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelectEmployee = new JLabel("Select employee:");
		lblSelectEmployee.setBounds(10, 11, 102, 14);
		contentPane.add(lblSelectEmployee);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 36, 324, 111);
		contentPane.add(scrollPane);
		
//		employeeList = newJList();
//		employeeListModel = new DefaultListModel();
//		employeeListModel.addElement(new Payroll(101, "Mark Swanson", 10.0));
//		employeeListModel.addElement(new Payroll(102, "Patti Weigand", 20.0));
//		employeeListModel.addElement(new Payroll(103, "Lyle Stelter", 30.0));
//		employeeListModel.addElement(new Payroll(104, "Weva Burdick", 40.0));
//		employeeListModel.addElement(new Payroll(105, "Lisa Laing", 50.0));
		payrollObjMapper = new PayrollObjMapper("exercise3g,txt");
		employeeListModel = payrollObjMapper.getAllPayroll();
		
		employeeList = new JList(employeeListModel);
		employeeList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				do_employeeList_mouseClicked(arg0);
			}
		});
		employeeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(employeeList);
		
		JLabel lblEmployeeId = new JLabel("Employee ID (> 100) :");
		lblEmployeeId.setBounds(23, 161, 137, 14);
		contentPane.add(lblEmployeeId);
		
		JLabel lblEmployeeName = new JLabel("Employee name :");
		lblEmployeeName.setBounds(23, 187, 102, 14);
		contentPane.add(lblEmployeeName);
		
		JLabel lblEnterHours = new JLabel("Enter hours (0.1 - 20.0) :");
		lblEnterHours.setBounds(23, 237, 137, 14);
		contentPane.add(lblEnterHours);
		
		JLabel lblTotalHours = new JLabel("Total hours :");
		lblTotalHours.setBounds(23, 262, 76, 14);
		contentPane.add(lblTotalHours);
		
		JLabel lblGrossPay = new JLabel("Gross pay :");
		lblGrossPay.setBounds(23, 287, 76, 14);
		contentPane.add(lblGrossPay);
		
		JLabel lblPayRate = new JLabel("Pay rate (7.25 - 100) :");
		lblPayRate.setBounds(23, 212, 137, 14);
		contentPane.add(lblPayRate);
		
		hoursTextField = new JTextField();
		hoursTextField.setHorizontalAlignment(SwingConstants.RIGHT);
		hoursTextField.setText("0.00");
		hoursTextField.setBounds(162, 234, 92, 20);
		contentPane.add(hoursTextField);
		hoursTextField.setColumns(10);
		
		totalHoursLabel = new JLabel("0.00");
		totalHoursLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		totalHoursLabel.setBounds(125, 262, 69, 14);
		contentPane.add(totalHoursLabel);
		
		grossPayLabel = new JLabel("$ 0.00");
		grossPayLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		grossPayLabel.setBounds(125, 287, 69, 14);
		contentPane.add(grossPayLabel);
		
		addHoursButton = new JButton("+");
		addHoursButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_addHoursButton_actionPerformed(arg0);
			}
		});
		addHoursButton.setBounds(264, 234, 41, 20);
		contentPane.add(addHoursButton);
		
		clearHoursButton = new JButton("Clear");
		clearHoursButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_clearHoursButton_actionPerformed(e);
			}
		});
		clearHoursButton.setBounds(315, 234, 69, 20);
		contentPane.add(clearHoursButton);
		
		clearFormButton = new JButton("Clear Form");
		clearFormButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				do_clearFormButton_actionPerformed(e);
			}
		});
		clearFormButton.setBounds(271, 312, 113, 23);
		contentPane.add(clearFormButton);
		
		empIdTextField = new JTextField();
		empIdTextField.setText("000");
		empIdTextField.setBounds(168, 158, 86, 20);
		contentPane.add(empIdTextField);
		empIdTextField.setColumns(10);
		
		empNameTextField = new JTextField();
		empNameTextField.setBounds(130, 184, 124, 20);
		contentPane.add(empNameTextField);
		empNameTextField.setColumns(10);
		
		payRateTextField = new JTextField();
		payRateTextField.setText("7.25");
		payRateTextField.setBounds(168, 209, 86, 20);
		contentPane.add(payRateTextField);
		payRateTextField.setColumns(10);
		
		btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnUpdate_actionPerformed(arg0);
			}
		});
		btnUpdate.setBounds(172, 312, 89, 23);
		contentPane.add(btnUpdate);
	}
	protected void do_employeeList_mouseClicked(MouseEvent arg0) {
		Payroll pay = (Payroll) employeeList.getSelectedValue();
		this.empIdTextField.setText(Integer.toString(pay.getId()));
		this.empNameTextField.setText(pay.getName());
		DecimalFormat dollarFmt = new DecimalFormat("###0.00");
		this.payRateTextField.setText(dollarFmt.format(pay.getPayRate()));
		this.empIdTextField.requestFocus();
		this.addHoursButton.setEnabled(true);
		this.clearHoursButton.setEnabled(true);
		this.btnUpdate.setEnabled(true);
	}
	
	
	protected void do_addHoursButton_actionPerformed(ActionEvent arg0) {
		
		Payroll pay = (Payroll) employeeList.getSelectedValue();
		double hours = Double.parseDouble(this.hoursTextField.getText());
		
       if (pay.addHours(hours)) {
        DecimalFormat hoursfmt = new DecimalFormat ("##0.00");
        this.totalHoursLabel.setText(hoursfmt.format(pay.getHours()));
        DecimalFormat grosspayfmt = new DecimalFormat ("$#,###,###,###,###.00");
        this.grossPayLabel.setText(grosspayfmt.format(pay.calcGrossPay()));
        hoursTextField.setText("0.00");
       }
       else {
    	   JOptionPane.showMessageDialog(null, "Invalid Hours: \nMust be in range 0.1 - 20.");
       }
        this.hoursTextField.requestFocus();
	}
	protected void do_clearHoursButton_actionPerformed(ActionEvent e) {
		Payroll pay = (Payroll) employeeList.getSelectedValue();
		pay.setHours(0);
		totalHoursLabel.setText("0.00");
		grossPayLabel.setText("0.00");
		hoursTextField.setText("0.00");
		
		this.hoursTextField.requestFocus();
	}
	
	protected void do_clearFormButton_actionPerformed(ActionEvent e) {
		empIdTextField.setText("0");
		empNameTextField.setText("");
		payRateTextField.setText("$0.00");
		hoursTextField.setText("0.00");
		totalHoursLabel.setText("0.00");
		grossPayLabel.setText("$0.00");
		
		this.hoursTextField.requestFocus();
		this.employeeList.clearSelection();
		this.addHoursButton.setEnabled(false);
		this.clearHoursButton.setEnabled(false);
		this.btnUpdate.setEnabled(false);
	}
	
	protected void do_hoursTextField_focusGained(FocusEvent arg0) {
		hoursTextField.selectAll();
	}
	protected void do_btnUpdate_actionPerformed(ActionEvent arg0) {
		int id = Integer.parseInt(empIdTextField.getText());
		double rate = Double.parseDouble(payRateTextField.getText());
		Payroll payroll = (Payroll) employeeList.getSelectedValue();
		if (!payroll.setId(id)) 
		{
			JOptionPane.showMessageDialog(null, "Invalid Employee ID: \nMust be > 100");
			empIdTextField.setText("101");
			empIdTextField.requestFocus();
		}
		else if (!payroll.setPayRate(rate)) 
		{
			JOptionPane.showMessageDialog(null, "Invalid pay rate: \nMust be 7.25 - 100");
			DecimalFormat rateFmt = new DecimalFormat("##0.00");
			this.payRateTextField.setText(rateFmt.format(payroll.getPayRate()));
			this.payRateTextField.requestFocus();
		}
		else if (!payroll.setName(empNameTextField.getText()))
		{
			JOptionPane.showMessageDialog(null, "Invalid name: \nMust enter a name.");
            this.empNameTextField.setText(payroll.getName());
            this.empNameTextField.requestFocus();
		}
		employeeList.repaint();
	}
	protected void do_this_windowClosing(WindowEvent arg0) {
		if (payrollObjMapper != null)
			payrollObjMapper.writeAllPayroll(employeeListModel);
	}
}
