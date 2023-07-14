import javax.swing.*;
import java.awt.*;
import java.awt.FlowLayout;
import java.io.*;
import java.security.Key;


public class Encryption{

    public static void encrypt(int key,JFileChooser fc){

     
        File f = fc.getSelectedFile();
        //read 
        try{

            FileInputStream fs = new FileInputStream(f);
            byte[]data = new byte[fs.available()];
            fs.read(data);
            int i=0;
            for(byte b:data){
                data[i]=(byte)(b^key);
                i++;

            }
            FileOutputStream fo = new FileOutputStream(f);
            fo.write(data);
            fo.close();
            JOptionPane.showMessageDialog(null, "Encryption Done!");

        }catch(Exception e ){

        }
    }

    public static void decrypt(int key,JFileChooser fc){
        File f = fc.getSelectedFile();
        //read 
        try{

            FileInputStream fs = new FileInputStream(f);
            byte[]data = new byte[fs.available()];
            fs.read(data);
            int i=0;
            for(byte b:data){
                data[i]=(byte)(b^key);
                i++;

            }
            FileOutputStream fo = new FileOutputStream(f);
            fo.write(data);
            fo.close();
            JOptionPane.showMessageDialog(null, "Decryption Done!");

        }catch(Exception e ){

        }

    }
   
    public static void main(String args[]){

        System.out.println("hello world");

        JFrame f = new JFrame();
        f.setTitle("File encryption decryption");
        f.setSize(400,400);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       

        //label
        JLabel label = new JLabel("Enter Key");

        //text field
        JTextField tf = new JTextField(10);

        //button
        JButton bt = new JButton();
        bt.setText("Select File");
        //file selection
        JFileChooser fc =new JFileChooser();
        bt.addActionListener(e->{
             fc.showOpenDialog(null);
        });

        //encrypt button
        JButton bt2 = new JButton();
        bt2.setText("Encrypt File");
        bt2.addActionListener(e->{
        String text = tf.getText();
        int temp = Integer.parseInt(text);
        encrypt(temp,fc);
        });

        //decrypt button
        JButton bt3 = new JButton();
        bt3.setText("Decrypt File");
        bt3.addActionListener(e->{
            String text = tf.getText();
            int temp = Integer.parseInt(text);
            decrypt(temp,fc);
            });
        f.setLayout(new FlowLayout());
        f.add(label);
        f.add(tf);
        f.add(bt);
        f.add(bt2);
        f.add(bt3);
        f.setVisible(true);
    }
}

