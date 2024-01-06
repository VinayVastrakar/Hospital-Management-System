package hmis.Hospital;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.DefaultTableModel;

public class View_Prescription extends JFrame implements ActionListener {
 

    String []x={"Pre. Id","Patient","Medicine","Advice","Frequency","Quantity","Date","Doctor Name","Status"};
    JButton bt;
    String y[][]=new String[20][9];
    int i=0,j=0;
    JTable t;
    JLabel l1,l2;
    JTextField tf1;
    JPanel p1,p2,p3;
    Font f,f1;
    String q,q1;
    String admin_id;
    
    View_Prescription(int login_id,String admin_id) // = app_id,appointment;
    {
        super("Prescription Information");
        setSize(1500,400);
        setLocation(1,1);
        this.admin_id = admin_id;
        
        f = new Font("MS UI Gothic", Font.BOLD,15);
        try{
            ConnectionClass obj = new ConnectionClass();
//            if(login_id==2){
            q = "select hmisdb.prescription_hd.id_hd as pre_id, hmisdb.patient.name as patient,"
                + "hmisdb.medicine.name as medicine, hmisdb.prescription_dd.advice,"
                + " hmisdb.prescription_dd.frequency as freq, hmisdb.prescription_dd.quantity," +
            "hmisdb.prescription_hd.date ,hmisdb.doctor.name as doctor, hmisdb.prescription_hd.status " +
            " from hmisdb.prescription_hd " +
            " left outer join hmisdb.patient on hmisdb.prescription_hd.patient =hmisdb.patient.username " +
            " left outer join hmisdb.prescription_dd on hmisdb.prescription_dd.pre_hd=hmisdb.prescription_hd.id_hd " +
            " left outer join hmisdb.doctor on hmisdb.doctor.username =hmisdb.prescription_hd.doctor " +
            " left outer join hmisdb.medicine on hmisdb.prescription_dd.med_id= hmisdb.medicine.med_id "+
            " where hmisdb.prescription_hd.appointment_id='"+admin_id+"'";
//            }
//            else{
//                q = "Select * from prescription where pet_name='"+admin_id+"'";
//            }
            
            
            ResultSet rest = obj.stm.executeQuery(q);
            while(rest.next()){
                //    "+pre_id+"','"+pet_name+"','"+med_name+"','"+advice+"','"+freq+"','"
//                         +quantity+"','"+date+"','"+doc_name+"'
                y[i][j++] = rest.getString("pre_id");
                y[i][j++] = rest.getString("patient");
                y[i][j++] = rest.getString("medicine");
                y[i][j++] = rest.getString("advice");
                y[i][j++] = rest.getString("freq");
                y[i][j++] = rest.getString("quantity");
                y[i][j++] = rest.getString("date");
                y[i][j++] = rest.getString("doctor");
                y[i][j++] = rest.getString("status");
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
        
        if(login_id==1){
            l1= new JLabel("Prescription Id");
            l2= new JLabel("Delete Any Medicine");

            l1.setForeground(Color.GRAY);
            l2.setForeground(Color.YELLOW);
            l2.setHorizontalAlignment(JLabel.CENTER);

            l1.setFont(f1);
            l2.setFont(f1);

            bt= new JButton("Delete Medicine");  // set buttons
    //        bt1= new JButton("Edit Medicine");

            bt.addActionListener(this); // 
    //        bt1.addActionListener(this);

            bt.setBackground(Color.black);
    //        bt1.setBackground(Color.black);

            bt.setForeground(Color.red);
    //        bt1.setForeground(Color.yellow);

            tf1 = new JTextField();
            tf1.setFont(f);

            p1 = new JPanel();
            p1.setLayout(new GridLayout(1,1,10,10));
            p1.add(l2);

            p2 = new JPanel();
            p2.setLayout(new GridLayout(1,4,10,10));
            p2.add(l1);
            p2.add(tf1);
            p2.add(bt);
    //        p2.add(bt1);

            p3 = new JPanel();
            p3.setLayout(new GridLayout(2,1,10,10));
            p3.add(p1);
            p3.add(p2);

            p1.setBackground(Color.black);
            p2.setBackground(Color.black);
            p3.setBackground(Color.black);

            add(p3,"South");
        }
        
        
        add(sp);
    }
    
    
    
       
        private void updateTable() {
        try {
            ConnectionClass obj = new ConnectionClass();
            q = "select hmisdb.prescription_hd.id_hd as pre_id, hmisdb.patient.name as patient,"
                + "hmisdb.medicine.name as medicine, hmisdb.prescription_dd.advice,"
                + " hmisdb.prescription_dd.frequency as freq, hmisdb.prescription_dd.quantity," +
            "hmisdb.prescription_hd.date ,hmisdb.doctor.name as doctor, hmisdb.prescription_hd.status " +
            " from hmisdb.prescription_hd " +
            " left outer join hmisdb.patient on hmisdb.prescription_hd.patient =hmisdb.patient.username " +
            " left outer join hmisdb.prescription_dd on hmisdb.prescription_dd.pre_hd=hmisdb.prescription_hd.id_hd " +
            " left outer join hmisdb.doctor on hmisdb.doctor.username =hmisdb.prescription_hd.doctor " +
            " left outer join hmisdb.medicine on hmisdb.prescription_dd.med_id= hmisdb.medicine.med_id "
                    + "where appointment_id='"+admin_id+"'";
            
            System.out.println("line no --> 149");
            ResultSet rest = obj.stm.executeQuery(q);
            System.out.println("line no --> 151");

            DefaultTableModel model = new DefaultTableModel(x, 0); // Create a new model

            while (rest.next()) {
                // Add the data to the model
                model.addRow(new Object[]{
                        rest.getString("pre_id"),
                        rest.getString("patient"),
                        rest.getString("medicine"),
                        rest.getString("advice"),
                        rest.getString("freq"),
                        rest.getString("quantity"),
                        rest.getString("date"),
                        rest.getString("doctor")
                });
            }

            // Update the JTable with the new model
            t.setModel(model);
            t.setFont(f);
            t.setBackground(Color.BLACK);
            t.setForeground(Color.WHITE);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        JScrollPane sp =new JScrollPane(t);
        f1= new Font("Lucida Fax", Font.BOLD,25);
        l1= new JLabel("Prescription Id");
        l2= new JLabel("Delete Any Medicine");
        
        l1.setForeground(Color.GRAY);
        l2.setForeground(Color.YELLOW);
        l2.setHorizontalAlignment(JLabel.CENTER);
        
        l1.setFont(f1);
        l2.setFont(f1);
        
        bt= new JButton("Delete Medicine");  // set buttons
//        bt1= new JButton("Edit Medicine");
        
        bt.addActionListener(this); // 
//        bt1.addActionListener(this);
        
        bt.setBackground(Color.black);
//        bt1.setBackground(Color.black);
        
        bt.setForeground(Color.red);
//        bt1.setForeground(Color.yellow);
        
    }
        
    public void actionPerformed(ActionEvent ae){
        String pre_id = tf1.getText();
        if(ae.getSource()==bt){
//            JOptionPane.showMessageDialog(null,"Delete Button Temporary Disable");
            if(pre_id.isEmpty()){
                JOptionPane.showMessageDialog(null,"Please fill Medicine Id !");
            }
            else{
                try{
                ConnectionClass obj1 = new ConnectionClass();
                String q = "delete from prescription_hd where id_hd='"+pre_id+"' and status='P'";
                String q1 = "delete from prescription_dd where pre_hd='"+pre_id+"'";
                try{
                    obj1.stm.executeUpdate(q);
                    obj1.stm.executeUpdate(q1);
                }catch(Exception a){
                     JOptionPane.showMessageDialog(null,"This Medicine is issued you cannnot delete this");
                }
                
                JOptionPane.showMessageDialog(null,"Medicine Is Deleted from prescription");
//                setVisible(false);
//                t= new JTable(y,x);
//                setVisible(true);
                updateTable();

 
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }

        }
//        if(ae.getSource()==bt1){
//             if(med_id.isEmpty()){
//                 JOptionPane.showMessageDialog(null,"Please fill Medicine Id !");
//             }
//             else{
//                 setVisible(false);
//                 new Edit_Medicine(med_id).setVisible(true);
//             }
//        }
    }
        
    
    public static void main(String[] args) {
        new View_Prescription(3,"2662").setVisible(true);
    }
}
