
package hmis.Hospital;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;
import java.sql.*;


public class CheckMyProfile implements ActionListener{
    
    JFrame f;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    Choice ch1;
    JButton bt1,bt2;
    private int login_id;
    private ResultSet rest0;
//    String admin_id;
    
    CheckMyProfile(String admin_id,int login_id){
        this.login_id  =login_id;
//        this.admin_id = admin_id;
        
        try{
            ConnectionClass obj1 = new ConnectionClass();
            if(login_id==1){
                String q ="Select * from doctor where doc_id='"+admin_id+"'";
                rest0 = obj1.stm.executeQuery(q);
            }
            else if(login_id==2){
                String q ="Select * from admin where admin_id='"+admin_id+"'";
                rest0 = obj1.stm.executeQuery(q);
            }
            else if(login_id==3){
                String q ="Select * from patient where pat_id='"+admin_id+"'";
                rest0 = obj1.stm.executeQuery(q);
            }
            else if(login_id==4){
                String q ="Select * from receptionist where rec_id='"+admin_id+"'";
                rest0 = obj1.stm.executeQuery(q);
            }
        
        
            if(rest0.next()){

                f = new JFrame("My Profile");
                f.setBackground(Color.WHITE);
                f.setLayout(null);

                l1 = new JLabel();
                l1.setBounds(0, 0, 900, 600);
                l1.setLayout(null);

                ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("hmis\\Hospital\\Images\\Profile.jpg"));
                Image i = img.getImage().getScaledInstance(900, 600, Image.SCALE_SMOOTH);
                ImageIcon img1 = new ImageIcon(i);
                l1.setIcon(img1);

                l2= new JLabel("Edit My Details");
                l2.setBounds(280, 30, 500, 50);
                l2.setFont(new Font("Arial" , Font.BOLD,30));
                l2.setForeground(Color.BLACK);
                l1.add(l2);


                l3= new JLabel("My Id");
                l3.setBounds(50, 150, 150, 30);
                l3.setFont(new Font("Arial" , Font.BOLD,20));
                l3.setForeground(Color.BLACK);
                l1.add(l3);

                t1 = new JTextField();
                t1.setBounds(200, 150, 150, 30);
                t1.setEditable(false);
                l1.add(t1);


                l4= new JLabel("Username");
                l4.setBackground(Color.white);
                l4.setBounds(450, 150, 200, 30);
                l4.setFont(new Font("Arial" , Font.BOLD,20));
                l4.setForeground(Color.BLACK);
                l1.add(l4);

                t2 = new JTextField();
                t2.setBounds(600, 150, 150, 30);
                t2.setEditable(false);
                l1.add(t2);


                l5= new JLabel("Name");
                l5.setBounds(50, 200, 100, 30);
                l5.setFont(new Font("Arial" , Font.BOLD,20));
                l5.setForeground(Color.BLACK);
                l1.add(l5);

                t3 = new JTextField();
                t3.setBounds(200, 200, 150, 30);
                l1.add(t3);


                l6= new JLabel("Age");
                l6.setBounds(450, 200, 200, 30);
                l6.setFont(new Font("Arial" , Font.BOLD,20));
                l6.setForeground(Color.BLACK);
                l1.add(l6);

                t4 = new JTextField();
                t4.setBounds(600, 200, 150, 30);
                l1.add(t4);


                l7= new JLabel("Phone");
                l7.setBounds(50, 250, 100, 30);
                l7.setFont(new Font("Arial" , Font.BOLD,20));
                l7.setForeground(Color.BLACK);
                l1.add(l7);

                t5 = new JTextField();
                t5.setBounds(200, 250, 150, 30);
                l1.add(t5);


                l8= new JLabel("City");
                l8.setBounds(450, 250, 100, 30);
                l8.setFont(new Font("Arial" , Font.BOLD,20));
                l8.setForeground(Color.BLACK);
                l1.add(l8);

                t6 = new JTextField();
                t6.setBounds(600, 250, 150, 30);
                l1.add(t6);


                l9= new JLabel("Email Id");
                l9.setBounds(50, 300, 100, 30);
                l9.setFont(new Font("Arial" , Font.BOLD,20));
                l9.setForeground(Color.BLACK);
                l1.add(l9);

                t7 = new JTextField();
                t7.setBounds(200, 300, 150, 30);
                l1.add(t7);


                l10= new JLabel("Gender");
                l10.setBounds(450, 300, 100, 30);
                l10.setFont(new Font("Arial" , Font.BOLD,20));
                l10.setForeground(Color.BLACK);
                l1.add(l10);

                t8 = new JTextField();
                t8.setBounds(600, 300, 150, 30);
                l1.add(t8);


                try{
                    ConnectionClass obj = new ConnectionClass();
//                    String q = "Select * from admin";
//                    ResultSet rest = obj.stm.executeQuery(q);
                    
                    if(login_id==1){
                        String q1 ="Select * from doctor where doc_id='"+admin_id+"'";
                        rest0 = obj1.stm.executeQuery(q1);
                    }
                    else if(login_id==2){
                        String q1 ="Select * from admin where admin_id='"+admin_id+"'";
                        rest0 = obj1.stm.executeQuery(q1);
                    }
                    else if(login_id==3){
                        String q1 ="Select * from patient where pat_id='"+admin_id+"'";
                        rest0 = obj1.stm.executeQuery(q1);
                    }
                    else if(login_id==4){
                        String q1 ="Select * from receptionist where rec_id='"+admin_id+"'";
                        rest0 = obj1.stm.executeQuery(q1);
                    }

                    while(rest0.next()){
                        if(login_id==1){
                             t1.setText(rest0.getString("doc_id"));
                        }
                        else if(login_id==2){
                             t1.setText(rest0.getString("admin_id"));
                        }
                        else if(login_id==3){
                             t1.setText(rest0.getString("pat_id"));
                        }
                        else if(login_id==4){
                             t1.setText(rest0.getString("rec_id"));
                        }
                       
                        t2.setText(rest0.getString("username"));
                        t3.setText(rest0.getString("name"));
                        t4.setText(rest0.getString("age"));
                        t5.setText(rest0.getString("phone"));
                        t6.setText(rest0.getString("city"));
                        t7.setText(rest0.getString("email"));
                        t8.setText(rest0.getString("gender"));
                    }
                }
                catch(Exception e){
                    e.printStackTrace();
                }

                bt1 = new JButton("Update"); // buttom 1
                bt1.setBackground(Color.black);
                bt1.setForeground(Color.white);
                bt1.setBounds(250,350,150,40);
                l1.add(bt1);

                bt2 = new JButton("Cancle"); // button 2
                bt2.setBackground(Color.RED);
                bt2.setForeground(Color.white);
                bt2.setBounds(450,350,150,40);
                l1.add(bt2);

                bt1.addActionListener(this); // add action
                bt2.addActionListener(this);

                f.setVisible(true);
                f.setSize(900,500);
                f.setLocation(210,50);
                f.setResizable(false);

                f.add(l1);
            }
            else{
                JOptionPane.showMessageDialog(null, "Record not found, Please fill the right admin id!");
//                  this.setVisible(false);
            }
           }
        catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==bt1){
             String add_id = t1.getText();
             String age = t4.getText();
             String phone = t5.getText();
             String city = t6.getText();
             String email = t7.getText();
             
             try{
                 ConnectionClass obj1 = new ConnectionClass();
                 if(login_id==1){
                     String q2 = "update doctor set age='"+age+"',phone='"+phone+"',city='"+city
                         +"',email='"+email+"' where doc_id='"+add_id+"'";
                    obj1.stm.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Your Details Successfully updated");
                    f.setVisible(false);
                 }
                 else if(login_id==2){
                     String q2 = "update admin set age='"+age+"',phone='"+phone+"',city='"+city
                         +"',email='"+email+"' where admin_id='"+add_id+"'";
                    obj1.stm.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Your Details Successfully updated");
                    f.setVisible(false);
                 }
                 else if(login_id==3){
                     String q2 = "update patient set age='"+age+"',phone='"+phone+"',city='"+city
                         +"',email='"+email+"' where pat_id='"+add_id+"'";
                    obj1.stm.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Your Details Successfully updated");
                    f.setVisible(false);
                 }
                 else if(login_id==4){
                     String q2 = "update receptionist set age='"+age+"',phone='"+phone+"',city='"+city
                         +"',email='"+email+"' where rec_id='"+add_id+"'";
                    obj1.stm.executeUpdate(q2);
                    JOptionPane.showMessageDialog(null, "Your Details Successfully updated");
                    f.setVisible(false);
                 }
                 
                 
             }
             catch(Exception e){
                 e.printStackTrace();
             }
        }
        if(ae.getSource()==bt2){
            f.setVisible(false);
        }
    }
    
//    public static void main(String[] args) {
//        new CheckMyProfile("85412",1);
//    }
}
