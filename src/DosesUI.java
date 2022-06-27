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
//import javax.swing.JPasswordField;

public class DosesUI extends JFrame {
	private static final long serialVersionUID = 1L;
	static DosesUI frame;
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new DosesUI();
					frame.setTitle("Covid Vaccination Tracker Database");
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
	public DosesUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(103, 95, 700, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblid = new JLabel("Aadhar no :");
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnClose = new JButton("Close");
        btnClose.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	 frame.dispose();
            }});
        btnClose.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnClose.setBackground(new Color(240, 240, 240));
        btnClose.setBounds(500, 666, 80, 30);
        contentPane.add(btnClose);
		
		JButton btnLogin = new JButton("Submit");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String name=textField.getText();
			if(checkdoses.checklogin(name)){
					JOptionPane.showMessageDialog(DosesUI.this, " No.of Doses: "+ checkdoses.NumSlots(name));
				frame.dispose();
			}
				else{
					JOptionPane.showMessageDialog(DosesUI.this," Error!!! \n Aadhar number is invalid");
				textField.setText("");
				}
			}}
		);
		
		textField = new JTextField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(15)
								.addComponent(lblid)
							.addGap(30)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup()
									.addComponent(btnLogin))))
					)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
			  .addGroup(gl_contentPane.createSequentialGroup()
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblid)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(20)
					.addGroup(gl_contentPane.createParallelGroup()
							.addComponent(btnLogin))
		));
		contentPane.setLayout(gl_contentPane);
	}
}
