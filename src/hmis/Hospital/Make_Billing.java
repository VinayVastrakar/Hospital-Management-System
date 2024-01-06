package hmis.Hospital;

import java.util.Date;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.text.SimpleDateFormat;

public class Make_Billing extends JFrame implements ActionListener {
 
    String []x={"Sr. n","PVMS No","Nomenculture","Expiry Date","Quantity","MRP","Amount"};
    
    JButton bt,bt1,bt2;
    String y[][]=new String[30][7];
    int i=0,j=0;
    JTable t;
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField tf1;
    JPanel p1,p2,p3,p4,p5,p6;
    Font f,f1,f2;
    String q;
    int Sr_n=0,qty;
    double MRP,Amount,Total;
    String app_id,pet_name,pat_user,doc_name ,med_id,pre_id;
    
    Make_Billing(String app_id,String admin_id)
    {
        
        super("Billing Information");
        setSize(1100,600);
        setLocation(50,1);
        Date d = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String date = dateFormat.format(d);
        
        f = new Font("MS UI Gothic", Font.BOLD,15);
        f2 = new Font("Lucida Fax", Font.BOLD,20);
        try{
            ConnectionClass obj = new ConnectionClass();
//            q = "Select * from Patient where username='"+app_id+"'";
            q = "select hmisdb.prescription_hd.id_hd as pre_id, hmisdb.patient.name as pat,"
                    + " hmisdb.patient.username as pat_user, hmisdb.doctor.name as doc, \n" +
"hmisdb.medicine.name as med, hmisdb.medicine.expiry_date , hmisdb.prescription_dd.quantity as qty,\n" +
"hmisdb.medicine.unit_rate as rate, hmisdb.medicine.med_id \n" +
"from hmisdb.prescription_hd\n" +
"left outer join hmisdb.patient on hmisdb.prescription_hd.patient =hmisdb.patient.username\n" +
"left outer join hmisdb.doctor on hmisdb.doctor.username =hmisdb.prescription_hd.doctor \n" +
"left outer join hmisdb.prescription_dd on hmisdb.prescription_dd.pre_hd=hmisdb.prescription_hd.id_hd\n" +
"left outer join hmisdb.medicine on hmisdb.prescription_dd.med_id= hmisdb.medicine.med_id\n" +
"left outer join hmisdb.appointment on hmisdb.prescription_hd.appointment_id = hmisdb.appointment.app_id\n" +
"where hmisdb.prescription_hd.appointment_id='"+app_id+"' and hmisdb.appointment.status ='Complete'";
            
            
            ResultSet rest = obj.stm.executeQuery(q);
//            ResultSet rest1;
//            id_hd,Username,name,expiry_date,quantity,unit_rate
            while(rest.next()){
                pet_name= rest.getString("pat");// patient name
                doc_name = rest.getString("doc");
                qty = Integer.parseInt(rest.getString("qty"));
                MRP = Integer.parseInt(rest.getString("rate"));
                med_id = rest.getString("med_id");
                pre_id =rest.getString("pre_id");
                pat_user = rest.getString("pat_user");
                Amount = MRP*qty;
                Total+=Amount;
                
                
                y[i][j++] = ++Sr_n +"";
                y[i][j++] = rest.getString("pre_id");
                y[i][j++] = rest.getString("med"); // medicinae_name
                y[i][j++] = rest.getString("expiry_date");// exp date
                y[i][j++] = rest.getString("qty");
                y[i][j++] = rest.getString("rate");
                y[i][j++] = Amount+"";//Amount
                i++;
                j=0;
                
                String q1 = "INSERT INTO med_issued(`med_id`, `issue_date`, `app_id`, `pre_id`, `issue_by`, `patient`)"
                + " VALUES ('"+med_id+"', '"+date+"', '"+app_id+"', '"+pre_id+"', '"+admin_id+"', '"+pat_user+"');";
                
                System.out.println(q1);
                obj.stm.executeUpdate(q1);
                System.out.println(q1);
            }
            
            
            y[++i][5]="Total";// for total
            y[i][6]=Total+"";
            
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
        
        
        if(1!=0){
        p5= new JPanel();
        p5.setLayout(new GridLayout(1,1,0,0));
        
        l5 = new JLabel("Medicine Invoice");
        l5.setFont(f1);
        l5.setForeground(Color.YELLOW); 
        l5.setHorizontalAlignment(JLabel.CENTER);
        p5.add(l5);
        
        
           // patient information
        l3 = new JLabel("Patient- "+pet_name);
        l3.setForeground(Color.GRAY);
        l3.setFont(f2);
        l4 = new JLabel("Invoice no. "+app_id); // patient name
        l4.setForeground(Color.GRAY);
        l4.setFont(f2);
        // doctor
        l6 = new JLabel("Doctor- "+doc_name);
        l6.setForeground(Color.GRAY);
        l6.setFont(f2);
        l7 = new JLabel("Date- "+date); // patient name
        l7.setForeground(Color.GRAY);
        l7.setFont(f2);
        
        p6 = new JPanel();
        p6.setLayout(new GridLayout(2,2,10,10));
        p6.add(l3);
        p6.add(l4);
        p6.add(l6);
        p6.add(l7);
        
        
        p4 = new JPanel();// for all greed
        p4.setLayout(new GridLayout(2,1,10,10));
        p4.add(p5);
        p4.add(p6);
        p4.setBackground(Color.black);
        p5.setBackground(Color.black);
        p6.setBackground(Color.black);
        add(p4,"North"); 
        }
        
        
        
        l1= new JLabel("Medicine id");
        l2= new JLabel("Delete Any Medicine");
        
        l1.setForeground(Color.GRAY);
        l2.setForeground(Color.YELLOW);
        l2.setHorizontalAlignment(JLabel.CENTER);
        
        l1.setFont(f1);
        l2.setFont(f1);
        
        bt= new JButton("Delete");  // set buttons
        bt1= new JButton("Issue medicine");
//        bt2 = new JButton("Add Prescription");
        
        bt.addActionListener(this); // 
        bt1.addActionListener(this);
//        bt2.addActionListener(this);
        
        bt.setBackground(Color.black);
        bt1.setBackground(Color.black);
//        bt2.setBackground(Color.black);
        
        bt.setForeground(Color.red);
        bt1.setForeground(Color.green);
//        bt2.setForeground(Color.green);
        
           
        tf1 = new JTextField();
        tf1.setFont(f);
        
        p1 = new JPanel();
        p1.setLayout(new GridLayout(1,1,0,10));
        p1.add(l2);
        
        p2 = new JPanel();
        p2.setLayout(new GridLayout(1,4,10,10));
        p2.add(l1);
        p2.add(tf1);
        p2.add(bt);
        p2.add(bt1);
//        p2.add(bt2);
         
        p3 = new JPanel();
        p3.setLayout(new GridLayout(2,1,10,10));
        p3.add(p1);
        p3.add(p2);
        
        p1.setBackground(Color.black);
        p2.setBackground(Color.black);
        p3.setBackground(Color.black);
        add(p3,"South");
        
        add(sp);
    }
    
    
    
    public void actionPerformed(ActionEvent ae){
         String username = tf1.getText();
        if(ae.getSource()==bt){
                if(username.isEmpty()){
                JOptionPane.showMessageDialog(null,"Please fill Patient Username !");
                }
                else{
                    try{
                    ConnectionClass obj1 = new ConnectionClass();
                    String q = "delete from patient where username='"+username +"'";
                    obj1.stm.executeUpdate(q);
    //                String q1 = "update appointment set appointment_status = 'Cancel' where patient_username='"+username+"'";
    //                obj1.stm.executeUpdate(q1);
                    setVisible(false);
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }
            
        }
        if(ae.getSource()==bt1){
            
            JOptionPane.showMessageDialog(null,"Medicines are issued");
            setVisible(false);
            
        }
    }
        
    
    public static void main(String[] args) {
        new Make_Billing("77797","Sippu").setVisible(true);
    }
}
