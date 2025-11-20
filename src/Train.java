import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class Train extends JFrame implements ActionListener {
    private JRadioButton delhiKolkataRadioBtn, delhiMumbaiRadioBtn, delhiAmritsarRadioBtn,
            kolkataDelhiRadioBtn, mumbaiDelhiRadioBtn, kolkataMumbaiRadioBtn;
    private ButtonGroup radioGroup;
    private JButton submitBtn, back;
    private JLabel resultLabel;
    static String time;
    public Train() {
        super("Train Route Program");
        JLabel l1 = new JLabel();

        l1.setBounds(500,10,500,300);
        l1.setText("TRAIN DETAILS:");
        l1.setFont(new Font("Times new roman", Font.BOLD, 20));
        l1.setForeground(new Color(0x123456));

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

        submitBtn = new JButton("Submit");
        resultLabel = new JLabel("");
        back = new JButton("Back");
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

        submitBtn.addActionListener(this);
        back.addActionListener(this);
        getContentPane().setBackground(new Color((0xc8caf7)));

        ImageIcon logo1 = new ImageIcon("img.png");
        setIconImage(logo1.getImage());
        setTitle("Transport Enquiry System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        String route = "";
        int total_time = 0;
        int seat=0;
        if (delhiKolkataRadioBtn.isSelected()) {
            route = "Delhi-Kolkata";
            total_time = 34;
            time = "9:00 am 18:00 pm";
            seat = 3;
        } else if (delhiMumbaiRadioBtn.isSelected()) {
            route = "Delhi-Mumbai";
            total_time = 78;
            time = "11:00 am, 15:00 pm";
            seat = 7;
        } else if (delhiAmritsarRadioBtn.isSelected()) {
            route = "Delhi-Amritsar";
            total_time = 7;
            time = "10:30 am, 16:15 pm";
            seat = 5;
        } else if (kolkataDelhiRadioBtn.isSelected()) {
            route = "Kolkata-Delhi";
            total_time = 34;
            time = "7:30 am";
            seat = 1;
        } else if (mumbaiDelhiRadioBtn.isSelected()) {
            route = "Mumbai-Delhi";
            time = "6:15 am, 19:30 pm";
            total_time = 78;
            seat = 10;
        } else if (kolkataMumbaiRadioBtn.isSelected()) {
            route = "Kolkata-Mumbai";
            total_time = 64;
            time = "23:15 pm";
            seat = 18;
        }

        resultLabel.setText(route + " journey duration: " + total_time + " hours."+"    Time slot available: "+time+ "      No of seats available: "+seat);
        try
        {
            File file = new File("D:\\CSE310\\transport_sys\\Train_details.txt");
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
        Train b = new Train();
    }
}
