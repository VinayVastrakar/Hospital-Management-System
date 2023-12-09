
package hmis.Hospital;


import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import java.sql.*;


public class Add_Appointment extends JFrame implements ActionListener{
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18;
    JButton bt,bt1,bt2;
    JPanel p1,p2,p3;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14;
    Font f,f1;
    Choice ch,ch1,ch2;
    String q;
    
    
    
    Add_Appointment(){
        
        super("Add Appointment");
        setLocation(450,10);
        setSize(740,730);
        
        f= new Font("Arial",Font.BOLD,25);
        f1 = new Font("Arial", Font.BOLD,18);
        
        ch = new Choice();
        ch1 = new Choice();
        ch2 = new Choice();
        
        ch2.add("10AM");
        ch2.add("11AM");
        ch2.add("12PM");
        ch2.add("1PM");
        ch2.add("2PM");
        ch2.add("3PM");
        
        try{
            ConnectionClass obj = new ConnectionClass();
            q = "Select username from patient";
            ResultSet rest = obj.stm.executeQuery(q);
            
            while(rest.next()){
                ch.add(rest.getString("username"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        l1 = new JLabel("Add Appointment");
        l2 = new JLabel("Username");
        l3 = new JLabel("Name");
        l4 = new JLabel("Email");
        l5 = new JLabel("Father Name");
        l6 = new JLabel("Phone");
        l7 = new JLabel("Maritial status");
        l8 = new JLabel("City");
        l9 = new JLabel("Gender");
        l10 = new JLabel("Blood");
        l11 = new JLabel("Age");
        l13 = new JLabel("Date Of Birth");
        l14 = new JLabel("Disease");
        l15 = new JLabel("Check Doctor Availability");
        l16 = new JLabel("Select Doctor");
        l17 = new JLabel("Appointment Date");
        l18 = new JLabel("Appointment Time");
        
        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        t7 = new JTextField();
        t8 = new JTextField();
        t9 = new JTextField();
        t10 = new JTextField();
        t11 = new JTextField();
        t12 = new JTextField();
        
        t1.setEditable(false);
        t2.setEditable(false);
        t3.setEditable(false);
        t4.setEditable(false);
        t5.setEditable(false);
        t6.setEditable(false);
        t7.setEditable(false);
        t8.setEditable(false);
        t9.setEditable(false);
        t10.setEditable(false);
        
        bt = new JButton("Boot Appointment");
        bt1 = new JButton("Back");
        bt2 = new JButton("Check");
        
        bt.addActionListener(this);
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        bt.setBackground(Color.BLUE);
        bt1.setBackground(Color.RED);
        bt2.setBackground(Color.BLACK);
        
        bt.setForeground(Color.WHITE);
        bt1.setForeground(Color.WHITE);
        bt2.setForeground(Color.WHITE);
        
        
        l1.setHorizontalAlignment(JLabel.CENTER);
        
        l1.setFont(f);
        
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);
        l6.setFont(f1);
        l7.setFont(f1);
        l8.setFont(f1);
        l9.setFont(f1);
        l10.setFont(f1);
        l11.setFont(f1);
        l13.setFont(f1);
        l14.setFont(f1);
        l15.setFont(f1);
        l16.setFont(f1);
        l17.setFont(f1);
        l18.setFont(f1);
        
        ch.setFont(f1);
        ch1.setFont(f1);
        ch2.setFont(f1);
        
        t1.setFont(f1);
        t2.setFont(f1);
        t3.setFont(f1);
        t4.setFont(f1);
        t5.setFont(f1);
        t6.setFont(f1);
        t7.setFont(f1);
        t8.setFont(f1);
        t9.setFont(f1);
        t10.setFont(f1);
        t11.setFont(f1);
        t12.setFont(f1);
        
        bt.setFont(f1);
        bt1.setFont(f1);
        bt2.setFont(f1);
        
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        
        p2 = new JPanel();
        p2.setLayout(new GridLayout(17,2,10,10));
        
        p2.add(l2);
        p2.add(ch);
        p2.add(l3);
        p2.add(t1);
        p2.add(l4);
        p2.add(t2);
        p2.add(l5);
        p2.add(t3);
        p2.add(l6);
        p2.add(t4);
        p2.add(l7);
        p2.add(t5);
        p2.add(l8);
        p2.add(t6);
        p2.add(l9);
        p2.add(t7);
        p2.add(l10);
        p2.add(t8);
        p2.add(l11);
        p2.add(t9);
        p2.add(l13);
        p2.add(t10);
        p2.add(l14);
        p2.add(t11);
        p2.add(l15);
        p2.add(bt2);
        p2.add(l16);
        p2.add(ch1);
        p2.add(l17);
        p2.add(t12);
        p2.add(l18);
        p2.add(ch2);
        p2.add(bt);
        p2.add(bt1);
        
                
        
        p3 = new JPanel();
        p3.setLayout(new GridLayout(1,1,10,10));
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("hmis\\Hospital\\Images\\Appoint.jpg"));
        Image i = img.getImage().getScaledInstance(350, 650, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i);
        l12 = new JLabel(img1);
        l12.setBounds(0, 0, 300, 500);
        l12.setLayout(null);
        p3.add(l12);
        
        
        setLayout(new BorderLayout(10,10));
        add(p1,"North");
        add(p2,"Center");
        add(p3,"West");
        
        ch.addMouseListener(new MouseAdapter()
        {
        
            @Override
            public void mouseClicked(MouseEvent arg0){
                
                try{
                    ConnectionClass obj1 = new ConnectionClass();
                    String username = ch.getSelectedItem();
                    String q1= "select * from patient where username='"+username+"'";
                    ResultSet rest1 = obj1.stm.executeQuery(q1);
                    while(rest1.next()){
                        t1.setText(rest1.getString("name"));
                        t2.setText(rest1.getString("email"));
                        t3.setText(rest1.getString("father_name"));
                        t4.setText(rest1.getString("phone"));
                        t5.setText(rest1.getString("marital_status"));
                        t6.setText(rest1.getString("city"));
                        t7.setText(rest1.getString("gender"));
                        t8.setText(rest1.getString("blood"));
                        t9.setText(rest1.getString("age"));
                        t10.setText(rest1.getString("dob"));
                        t11.setText(rest1.getString("disease"));
                        
                        
                    }
                }
                catch(Exception e){
                 e.printStackTrace();
                }
            }
        });
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==bt2){
            ch1.removeAll();
            try{
                ConnectionClass obj2 = new ConnectionClass();
                String q2= "select * from doctor where spcialization='"+t11.getText()+"' and avalibility='Yes'";
                ResultSet rest3= obj2.stm.executeQuery(q2);
                while(rest3.next()){
                    ch1.add(rest3.getString("username"));
                }
                
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        if(ae.getSource()==bt){
            String username = ch.getSelectedItem();
            String name = t1.getText();
            String email = t2.getText();
            String fname = t3.getText();
            String phone = t4.getText();
            String mstatus = t5.getText();
            String city = t6.getText();
            String gender = t7.getText();
            String blood = t8.getText();
            String age = t9.getText();
            String dob = t10.getText();
            String disease = t11.getText();
            String doctor = ch1.getSelectedItem();
            String app_date = t12.getText();
            String app_time = ch2.getSelectedItem();
            String app_status = "Open";
            Random r = new Random();
            String app_id = ""+Math.abs(r.nextInt()%100000);
            
            try{
                ConnectionClass obj3 = new ConnectionClass();
                String q3= "insert into appointment(app_id,username,name,email,father_name,phone,"
                        + "marital_status,city,gender,blood,age,dob,disease,doctor_username, appointment_date,"
                        + "appointment_time,appointment_status) values('"+app_id+"','"+username+"','"+name+"','"+
                        email+"','"+fname+"','"+phone+"','"+mstatus+"','"+city+"','"+gender+"','"+blood+"','"+age+
                        "','"+dob+"','"+disease+"','"+doctor+"','"+app_date+"','"+app_time+"','"+app_status+"')";
                int aa = obj3.stm.executeUpdate(q3);
                
                if(aa==1){
                    JOptionPane.showMessageDialog(null, "Your appointment Successfully Booked"); 
                    this.setVisible(false);
                }else{
                     JOptionPane.showMessageDialog(null, "Please fill all the details carefully!");
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        if(ae.getSource()==bt1){
            this.setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new Add_Appointment().setVisible(true);
    }
}
