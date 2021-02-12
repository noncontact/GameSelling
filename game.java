package game;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

public class game extends JButton{
	private String title;
	   private String genre;
	   private int price;
	   JLabel lb1 = null,lb2=null;
	   GridLayout layout =new GridLayout(1,3);
	   public game(String title, String genre, int price)
	   {
	      this.title=title;
	      this.genre=genre;
	      this.price=price;
	      this.setText(title);
      	
      	this.setHorizontalAlignment(SwingConstants.LEFT);
      	this.setBackground(Color.GRAY);
      	this.setForeground(Color.white);
      	lb1=new JLabel(genre);
      	lb2=new JLabel(price+"￠");
      	
      	lb1.setVerticalAlignment(SwingConstants.BOTTOM);
      	lb1.setHorizontalAlignment(SwingConstants.LEFT);
      	this.setLayout(layout);
      	this.add(lb1);
      	this.add(lb2);
      	
	   }
	   void setInfo(String t,String ge,int p) {
		   this.setText(t);
		   this.lb1.setText(ge);
		   this.lb2.setText(p+"￠");
	   }
	   String getlb1()
	   {
	      return this.lb1.getText();
	   }
	   String getlb2()
	   {
	      return this.lb2.getText();
	   }
	   //title 반환
	   String getTitle()
	   {
	      return this.title;
	   }
	   
	   //genre 반환
	   String getGenre()
	   {
	      return this.genre;
	   }
	   
	   //price 반환
	   int getPrice()
	   {
	      return this.price;
	   }

}
