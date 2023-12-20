
package hmis.Hospital;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import java.sql.*;

public class Add_Medicine implements ActionListener{
    
    JFrame f;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JTextField t1,t2,t3,t4,t5,t6,t7;
    Choice gen,mar;
    JButton bt1,bt2;
    Font f1;
    
    Add_Medicine(){
        f = new JFrame("Add Medicine");
        f.setBackground(Color.WHITE);
        f.setLayout(null);
        
        f1 = new Font("Arial", Font.BOLD,18);
        
        l1 = new JLabel();
        l1.setBounds(0, 0, 900, 600);
        l1.setLayout(null);
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("hmis\\Hospital\\Images\\AddPatient.jpg"));
        Image i = img.getImage().getScaledInstance(900, 600, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i);
        l1.setIcon(img1);
        
        l2= new JLabel("Add Medicine Details");
        l2.setBounds(280, 30, 500, 50);
        l2.setFont(new Font("Arial" , Font.BOLD,30));
        l2.setForeground(Color.BLACK);
        l1.add(l2);
        
        l3= new JLabel("Medicine Name");
        l3.setBounds(50, 150, 150, 30);
        l3.setFont(new Font("Arial" , Font.BOLD,20));
        l3.setForeground(Color.BLACK);
        l1.add(l3);
        
        t1 = new JTextField();
        t1.setBounds(200, 150, 550, 30);
        l1.add(t1);
        
        
        l5= new JLabel("Drug Code");
        l5.setBounds(50, 200, 150, 30);
        l5.setFont(new Font("Arial" , Font.BOLD,20));
        l5.setForeground(Color.BLACK);
        l1.add(l5);
        
        t3 = new JTextField();
        t3.setBounds(200, 200, 150, 30);
        l1.add(t3);
        
        
        l6= new JLabel("Quantity");
        l6.setBounds(450, 200, 200, 30);
        l6.setFont(new Font("Arial" , Font.BOLD,20));
        l6.setForeground(Color.BLACK);
        l1.add(l6);
        
        t4 = new JTextField();
        t4.setBounds(600, 200, 150, 30);
        l1.add(t4);
        
        
        l7= new JLabel("Drug Type");
        l7.setBounds(50, 250, 150, 30);
        l7.setFont(new Font("Arial" , Font.BOLD,20));
        l7.setForeground(Color.BLACK);
        l1.add(l7);
        
        t5 = new JTextField();
        t5.setBounds(200, 250, 150, 30);
        l1.add(t5);
        
        
        l8= new JLabel("Expiry Date");
        l8.setBounds(450, 250, 150, 30);
        l8.setFont(new Font("Arial" , Font.BOLD,20));
        l8.setForeground(Color.BLACK);
        l1.add(l8);
        
        t6 = new JTextField();
        t6.setBounds(600, 250, 150, 30);
        l1.add(t6);
        
        
        l9= new JLabel("Unit Rate");
        l9.setBounds(50, 300, 150, 30);
        l9.setFont(new Font("Arial" , Font.BOLD,20));
        l9.setForeground(Color.BLACK);
        l1.add(l9);
        
        t7 = new JTextField();
        t7.setBounds(200, 300, 150, 30);
        l1.add(t7);
        
        
        bt1 = new JButton("Submit"); // buttom 1
        bt1.setBackground(Color.green);
        bt1.setForeground(Color.white);
        bt1.setBounds(250,500,150,40);
        l1.add(bt1);
        
        bt2 = new JButton("Cancle"); // button 2
        bt2.setBackground(Color.RED);
        bt2.setForeground(Color.white);
        bt2.setBounds(450,500,150,40);
        l1.add(bt2);
        
        bt1.addActionListener(this); // add action
        bt2.addActionListener(this);
        
        f.add(l1);
        
        f.setVisible(true);
        f.setSize(900,600);
        f.setLocation(210,50);
        f.setResizable(false);
    }
    
    public void actionPerformed(ActionEvent ae){
     
         if(ae.getSource()==bt1){
             String name = t1.getText();
             String drug_code = t3.getText();
             String quantity = t4.getText();
             String drug_type = t5.getText();
             String expiry_date = t6.getText();
             String unit_rate = t7.getText();
             Random r= new Random();
             String med_id = ""+Math.abs(r.nextInt()%100000);
             
             try{
                 ConnectionClass obj = new ConnectionClass();
                 String q = "insert into medicine values('"+med_id+"','"+name+"','"+drug_code+"','"+quantity+"','"
                         +drug_type+"','"+expiry_date+"','"+unit_rate+"')";
                 
                 obj.stm.executeUpdate(q);
                 JOptionPane.showMessageDialog(null, "Medicine Details Successfull Inserted");
                 f.setVisible(false);
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
        new Add_Medicine();
    }
}
