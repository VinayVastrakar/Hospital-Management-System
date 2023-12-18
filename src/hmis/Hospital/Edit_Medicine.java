
package hmis.Hospital;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Edit_Medicine extends JFrame implements ActionListener{
    
    JFrame f;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField t1,t2,t3,t4,t5,t6;
    JButton bt1,bt2;
    String med_id;
    
    
    Edit_Medicine(String med_id){
        this.med_id = med_id;
        try{
            ConnectionClass obj = new ConnectionClass();
            String q = "Select * from medicine where med_id='"+med_id+"'";
            ResultSet rest = obj.stm.executeQuery(q);
            if(rest.next()){
                
                f = new JFrame("Edit Medicine");
                f.setBackground(Color.WHITE);
                f.setLayout(null);
                
                l1 = new JLabel();
                l1.setBounds(0, 0, 800, 600);
                l1.setLayout(null);

                ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("hmis\\Hospital\\Images\\AddPatient.jpg"));
                Image i = img.getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH);
                ImageIcon img1 = new ImageIcon(i);
                l1.setIcon(img1);

                l2= new JLabel("Edit Medicine Quantity");
                l2.setBounds(240, 30, 500, 50);
                l2.setFont(new Font("Arial" , Font.BOLD,30));
                l2.setForeground(Color.BLACK);
                l1.add(l2);

                l3= new JLabel("Drug Code");
                l3.setBounds(50, 150, 150, 30);
                l3.setFont(new Font("Arial" , Font.BOLD,20));
                l3.setForeground(Color.BLACK);
                l1.add(l3);
                
                l4= new JLabel("Name");
                l4.setBackground(Color.white);
                l4.setBounds(450, 150, 200, 30);
                l4.setFont(new Font("Arial" , Font.BOLD,20));
                l4.setForeground(Color.BLACK);
                l1.add(l4);
        
                l5= new JLabel("Quantity");
                l5.setBounds(50, 200, 100, 30);
                l5.setFont(new Font("Arial" , Font.BOLD,20));
                l5.setForeground(Color.BLACK);
                l1.add(l5);
                
                l6= new JLabel("Drug Type");
                l6.setBounds(450, 200, 200, 30);
                l6.setFont(new Font("Arial" , Font.BOLD,20));
                l6.setForeground(Color.BLACK);
                l1.add(l6);
                
                l7= new JLabel("Expiry Date");
                l7.setBounds(50, 250, 150, 30);
                l7.setFont(new Font("Arial" , Font.BOLD,20));
                l7.setForeground(Color.BLACK);
                l1.add(l7);
                
                l8= new JLabel("Unit Rate");
                l8.setBounds(450, 250, 100, 30);
                l8.setFont(new Font("Arial" , Font.BOLD,20));
                l8.setForeground(Color.BLACK);
                l1.add(l8);
                
                
        
                
                
                try{
                    
                    ConnectionClass obj1 = new ConnectionClass();
                    String q1 ="Select * from medicine where med_id='"+med_id+"'";
                    ResultSet rest1 = obj1.stm.executeQuery(q1);
                    
                    while(rest1.next()){
                        t1 = new JTextField();
                        t1.setBounds(200, 150, 150, 30);
                        t1.setText(rest1.getString("drug_code"));
                        t1.setEditable(false);
                        l1.add(t1);
                        
                        t2 = new JTextField();
                        t2.setBounds(600, 150, 150, 30);
                        t2.setText(rest1.getString("name"));
                        t2.setEditable(false);
                        l1.add(t2);
                        
                        t3 = new JTextField();
                        t3.setBounds(200, 200, 150, 30);
                        t3.setText(rest1.getString("quantity"));
                        l1.add(t3);

                        t4 = new JTextField();
                        t4.setBounds(600, 200, 150, 30);
                        t4.setText(rest1.getString("drug_type"));
                        t4.setEditable(false);
                        l1.add(t4);

                        t5 = new JTextField();
                        t5.setBounds(200, 250, 150, 30);
                        t5.setText(rest1.getString("expiry_date"));
                        t5.setEditable(false);
                        l1.add(t5);

                        t6 = new JTextField();
                        t6.setBounds(600, 250, 150, 30);
                        t6.setText(rest1.getString("unit_rate"));
                        t6.setEditable(false);
                        l1.add(t6);
                    }
                    
                    
                }
                catch(Exception e){
                    e.printStackTrace();
                }
                bt1 = new JButton("Update"); // buttom 1
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
                f.setSize(800,600);
                f.setLocation(300,100);
                f.setResizable(false);
                
                
                
            }
            else{
                JOptionPane.showMessageDialog(null, "Record not found, Please fill the right Medicine! ");
                this.setVisible(false);
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==bt1){
             
             String quantity = t3.getText();
             

             
             try{
                 ConnectionClass obj = new ConnectionClass();
                 String q = "update medicine set quantity='"+quantity+"' where med_id='"+med_id+"'";
                 obj.stm.executeUpdate(q);
                 JOptionPane.showMessageDialog(null, "Quanity Successfull Updated");
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
        new Edit_Medicine("89258").setVisible(true);
    }
}
