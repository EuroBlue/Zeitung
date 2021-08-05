import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
public class Login extends MainClass implements ActionListener {
	private static JFrame loginFrame;
	private static JPanel loginPanel;
	private static JLabel loginLabel;
	private static JTextField userField;
	private static JLabel usernameLabel;
	private static JLabel passwordLabel;
	private static JPasswordField passField;
	private static JButton loginKnopf;
	private static JButton registerKnopf;
	public static void start(String username)
	{
		loginPanel=new JPanel();
		loginPanel.setLayout(null);
		
		loginFrame=new JFrame("Zeitung | Login");
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.setVisible(true);
		loginFrame.add(loginPanel);
		loginFrame.setResizable(false);
		//loginFrame.setIconImage(icon.getImage());
		setIcon(loginFrame);
		
		loginLabel=new JLabel("Login", SwingConstants.CENTER);
		loginLabel.setBounds(0, 0, 550, 70);
		loginLabel.setFont(new Font("Calibri", Font.PLAIN, 50));
		loginLabel.setVisible(true);
		loginPanel.add(loginLabel);
		loginLabel.setVisible(true);		
		userField=new JTextField();
		userField.setBounds(250, 75, 250, 30);
		userField.setFont(new Font("Calibri", Font.PLAIN, 25));
		userField.setVisible(true);
		loginPanel.add(userField);
		userField.setVisible(true);
		userField.setText(username);

		
		usernameLabel=new JLabel("Username:");
		usernameLabel.setBounds(25,77,150,30);
		usernameLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
		usernameLabel.setVisible(true);
		loginPanel.add(usernameLabel);
		usernameLabel.setVisible(true);
		
		passwordLabel=new JLabel("Password:");
		passwordLabel.setBounds(25,152,150,30);
		passwordLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
		passwordLabel.setVisible(true);
		loginPanel.add(passwordLabel);
		passwordLabel.setVisible(true);

		passField=new JPasswordField();
		passField.setBounds(250, 150, 250, 30);
		passField.setFont(new Font("Calibri", Font.PLAIN, 25));
		passField.setVisible(true);
		loginPanel.add(passField);
		passField.setVisible(true);
		
		loginKnopf=new JButton("Login");
		loginKnopf.setBounds(300, 250, 150, 60);
		loginPanel.add(loginKnopf);
		loginKnopf.setFont(new Font("Calibri", Font.PLAIN, 25));
		loginKnopf.addActionListener(new Login());
		
		registerKnopf=new JButton("Register");
		registerKnopf.setBounds(100, 250, 150, 60);
		loginPanel.add(registerKnopf);
		registerKnopf.setFont(new Font("Calibri", Font.PLAIN, 25));
		registerKnopf.addActionListener(new Login());
		
		loginFrame.setSize(550, 400);
		loginFrame.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==loginKnopf)
		{
			String a=String.valueOf(passField.getPassword());
			String b=userField.getText();
			String nichts="";
			if(b.equals(nichts)||a.equals(nichts))
			{
				JOptionPane.showMessageDialog(loginFrame, "Please fill all textfields", "Error", JOptionPane.ERROR_MESSAGE);
			}
			else
			{
				List<String> userList = Arrays.asList(Kunde.getKL());
				if(userList.contains(b))
				{
					List<String> passList = Arrays.asList(Kunde.getPL());
					if(passList.contains(a))
					{
						int pID=findIDKunde(b);
						String passString=Kunde.getPass(pID);
						boolean match=false; 
						match=(a.equals(passString));
						if(match==true)
						{
							Kunde user=Kunde.getZeichen(pID);
							Cabinet.start(user);
							loginFrame.dispose();
						}
						else
						{
							JOptionPane.showMessageDialog(loginFrame, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(loginFrame, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
				else
				{
					JOptionPane.showMessageDialog(loginFrame, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		if(e.getSource()==registerKnopf)
		{
			String b=userField.getText();
			Register.start(b);
			loginFrame.dispose();
		}
	}
}
