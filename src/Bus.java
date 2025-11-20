import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

class Bus extends JFrame implements ActionListener {
    private JRadioButton delhiKolkataRadioBtn, delhiAmritsarRadioBtn, kolkataDelhiRadioBtn, kolkataMumbaiRadioBtn;
    private ButtonGroup radioGroup;
    private JButton submitBtn, back;
    private JLabel resultLabel;
    static String time;
    public Bus() {
        super("Bus Route Program");
        JLabel l1 = new JLabel();

        l1.setBounds(500,10,500,300);
        l1.setText("BUS DETAILS:");
        l1.setFont(new Font("Font-Style", Font.BOLD, 20));
        l1.setForeground(new Color(0x123456));
        // Create radio buttons and add them to the group
        delhiKolkataRadioBtn = new JRadioButton("Delhi-Kolkata");
        delhiAmritsarRadioBtn = new JRadioButton("Delhi-Amritsar");
        kolkataDelhiRadioBtn = new JRadioButton("Kolkata-Delhi");

        kolkataMumbaiRadioBtn = new JRadioButton("Kolkata-Mumbai");

        radioGroup = new ButtonGroup();
        radioGroup.add(delhiKolkataRadioBtn);
        radioGroup.add(delhiAmritsarRadioBtn);
        radioGroup.add(kolkataDelhiRadioBtn);
        radioGroup.add(kolkataMumbaiRadioBtn);

        submitBtn = new JButton("Submit");
        resultLabel = new JLabel("");

        back = new JButton("Back");
        setLayout(new GridLayout(7, 1));
        add(l1);
        add(delhiKolkataRadioBtn);

        add(delhiAmritsarRadioBtn);
        add(kolkataDelhiRadioBtn);

        add(kolkataMumbaiRadioBtn);
        add(submitBtn);
        add(resultLabel);
        add(back);


        submitBtn.addActionListener(this);
        back.addActionListener(this);


        ImageIcon logo1 = new ImageIcon("img.png");
        setIconImage(logo1.getImage());
        getContentPane().setBackground(new Color((0xb4bcee)));
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
            total_time = 54;
            time = "9:00 am, 13:00 pm, 18:00 pm";
            seat = 12;
        }
        else if (delhiAmritsarRadioBtn.isSelected()) {
            route = "Delhi-Amritsar";
            total_time = 9;
            time = "10:30 am, 16:15 pm, 20:30 pm";
            seat = 19;
        }
        else if (kolkataDelhiRadioBtn.isSelected()) {
            route = "Kolkata-Delhi";
            total_time = 54;
            time = "7:30 am";
            seat = 3;
        }
        else if (kolkataMumbaiRadioBtn.isSelected()) {
            route = "Kolkata-Mumbai";
            total_time = 78;
            time = "23:15 pm";
            seat = 17;
        }

        resultLabel.setText(route + " journey duration: " + total_time + " hours."+"    Time slot available: "+time+ "      No of seats available: "+seat);
        try
        {
            File file = new File("D:\\CSE310\\transport_sys\\Bus_details.txt");
            FileWriter writer = new FileWriter(file);
            writer.write("Journey : " + route + "\n");
            writer.write("Total time: " + total_time + "\n");
            writer.write("Time available: " + time + "\n");
            writer.close();
            System.out.println("Data written to file successfully.");
        }
        catch (IOException ex) {
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
        Bus b = new Bus();
    }
}
