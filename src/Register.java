import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
public class Register extends MainClass implements ActionListener {
	private static JFrame registerFrame;
	private static JPanel registerPanel;
	private static JLabel registerLabel;
	private static JTextField userField;
	private static JLabel usernameLabel;
	private static JTextField fnField;
	private static JLabel fnLabel;
	private static JTextField lnField;
	private static JLabel lnLabel;
	private static JTextField telefonField;
	private static JLabel telefonLabel;
	private static JLabel passwordLabel;
	private static JPasswordField passField;
	private static JLabel confPasswordLabel;
	private static JPasswordField confPassField;
	private static JButton loginKnopf;
	private static JButton registerKnopf;
	public static void start(String username)
	{
		registerPanel=new JPanel();
		registerPanel.setLayout(null);
		
		registerFrame=new JFrame("Zeitung | Registration");
		registerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		registerFrame.setVisible(true);
		registerFrame.add(registerPanel);
		registerFrame.setResizable(false);
		registerFrame.setIconImage(icon.getImage());
		
		registerLabel=new JLabel("Registration", SwingConstants.CENTER);
		registerLabel.setBounds(0, 0, 550, 70);
		registerLabel.setFont(new Font("Calibri", Font.PLAIN, 50));
		registerLabel.setVisible(true);
		registerPanel.add(registerLabel);
		registerLabel.setVisible(true);
		
		userField=new JTextField();
		userField.setBounds(250, 75, 250, 30);
		userField.setFont(new Font("Calibri", Font.PLAIN, 25));
		userField.setVisible(true);
		registerPanel.add(userField);
		userField.setVisible(true);
		userField.setText(username);
		
		usernameLabel=new JLabel("Username:");
		usernameLabel.setBounds(25,77,150,30);
		usernameLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
		usernameLabel.setVisible(true);
		registerPanel.add(usernameLabel);
		usernameLabel.setVisible(true);
		
		fnField=new JTextField();
		fnField.setBounds(250, 150, 250, 30);
		fnField.setFont(new Font("Calibri", Font.PLAIN, 25));
		fnField.setVisible(true);
		registerPanel.add(fnField);
		fnField.setVisible(true);
		
		fnLabel=new JLabel("First Name:");
		fnLabel.setBounds(25,152,150,30);
		fnLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
		fnLabel.setVisible(true);
		registerPanel.add(fnLabel);
		fnLabel.setVisible(true);
		
		lnField=new JTextField();
		lnField.setBounds(250, 225, 250, 30);
		lnField.setFont(new Font("Calibri", Font.PLAIN, 25));
		lnField.setVisible(true);
		registerPanel.add(lnField);
		lnField.setVisible(true);
		
		lnLabel=new JLabel("Last Name:");
		lnLabel.setBounds(25,227,150,30);
		lnLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
		lnLabel.setVisible(true);
		registerPanel.add(lnLabel);
		lnLabel.setVisible(true);
		
		telefonField=new JTextField();
		telefonField.setBounds(250, 300, 250, 30);
		telefonField.setFont(new Font("Calibri", Font.PLAIN, 25));
		telefonField.setVisible(true);
		registerPanel.add(telefonField);
		telefonField.setVisible(true);
		
		telefonLabel=new JLabel("Telephone Number:");
		telefonLabel.setBounds(25,302,250,30);
		telefonLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
		telefonLabel.setVisible(true);
		registerPanel.add(telefonLabel);
		telefonLabel.setVisible(true);
		
		passwordLabel=new JLabel("Password:");
		passwordLabel.setBounds(25,377,150,30);
		passwordLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
		passwordLabel.setVisible(true);
		registerPanel.add(passwordLabel);
		passwordLabel.setVisible(true);

		passField=new JPasswordField();
		passField.setBounds(250, 375, 250, 30);
		passField.setFont(new Font("Calibri", Font.PLAIN, 25));
		passField.setVisible(true);
		registerPanel.add(passField);
		passField.setVisible(true);
		
		confPasswordLabel=new JLabel("Confirm Password:");
		confPasswordLabel.setBounds(25,452,250,30);
		confPasswordLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
		confPasswordLabel.setVisible(true);
		registerPanel.add(confPasswordLabel);
		confPasswordLabel.setVisible(true);

		confPassField=new JPasswordField();
		confPassField.setBounds(250, 450, 250, 30);
		confPassField.setFont(new Font("Calibri", Font.PLAIN, 25));
		confPassField.setVisible(true);
		registerPanel.add(confPassField);
		confPassField.setVisible(true);
		
		loginKnopf=new JButton("Login");
		loginKnopf.setBounds(300, 525, 150, 60);
		registerPanel.add(loginKnopf);
		loginKnopf.setFont(new Font("Calibri", Font.PLAIN, 25));
		loginKnopf.addActionListener(new Register());
		
		registerKnopf=new JButton("Register");
		registerKnopf.setBounds(100, 525, 150, 60);
		registerPanel.add(registerKnopf);
		registerKnopf.setFont(new Font("Calibri", Font.PLAIN, 25));
		registerKnopf.addActionListener(new Register());
		
		registerFrame.setSize(550, 675);
		registerFrame.setLocationRelativeTo(null);
	}
	@Override
	public void actionPerformed(ActionEvent click) 
	{
		// TODO Auto-generated method stub
		if(click.getSource()==registerKnopf)
		{
			String a=userField.getText();
			String b=fnField.getText();
			String c=lnField.getText();
			String d=telefonField.getText();
			String e=String.valueOf(passField.getPassword());
			String f=String.valueOf(confPassField.getPassword());
			String nichts="";
			if(a.equals(nichts)||b.equals(nichts)||c.equals(nichts)||d.equals(nichts)||e.equals(nichts)||f.equals(nichts))
			{
				JOptionPane.showMessageDialog(registerFrame, "Please fill all textfields", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				if(e.equals(f))
				{
					List<String> userList = Arrays.asList(Kunde.getKL());
					if(userList.contains(a))
					{
						JOptionPane.showMessageDialog(registerFrame, "That username is already taken", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
					new Kunde(a,e,b,c,d,(0.0f));
					FileWriter(a+"&"+e+"&"+b+"&"+c+"&"+d+"&"+0+"&",0);
					Login.start(a);
					registerFrame.dispose();
					}
					
				}
				else
				{
					JOptionPane.showMessageDialog(registerFrame, "Password's doesn't match", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		if(click.getSource()==loginKnopf)
		{
			Login.start("");
			registerFrame.dispose();
		}
	}
}