
package hmis.Hospital;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class View_Appointment extends JFrame implements ActionListener{
    
    String []x={"Appointment_Id","Patient","Doctor","Date","Time","Status"};
    JButton bt,bt1,bt2,bt3,bt4,bt5;
    String y[][]=new String[20][6];
    int i=0,j=0;
    JTable t;
    JLabel l1,l2;
    JTextField tf1;
    JPanel p1,p2,p3;
    Font f,f1;
    String q;
    int login_id;
    String username,app_id,patient,doctor;
    ResultSet rest;
    
    
   View_Appointment(String username,int login_id){
        super("Appointment Information");
        setSize(1500,400);
        setLocation(1,1);
        this.login_id = login_id;
        this.username = username;
        
        f = new Font("MS UI Gothic", Font.BOLD,15);
        
        try{
            ConnectionClass obj = new ConnectionClass();
            
            if(login_id==1){
                q= "Select * from Appointment where doctor_id='"+username+"'";
            }
            else if(login_id==3){
                q = "Select * from Appointment where patient_id='"+username+"'";
            }
            else if(login_id==5){
                q = "Select * from Appointment where status='Complete'";
            }
            else{
                q = "Select * from Appointment";
            }
            
            rest = obj.stm.executeQuery(q);
            
            while(rest.next()){
                y[i][j++] = rest.getString("app_id");
//                appo_id= rest.getString("app_id");
                y[i][j++] = rest.getString("patient_id");
                y[i][j++] = rest.getString("doctor_id");
                y[i][j++] = rest.getString("date");
                y[i][j++] = rest.getString("time");
                y[i][j++] = rest.getString("status");
                
                i++;
                j=0;
            }
            t= new JTable(y,x);
            t.setFont(f);
            t.setBackground(Color.BLACK);
            t.setForeground(Color.WHITE);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        JScrollPane sp =new JScrollPane(t);
        
        if(login_id==1){
        f1= new Font("Lucida Fax", Font.BOLD,25);
        l1= new JLabel("Appointment ID");
        l2= new JLabel("Complete or Cancelled any Appointment Status?");
        
        l1.setForeground(Color.GRAY);
        l2.setForeground(Color.YELLOW);
        l2.setHorizontalAlignment(JLabel.CENTER);
        
        l1.setFont(f1);
        l2.setFont(f1);
        
        bt= new JButton("Complete Appointment");  // set buttons
        bt1= new JButton("Cancel Appointment");
        
        bt.addActionListener(this); // 
        bt1.addActionListener(this);
        
        bt.setBackground(Color.black);
        bt1.setBackground(Color.black);
        
        bt.setForeground(Color.green);
        bt1.setForeground(Color.red);
        
        bt2 = new JButton("Add Prescription");
        bt2.addActionListener(this);
        bt2.setBackground(Color.black);
        bt2.setForeground(Color.blue);
        
        tf1 = new JTextField();
        tf1.setFont(f);
        
        
            p1 = new JPanel();
            p1.setLayout(new GridLayout(1,1,10,10));
            p1.add(l2);

            p2 = new JPanel();
            p2.setLayout(new GridLayout(1,5,10,10));
            p2.add(l1);
            p2.add(tf1);
            p2.add(bt);
            p2.add(bt1);
            p2.add(bt2);

            p3 = new JPanel();
            p3.setLayout(new GridLayout(2,1,10,10));
            p3.add(p1);
            p3.add(p2);

            p1.setBackground(Color.black);
            p2.setBackground(Color.black);
            p3.setBackground(Color.black);

            add(p3,"South");
            
        }
        
        if(login_id==3){
        f1= new Font("Lucida Fax", Font.BOLD,25);
        l1= new JLabel("Appointment ID");
//        l2= new JLabel("Complete or Cancelled any Appointment Status?");
        
        l1.setForeground(Color.GRAY);
//        l2.setForeground(Color.YELLOW);
//        l2.setHorizontalAlignment(JLabel.CENTER);
        
        l1.setFont(f1);
//        l2.setFont(f1);
        
        bt3= new JButton("View Prescription");  // set buttons
        
        bt3.setBackground(Color.black);
        bt3.setForeground(Color.green);
        bt3.addActionListener(this);
        tf1 = new JTextField();
        tf1.setFont(f);
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
//        p1.add(l2);

            p2 = new JPanel();
            p2.setLayout(new GridLayout(1,3,10,10));
            p2.add(l1);
            p2.add(tf1);
            p2.add(bt3);

            p3 = new JPanel();
            p3.setLayout(new GridLayout(2,1,10,10));
            p3.add(p1);
            p3.add(p2);

            p1.setBackground(Color.black);
            p2.setBackground(Color.black);
            p3.setBackground(Color.black);
            add(p3,"South");
        }
        
        if(login_id ==5){
            f1= new Font("Lucida Fax", Font.BOLD,25);
            l1= new JLabel("Appointment ID");
            l2= new JLabel("Make And View Billings");

            l1.setForeground(Color.GRAY);
            l2.setForeground(Color.YELLOW);
            l2.setHorizontalAlignment(JLabel.CENTER);

            l1.setFont(f1);
            l2.setFont(f1);

            bt4= new JButton("Make Billing");  // set buttons
            bt5= new JButton("View Billings");

            bt4.addActionListener(this); // 
            bt5.addActionListener(this);

            bt4.setBackground(Color.black);
            bt5.setBackground(Color.black);

            bt4.setForeground(Color.green);
            bt5.setForeground(Color.yellow);

            tf1 = new JTextField();
            tf1.setFont(f);
        
        
            p1 = new JPanel();
            p1.setLayout(new GridLayout(1,1,10,10));
            p1.add(l2);

            p2 = new JPanel();
            p2.setLayout(new GridLayout(1,4,10,10));
            p2.add(l1);
            p2.add(tf1);
            p2.add(bt4);
            p2.add(bt5);

            p3 = new JPanel();
            p3.setLayout(new GridLayout(2,1,10,10));
            p3.add(p1);
            p3.add(p2);

            p1.setBackground(Color.black);
            p2.setBackground(Color.black);
            p3.setBackground(Color.black);

            add(p3,"South");
        }
        
        add(sp);
        
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        
        app_id = tf1.getText();
        
//        if(login_id==4)
        if(ae.getSource()==bt){
            if(app_id.isEmpty()){
                JOptionPane.showMessageDialog(null,"Please fill Appointment ID !");
            }
            else{
                try{
                    ConnectionClass obj1 = new ConnectionClass();
                    String q = "update appointment set status='Complete' where app_id='"+app_id +"'";
                    int aa =obj1.stm.executeUpdate(q);
                    if(aa==1){
                        JOptionPane.showMessageDialog(null, "Appointment status is Complete ");
                        setVisible(false);
                    }else{
                        JOptionPane.showMessageDialog(null, "Appointment ID not found");
                    }
                
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        if(ae.getSource()==bt1){
            if(app_id.isEmpty()){
                JOptionPane.showMessageDialog(null,"Please fill Appointment ID !");
            }
            else{
                try{
                    ConnectionClass obj1 = new ConnectionClass();
                    String q = "update appointment set status='Cancel' where app_id='"+app_id +"'";
                    int aa =obj1.stm.executeUpdate(q);
                    if(aa==1){
                        JOptionPane.showMessageDialog(null, "Appointment status is Cancelled ");
                        setVisible(false);
                    }else{
                        JOptionPane.showMessageDialog(null, "Appointment ID not found");
                    }
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
        if(ae.getSource()==bt2){
            if(login_id==1){
                if(app_id.isEmpty()){
                    JOptionPane.showMessageDialog(null,"Please fill Appointment Id !");
                }
                else{
                    setVisible(false); 
                    new Add_Prescription(app_id).setVisible(true);
                    new View_Prescription(login_id,app_id).setVisible(true);
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"You have not Permission to patient perscribe!");
            }
        }
        
        if(ae.getSource()==bt3){
            if(app_id.isEmpty()){
                JOptionPane.showMessageDialog(null,"Please fill Appointment ID !");
            }
            else if(login_id==3){
                new View_Prescription(login_id,app_id).setVisible(true);
            }
        }
        if(ae.getSource()==bt4){
            if(app_id.isEmpty()){
                JOptionPane.showMessageDialog(null,"Please fill Appointment ID !");
            }
            else if(login_id==5){
                new Make_Billing(app_id,username).setVisible(true);
            }
        }
    }
    
    public static void main(String[] args) {
        new View_Appointment("Sippu",5).setVisible(true);
    }
    
}
