package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class GDV {
	public Vector<game> gdv = new Vector();
	String s = "dat\\gamedata.dat";
	GridLayout layout =new GridLayout(1,3);
	public GDV(){
		JLabel lb1 = null,lb2=null;
		int i=0;
		try {
			File f=new File(s);
				if(!f.exists())f.createNewFile();
				else {
				BufferedReader reader = new BufferedReader(new FileReader(s));
		    	String line = "";

		    	while ((line = reader.readLine()) != null) { 
		        	String[] temp = line.split(","); // , : 구분자
		        	game c=new game(temp[0],temp[1],Integer.parseInt(temp[2]));
		        	c.setBounds(10, 70+50*(i%5),400, 50);
		        	gdv.add(c);
		        	i++;
		    	}
		    	reader.close();
		    	}
			
			} catch (Exception e) {
		    	e.printStackTrace();
			}
		
		
	}
	public void save() {
		costomer c;
		int i = 0;
		String wt[]=new String[3] ;
		try {
        
        //얘는 파일입출력용    
        BufferedWriter writer = new BufferedWriter(new FileWriter(s)); 
        while(i!=gdv.size()) {
        	wt[0]=gdv.get(i).getTitle();
        	wt[1]=gdv.get(i).getGenre();
        	wt[2]=gdv.get(i).getPrice()+"";
        	writer.write(String.format("%s,%s,%s\n", wt[0], wt[1], wt[2]));
        	i++;
        }
        writer.close();
        System.out.println("작성 완료.");
 
    } catch (IOException e) {
        e.printStackTrace();
 
    }
		
	}
}
