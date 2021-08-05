import java.lang.reflect.*;
import java.util.Arrays;
import java.util.List;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
public class Cabinet extends MainClass implements ActionListener {
	private static JFrame cabinetFrame;
	private static JPanel cabinetPanel;
	private static JLabel cabinetLabel;
	private static JTextField userField;
	private static JLabel usernameLabel;
	private static JTextField fnField;
	private static JLabel fnLabel;
	private static JTextField lnField;
	private static JLabel lnLabel;
	private static JTextField telefonField;
	private static JLabel telefonLabel;
	private static JLabel passwordLabel;
	private static JButton SaveChangeKnopf;
	private static JButton DeleteAccKnopf;
	private static JPasswordField passField;
	private static JPasswordField oldPassField;
	private static JPasswordField newPassField;
	private static JPasswordField confNewPassField;
	private static JLabel oldPassLabel;
	private static JLabel newPassLabel;
	private static JLabel confNewPassLabel;
	private static JButton saveNewPassKnopf;
	private static JLabel currentBalanceLabel;
	private static JLabel chargeBalanceLabel;
	private static JTextField chargeBalanceField;
	private static JTextField titleField;
	private static JSpinner lineField;
	private static JLabel titleLabel;
	private static JLabel lineLabel;
	private static JComboBox anzeigeBox;
	private static JButton SaveChangeAdverKnopf;
	private static JButton DeleteAdverKnopf;
	private static JButton createAdvKnopf;
	private static JButton chargeBalanceKnopf;
	private static JButton logOutKnopf;
	private static JButton changePassKnopf;
	private static JButton editPersonalDataKnopf;
	private static JButton balanceKnopf;
	private static JButton editAdverKnopf;
	private static JButton newAdverKnopf;
	private static Kunde kund;
	private static void clear()
	{
		if(oldPassField!=null)
		{
			cabinetPanel.remove(oldPassField);
		}
		if(newPassField!=null)
		{
			cabinetPanel.remove(newPassField);
		}
		if(confNewPassField!=null)
		{
			cabinetPanel.remove(confNewPassField);
		}
		if(oldPassLabel!=null)
		{
			cabinetPanel.remove(oldPassLabel);
		}
		if(newPassLabel!=null)
		{
			cabinetPanel.remove(newPassLabel);
		}
		if(confNewPassLabel!=null)
		{
			cabinetPanel.remove(confNewPassLabel);
		}
		if(saveNewPassKnopf!=null)
		{
			cabinetPanel.remove(saveNewPassKnopf);
		}
		if(currentBalanceLabel!=null)
		{
			cabinetPanel.remove(currentBalanceLabel);
		}
		if(chargeBalanceField!=null)
		{
			cabinetPanel.remove(chargeBalanceField);
		}
		if(chargeBalanceLabel!=null)
		{
			cabinetPanel.remove(chargeBalanceLabel);
		}
		if(chargeBalanceKnopf!=null)
		{
			cabinetPanel.remove(chargeBalanceKnopf);
		}
		if(userField!=null)
		{
			cabinetPanel.remove(userField);
		}
		if(usernameLabel!=null)
		{
			cabinetPanel.remove(usernameLabel);
		}
		if(fnField!=null)
		{
			cabinetPanel.remove(fnField);
		}
		if(fnLabel!=null)
		{
			cabinetPanel.remove(fnLabel);
		}
		if(lnField!=null)
		{
			cabinetPanel.remove(lnField);
		}
		if(lnLabel!=null)
		{
			cabinetPanel.remove(lnLabel);
		}
		if(telefonField!=null)
		{
			cabinetPanel.remove(telefonField);
		}
		if(telefonLabel!=null)
		{
			cabinetPanel.remove(telefonLabel);
		}
		if(passwordLabel!=null)
		{
			cabinetPanel.remove(passwordLabel);
		}
		if(passField!=null)
		{
			cabinetPanel.remove(passField);
		}
		if(SaveChangeKnopf!=null)
		{
			cabinetPanel.remove(SaveChangeKnopf);
		}
		if(DeleteAccKnopf!=null)
		{
			cabinetPanel.remove(DeleteAccKnopf);
		}
		if(DeleteAccKnopf!=null)
		{
			cabinetPanel.remove(DeleteAccKnopf);
		}
		if(DeleteAccKnopf!=null)
		{
			cabinetPanel.remove(DeleteAccKnopf);
		}
		if(titleLabel!=null)
		{
			cabinetPanel.remove(titleLabel);
		}
		if(createAdvKnopf!=null)
		{
			cabinetPanel.remove(createAdvKnopf);
		}
		if(titleField!=null)
		{
			cabinetPanel.remove(titleField);
		}
		if(lineLabel!=null)
		{
			cabinetPanel.remove(lineLabel);
		}
		if(lineField!=null)
		{
			cabinetPanel.remove(lineField);
		}
		if(anzeigeBox!=null)
		{
			cabinetPanel.remove(anzeigeBox);
		}
		if(SaveChangeAdverKnopf!=null)
		{
			cabinetPanel.remove(SaveChangeAdverKnopf);
		}
		if(DeleteAdverKnopf!=null)
		{
			cabinetPanel.remove(DeleteAdverKnopf);
		}
		cabinetPanel.revalidate();
		cabinetPanel.repaint();
	}
	private static void reloadAdverEdit(int l)
	{
		clear();
		
		String[] persAdverList=Anzeige.createPersAnzeigeList(kund);
		Anzeige[] andvZeichenList=Anzeige.createPersAnzeigeNonStrList(kund);
		if(persAdverList.length==0)
		{
			clear();
			JOptionPane.showMessageDialog(cabinetFrame, "You don't have any Advertisements yet", "Error", JOptionPane.ERROR_MESSAGE);
		}
		else
		{
			anzeigeBox=new JComboBox(persAdverList);
			anzeigeBox.setBounds(425, 200, 250, 30);
			anzeigeBox.setFont(new Font("Calibri", Font.PLAIN, 25));
			anzeigeBox.setVisible(true);
			cabinetPanel.add(anzeigeBox);
			anzeigeBox.setVisible(true);
			anzeigeBox.addActionListener(new Cabinet());
			anzeigeBox.setSelectedIndex(l);
			
			titleLabel=new JLabel("Advertisement Title:");
			titleLabel.setBounds(300,252,250,30);
			titleLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
			titleLabel.setVisible(true);
			cabinetPanel.add(titleLabel);
			titleLabel.setVisible(true);
			
			titleField=new JTextField();
			titleField.setBounds(575, 250, 250, 30);
			titleField.setFont(new Font("Calibri", Font.PLAIN, 25));
			titleField.setVisible(true);
			cabinetPanel.add(titleField);
			titleField.setVisible(true);
			titleField.setText(andvZeichenList[l].getTitel());
			
			lineLabel=new JLabel("Number of lines:");
			lineLabel.setBounds(300,307,275,30);
			lineLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
			lineLabel.setVisible(true);
			cabinetPanel.add(lineLabel);
			lineLabel.setVisible(true);
			
			lineField=new JSpinner();
			lineField.setBounds(575, 305, 250, 30);
			lineField.setFont(new Font("Calibri", Font.PLAIN, 25));
			lineField.setVisible(true);
			cabinetPanel.add(lineField);
			lineField.setVisible(true);
			lineField.setValue(andvZeichenList[l].getZA());
			
			SaveChangeAdverKnopf=new JButton("Save Changes");
			SaveChangeAdverKnopf.setText("<html><p style=\"text-align:center;\">Save<br />Changes</p></html>");
			SaveChangeAdverKnopf.setHorizontalTextPosition(SwingConstants.CENTER);
			SaveChangeAdverKnopf.setBounds(575, 650, 150, 60);
			cabinetPanel.add(SaveChangeAdverKnopf);
			SaveChangeAdverKnopf.setFont(new Font("Calibri", Font.PLAIN, 20));
			SaveChangeAdverKnopf.addActionListener(new Cabinet());
			
			DeleteAdverKnopf=new JButton("Delete Advertisement");
			DeleteAdverKnopf.setText("<html><p style=\"text-align:center;\">Delete<br />Advertisement</p></html>");
			DeleteAdverKnopf.setHorizontalTextPosition(SwingConstants.CENTER);
			DeleteAdverKnopf.setBounds(375, 650, 150, 60);
			cabinetPanel.add(DeleteAdverKnopf);
			DeleteAdverKnopf.setFont(new Font("Calibri", Font.PLAIN, 20));
			DeleteAdverKnopf.addActionListener(new Cabinet());
			
			cabinetPanel.revalidate();
			cabinetPanel.repaint();
		}
	}
	public static void start(Kunde k)
	{
		kund=k;
		cabinetPanel=new JPanel();
		cabinetPanel.setLayout(null);
		
		cabinetFrame=new JFrame("Zeitung | Personal Cabinet");
		cabinetFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		cabinetFrame.setVisible(true);
		cabinetFrame.add(cabinetPanel);
		cabinetFrame.setResizable(false);
		cabinetFrame.setIconImage(icon.getImage());
		
		cabinetLabel=new JLabel(k.getName()+"'s "+"Personal Cabinet", SwingConstants.CENTER);
		cabinetLabel.setBounds(0, 0, 1100, 70);
		cabinetLabel.setFont(new Font("Calibri", Font.PLAIN, 50));
		cabinetLabel.setVisible(true);
		cabinetPanel.add(cabinetLabel);
		cabinetLabel.setVisible(true);
		
		logOutKnopf=new JButton("Log Out");
		logOutKnopf.setBounds(25, 100, 150, 60);
		cabinetPanel.add(logOutKnopf);
		logOutKnopf.setFont(new Font("Calibri", Font.PLAIN, 20));
		logOutKnopf.addActionListener(new Cabinet());
		
		changePassKnopf=new JButton("Change Password");
		changePassKnopf.setText("<html><p style=\"text-align:center;\">Change<br />Password</p></html>");
		changePassKnopf.setBounds(200, 100, 150, 60);
		cabinetPanel.add(changePassKnopf);
		changePassKnopf.setFont(new Font("Calibri", Font.PLAIN, 20));
		changePassKnopf.addActionListener(new Cabinet());
		
		editPersonalDataKnopf=new JButton("Edit Personal Data");
		editPersonalDataKnopf.setText("<html><p style=\"text-align:center;\">Edit or Delete<br />your Account</p></html>");
		editPersonalDataKnopf.setBounds(375, 100, 150, 60);
		cabinetPanel.add(editPersonalDataKnopf);
		editPersonalDataKnopf.setFont(new Font("Calibri", Font.PLAIN, 20));
		editPersonalDataKnopf.addActionListener(new Cabinet());
		
		balanceKnopf=new JButton("Balance");
		balanceKnopf.setBounds(550, 100, 150, 60);
		cabinetPanel.add(balanceKnopf);
		balanceKnopf.setFont(new Font("Calibri", Font.PLAIN, 20));
		balanceKnopf.addActionListener(new Cabinet());
		
		editAdverKnopf=new JButton("Edit or Delete your Advertisement");
		editAdverKnopf.setText("<html><p style=\"text-align:center;\">Edit or Delete<br />Advertisement</p></html>");
		editAdverKnopf.setBounds(725, 100, 150, 60);
		cabinetPanel.add(editAdverKnopf);
		editAdverKnopf.setFont(new Font("Calibri", Font.PLAIN, 20));
		editAdverKnopf.addActionListener(new Cabinet());
		
		newAdverKnopf=new JButton("Buy new advertisement");
		newAdverKnopf.setText("<html><p style=\"text-align:center;\">Buy new<br />Advertisement</p></html>");
		newAdverKnopf.setHorizontalTextPosition(SwingConstants.CENTER);
		newAdverKnopf.setBounds(900, 100, 150, 60);
		cabinetPanel.add(newAdverKnopf);
		newAdverKnopf.setFont(new Font("Calibri", Font.PLAIN, 20));
		newAdverKnopf.addActionListener(new Cabinet());
		
		cabinetFrame.setSize(1100, 800);
		cabinetFrame.setLocationRelativeTo(null);
	}
	@Override
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==logOutKnopf)
		{
			Login.start("");
			cabinetFrame.dispose();
		}
		if(e.getSource()==changePassKnopf)
		{
			clear();
			oldPassField=new JPasswordField();
			oldPassField.setBounds(575, 250, 250, 30);
			oldPassField.setFont(new Font("Calibri", Font.PLAIN, 25));
			oldPassField.setVisible(true);
			cabinetPanel.add(oldPassField);
			oldPassField.setVisible(true);
			
			oldPassLabel=new JLabel("Old Password:");
			oldPassLabel.setBounds(300, 252, 250, 30);
			oldPassLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
			oldPassLabel.setVisible(true);
			cabinetPanel.add(oldPassLabel);
			oldPassLabel.setVisible(true);
			
			newPassField=new JPasswordField();
			newPassField.setBounds(575, 305, 250, 30);
			newPassField.setFont(new Font("Calibri", Font.PLAIN, 25));
			newPassField.setVisible(true);
			cabinetPanel.add(newPassField);
			newPassField.setVisible(true);
			
			newPassLabel=new JLabel("New Password:");
			newPassLabel.setBounds(300, 307, 250, 30);
			newPassLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
			newPassLabel.setVisible(true);
			cabinetPanel.add(newPassLabel);
			newPassLabel.setVisible(true);
			
			confNewPassField=new JPasswordField();
			confNewPassField.setBounds(575, 360, 250, 30);
			confNewPassField.setFont(new Font("Calibri", Font.PLAIN, 25));
			confNewPassField.setVisible(true);
			cabinetPanel.add(confNewPassField);
			confNewPassField.setVisible(true);
			
			confNewPassLabel=new JLabel("Confirm New Password:");
			confNewPassLabel.setBounds(300, 362, 250, 30);
			confNewPassLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
			confNewPassLabel.setVisible(true);
			cabinetPanel.add(confNewPassLabel);
			confNewPassLabel.setVisible(true);
			
			saveNewPassKnopf=new JButton("Save new Password");
			saveNewPassKnopf.setText("<html><p style=\"text-align:center;\">Save new<br />Password</p></html>");
			saveNewPassKnopf.setHorizontalTextPosition(SwingConstants.CENTER);
			saveNewPassKnopf.setBounds(475, 650, 150, 60);
			cabinetPanel.add(saveNewPassKnopf);
			saveNewPassKnopf.setFont(new Font("Calibri", Font.PLAIN, 20));
			saveNewPassKnopf.addActionListener(new Cabinet());
			
			cabinetPanel.revalidate();
			cabinetPanel.repaint();
		}
		if(e.getSource()==saveNewPassKnopf)
		{
			String a=String.valueOf(oldPassField.getPassword());
			String b=String.valueOf(newPassField.getPassword());
			String c=String.valueOf(confNewPassField.getPassword());
			String d=kund.getKundPass();
			
			if(a.equals(d))
			{
				if(b.equals(c))
				{
					kund.editPass(b,a);
					FileUpdate();
					clear();
				}
				else
				{
					JOptionPane.showMessageDialog(cabinetFrame, "New Password's doesn't match", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(cabinetFrame, "Invalid Old Password", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource()==balanceKnopf)
		{
			
			clear();
			
			currentBalanceLabel=new JLabel("Current Balance: " +kund.getGeld()+"�",  SwingConstants.CENTER);
			currentBalanceLabel.setBounds(0, 200, 1100, 30);
			currentBalanceLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
			currentBalanceLabel.setVisible(true);
			cabinetPanel.add(currentBalanceLabel);
			currentBalanceLabel.setVisible(true);
			
			chargeBalanceField=new JTextField();
			chargeBalanceField.setBounds(575, 305, 250, 30);
			chargeBalanceField.setFont(new Font("Calibri", Font.PLAIN, 25));
			chargeBalanceField.setVisible(true);
			cabinetPanel.add(chargeBalanceField);
			chargeBalanceField.setVisible(true);
			
			chargeBalanceLabel=new JLabel("Charge Balance:");
			chargeBalanceLabel.setBounds(300, 307, 250, 30);
			chargeBalanceLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
			chargeBalanceLabel.setVisible(true);
			cabinetPanel.add(chargeBalanceLabel);
			chargeBalanceLabel.setVisible(true);
			
			chargeBalanceKnopf=new JButton("Charge Balance");
			chargeBalanceKnopf.setText("<html><p style=\"text-align:center;\">Charge<br />Balance</p></html>");
			chargeBalanceKnopf.setHorizontalTextPosition(SwingConstants.CENTER);
			chargeBalanceKnopf.setBounds(475, 650, 150, 60);
			cabinetPanel.add(chargeBalanceKnopf);
			chargeBalanceKnopf.setFont(new Font("Calibri", Font.PLAIN, 20));
			chargeBalanceKnopf.addActionListener(new Cabinet());
			
			cabinetPanel.revalidate();
			cabinetPanel.repaint();
		}
		if(e.getSource()==chargeBalanceKnopf)
		{
			String nichts="";
			
			if(chargeBalanceField.getText()!=null)
			{
				if(chargeBalanceField.getText().equals(nichts))
				{
					JOptionPane.showMessageDialog(cabinetFrame, "Please fill all textfields", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else
				{
					float a = Float.parseFloat(chargeBalanceField.getText());
					float b = kund.getGeld();
					if(a<=0)
					{
						JOptionPane.showMessageDialog(cabinetFrame, "The ammount of money you will add to you Balance must be bigger than 0", "Error", JOptionPane.ERROR_MESSAGE);
					}
					else
					{
						kund.setGeld(b+a);
						currentBalanceLabel.setText("Current Balance: " +kund.getGeld()+"�" );
						chargeBalanceField.setText("");
					}
				}
				FileUpdate();
			
			}
			
			else
			{
				JOptionPane.showMessageDialog(cabinetFrame, "Please fill all textfields", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource()==editPersonalDataKnopf)
		{
			clear();
			userField=new JTextField();
			userField.setBounds(575, 250, 250, 30);
			userField.setFont(new Font("Calibri", Font.PLAIN, 25));
			userField.setVisible(true);
			cabinetPanel.add(userField);
			userField.setVisible(true);
			userField.setText(kund.getUsername());
			
			usernameLabel=new JLabel("Username:");
			usernameLabel.setBounds(300,252,150,30);
			usernameLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
			usernameLabel.setVisible(true);
			cabinetPanel.add(usernameLabel);
			usernameLabel.setVisible(true);
			userField.setText(kund.getUsername());
			
			fnField=new JTextField();
			fnField.setBounds(575, 305, 250, 30);
			fnField.setFont(new Font("Calibri", Font.PLAIN, 25));
			fnField.setVisible(true);
			cabinetPanel.add(fnField);
			fnField.setVisible(true);
			fnField.setText(kund.getFName());
			
			fnLabel=new JLabel("First Name:");
			fnLabel.setBounds(300,307,150,30);
			fnLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
			fnLabel.setVisible(true);
			cabinetPanel.add(fnLabel);
			fnLabel.setVisible(true);
			
			lnField=new JTextField();
			lnField.setBounds(575, 360, 250, 30);
			lnField.setFont(new Font("Calibri", Font.PLAIN, 25));
			lnField.setVisible(true);
			cabinetPanel.add(lnField);
			lnField.setVisible(true);
			lnField.setText(kund.getLName());
			
			lnLabel=new JLabel("Last Name:");
			lnLabel.setBounds(300,362,150,30);
			lnLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
			lnLabel.setVisible(true);
			cabinetPanel.add(lnLabel);
			lnLabel.setVisible(true);
			
			telefonField=new JTextField();
			telefonField.setBounds(575,415, 250, 30);
			telefonField.setFont(new Font("Calibri", Font.PLAIN, 25));
			telefonField.setVisible(true);
			cabinetPanel.add(telefonField);
			telefonField.setVisible(true);
			telefonField.setText(kund.getTelefon());
			
			telefonLabel=new JLabel("Telephone Number:");
			telefonLabel.setBounds(300,417,250,30);
			telefonLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
			telefonLabel.setVisible(true);
			cabinetPanel.add(telefonLabel);
			telefonLabel.setVisible(true);
			
			passwordLabel=new JLabel("Password:");
			passwordLabel.setBounds(300,472,150,30);
			passwordLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
			passwordLabel.setVisible(true);
			cabinetPanel.add(passwordLabel);
			passwordLabel.setVisible(true);

			passField=new JPasswordField();
			passField.setBounds(575, 470, 250, 30);
			passField.setFont(new Font("Calibri", Font.PLAIN, 25));
			passField.setVisible(true);
			cabinetPanel.add(passField);
			passField.setVisible(true);
			
			SaveChangeKnopf=new JButton("Save Changes");
			SaveChangeKnopf.setText("<html><p style=\"text-align:center;\">Save<br />Changes</p></html>");
			SaveChangeKnopf.setHorizontalTextPosition(SwingConstants.CENTER);
			SaveChangeKnopf.setBounds(575, 650, 150, 60);
			cabinetPanel.add(SaveChangeKnopf);
			SaveChangeKnopf.setFont(new Font("Calibri", Font.PLAIN, 20));
			SaveChangeKnopf.addActionListener(new Cabinet());
			
			DeleteAccKnopf=new JButton("Delete Account");
			DeleteAccKnopf.setText("<html><p style=\"text-align:center;\">Delete<br />Account</p></html>");
			DeleteAccKnopf.setHorizontalTextPosition(SwingConstants.CENTER);
			DeleteAccKnopf.setBounds(375, 650, 150, 60);
			cabinetPanel.add(DeleteAccKnopf);
			DeleteAccKnopf.setFont(new Font("Calibri", Font.PLAIN, 20));
			DeleteAccKnopf.addActionListener(new Cabinet());
		}
		if(e.getSource()==SaveChangeKnopf)
		{
			String a=kund.getKundPass();
			String b=String.valueOf(passField.getPassword());
			if(a.equals(b))
			{
				int id=findIDKunde(kund.getUsername());
				kund.setUsername(userField.getText());
				kund.setVorname(fnField.getText());
				kund.setNachname(lnField.getText());
				kund.setTelefon(telefonField.getText());
				Kunde.setList(id,userField.getText());
				cabinetLabel.setText(kund.getName()+"'s "+"Personal Cabinet");
				FileUpdate();
			}
			else
			{
				JOptionPane.showMessageDialog(cabinetFrame, "Invalid Password", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource()==DeleteAccKnopf)
		{
			String a=kund.getKundPass();
			String b=String.valueOf(passField.getPassword());
			if(a.equals(b))
			{
				int id=findIDKunde(kund.getUsername());
				kund=null;
				Kunde.deleteAcc(id);
				Login.start("");
				cabinetFrame.dispose();
				FileUpdate();
			}
			else
			{
				JOptionPane.showMessageDialog(cabinetFrame, "Invalid Password", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		if(e.getSource()==editAdverKnopf)
		{
			Cabinet.reloadAdverEdit(0);
		}
		if(e.getSource()==SaveChangeAdverKnopf)
		{
			int a=anzeigeBox.getSelectedIndex();
			Anzeige[] andvZeichenList=Anzeige.createPersAnzeigeNonStrList(kund);
			String[] persAdverList=Anzeige.createPersAnzeigeList(kund);
			float b=Float.parseFloat(lineField.getValue().toString());
			float a1=andvZeichenList[a].getPreis();
			float a2=Anzeige.getMBPreis(b);
			if(a2<=a1)
			{
				andvZeichenList[a].setZeileA((int) b);
				andvZeichenList[a].setTitel(titleField.getText());
				persAdverList[a]=titleField.getText();
				if(a2!=a1)
				{
					kund.setGeld(kund.getGeld()-(a2-a1));
					FileUpdate();
					JOptionPane.showMessageDialog(cabinetFrame, "You successfully edited this Advertisement", "Info", JOptionPane.INFORMATION_MESSAGE);
					JOptionPane.showMessageDialog(cabinetFrame, "Through the editing of this Advertisement you became "+((a2-a1)*(-1))+"� back", "Info", JOptionPane.INFORMATION_MESSAGE);
					
				}
			}
			else
			{
				int o=JOptionPane.showConfirmDialog(cabinetFrame, "The Price of the Advertisement will be on "+ (a2-a1) +"� bigger.\nWould you like to buy it?", "Confirmation",JOptionPane.YES_NO_OPTION);
				if(o==0)
				{
					if(kund.getGeld()>=(a2-a1))
					{
						andvZeichenList[a].setZeileA((int) b);
						andvZeichenList[a].setTitel(titleField.getText());
						persAdverList[a]=titleField.getText();
						if(a2!=a1)
						{
							kund.setGeld(kund.getGeld()-(a2-a1));
							FileUpdate();
							JOptionPane.showMessageDialog(cabinetFrame, "You successfully edited this Advertisement", "Info", JOptionPane.INFORMATION_MESSAGE);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(cabinetFrame, "Not enough money", "Error", JOptionPane.ERROR_MESSAGE);
					}
				}
			}			
			Cabinet.reloadAdverEdit(a);
		}
		if(e.getSource()==DeleteAdverKnopf)
		{
			Anzeige[] andvZeichenList=Anzeige.createPersAnzeigeNonStrList(kund);
			int a=anzeigeBox.getSelectedIndex();
			float p=andvZeichenList[a].getPreis();
			Anzeige.deleteAdver(a);
			kund.setGeld(kund.getGeld()+p);
			JOptionPane.showMessageDialog(cabinetFrame, "Through the delete of this Advertisement you became "+p+"� back", "Info", JOptionPane.INFORMATION_MESSAGE);
			andvZeichenList=Anzeige.createPersAnzeigeNonStrList(kund);
			String[] persAdverList=Anzeige.createPersAnzeigeList(kund);
			int elem=andvZeichenList.length;
			if(elem>=0)
			{
				Cabinet.reloadAdverEdit(0);
			}
			else
			{
				clear();
			}
			FileUpdate();
		}
		if(e.getSource()==anzeigeBox)
		{
			int a=anzeigeBox.getSelectedIndex();	
			if(titleField==null)
			{
				titleLabel=new JLabel("Advertisement Title:");
				titleLabel.setBounds(300,252,250,30);
				titleLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
				titleLabel.setVisible(true);
				cabinetPanel.add(titleLabel);
				titleLabel.setVisible(true);
				
				titleField=new JTextField();
				titleField.setBounds(575, 250, 250, 30);
				titleField.setFont(new Font("Calibri", Font.PLAIN, 25));
				titleField.setVisible(true);
				cabinetPanel.add(titleField);
				titleField.setVisible(true);
				
				lineLabel=new JLabel("Number of lines:");
				lineLabel.setBounds(300,307,275,30);
				lineLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
				lineLabel.setVisible(true);
				cabinetPanel.add(lineLabel);
				lineLabel.setVisible(true);
				
				lineField=new JSpinner();
				lineField.setBounds(575, 305, 250, 30);
				lineField.setFont(new Font("Calibri", Font.PLAIN, 25));
				lineField.setVisible(true);
				cabinetPanel.add(lineField);
				lineField.setVisible(true);
			}
			
			Anzeige[] andvZeichenList=Anzeige.createPersAnzeigeNonStrList(kund);
			titleField.setText(andvZeichenList[a].getTitel().toString());
			lineField.setValue(andvZeichenList[a].getZA());
		}
		if(e.getSource()==newAdverKnopf)
		{
			clear();
			
			titleLabel=new JLabel("Advertisement Title:");
			titleLabel.setBounds(300,252,250,30);
			titleLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
			titleLabel.setVisible(true);
			cabinetPanel.add(titleLabel);
			titleLabel.setVisible(true);
			
			titleField=new JTextField();
			titleField.setBounds(575, 250, 250, 30);
			titleField.setFont(new Font("Calibri", Font.PLAIN, 25));
			titleField.setVisible(true);
			cabinetPanel.add(titleField);
			titleField.setVisible(true);
			
			lineLabel=new JLabel("Number of lines:");
			lineLabel.setBounds(300,307,275,30);
			lineLabel.setFont(new Font("Calibri", Font.PLAIN, 25));
			lineLabel.setVisible(true);
			cabinetPanel.add(lineLabel);
			lineLabel.setVisible(true);
			
			lineField=new JSpinner();
			lineField.setBounds(575, 305, 250, 30);
			lineField.setFont(new Font("Calibri", Font.PLAIN, 25));
			lineField.setVisible(true);
			cabinetPanel.add(lineField);
			lineField.setVisible(true);
			
			createAdvKnopf=new JButton("Create Advertisement");
			createAdvKnopf.setText("<html><p style=\"text-align:center;\">Create<br />Advertisement</p></html>");
			createAdvKnopf.setHorizontalTextPosition(SwingConstants.CENTER);
			createAdvKnopf.setBounds(475, 650, 150, 60);
			cabinetPanel.add(createAdvKnopf);
			createAdvKnopf.setFont(new Font("Calibri", Font.PLAIN, 20));
			createAdvKnopf.addActionListener(new Cabinet());
		}
		if(e.getSource()==createAdvKnopf)
		{
			String a=(titleField.getText());
			int b=Integer.parseInt(lineField.getValue().toString());
			float c=Anzeige.getMBPreis(b);
			float d=kund.getGeld();
			int o=JOptionPane.showConfirmDialog(cabinetFrame, "The Price of the Advertisement is "+ c +"�\nWould you like to buy it?", "Confirmation",JOptionPane.YES_NO_OPTION);
			if(c<=d)
			{
				if(b>=0)
				{
					if(o==0)
					{
						JOptionPane.showMessageDialog(cabinetFrame, "You successfully bought a Advertisement", "Info", JOptionPane.INFORMATION_MESSAGE);
						new Anzeige(b,a,kund);
						kund.setGeld(d-c);
					}

				}
				else
				{
					JOptionPane.showMessageDialog(cabinetFrame, "Number of lines must be bigger than 0", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(cabinetFrame, "Not enough money", "Error", JOptionPane.ERROR_MESSAGE);
			}
			FileUpdate();
		}
	}
}

