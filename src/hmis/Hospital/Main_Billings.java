package hmis.Hospital;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Main_Billings extends JFrame implements ActionListener {
 
    String []x={"Id","Patient Name","Bill Id","Date","Amount"};
    JButton bt,bt1,bt2;
    String y[][]=new String[20][5];
    int i=0,j=0;
    JTable t;
    JLabel l1,l2,l3;
    JTextField tf1;
    JPanel p1,p2,p3,p4,p5;
    Font f,f1;
    String q;
    int login_id;
    String pet_id,doc_id,admin_id,app_id;
    
    Main_Billings(int login_id,String admin_id)
    {
        
        super("Patient Information");
        setSize(1500,400);
        setLocation(1,1);
        this.login_id = login_id;
        
        f = new Font("MS UI Gothic", Font.BOLD,15);
        try{
            ConnectionClass obj = new ConnectionClass();
            if(login_id==3){
                q = "SELECT pay.id, pat.name as patient,pay.appointment_id as app_id,pay.date,pay.amount "+
            " FROM hmisdb.payment_detail pay \n" +
            "left join patient pat on pay.patient_id = pat.username "
                        + "where pay.patient_id='"+admin_id+"'";
            }
            else{
                q = "SELECT pay.id, pat.name as patient,pay.appointment_id as app_id,pay.date,pay.amount "+
            " FROM hmisdb.payment_detail pay \n" +
            "left join patient pat on pay.patient_id = pat.username;";
            }
            
            
            ResultSet rest = obj.stm.executeQuery(q);
            while(rest.next()){
                y[i][j++] = rest.getString("id");
                y[i][j++] = rest.getString("patient");
                y[i][j++] = rest.getString("app_id");
                y[i][j++] = rest.getString("date");
                y[i][j++] = rest.getString("amount");
                i++;
                j=0;
            }
    
            t= new JTable(y,x);
            t.setFont(f);
            t.setBackground(Color.BLACK);
            t.setForeground(Color.WHITE);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        JScrollPane sp =new JScrollPane(t);
        f1= new Font("Lucida Fax", Font.BOLD,25);
        
        
        
        l1= new JLabel("Patient Username");
        l2= new JLabel("Gloitel Medical Group Of Technology");
        
        l2.setForeground(Color.YELLOW);
        l2.setHorizontalAlignment(JLabel.CENTER);
        
       
        l2.setFont(f1);
        
        
        
        bt1= new JButton("Edit Patient");
//        bt2 = new JButton("Add Prescription");
        
        // 
        bt1.addActionListener(this);
//        bt2.addActionListener(this);
        
        
        bt1.setBackground(Color.black);
//        bt2.setBackground(Color.black);
        
       
        bt1.setForeground(Color.yellow);
//        bt2.setForeground(Color.green);

        
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l2);
        
        
         
        p3 = new JPanel();
        p3.setLayout(new GridLayout(1,1,10,10));
        p3.add(p1);
        
        p1.setBackground(Color.black);  
        p3.setBackground(Color.black);
       
        add(p3,"North");
        
        p2 = new JPanel();
        p2.setLayout(new GridLayout(2,1,10,10));
        
        l1 = new JLabel("View Full Detail Bills");
        l1.setFont(new Font("MS UI Gothic", Font.BOLD,24));
        l1.setForeground(Color.yellow);
        l1.setHorizontalAlignment(JLabel.CENTER);
        
        
        p4 = new JPanel();
        p4.setLayout(new GridLayout(1,3,10,10));
        
        
        
        l3 = new JLabel("Bill No.");
        l3.setFont(new Font("MS UI Gothic", Font.BOLD,22));
        l3.setForeground(Color.gray);
        
        tf1 = new JTextField();
        tf1.setFont(f);
        
        bt= new JButton("View Billing");  // set buttons
        bt.addActionListener(this);
        bt.setBackground(Color.black);
        bt.setForeground(Color.green);
        
        p5 = new JPanel();
        p5.setLayout(new GridLayout(1,2,10,10));
        p5.setBackground(Color.black);
        p5.add(l3);
        p5.add(tf1);
        
        p4.add(p5);
        p4.add(bt);
        p4.setBackground(Color.black);
        
        p2.setBackground(Color.black);
        p2.add(l1);
        p2.add(p4);
        add(p2,"South");
        
        
        add(sp);
    }
    
    
    
    public void actionPerformed(ActionEvent a){
         
        app_id = tf1.getText();
        
        if(a.getSource()==bt){
             if(app_id.isEmpty()){
                JOptionPane.showMessageDialog(null,"Please fill Bill ID !");
            }
            else{
                new View_Billing(app_id).setVisible(true);
                
            }
        }  
    }
        
    
    public static void main(String[] args) {
        new Main_Billings(1,"Daku").setVisible(true);
    }
}
