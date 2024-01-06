package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import java.sql.SQLException;


public class AddTeacher extends JFrame implements ActionListener{
       
    JTextField tfname,tfqualif,tfemail;
        JLabel labelid;
        JDateChooser dcdob;
        JButton submit, cancel;
    
        
        
    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);
   

    
    AddTeacher() {
        
        setSize(900, 700);
        setLocation(350, 50);
        
        setLayout(null);
        
        JLabel heading = new JLabel("New Teacher's Details");
        heading.setBounds(310, 30, 500, 50);
        heading.setFont(new Font("serif", Font.BOLD, 30));
        add(heading);
        
           
        JLabel lblname = new JLabel("Name");
        lblname.setBounds(50, 150, 100, 30);
        lblname.setFont(new Font("serif", Font.BOLD, 20));
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 150, 150, 30);
        add(tfname);
        
        JLabel lblqualif = new JLabel("Qualification");
        lblqualif.setBounds(400, 150, 200, 30);
        lblqualif.setFont(new Font("serif", Font.BOLD, 20));
        add(lblqualif);
        
        tfqualif = new JTextField();
        tfqualif.setBounds(600, 150, 150, 30);
        add(tfqualif);
        
        JLabel lblid = new JLabel("Roll Number");
        lblid.setBounds(50, 200, 200, 30);
        lblid.setFont(new Font("serif", Font.BOLD, 20));
        add(lblid);
       
          labelid = new JLabel("153"+first4);
        labelid.setBounds(200, 200, 200, 30);
        labelid.setFont(new Font("serif", Font.BOLD, 20));
        add(labelid);
        
        JLabel lbldob = new JLabel("Date of Birth");
        lbldob.setBounds(400, 200, 200, 30);
        lbldob.setFont(new Font("serif", Font.BOLD, 20));
        add(lbldob);
        
        dcdob = new JDateChooser();
        dcdob.setBounds(600, 200, 150, 30);
        add(dcdob);
      
          JLabel lblemail = new JLabel("Email Id");
        lblemail.setBounds(50, 300, 200, 30);
        lblemail.setFont(new Font("serif", Font.BOLD, 20));
        add(lblemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(200, 300, 150, 30);
        add(tfemail);
        
       submit = new JButton("Submit");
        submit.setBounds(250, 550, 120, 30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener((ActionListener) this);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(submit);
        
        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 120, 30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener((ActionListener) this);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        add(cancel);
        
        setVisible(true);
    }
    
          public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String name = tfname.getText();
            String qualif = tfqualif.getText();
            String id = labelid.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String email = tfemail.getText();
          
            try {
                String query = "insert into teacher values('" + name + "', '" + qualif+ "', '" + id + "', '" + dob + "','" + email + "')";

                Conn con = new Conn();
                int rowsAffected = con.s.executeUpdate(query);

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(null, "Teacher's Details Inserted Successfully");
                    setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to insert student details", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    
  
    
 public static void main(String[] args) {
        AddTeacher addTeacher = new AddTeacher();
    }
 
}