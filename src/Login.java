import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Login extends JFrame implements ActionListener {

     JLabel userLabel, passLabel;
     JTextField userText;
     JPasswordField passText;
     JButton login_button, back_button;

     Login() {
        setTitle("Login");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel l1 = new JLabel("Login Details: ");
        l1.setForeground(new Color(0xffffff));
        l1.setBounds(10,10,200,60);

        userLabel = new JLabel("Username");
        userLabel.setBounds(20, 80, 80, 25);
        userLabel.setForeground(new Color(0xffffff));
        add(userLabel);
        userText = new JTextField(20);
        userText.setBounds(100, 80, 160, 25);
        add(userText);

        passLabel = new JLabel("Password");
        passLabel.setBounds(20, 110, 80, 25);
        passLabel.setForeground(new Color(0xffffff));
        add(passLabel);
        passText = new JPasswordField(20);
        passText.setBounds(100, 110, 160, 25);
        add(passText);

        login_button = new JButton("Login");
        login_button.setBounds(75, 150, 80, 25);
        add(login_button);

        back_button = new JButton("Back");
        back_button.setBounds(160, 150, 80, 25);
        add(back_button);

        login_button.addActionListener(this);
        back_button.addActionListener(this);
        add(l1);
        ImageIcon logo1 = new ImageIcon("img.png");
        setIconImage(logo1.getImage());

        setVisible(true);
        getContentPane().setBackground(new Color((0x5855bc)));

    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == login_button)
        {
            String username = userText.getText();
            String password = String.valueOf(passText.getPassword());

            try
            {
                BufferedReader br = new BufferedReader(new FileReader("D:\\CSE310\\transport_sys\\Person_details.txt"));
                String line;

                while ((line = br.readLine()) != null)
                {
                    String[] details = line.split(","); //splits the string in new line when , encountered
                    if (details[0].equals(username) && details[3].equals(password))
                    {
                        JOptionPane.showMessageDialog(this, "Login successful.");
                        userText.setText("");
                        passText.setText("");
                        setVisible(false);
                        Vehicle vehicle = new Vehicle();
                        return;
                    }
                }

                JOptionPane.showMessageDialog(this, "Incorrect username or password.");
                userText.setText("");
                passText.setText("");

            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }
        }
        else if (e.getSource() == back_button)
        {
            dispose();
            Main m =new Main();
        }
    }


    public static void main(String[] args) {
        Login login = new Login();

    }
}
