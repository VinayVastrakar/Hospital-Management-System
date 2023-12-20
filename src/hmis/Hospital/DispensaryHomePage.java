
package hmis.Hospital;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class DispensaryHomePage extends JFrame implements ActionListener {
    JLabel l1;
    Font f,f1,f2;
    private String dec_id;
    private int login_id ;
    String username;
    
    DispensaryHomePage(String despensaryName, String dec_id,int login_id,String username){
        super("Dispensary Home Page");
        setLocation(0,0);
        setSize(1500,720);
       
        this.dec_id = dec_id;
        this.login_id = login_id;
        this.username = username;
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("hmis\\Hospital\\Images\\Doctor.jpg"));
        Image i = img.getImage().getScaledInstance(1500, 720, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i);
        l1 = new JLabel(img1);
        
        f = new Font("Lucida Fax", Font.BOLD,16);
        f1 = new Font("Gadugi", Font.BOLD,25);
        f2 = new Font("MS UI Gothic", Font.BOLD,10);
        
        JMenuBar m1 = new JMenuBar();
        m1.getAlignmentX();
        
        JMenu men1 = new JMenu("Medicine");

        JMenuItem ment2 = new JMenuItem("View Medicine");
        JMenuItem ment3 = new JMenuItem("Add Medicine");
        men1.add(ment2);
        men1.add(ment3);
        
        JMenu men3 = new JMenu("Billing");

        JMenuItem ment6 = new JMenuItem("Make Billing");
        JMenuItem ment7 = new JMenuItem("View Billing");

        men3.add(ment6);
        men3.add(ment7);
        
        JMenu men4 = new JMenu("Priscription");
        JMenuItem ment8 = new JMenuItem("View Priscription");
        men4.add(ment8);
        
        
        JMenu men5 = new JMenu("Despensary ("+despensaryName+")");
        JMenuItem ment9 = new JMenuItem("My Profile");
        JMenuItem ment10 = new JMenuItem("Change Password");
        men5.add(ment9);
        men5.add(ment10);
        
        JMenu men6 = new JMenu("Exit");
        JMenuItem ment11 = new JMenuItem("Exit");
        men6.add(ment11);
        
        m1.add(men1);
        m1.add(men3);
        m1.add(men4);
        m1.add(men5);
        m1.add(men6);
        
        men1.setFont(f1);
        men3.setFont(f1);
        men4.setFont(f1);
        men5.setFont(f1);
        men6.setFont(f1);
        

        ment2.setFont(f);
        ment3.setFont(f);
        ment6.setFont(f);
        ment7.setFont(f);
        ment8.setFont(f);
        ment9.setFont(f);
        ment10.setFont(f);
        ment11.setFont(f);
        
        m1.setBackground(Color.LIGHT_GRAY);
        
        men1.setForeground(Color.BLACK);
        men3.setForeground(Color.BLACK);
        men4.setForeground(Color.BLACK);
        men5.setForeground(Color.BLACK);
        men6.setForeground(Color.RED);
        
        ment8.setBackground(Color.GREEN);
        ment9.setBackground(Color.GREEN);
        ment11.setBackground(Color.RED);
        
        ment2.setBackground(Color.BLUE);
        ment3.setBackground(Color.GREEN);
        ment6.setBackground(Color.BLUE);
        ment7.setBackground(Color.GREEN);
        ment10.setBackground(Color.BLUE);
        

        ment2.addActionListener(this);
        ment3.addActionListener(this);
        ment6.addActionListener(this);
        ment8.addActionListener(this);
        ment9.addActionListener(this);
        ment10.addActionListener(this);
        ment11.addActionListener(this);
        
        setJMenuBar(m1);
        add(l1);
        
        
        
        
    }
     public void actionPerformed(ActionEvent ae){
         
         String comnd = ae.getActionCommand();
         
         if(comnd.equals("Add Medicine")){
             new Add_Medicine();
         }
         else if(comnd.equals("View Medicine")){
             new View_Medicine().setVisible(true);
         }
         else if(comnd.equals("Make Billing")){
             new Make_Billing(login_id).setVisible(true);  
         }
         else if(comnd.equals("View Billing")){
             new View_Billing(username,login_id).setVisible(true);
         }
         else if(comnd.equals("View Priscription")){
             new View_Priscription(username,login_id).setVisible(true);
         }
//         else if(comnd.equals("My Profile")){
//             new CheckMyProfile(dec_id,login_id);
//         }
         else if(comnd.equals("Change Password")){
             new ChangeMyPassword(dec_id,login_id);
         }
         else if(comnd.equals("Exit")){
             this.setVisible(false);
             new Index();
         }
     }
     
     public static void main(String[] args) {
        new DispensaryHomePage("Sippu Sharma","1",5,"Sippu").setVisible(true);
    }
}
