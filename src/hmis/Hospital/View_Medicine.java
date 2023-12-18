package hmis.Hospital;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class View_Medicine extends JFrame implements ActionListener {
 
    String []x={"Medicine Id","Drug Code","Name","Quantity","Drug Type","Expiry Date","Unit Rate"};
    JButton bt,bt1;
    String y[][]=new String[20][7];
    int i=0,j=0;
    JTable t;
    JLabel l1,l2;
    JTextField tf1;
    JPanel p1,p2,p3;
    Font f,f1;
    String q;
    
    View_Medicine()
    {
        super("Medicine Information");
        setSize(1500,400);
        setLocation(1,1);
        
        f = new Font("MS UI Gothic", Font.BOLD,15);
        try{
            ConnectionClass obj = new ConnectionClass();
            
            q = "Select * from medicine";
            
            ResultSet rest = obj.stm.executeQuery(q);
            while(rest.next()){
                y[i][j++] = rest.getString("med_id");
                y[i][j++] = rest.getString("drug_code");
                y[i][j++] = rest.getString("name");
                y[i][j++] = rest.getString("quantity");
                y[i][j++] = rest.getString("drug_type");
                y[i][j++] = rest.getString("expiry_date");
                y[i][j++] = rest.getString("unit_rate");
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
        l1= new JLabel("Medicine Id");
        l2= new JLabel("Delete or Edit Any Medicine");
        
        l1.setForeground(Color.GRAY);
        l2.setForeground(Color.YELLOW);
        l2.setHorizontalAlignment(JLabel.CENTER);
        
        l1.setFont(f1);
        l2.setFont(f1);
        
        bt= new JButton("Delete Medicine");  // set buttons
        bt1= new JButton("Edit Medicine");
        
        bt.addActionListener(this); // 
        bt1.addActionListener(this);
        
        bt.setBackground(Color.black);
        bt1.setBackground(Color.black);
        
        bt.setForeground(Color.red);
        bt1.setForeground(Color.yellow);
        
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
        p2.add(bt1);
         
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
        String med_id = tf1.getText();
        if(ae.getSource()==bt){
            JOptionPane.showMessageDialog(null,"Delete Button Temporary Disable");
//            if(med_id.isEmpty()){
//                JOptionPane.showMessageDialog(null,"Please fill Medicine Id !");
//            }
//            else{
//                try{
//                ConnectionClass obj1 = new ConnectionClass();
//                String q = "delete from medicine where med_id='"+med_id+"'";
//                obj1.stm.executeUpdate(q);
//                JOptionPane.showMessageDialog(null,"Medicine Is Deleted");
//                setVisible(false);
//                }
//                catch(Exception e){
//                    e.printStackTrace();
//                }
//            }

        }
        if(ae.getSource()==bt1){
             if(med_id.isEmpty()){
                 JOptionPane.showMessageDialog(null,"Please fill Medicine Id !");
             }
             else{
                 setVisible(false);
                 new Edit_Medicine(med_id).setVisible(true);
             }
        }
    }
        
    
    public static void main(String[] args) {
        new View_Medicine().setVisible(true);
    }
}
