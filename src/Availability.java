import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class Availability  extends JFrame implements ActionListener {
    JTextArea textArea;
    JButton  loadButton;

    public Availability () {
        super("File Handling Example");

        // create text area
        textArea = new JTextArea(10, 30);



        // create load button
        loadButton = new JButton("Load");
        loadButton.addActionListener(this);

        // add components to panel
        JPanel panel = new JPanel();
        panel.add(textArea);
        panel.add(loadButton);

        // add panel to frame
        getContentPane().add(panel);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loadButton) {
            try {
                File file = new File("D:\\CSE310\\transport_sys\\Person_details.txt");
                FileReader reader = new FileReader(file);
                BufferedReader br = new BufferedReader(reader);
                String line = "PERSONAL DETAILS: ";
                textArea.append(line + "\n");
                while ((line = br.readLine()) != null) {
                    textArea.append(line + "\n");
                }
                br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
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
                File file = new File("D:\\CSE310\\transport_sys\\Plane_details.txt");
                FileReader reader = new FileReader(file);
                BufferedReader br = new BufferedReader(reader);
                String line = "PLANE DETAILS: ";
                textArea.append(line + "\n");
                while ((line = br.readLine()) != null) {
                    textArea.append(line + "\n");
                }
                br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Availability ();
    }
}
