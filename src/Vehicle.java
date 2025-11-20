import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Vehicle extends JFrame implements ActionListener {
    private JButton bus, train, history, back, book ;

    public Vehicle()
    {
        ImageIcon image1 = new ImageIcon("pop.jpeg");

        JLabel l1 = new JLabel();
        l1.setIcon(image1);
        l1.setBounds(400,10,800,300);
        l1.setText("Mode of transportation");
        l1.setForeground(new Color(0xffffff));
        l1.setFont(new Font("Times New Roman", Font.BOLD, 40));

        bus = new JButton("Bus");
        bus.setBounds(500,310,500,75);
        train = new JButton("Train");
        train.setBounds(500,405,500,75);
        history = new JButton("History");
        history.setBounds(500,500, 500, 75);
        book = new JButton("Booking");
        book.setBounds(500,595, 500, 75);
        back = new JButton("Back");
        back.setBounds(500,690, 500, 75);


        bus.addActionListener(this);
        train.addActionListener(this);
        history.addActionListener(this);
        back.addActionListener(this);
        book.addActionListener(this);

        setTitle("Transport Enquiry System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,500);
        setLayout(null);
        setVisible(true);
        add(l1);
        add(bus);
        add(train);
        add(history);
        add(book);
        add(back);

        ImageIcon logo1 = new ImageIcon("img.png");
        setIconImage(logo1.getImage());
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        getContentPane().setBackground(new Color((0x6d69d7)));


    }

    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == bus)
        {
            Bus b1 =new Bus();
            setVisible(false);
        }
        else if (e.getSource() == train)
        {
            Train t1 = new Train();
            setVisible(false);
        }
        else if (e.getSource() == history)
        {
            Details t1 = new Details();
            setVisible(false);
        }
        else if (e.getSource() == back)
        {
            dispose();
            Main a = new Main();
            setVisible(false);
        }
        else if (e.getSource() == book)
        {
            Booking t1 = new Booking();
            setVisible(false);
            setVisible(false);
        }
    }


    public static void main(String[] args)
    {
        Vehicle m1 = new Vehicle();
    }


}