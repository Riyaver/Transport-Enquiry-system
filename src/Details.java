import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Details  extends JFrame implements ActionListener {
    JTextArea textArea;
    JButton  loadButton, back;

    public Details () {
        super("File Handling Example");

        textArea = new JTextArea(10, 30);
        loadButton = new JButton("Load");
        loadButton.addActionListener(this);
        back = new JButton("Back");
        back.addActionListener(this);
        JPanel panel = new JPanel();
        panel.add(loadButton);
        panel.add(back);
        panel.add(textArea);

        getContentPane().add(panel);
        ImageIcon logo1 = new ImageIcon("img.png");
        setIconImage(logo1.getImage());
        getContentPane().setBackground(new Color((0x443b95)));
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loadButton) {

            try {
                File file = new File("D:\\CSE310\\transport_sys\\Bus_details.txt");
                FileReader reader = new FileReader(file);
                BufferedReader br = new BufferedReader(reader);
                String line = "BUS DETAILS: ";
                textArea.append(line + "\n");
                while ((line = br.readLine()) != null)
                {
                    textArea.append(line + "\n");
                }
                br.close();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                File file = new File("D:\\CSE310\\transport_sys\\Train_details.txt");


                FileReader reader = new FileReader(file);
                BufferedReader br = new BufferedReader(reader);
                String line = "TRAIN DETAILS: ";
                textArea.append(line + "\n");
                while ((line = br.readLine()) != null) {
                    textArea.append(line + "\n");
                }
                br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            try {
                File file = new File("D:\\CSE310\\transport_sys\\Booking_details.txt");
                FileReader reader = new FileReader(file);
                BufferedReader br = new BufferedReader(reader);
                String line = "BOOKING DETAILS: ";
                textArea.append(line + "\n");
                while ((line = br.readLine()) != null)
                {
                    textArea.append(line + "\n");
                }
                br.close();
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        else if (e.getSource() == back)
        {
            dispose();
            Vehicle a = new Vehicle();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        new Details ();
    }
}
