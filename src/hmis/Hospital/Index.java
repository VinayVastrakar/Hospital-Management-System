
package hmis.Hospital;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Index extends JFrame implements ActionListener {
    
    JFrame f;
    JLabel l1,l2,l3,l4;
    JButton b1,b2,b3,b4,b5;
    int loginId;
    
    
    Index(){
     
        f= new JFrame("Index Page");
        f.setBackground(Color.WHITE);
        f.setLayout(null);
        
        l1 = new JLabel();
        l1.setBounds(0, 0, 800, 570);
        l1.setLayout(null);
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("hmis\\Hospital\\Images\\IndexImg.jpg"));
        Image i1 = img.getImage().getScaledInstance(800, 570, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i1);
        l1.setIcon(img1);
        
        l2 = new JLabel("Gloitel Medical Group Of Technologies");
        l2.setBounds(70,25,600,40);
        l2.setFont(new Font("Arial", Font.BOLD,30));
        l2.setForeground(Color.BLACK);
        l1.add(l2);
        
        l3 = new JLabel("Provide Best Quality Health Care");
        l3.setBounds(86,50,600,40);
        l3.setFont(new Font("Arial", Font.BOLD,17));
        l3.setForeground(Color.BLACK);
        l1.add(l3);
        
        b1= new JButton("Doctor");
        b1.setBounds(50, 390, 150, 40);
        b1.setFont(new Font("Arial",Font.CENTER_BASELINE,20));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        l1.add(b1);
        
        b2= new JButton("Admin");
        b2.setBounds(250, 390, 150, 40);
        b2.setFont(new Font("Arial",Font.CENTER_BASELINE,20));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        l1.add(b2);
        
        b3= new JButton("Patient");
        b3.setBounds(50, 450, 150, 40);
        b3.setFont(new Font("Arial",Font.CENTER_BASELINE,20));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        l1.add(b3);
        
        b4= new JButton("Reception");
        b4.setBounds(250, 450, 150, 40);
        b4.setFont(new Font("Arial",Font.CENTER_BASELINE,20));
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        l1.add(b4);
        
        b5= new JButton("Dispensary");
        b5.setBounds(450, 390, 150, 40);
        b5.setFont(new Font("Arial",Font.CENTER_BASELINE,20));
        b5.setBackground(Color.BLACK);
        b5.setForeground(Color.WHITE);
        l1.add(b5);
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
        b5.addActionListener(this);
        
        f.add(l1);
        f.setSize(800, 570);
        f.setLocation(300, 100);
        f.setVisible(true);
        f.setResizable(false);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource()==b1){//doctor
            loginId =1;
            f.setVisible(false);
            new Login(loginId);
        }
         if(ae.getSource()==b2){//admin
             loginId = 2;
            f.setVisible(false);
            new Login(loginId);
        } 
        if(ae.getSource()==b3){//patient
            loginId =3;
            f.setVisible(false);
            new Login(loginId);
        } 
        if(ae.getSource()==b4){//reception
            loginId = 4;
            f.setVisible(false);
            new Login(loginId);
        }
        if(ae.getSource()==b5){//dispensary
            loginId = 5;
            f.setVisible(false);
            new Login(loginId);
        }
        
         
        
    }
    
    public static void main(String[] args) {
        new Index();
    }
    
}