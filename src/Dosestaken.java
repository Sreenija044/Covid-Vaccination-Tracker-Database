
//import java.awt.BorderLayout;
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
//import javax.swing.LayoutStyle.ComponentPlacement;

public class Dosestaken extends JFrame {
	private static final long serialVersionUID = 1L;
	static Dosestaken frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void DosesTaken(String aadhar_no) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new Dosestaken(aadhar_no);
					frame.setTitle("Vaccine Details");
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
	public Dosestaken(String aadhar_no) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 404);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblDosetaken = new JLabel("Vaccine Details");
		lblDosetaken.setForeground(Color.GRAY);
		lblDosetaken.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lbltype = new JLabel("vaccine type :");
		
		JLabel lblfirst_dose = new JLabel("First Dose :");
		
		JLabel lblsecond_dose = new JLabel("Second Dose :");
		
		JLabel lblbooster_dose = new JLabel("Booster Dose :");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		
		JButton btnDosetaken = new JButton("Insert");
		btnDosetaken.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String type=textField.getText();
			String firstdose=textField_1.getText();
			String seconddose=textField_2.getText();
			String boosterdose=textField_3.getText();
			int i=Dosesdetails.insertbook(aadhar_no,firstdose, seconddose, boosterdose, type);
			if(i>0){
				JOptionPane.showMessageDialog(Dosestaken.this,"Details added successfully!");
			}else{
				JOptionPane.showMessageDialog(Dosestaken.this,"Unknown Error !!!\nInsertion not completed");
			}
			}
			}
		);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e1) {
				AddUser.main(new String[]{});
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
							.addComponent(lblDosetaken))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lbltype)
								.addComponent(lblfirst_dose)
								.addComponent(lblsecond_dose)
								.addComponent(lblbooster_dose)
								)
							.addGap(47)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								
								.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 167, GroupLayout.PREFERRED_SIZE))))
					.addContainerGap(125, Short.MAX_VALUE))
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addGap(50)
					.addComponent(btnDosetaken)
					.addGap(30)
					.addComponent(btnBack)
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblDosetaken)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbltype)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblfirst_dose)
						.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblsecond_dose)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblbooster_dose)
						.addComponent(textField_3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						)
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
							.addComponent(btnDosetaken, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE)
							
							.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 31, GroupLayout.PREFERRED_SIZE))
					
	)	);
		contentPane.setLayout(gl_contentPane);
	}

}
