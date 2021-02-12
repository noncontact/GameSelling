package game;

import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Login extends JFrame implements ActionListener{
	static JButton b = new JButton("Log In");
	static TextField txt1 = new TextField("ID", 20 );
    static TextField txt2 = new TextField(20);
    private String id,pw;
    
	private CDV cdv = new CDV();
	private costomer user = null;
	JFrame f = new JFrame();
	public Login() {
		
		Panel p = new Panel();
		
		Label lb1 = new Label("ID");
		Label lb2=new Label("PW");
		txt2.setEchoChar('*');
        p.add(lb1);
        p.add(txt1);
        p.add(lb2);  
        p.add(txt2);
        p.add(b);
        f.add(p);
        f.setTitle("Log In");
        b.addActionListener(this);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocation(500, 300);
        f.setSize(200,200);
        f.setVisible(true);
        //System.out.println(cdv.cdv.get(2).getLib().get(2).getTitle());
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int i=0;
		 Object obj = e.getSource();
	        if((JButton)obj == b) 
	        {
	            id=txt1.getText();
	            pw=txt2.getText();
	            while(i!=cdv.cdv.size()) {
	    			if(cdv.cdv.get(i).getID().equals(id)) {
	    				user=cdv.cdv.get(i);
	    				break;
	    			}
	    			i++;
	    		}
	            if(user==null) {
	    			System.out.println("No Exist ID");
	    			
	    			//System.exit(0);
	    		}
	            else {
	            	if(user.getPW().equals(pw)) {
	        			System.out.println("Log in Success");
	        			
	        			
	        			f.dispose();
	        			new display(user);
	        			
	        		}
	            	else {
	            		System.out.println("No Exist ID");
	            	}
	            }
	            System.out.println(id);
	        }
	}
	
}
