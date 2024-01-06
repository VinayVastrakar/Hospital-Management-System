/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hmis.Hospital;

import com.mysql.cj.protocol.Resultset;
import com.toedter.calendar.JDateChooser;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;
import java.util.Random;
import javax.swing.*;

public class Add_Prescription extends JFrame implements ActionListener{
    
    JFrame f;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16;
    JTextField t1,t2,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14;
    JDateChooser d;
    Choice c1,c2,c3;
    Font f1;
    public JButton bt1,bt2;
    String pat_name,doc_name , app_id, med_id, time, date;
    
    Add_Prescription(String app_id){
        
        f = new JFrame("Add Prescription");
        f.setBackground(Color.WHITE);
        f.setLayout(null);
        this.app_id = app_id;
        
        f1= new Font("Arial" , Font.CENTER_BASELINE,18); 
        
        l1 = new JLabel();
        l1.setBounds(0, 0, 1000, 150);
        l1.setLayout(null);
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("hmis\\Hospital\\Images\\AddDoctor.jpg"));
        Image i = img.getImage().getScaledInstance(1000, 130, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i);
        l1.setIcon(img1);
        
        l2= new JLabel("Medicine Name");
        l2.setBounds(20, 0, 150, 50);
        l2.setFont(new Font("Arial" , Font.BOLD,18));
        l2.setForeground(Color.BLACK);
        l1.add(l2);
        
        c1 = new Choice();
        String q="";
        try{
            ConnectionClass obj = new ConnectionClass();
            q = "Select name from medicine";
            ResultSet rest = obj.stm.executeQuery(q);
            
            while(rest.next()){
                c1.add(rest.getString("name"));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        
        c1.setBounds(20, 50, 130, 50);
        l1.add(c1);
        
        
        l3= new JLabel("Advice");
        l3.setBounds(210, 0, 100, 50);
        l3.setFont(new Font("Arial" , Font.BOLD,18));
        l3.setForeground(Color.BLACK);
        l1.add(l3);
        
        c2 = new Choice();
        c2.add("Before meal");
        c2.add("After meal");
        c2.setBounds(190, 50, 120, 50);
        l1.add(c2);
        
        
        l4= new JLabel("Frequencey");
        l4.setBounds(360, 0, 130, 50);
        l4.setFont(new Font("Arial" , Font.BOLD,18));
        l4.setForeground(Color.BLACK);
        l1.add(l4);
        
        c3 = new Choice();
        c3.add("OID");
        c3.add("BID");
        c3.add("TID");
        c3.add("QID");
        c3.setBounds(355, 50, 120, 50);
        l1.add(c3);
        
        
        l5= new JLabel("Quantity");
        l5.setBounds(510, 0, 130, 50);
        l5.setFont(new Font("Arial" , Font.BOLD,18));
        l5.setForeground(Color.BLACK);
        l1.add(l5);
        
        t2 = new JTextField();
        t2.setBounds(510, 50, 100, 20);
        l1.add(t2);
        
        bt1 = new JButton("Add"); // buttom 1
        bt1.setBackground(Color.blue);
        bt1.setForeground(Color.white);
        bt1.setBounds(650,30,120,30);
        l1.add(bt1);
        
        bt2 = new JButton("Cancle"); // button 2
        bt2.setBackground(Color.RED);
        bt2.setForeground(Color.white);
        bt2.setBounds(820,30,120,30);
        l1.add(bt2);
        
        bt1.addActionListener(this); // add action
        bt2.addActionListener(this);
        
        f.add(l1);
        
        f.setVisible(true);
        f.setSize(1000,130);
        f.setLocation(150,400);
        f.setResizable(false);
        
    }
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==bt1){
             String med_name = c1.getSelectedItem();
             try{
                 ConnectionClass obj = new ConnectionClass();
                 String q = "select med_id from medicine where name='"+med_name+"'";
                 ResultSet rest = obj.stm.executeQuery(q);
              
                   if(rest.next())
                   {
                       med_id = rest.getString("med_id");
                   }

             }
             catch(Exception e){
                 e.printStackTrace();
             }
             String advice = c2.getSelectedItem();
             String freq = c3.getSelectedItem();
             String day = t2.getText();
//             String date = new Date().toString();
             Random r= new Random();
             String pre_hd = ""+Math.abs(r.nextInt()%10000);
             String pre_dd = ""+Math.abs(r.nextInt()%10000);
             
             try{
                ConnectionClass obj = new ConnectionClass();
                String q2 = "Select * from appointment where app_id='"+app_id+"'";
                ResultSet rest = obj.stm.executeQuery(q2);
                while(rest.next())
                {
                    pat_name = rest.getString("patient_id");
                    doc_name = rest.getString("doctor_id");
                    time = rest.getString("time");
                    date = rest.getString("date");
                }
                
                String q = "insert into prescription_hd(id_hd,date,time,status,appointment_id,patient,doctor) "
                         + "values('"+pre_hd+"','"+date+"','"+time+"','"+"P"+"','"+app_id+"','"
                         +pat_name+"','"+doc_name+"')";
                
                
                 
                 String q1 = "insert into prescription_dd(pre_dd_id,med_id,advice,frequency,quantity,pre_hd) values('"+pre_dd+"','"+med_id+"','"+advice+"','"
                         +freq+"','"+day+"','"+pre_hd+"')";
                 obj.stm.executeUpdate(q);
                 obj.stm.executeUpdate(q1);
                 JOptionPane.showMessageDialog(null, "Prescription Added");
                 
                 new View_Prescription(1,app_id).setVisible(true);
//               f.setVisible(false);
//               f.setVisible(true);
             }
             catch(Exception e){
                 e.printStackTrace();
             }
             
         }
         if(ae.getSource()== bt2){
             f.setVisible(false);
         }
    }
    public static void main(String[] args) {
        new Add_Prescription("2662").setVisible(true);
    }
}
