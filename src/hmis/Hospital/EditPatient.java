
package hmis.Hospital;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class EditPatient extends JFrame implements ActionListener{
    
    JFrame f;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16;
    JTextField t1,t2,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14;
    JPasswordField t3;
    JButton bt1,bt2;
    
    
    EditPatient(String username){
        try{
            ConnectionClass obj = new ConnectionClass();
            String q = "Select * from Patient where username='"+username+"'";
            ResultSet rest = obj.stm.executeQuery(q);
            if(rest.next()){
                
                f = new JFrame("Edit Patient");
                f.setBackground(Color.WHITE);
                f.setLayout(null);
                
                l1 = new JLabel();
                l1.setBounds(0, 0, 800, 600);
                l1.setLayout(null);

                ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("hmis\\Hospital\\Images\\AddPatient.jpg"));
                Image i = img.getImage().getScaledInstance(800, 600, Image.SCALE_SMOOTH);
                ImageIcon img1 = new ImageIcon(i);
                l1.setIcon(img1);

                l2= new JLabel("Patient Details");
                l2.setBounds(280, 30, 500, 50);
                l2.setFont(new Font("Arial" , Font.BOLD,30));
                l2.setForeground(Color.BLACK);
                l1.add(l2);

                l3= new JLabel("Name");
                l3.setBounds(50, 150, 150, 30);
                l3.setFont(new Font("Arial" , Font.BOLD,20));
                l3.setForeground(Color.BLACK);
                l1.add(l3);
                
                l4= new JLabel("Username");
                l4.setBackground(Color.white);
                l4.setBounds(450, 150, 200, 30);
                l4.setFont(new Font("Arial" , Font.BOLD,20));
                l4.setForeground(Color.BLACK);
                l1.add(l4);
        
                l5= new JLabel("Password");
                l5.setBounds(50, 200, 100, 30);
                l5.setFont(new Font("Arial" , Font.BOLD,20));
                l5.setForeground(Color.BLACK);
                l1.add(l5);
                
                l6= new JLabel("Email");
                l6.setBounds(450, 200, 200, 30);
                l6.setFont(new Font("Arial" , Font.BOLD,20));
                l6.setForeground(Color.BLACK);
                l1.add(l6);
                
                l7= new JLabel("Father Name");
                l7.setBounds(50, 250, 150, 30);
                l7.setFont(new Font("Arial" , Font.BOLD,20));
                l7.setForeground(Color.BLACK);
                l1.add(l7);
                
                l8= new JLabel("Phone");
                l8.setBounds(450, 250, 100, 30);
                l8.setFont(new Font("Arial" , Font.BOLD,20));
                l8.setForeground(Color.BLACK);
                l1.add(l8);
        
                l9= new JLabel("Marital Status");
                l9.setBounds(50, 300, 150, 30);
                l9.setFont(new Font("Arial" , Font.BOLD,20));
                l9.setForeground(Color.BLACK);
                l1.add(l9);
        
                l10= new JLabel("City");
                l10.setBounds(450, 300, 100, 30);
                l10.setFont(new Font("Arial" , Font.BOLD,20));
                l10.setForeground(Color.BLACK);
                l1.add(l10);
        
                l11= new JLabel("Gender");
                l11.setBounds(50, 350, 100, 30);
                l11.setFont(new Font("Arial" , Font.BOLD,20));
                l11.setForeground(Color.BLACK);
                l1.add(l11);
        
                l12= new JLabel("Blood Group");
                l12.setBounds(450, 350, 140, 30);
                l12.setFont(new Font("Arial" , Font.BOLD,20));
                l12.setForeground(Color.BLACK);
                l1.add(l12);
                
                l13= new JLabel("Disease");
                l13.setBounds(450, 400, 150, 30);
                l13.setFont(new Font("Arial" , Font.BOLD,20));
                l13.setForeground(Color.BLACK);
                l13.setBackground(Color.white);
                l1.add(l13);
                
                l14= new JLabel("Age");
                l14.setBounds(450, 450, 150, 30);
                l14.setFont(new Font("Arial" , Font.BOLD,20));
                l14.setForeground(Color.BLACK);
                l1.add(l14);
                
                l15= new JLabel("Address");
                l15.setBounds(50, 400, 120, 30);
                l15.setFont(new Font("Arial" , Font.BOLD,20));
                l15.setForeground(Color.BLACK);
                l1.add(l15);
                
                l16= new JLabel("Date Of Birth");
                l16.setBounds(50, 450, 140, 30);
                l16.setFont(new Font("Arial" , Font.BOLD,20));
                l16.setForeground(Color.BLACK);
                l1.add(l16);
                
                try{
                    
                    ConnectionClass obj1 = new ConnectionClass();
                    String q1 ="Select * from patient where username='"+username+"'";
                    ResultSet rest1 = obj1.stm.executeQuery(q1);
                    
                    while(rest1.next()){
                        t1 = new JTextField();
                        t1.setBounds(200, 150, 150, 30);
                        t1.setText(rest1.getString("name"));
                        l1.add(t1);
                        
                        t2 = new JTextField();
                        t2.setBounds(600, 150, 150, 30);
                        t2.setText(rest1.getString("username"));
                        t2.setEditable(false);
                        l1.add(t2);
                        
                        t3 = new JPasswordField();
                        t3.setBounds(200, 200, 150, 30);
                        t3.setText(rest1.getString("password"));
                        t3.setEditable(false);
                        l1.add(t3);

                        t4 = new JTextField();
                        t4.setBounds(600, 200, 150, 30);
                        t4.setText(rest1.getString("email"));
                        l1.add(t4);

                        t5 = new JTextField();
                        t5.setBounds(200, 250, 150, 30);
                        t5.setText(rest1.getString("father_name"));
                        l1.add(t5);

                        t6 = new JTextField();
                        t6.setBounds(600, 250, 150, 30);
                        t6.setText(rest1.getString("phone"));
                        l1.add(t6);

                        t7 = new JTextField();
                        t7.setBounds(200, 300, 150, 30);
                        t7.setText(rest1.getString("marital_status"));
                        l1.add(t7);

                        t8 = new JTextField();
                        t8.setBounds(600, 300, 150, 30);
                        t8.setText(rest1.getString("city"));
                        l1.add(t8);

                        t9 = new JTextField();
                        t9.setBounds(200, 350, 150, 30);
                        t9.setText(rest1.getString("gender"));
                        l1.add(t9);
                        
                        t10 = new JTextField();
                        t10.setBounds(600, 350, 150, 30);
                        t10.setText(rest1.getString("blood"));
                        l1.add(t10);

                        t11 = new JTextField();
                        t11.setBounds(600, 400, 150, 30);
                        t11.setText(rest1.getString("Disease"));
                        l1.add(t11);

                        t12 = new JTextField();
                        t12.setBounds(600, 450, 150, 30);
                        t12.setText(rest1.getString("age"));
                        l1.add(t12);

                        t13 = new JTextField();
                        t13.setBounds(200, 400, 150, 30);
                        t13.setText(rest1.getString("address"));
                        l1.add(t13);

                        t14 = new JTextField();
                        t14.setBounds(200, 450, 150, 30);
                        t14.setText(rest1.getString("dob"));
                        l1.add(t14);
                        
                        
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
                JOptionPane.showMessageDialog(null, "Record not found, Please fill the right Patient! ");
                this.setVisible(false);
            }
            
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==bt1){
             String name = t1.getText();
             String username = t2.getText();
             String email = t4.getText();
             String father_name = t5.getText();
             String phone = t6.getText();
             String marital_status = t7.getText();
             String city = t8.getText();
             String gender = t9.getText();
             String blood = t10.getText();
             String disease = t11.getText();
             String age = t12.getText();
             String address = t13.getText();
             String dob = t14.getText();

             
             try{
                 ConnectionClass obj = new ConnectionClass();
                 String q = "update patient set name='"+name+"',email='"+email+"',father_name='"+father_name+
                         "',phone='"+phone+"',marital_status='"+marital_status+"',city='"+city+"',gender='"+gender+
                         "',blood='"+blood+"',deceased='"+disease+"',age='"+age+"',address='"+address+
                         "',dob='"+dob+"' where username='"+username+"'";
                 obj.stm.executeUpdate(q);
                 JOptionPane.showMessageDialog(null, "Details Successfull Updated");
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
}
