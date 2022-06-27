
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class AddUser extends JFrame {
	private static final long serialVersionUID = 1L;
	static AddUser frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new AddUser();
					frame.setTitle("User Details");
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
	public AddUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblEnterDetails = new JLabel("Enter Details");
		lblEnterDetails.setForeground(Color.GRAY);
		lblEnterDetails.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblusername = new JLabel("User name :");
		
		JLabel lblphone = new JLabel("Phone no. :");
		
		JLabel lblaadhar = new JLabel("Aadhar no. :");
		
		JLabel lbladdress = new JLabel("Address :");
		
		JLabel lblage = new JLabel("Age :");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		
		JButton btnAddUser = new JButton("Insert");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String sname=textField.getText();
			String phone_no=textField_1.getText();
			String aadhar_no=textField_2.getText();
			String address=textField_3.getText();
			String age=textField_4.getText();
			long phone=Long.parseLong(phone_no);
			long aadhar=Long.parseLong(aadhar_no);
			int ages=Integer.parseInt(age);
			int i=Userdetails.insertbook(sname, phone, aadhar,address,ages);
			if(i>0){
				JOptionPane.showMessageDialog(AddUser.this,"User added successfully!");
			}else{
				JOptionPane.showMessageDialog(AddUser.this,"Unknown Error !!!\nInsertion not completed");
			}
			}

		});
		
		JButton btnBack = new JButton("Delete");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				String sname=textField_2.getText();
				long L1= Long.parseLong(sname);
				Userdetails.deletebook(L1);
				frame.dispose();
			}
			});
		
		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				String aadhar_no = textField_2.getText();
				Dosestaken.DosesTaken(aadhar_no);
				frame.dispose();
			}
			});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(150)
							.addComponent(lblEnterDetails))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblusername)
								.addComponent(lblphone)
								.addComponent(lblaadhar)
								.addComponent(lbladdress)
								.addComponent(lblage)
								)
							.addGap(47)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								
									
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(125, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(50)
					.addComponent(btnAddUser)
					.addGap(30)
					.addComponent(btnBack)
					.addGap(30)
					.addComponent(btnNext)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblEnterDetails)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblusername)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblphone)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblaadhar)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(lbladdress)
							.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblage)
								.addComponent(textField_4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						)
					.addGap(30)
					
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnAddUser, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
							
							.addComponent(btnNext, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					
	);
		contentPane.setLayout(gl_contentPane);
	}

}
