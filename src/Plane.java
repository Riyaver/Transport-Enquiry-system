import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class Plane extends JFrame implements ActionListener {
    private JRadioButton delhiKolkataRadioBtn, delhiMumbaiRadioBtn, delhiAmritsarRadioBtn,
            kolkataDelhiRadioBtn, mumbaiDelhiRadioBtn, kolkataMumbaiRadioBtn;
    private ButtonGroup radioGroup;
    private JButton submitBtn, back;
    private JLabel resultLabel;
    static String time;
    public Plane() {
        super("Plane Route Program");
        JLabel l1 = new JLabel();

        //POSITION OF TEXT WRT IMAGEICON
        l1.setBounds(500,10,500,300);
        l1.setText("PLANE DETAILS:");
        l1.setFont(new Font("TIMES NEW ROMAN", Font.BOLD, 20));
        l1.setForeground(new Color(0xffffff));

        // Create radio buttons and add them to the group
        delhiKolkataRadioBtn = new JRadioButton("Delhi-Kolkata");
        delhiMumbaiRadioBtn = new JRadioButton("Delhi-Mumbai");
        delhiAmritsarRadioBtn = new JRadioButton("Delhi-Amritsar");
        kolkataDelhiRadioBtn = new JRadioButton("Kolkata-Delhi");
        mumbaiDelhiRadioBtn = new JRadioButton("Mumbai-Delhi");
        kolkataMumbaiRadioBtn = new JRadioButton("Kolkata-Mumbai");

        radioGroup = new ButtonGroup();
        radioGroup.add(delhiKolkataRadioBtn);
        radioGroup.add(delhiMumbaiRadioBtn);
        radioGroup.add(delhiAmritsarRadioBtn);
        radioGroup.add(kolkataDelhiRadioBtn);
        radioGroup.add(mumbaiDelhiRadioBtn);
        radioGroup.add(kolkataMumbaiRadioBtn);

        // Create submit button and result label
        submitBtn = new JButton("Submit");
        resultLabel = new JLabel("");
        submitBtn = new JButton("Back");
        // Set layout and add components to frame
        setLayout(new GridLayout(7, 1));
        add(l1);
        add(delhiKolkataRadioBtn);
        add(delhiMumbaiRadioBtn);
        add(delhiAmritsarRadioBtn);
        add(kolkataDelhiRadioBtn);
        add(mumbaiDelhiRadioBtn);
        add(kolkataMumbaiRadioBtn);
        add(submitBtn);
        add(resultLabel);
        add(back);

        // Add action listeners to buttons
        submitBtn.addActionListener(this);
        back.addActionListener(this);
        getContentPane().setBackground(new Color((0xffffff)));

        ImageIcon logo1 = new ImageIcon("img.png");
        setIconImage(logo1.getImage());
        // Set size and show frame
        setTitle("Transport Enquiry System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String route = "";
        double total_time = 0;
        int seat=0;
        // Get selected radio button and set route and time accordingly
        if (delhiKolkataRadioBtn.isSelected()) {
            route = "Delhi-Kolkata";
            total_time = 2.5;
            time = "9:00 am 18:00 pm";
            seat = 3;
        } else if (delhiMumbaiRadioBtn.isSelected()) {
            route = "Delhi-Mumbai";
            total_time = 3;
            time = "11:00 am, 15:00 pm";
            seat = 10;
        } else if (delhiAmritsarRadioBtn.isSelected()) {
            route = "Delhi-Amritsar";
            total_time = 1.5;
            time = "10:30 am, 16:15 pm";
            seat = 6;
        } else if (kolkataDelhiRadioBtn.isSelected()) {
            route = "Kolkata-Delhi";
            total_time = 2.5;
            time = "7:30 am";
            seat = 33;
        } else if (mumbaiDelhiRadioBtn.isSelected()) {
            route = "Mumbai-Delhi";
            time = "6:15 am, 19:30 pm";
            total_time = 3;
            seat = 9;
        } else if (kolkataMumbaiRadioBtn.isSelected()) {
            route = "Kolkata-Mumbai";
            total_time = 2.5;
            time = "23:15 pm";
            seat = 7;
        }

        // Display result
        resultLabel.setText(route + " journey duration: " + total_time + " hours."+"    Time slot available: "+time+ "      No of seats available: "+seat);
        try
        {
            File file = new File("D:\\CSE310\\transport_sys\\Plane_details.txt");
            FileWriter writer = new FileWriter(file);
            writer.write("Journey : " + route + "\n");
            writer.write("Total time: " + total_time + "\n");
            writer.write("Time available: " + time + "\n");
            writer.close();
            System.out.println("Data written to file successfully.");
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        if (e.getSource() == back)
        {
            dispose();
            Vehicle a = new Vehicle();
            setVisible(false);
        }
    }

    public static void main(String[] args) {
        Plane b = new Plane();
    }
}
