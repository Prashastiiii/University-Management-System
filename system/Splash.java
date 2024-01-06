package university.management.system;
import java.awt.Image;
import javax.swing.*;

public class Splash extends JFrame implements Runnable{
    
    Thread t;
    Splash(){
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("Icon/Desktop.jpg"));
        Image i2=i1.getImage().getScaledInstance(1000,700, Image.SCALE_DEFAULT);
        /*   ImageIcon new;*/
        ImageIcon i3 = new ImageIcon(i2);
      JLabel image = new JLabel(i3);
      add(image);
        
      t = new Thread(this);
      t.start();
                
        setLocation(450,120);
        setSize(600,600);
        setVisible(true);
        
          
        
    }
    
    public void run(){
        try{
            Thread.sleep(4000);
            setVisible(false);
            Login login = new Login();
        }catch (InterruptedException e){
           
            //next frame
     
        }
    }
    
    public static void main(String[] args){
           new Splash();
    }

   // private void add(Jlabel Image) {
     //   throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
