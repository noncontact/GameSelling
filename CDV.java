package game;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class CDV {
	public Vector<costomer> cdv = new Vector();
	private String s = "dat\\costomer.dat";
	public CDV(){
		int i,j=0;
		Vector<game> lg=new Vector<game>();
		game g;
		try {
			File f=new File(s);
			if(!f.exists())f.createNewFile();
			else {
		    BufferedReader reader = new BufferedReader(new FileReader(s));
		    String line = "";
		    GridLayout layout =new GridLayout(1,3);
		    JLabel lb1 = null,lb2=null;

		    while ((line = reader.readLine()) != null) { 
		        String[] temp = line.split(","); // , : 구분자
		        for(i=3;i<temp.length;i+=3) {
		        	g=new game(temp[i],temp[i+1],Integer.parseInt(temp[i+2]));
		        	g.setBounds(10, 70+50*(j),400, 50);
		        	j++;
		        	
		        	lg.add(g);
		        }
		        costomer c=new costomer(temp[0],temp[1],Integer.parseInt(temp[2]),lg);
		        cdv.add(c);
		        lg.removeAllElements();
		    }
		    reader.close();
		    }
			
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
	}
	public void save() {
		//costomer c;
		int i=0,j = 0;
		String wt[]=new String[3] ;
		Vector<game> wg;
		try {
        
        //얘는 파일입출력용    
        BufferedWriter writer = new BufferedWriter(new FileWriter(s)); 
        while(i!=cdv.size()) {
        	//System.out.println(cdv.get(i).getID());
        	wt[0]=cdv.get(i).getID();
        	wt[1]=cdv.get(i).getPW();
        	wt[2]=cdv.get(i).getCoin()+"";
        	writer.write(String.format("%s,%s,%s", wt[0], wt[1], wt[2]));
        	wg=cdv.get(i).getLib();
        	for(j=0;j<wg.size();j++) {
        		writer.write(String.format(",%s,%s,%s", wg.get(j).getTitle(), wg.get(j).getGenre(), wg.get(j).getPrice())+"");
        	}
        	writer.write(String.format("\n"));
        	i++;
        }
        writer.close();
        System.out.println("작성 완료.");
 
    } catch (IOException e) {
        e.printStackTrace();
 
    }
		
	}
	
}

