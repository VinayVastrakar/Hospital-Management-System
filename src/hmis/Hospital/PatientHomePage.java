
package hmis.Hospital;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class PatientHomePage extends JFrame implements ActionListener {
    JLabel l1;
    Font f,f1,f2;
    private String patientId;
    int login_id;
    String username;
    String admin_id;
    
    PatientHomePage(String PatientName, String pat_id, int login_id,String username){
        super("Patient Home Page");
        setLocation(0,0);
        setSize(1500,720);
       
        patientId = pat_id;
        this.login_id = login_id;
        this.username = username;
        admin_id = pat_id;
        
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("hmis\\Hospital\\Images\\PatientHome.jpg"));
        Image i = img.getImage().getScaledInstance(1500, 720, Image.SCALE_SMOOTH);
        ImageIcon img1 = new ImageIcon(i);
        l1 = new JLabel(img1);
        
        f = new Font("Lucida Fax", Font.BOLD,16);
        f1 = new Font("Gadugi", Font.BOLD,25);
        f2 = new Font("MS UI Gothic", Font.BOLD,10);
        
        JMenuBar m1 = new JMenuBar();
        m1.getAlignmentX();
        
        JMenu men1 = new JMenu("Doctor");

        JMenuItem ment2 = new JMenuItem("View Doctor");

        men1.add(ment2);
        
        JMenu men2 = new JMenu("Patient");

        JMenuItem ment4 = new JMenuItem("View Patient");

        men2.add(ment4);
        
        JMenu men3 = new JMenu("Receptionist");

        JMenuItem ment6 = new JMenuItem("View Receptionist");

        men3.add(ment6);
        
        JMenu men4 = new JMenu("Appiontment");
        JMenuItem ment7 = new JMenuItem("Add Appiontment");
        JMenuItem ment8 = new JMenuItem("View Appiontment");
        men4.add(ment7);
        men4.add(ment8);
        
        JMenu men5 = new JMenu("Hii, Sir ("+PatientName+")");
        JMenuItem ment9 = new JMenuItem("My Profile");
        JMenuItem ment10 = new JMenuItem("Change Password");
        men5.add(ment9);
        men5.add(ment10);
        
        JMenu men6 = new JMenu("Exit");
        JMenuItem ment11 = new JMenuItem("Exit");
        men6.add(ment11);
        
        m1.add(men1);
        m1.add(men2);
        m1.add(men3);
        m1.add(men4);
        m1.add(men5);
        m1.add(men6);
        
        men1.setFont(f1);
        men2.setFont(f1);
        men3.setFont(f1);
        men4.setFont(f1);
        men5.setFont(f1);
        men6.setFont(f1);
        

        ment2.setFont(f);

        ment4.setFont(f);

        ment6.setFont(f);
        ment7.setFont(f);
        ment8.setFont(f);
        ment9.setFont(f);
        ment10.setFont(f);
        ment11.setFont(f);
        
        m1.setBackground(Color.LIGHT_GRAY);
        
        men1.setForeground(Color.BLACK);
        men2.setForeground(Color.BLACK);
        men3.setForeground(Color.BLACK);
        men4.setForeground(Color.BLACK);
        men5.setForeground(Color.BLACK);
        men6.setForeground(Color.RED);
        

        ment7.setBackground(Color.GREEN);
        ment9.setBackground(Color.GREEN);
        ment11.setBackground(Color.RED);
        
        ment2.setBackground(Color.BLUE);
        ment4.setBackground(Color.BLUE);
        ment6.setBackground(Color.BLUE);
        ment8.setBackground(Color.BLUE);
        ment10.setBackground(Color.BLUE);
        

        ment2.addActionListener(this);

        ment4.addActionListener(this);

        ment6.addActionListener(this);
        ment7.addActionListener(this);
        ment8.addActionListener(this);
        ment9.addActionListener(this);
        ment10.addActionListener(this);
        ment11.addActionListener(this);
        
        setJMenuBar(m1);
        add(l1);
        
        
        
        
    }
     public void actionPerformed(ActionEvent ae){
         
         String comnd = ae.getActionCommand();
         
         if(comnd.equals("View Doctor")){
             new ViewDoctor(login_id).setVisible(true);
         }
         else if(comnd.equals("View Patient")){
             new ViewPatient(username,login_id).setVisible(true);
         }
         else if(comnd.equals("View Receptionist")){
             new View_Receptionist(login_id).setVisible(true);
         }
         else if(comnd.equals("View Appiontment")){
             new View_Appointment(username,login_id).setVisible(true);
         }
         else if(comnd.equals("Add Appiontment")){
             new Add_Appointment(login_id,username).setVisible(true);
         }
         else if(comnd.equals("My Profile")){
             new CheckMyProfile(admin_id,login_id);
         }
         else if(comnd.equals("Change Password")){
             new ChangeMyPassword(patientId,login_id);
         }
         else if(comnd.equals("Exit")){
             this.setVisible(false);
             new Index();
         }
     }
    

}
