import javax.swing.*;  
public class main {  
public static void main(String[] args) {  
JFrame f=new JFrame();
          
JButton b=new JButton("Restoring Division");  
b.setBounds(50,120,300, 40); 
f.add(b);
b.addActionListener(e -> {
            System.out.println("Restoring Division button clicked");
            restoring obj = new restoring();
            obj.mainfun();
        });

JButton c=new JButton("Non-restoring Division");  
c.setBounds(50,200,300, 40);          
f.add(c);
c.addActionListener(e -> {
            System.out.println("Non-restoring Division button clicked");
            non_restoring obj1 = new non_restoring();
            obj1.mainfun();
        });

f.setSize(400,500);
f.setLayout(null); 
f.setVisible(true); 
}  
}  