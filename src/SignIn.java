import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class SignIn extends JFrame implements ActionListener {
    // Create components
    JLabel label1, label2, label3;
    JTextField textField1;
    JPasswordField passwordField;
    JButton loginButton, signupButton;

    public SignIn() {
        // Set frame properties
        setTitle("Transport Enquiry System - Login/Signup");
        setSize(500, 300);
        setLayout(new GridLayout(4, 2));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize components
        label1 = new JLabel("Username:");
        label2 = new JLabel("Password:");
        label3 = new JLabel("");

        textField1 = new JTextField(20);
        passwordField = new JPasswordField(20);

        loginButton = new JButton("Login");
        signupButton = new JButton("Signup");

        // Add components to frame
        add(label1);
        add(textField1);
        add(label2);
        add(passwordField);
        add(loginButton);
        add(signupButton);
        add(label3);

        // Add action listeners
        loginButton.addActionListener(this);
        signupButton.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            // Code for login button
            String username = textField1.getText();
            String password = new String(passwordField.getPassword());

            // Check if username and password are correct
            if (username.equals("admin") && password.equals("admin123")) {
                label3.setText("Login Successful!");
            } else {
                label3.setText("Invalid Username or Password!");
            }
        } else if (e.getSource() == signupButton) {
            // Code for signup button
            JOptionPane.showMessageDialog(this, "Sign up with mobile no./ using google ID.");
        }
    }

    public static void main(String[] args) {
        // Create and show the frame
        SignIn frame = new SignIn();
        frame.setVisible(true);
    }
}