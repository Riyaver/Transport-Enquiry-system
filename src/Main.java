import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Main extends JFrame implements ActionListener {
    private JButton sign_up_button, sign_in_button;

    public Main()
    {
        ImageIcon image1 = new ImageIcon("t2.png");

        JLabel l1 = new JLabel();
        //l1.setText("Welcome!");
        l1.setIcon(image1);
        //POSITION OF TEXT WRT IMAGEICON
        l1.setBounds(10,5,500,300);
        l1.setText("Connecting you to your Destination...");
        l1.setForeground(new Color(0x123456));
        l1.setFont(new Font("Times New Roman", Font.ITALIC, 20));

        sign_up_button = new JButton("Sign-up");
        sign_up_button.setBounds(10,240,470,100);
        sign_in_button = new JButton("Sign-in");
        sign_in_button.setBounds(10,350,470,100);


        sign_up_button.addActionListener(this);
        sign_in_button.addActionListener(this);

        setTitle("Transport Enquiry System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setLayout(null); //FOR MANUAL BOUNDS OF LABEL N ALL
        setVisible(true);
        add(l1);
        add(sign_up_button);
        add(sign_in_button);

        //FOR LOGO ON TOP
        ImageIcon logo1 = new ImageIcon("img.png");
        setIconImage(logo1.getImage());

        //TO CHANGE BACKGROUND COLOR
        getContentPane().setBackground(new Color((0xAEC6CF)));
    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == sign_up_button)
        {
            SignUp l1 =new SignUp();

            setVisible(false);
        }
        else if (e.getSource() == sign_in_button)
        {
            Login a1 = new Login();
            setVisible(false);
        }

    }

    public static void main(String[] args)
    {
        Main m1 = new Main();
    }
}