
package hmis.Hospital;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener {
    
    JFrame f;
    JPanel panel;
    JLabel l1, l2, l3, l4;
    JTextField tf;
    JPasswordField pf;
    JButton bt1, bt2;
    int login_id;
    
    Login(int login_id) {
        this.login_id = login_id;
        
        if(login_id==1){
            f = new JFrame("Doctor Login Page");
        }
        else if(login_id==2){
            f = new JFrame("Admin Login Page");
        }
        else if(login_id==3){
            f = new JFrame("Patient Login Page");
        }
        else{
            f = new JFrame("Reception Login Page");
        }
        
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
        
        l2 = new JLabel("Login Page");
        l2.setBounds(198, 30, 500, 50);
        l2.setFont(new Font("Arial", Font.BOLD, 30));
        l2.setForeground(Color.BLACK);
        l1.add(l2);
        
        l3 = new JLabel("Username:  ");
        l3.setBounds(130, 120, 150, 30);
        l3.setFont(new Font("Arial", Font.BOLD, 20));
        l3.setForeground(Color.BLACK);
        l1.add(l3);
        
        l4 = new JLabel("Password:  ");
        l4.setBounds(130, 170, 150, 30);
        l4.setFont(new Font("Arial", Font.BOLD, 20));
        l4.setForeground(Color.BLACK);
        l1.add(l4);
        
        tf = new JTextField();
        tf.setBounds(310, 120, 150, 30);
        l1.add(tf);
        
        pf = new JPasswordField();
        pf.setBounds(310, 170, 150, 30);
        l1.add(pf);
        
        bt1 = new JButton("Login");
        bt1.addActionListener(this);
        bt1.setBackground(Color.BLACK);
        bt1.setForeground(Color.WHITE);
        bt1.setBounds(130, 220, 150, 40);
        l1.add(bt1);
        
        bt2 = new JButton("Cancel");
        bt2.setBackground(Color.BLACK);
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
            try{
                ConnectionClass obj = new ConnectionClass();
                String name = tf.getText();
                String pass = pf.getText();
                ResultSet  rs;
                if(login_id==1){
                    String q = "Select * from doctor where username='"+name+"' and password='"+pass+"'";
                    rs = obj.stm.executeQuery(q);
                    
                    if(rs.next()){
                        String doctorName = rs.getString("name");
                        String doctor_id = rs.getString("doc_id");
                        String doctor_username = rs.getString("username");

//                        System.out.println("Doctor login");
                        new DoctorHomePage(doctorName,doctor_id,login_id,doctor_username).setVisible(true);
                        f.setVisible(false);
                    }else{
                        JOptionPane.showMessageDialog(null, "You have entered wrong Username and Password");
                        f.setVisible(false);
                        f.setVisible(true);
                    }
                }
                else if(login_id==2){
                    String q = "Select * from admin where username='"+name+"' and password='"+pass+"'";
                    rs = obj.stm.executeQuery(q);
                    
                    if(rs.next()){
                        String adminName = rs.getString("name");
                        String admin_id = rs.getString("admin_id");
                        String admin_username = rs.getString("username");

                        new AdminHomePage(adminName,admin_id,login_id,admin_username).setVisible(true);
                        f.setVisible(false);
                    }else{
                        JOptionPane.showMessageDialog(null, "You have entered wrong Username and Password");
                        f.setVisible(false);
                        f.setVisible(true);
                    }
                }
                else if(login_id==3){
                    String q = "Select * from patient where username='"+name+"' and password='"+pass+"'";
                    rs = obj.stm.executeQuery(q);
                    
                    if(rs.next()){
                        String patientName = rs.getString("name");
                        String patient_id = rs.getString("pat_id");
                        String patient_username = rs.getString("username");

                        new PatientHomePage(patientName,patient_id,login_id,patient_username).setVisible(true);
                        f.setVisible(false);
                    }else{
                        JOptionPane.showMessageDialog(null, "You have entered wrong Username and Password");
                        f.setVisible(false);
                        f.setVisible(true);
                    }
                }
                else if(login_id==4){
                        String q = "Select * from receptionist where username='"+name+"' and password='"+pass+"'";
                    rs = obj.stm.executeQuery(q);
                    
                    if(rs.next()){
                        String receptionistName = rs.getString("name");
                        String receptionist_id = rs.getString("rec_id");
                        String reception_username = rs.getString("username");

                        new ReceptionistHomePage(receptionistName,receptionist_id,login_id,reception_username).setVisible(true);
                        f.setVisible(false);
                    }else{
                        JOptionPane.showMessageDialog(null, "You have entered wrong Username and Password");
                        f.setVisible(false);
                        f.setVisible(true);
                    }
                }
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
        if(ae.getSource()==bt2){
            this.f.setVisible(false);
            new Index();
        }
    }
    
//    public static void main(String[] args) {
//        new Login();
//    }
    
    
}
