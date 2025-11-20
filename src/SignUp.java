import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class SignUp extends JFrame implements ActionListener {

    JLabel userLabel, emailLabel, phoneLabel, passLabel, confirmPassLabel;
    JTextField userText, emailText, phoneText;
    JPasswordField passText, confirmPassText;
    JButton confirmButton, clearButton, back_button;

    public SignUp()
    {
        setTitle("Sign Up");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        userLabel = new JLabel("Username");
        userLabel.setBounds(20, 20, 80, 25);
        userLabel.setForeground(new Color(0xffffff));
        add(userLabel);
        userText = new JTextField(20);
        userText.setBounds(100, 20, 250, 25);
        add(userText);

        emailLabel = new JLabel("Email");
        emailLabel.setBounds(20, 60, 80, 25);
        emailLabel.setForeground(new Color(0xffffff));
        add(emailLabel);
        emailText = new JTextField(20);
        emailText.setBounds(100, 60, 250, 25);
        add(emailText);

        phoneLabel = new JLabel("Phone No");
        phoneLabel.setBounds(20, 100, 80, 25);
        phoneLabel.setForeground(new Color(0xffffff));
        add(phoneLabel);
        phoneText = new JTextField(20);
        phoneText.setBounds(100, 100, 250, 25);
        add(phoneText);

        passLabel = new JLabel("Password");
        passLabel.setBounds(20, 140, 80, 25);
        passLabel.setForeground(new Color(0xffffff));
        add(passLabel);
        passText = new JPasswordField(20);
        passText.setBounds(100, 140, 250, 25);
        add(passText);

        confirmPassLabel = new JLabel("Confirm Password");
        confirmPassLabel.setBounds(20, 180, 120, 25);
        confirmPassLabel.setForeground(new Color(0xffffff));
        add(confirmPassLabel);
        confirmPassText = new JPasswordField(20);
        confirmPassText.setBounds(140, 180, 210, 25);
        add(confirmPassText);

        confirmButton = new JButton("Confirm");
        confirmButton.setBounds(100, 240, 80, 25);
        add(confirmButton);
        clearButton = new JButton("Clear");
        clearButton.setBounds(200, 240, 80, 25);
        add(clearButton);
        back_button = new JButton("Back");
        back_button.setBounds(150, 280, 80, 25);
        add(back_button);

        confirmButton.addActionListener(this);
        clearButton.addActionListener(this);
        back_button.addActionListener(this);
        setVisible(true);
        ImageIcon logo1 = new ImageIcon("img.png");
        setIconImage(logo1.getImage());
        getContentPane().setBackground(new Color((0x5855bc)));
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == confirmButton)
        {
            String username = userText.getText();
            String email = emailText.getText();
            String phoneNo = phoneText.getText();
            String password = String.valueOf(passText.getPassword());
            String confirmPassword = String.valueOf(confirmPassText.getPassword());

            if (username.equals("") || email.equals("") || phoneNo.equals("") || password.equals("") || confirmPassword.equals(""))
            {
                JOptionPane.showMessageDialog(this, "Please fill all the fields.");
            }
            else if (!password.equals(confirmPassword))
            {
                JOptionPane.showMessageDialog(this, "Passwords do not match.");
            }
            else
            {
                try
                {
                    FileWriter fw = new FileWriter("D:\\CSE310\\transport_sys\\Person_details.txt", true);
                    fw.write(username + "," + email + "," + phoneNo + "," + password + "\n");
                    fw.close();

                    JOptionPane.showMessageDialog(this, "Details saved successfully.");
                    userText.setText("");
                    emailText.setText("");
                    phoneText.setText("");
                    passText.setText("");
                    confirmPassText.setText("");
                    Vehicle vehicle = new Vehicle();
                    vehicle.setVisible(true);

                    setVisible(false);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        else if (e.getSource() == clearButton)
        {
            userText.setText("");
            emailText.setText("");
            phoneText.setText("");
            passText.setText("");
            confirmPassText.setText("");
        }
        else if (e.getSource() == back_button)
        {
            dispose();
            Main m =new Main();
        }
    }

    public static void main(String[] args) {
        SignUp signUp = new SignUp();
    }
}
