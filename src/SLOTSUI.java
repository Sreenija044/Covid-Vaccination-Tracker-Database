import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
//import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import javax.swing.JPasswordField;

public class SLOTSUI extends JFrame {
	private static final long serialVersionUID = 1L;
	static SLOTSUI frame;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new SLOTSUI();
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
	public SLOTSUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(103, 95, 700, 750);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblid = new JLabel("Center_code :");
		
		JLabel lblpassword = new JLabel("Area :");
		
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
			String password=textField1.getText();
			if(checkvaccinetype.checklogin(name)){
				if(checkvaccinetype.checkpassword(name,password)){
					JOptionPane.showMessageDialog(SLOTSUI.this, " Slots Present");
				frame.dispose();
			}
				else{
					JOptionPane.showMessageDialog(SLOTSUI.this, " Error!!! \n Area doesn't exist");
					textField1.setText("");
					}
				}
				else{
					JOptionPane.showMessageDialog(SLOTSUI.this," Error!!! \n Center code is invalid");
				textField.setText("");
				textField1.setText("");
			}
			}}
		);
		
		textField1 = new JTextField();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(19)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblid)
								.addComponent(lblpassword))
							.addGap(47)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(textField1)
								.addComponent(textField, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE))
							.addGroup(gl_contentPane.createParallelGroup()
									.addComponent(btnLogin))))
					)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
			  .addGroup(gl_contentPane.createSequentialGroup()
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblid)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblpassword)
						.addComponent(textField1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup()
							.addComponent(btnLogin))
		));
		contentPane.setLayout(gl_contentPane);
	}
}
