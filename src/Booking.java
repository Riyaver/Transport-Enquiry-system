import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
class Booking extends JFrame implements ActionListener {

    // declare the components
    private JLabel nameLabel, phoneLabel, sourceLabel, destinationLabel, dateLabel;
    private JTextField nameTextField, phoneTextField, sourceTextField, destinationTextField, dateTextField;
    private JButton bookButton, clearButton, back;

    public Booking() {
        setTitle("Transport Booking System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // initialize the components
        nameLabel = new JLabel("Name:");
        nameLabel.setForeground(new Color(0xffffff));
        phoneLabel = new JLabel("Phone:");
        phoneLabel.setForeground(new Color(0xffffff));
        sourceLabel = new JLabel("Source:");
        sourceLabel.setForeground(new Color(0xffffff));
        destinationLabel = new JLabel("Destination:");
        destinationLabel.setForeground(new Color(0xffffff));
        dateLabel = new JLabel("Date:");
        dateLabel.setForeground(new Color(0xffffff));

        nameTextField = new JTextField(20);
        phoneTextField = new JTextField(20);
        sourceTextField = new JTextField(20);
        destinationTextField = new JTextField(20);
        dateTextField = new JTextField(20);

        bookButton = new JButton("Book");
        clearButton = new JButton("Clear");
        back = new JButton("Back");

        bookButton.addActionListener(this);
        clearButton.addActionListener(this);
        back.addActionListener(this);

        setLayout(null);

        nameLabel.setBounds(30, 20, 60, 25);
        nameTextField.setBounds(100, 20, 200, 25);
        phoneLabel.setBounds(30, 60, 60, 25);
        phoneTextField.setBounds(100, 60, 200, 25);
        sourceLabel.setBounds(30, 100, 60, 25);
        sourceTextField.setBounds(100, 100, 200, 25);
        destinationLabel.setBounds(30, 140, 80, 25);
        destinationTextField.setBounds(100, 140, 200, 25);
        dateLabel.setBounds(30, 180, 60, 25);
        dateTextField.setBounds(100, 180, 200, 25);
        bookButton.setBounds(100, 220, 80, 25);
        clearButton.setBounds(190, 220, 80, 25);
        back.setBounds(280, 220, 80, 25);

        add(nameLabel);
        add(nameTextField);
        add(phoneLabel);
        add(phoneTextField);
        add(sourceLabel);
        add(sourceTextField);
        add(destinationLabel);
        add(destinationTextField);
        add(dateLabel);
        add(dateTextField);
        add(bookButton);
        add(clearButton);
        add(back);

        ImageIcon logo1 = new ImageIcon("img.png");
        setIconImage(logo1.getImage());
        // show the frame
        setVisible(true);
        getContentPane().setBackground(new Color((0x5855bc)));
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == bookButton)
        {
            Scanner input = new Scanner(System.in);
            String name = nameTextField.getText();
            String phone = phoneTextField.getText();
            String source = sourceTextField.getText();
            String destination = destinationTextField.getText();
            String date = dateTextField.getText();

            System.out.println("Name: " + name);
            System.out.println("Phone: " + phone);
            System.out.println("Source: " + source);
            System.out.println("Destination: " + destination);
            System.out.println("Date: " + date);

            try
            {
                File file = new File("D:\\CSE310\\transport_sys\\Booking_details.txt");
                FileWriter writer = new FileWriter(file);
                writer.write("Name: " + name + "\n");
                writer.write("Phone no: " + phone + "\n");
                writer.write("Email: " + source + "\n");
                writer.write("Date: " + date + "\n");
                writer.close();
                System.out.println("Data written to file successfully.");
            }
            catch (IOException ex)
            {
                ex.printStackTrace();
            }

            nameTextField.setText("");
            phoneTextField.setText("");
            sourceTextField.setText("");
            destinationTextField.setText("");
            dateTextField.setText("");
        }
        else if (e.getSource() == clearButton)
        {
            nameTextField.setText("");
            phoneTextField.setText("");
            sourceTextField.setText("");
            destinationTextField.setText("");
            dateTextField.setText("");
        }
        else if (e.getSource() == back)
        {
            dispose();
            Vehicle a = new Vehicle();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        Booking booking = new Booking();
    }
}