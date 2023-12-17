
package hmis.Hospital;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class ChangeMyPassword extends JFrame implements ActionListener{
    
    JFrame f;
    JPanel panel;
    JLabel l1, l2, l3, l4;
    JTextField tf;
    JPasswordField pf;
    JButton bt1, bt2;
    private String admin_id;
    int login_id;
    
    ChangeMyPassword(String adminId,int login_id){
        
        admin_id = adminId;
        this.login_id = login_id;
        
        f = new JFrame("Change Password");
        f.setBackground(Color.WHITE);
        f.setLayout(null);
        
        l1 = new JLabel();
        l1.setBounds(0, 0, 580, 350);
        l1.setLayout(null);
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("hmis\\Hospital\\Images\\login.jpg"));
        Image i = img.getImage().getScaledInstance(580, 350, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i);
        l1.setIcon(img1);
        
        f.add(l1);
        
        l2 = new JLabel("Change My Password");
        l2.setBounds(140, 30, 500, 50);
        l2.setFont(new Font("Arial", Font.BOLD, 30));
        l2.setForeground(Color.BLACK);
        l1.add(l2);
        
        l3 = new JLabel("Old Password:");
        l3.setBounds(130, 120, 160, 30);
        l3.setFont(new Font("Arial", Font.BOLD, 20));
        l3.setForeground(Color.BLACK);
        l1.add(l3);
        
        l4 = new JLabel("New Password:");
        l4.setBounds(130, 170, 160, 30);
        l4.setFont(new Font("Arial", Font.BOLD, 20));
        l4.setForeground(Color.BLACK);
        l1.add(l4);
        
        tf = new JTextField();
        tf.setBounds(310, 120, 150, 30);
        l1.add(tf);
        
        pf = new JPasswordField();
        pf.setBounds(310, 170, 150, 30);
        l1.add(pf);
        
        bt1 = new JButton("Change Password");
        bt1.addActionListener(this);
        bt1.setBackground(Color.BLACK);
        bt1.setForeground(Color.WHITE);
        bt1.setBounds(130, 220, 150, 40);
        l1.add(bt1);
        
        bt2 = new JButton("Cancel");
        bt2.setBackground(Color.RED);
        bt2.setForeground(Color.WHITE);
        bt2.addActionListener(this);
        bt2.setBounds(310, 220, 150, 40);
        l1.add(bt2);
        
        f.setVisible(true);
        f.setSize(580, 350);
        f.setLocation(300, 100);
        f.setResizable(false);
    }
    
    public void actionPerformed(ActionEvent ae) {
        
        if(ae.getSource()==bt1){
            String old_pass = tf.getText();
            String new_pass = pf.getText();
            
            try{
                ConnectionClass obj = new ConnectionClass();
                String q="";
                if(login_id==1){
                    q = "update doctor set password='"+new_pass+"' where doc_id='"+admin_id+
                        "' and password='"+old_pass+"'";
                }
                else if(login_id==2){
                    q = "update admin set password='"+new_pass+"' where admin_id='"+admin_id+
                        "' and password='"+old_pass+"'";
                }
                else if(login_id==3){
                    q = "update patient set password='"+new_pass+"' where pat_id='"+admin_id+
                        "' and password='"+old_pass+"'";
                }
                else if(login_id==4){
                    q = "update receptionist set password='"+new_pass+"' where rec_id='"+admin_id+
                        "' and password='"+old_pass+"'";
                }
                else if(login_id==5){
                    q = "update dispensary set password='"+new_pass+"' where dec_id='"+admin_id+
                        "' and password='"+old_pass+"'";
                }
                
                int ss = obj.stm.executeUpdate(q);
                if(ss==1){
                    JOptionPane.showMessageDialog(null, "Your Password is Successfully updated");
                    f.setVisible(false);
                }else{
                     JOptionPane.showMessageDialog(null, "Your Entered Wrong Password");
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        if(ae.getSource()==bt2){
            this.f.setVisible(false);
        }
    }
    
}
