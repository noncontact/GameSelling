package game;

import java.awt.Dimension;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

public class display {
	private GDV gdv = new GDV();
	JFrame f=new JFrame();
	costomer duser;
	public JButton balance;
	game[] gb=new game[5];
	int i=0,n=1;
	public display(costomer c) {
		
		JPanel p = new JPanel();
		JButton cInfo=new JButton();
		JButton next=new JButton("Next>");
		JButton pre=new JButton("<previous");
		
		duser=c;
		
		balance=new JButton("Your Coin: "+c.getCoin()+"￠");
		cInfo.setText(c.getID());
		p.setLayout(null);
		cInfo.setBounds(10, 10, 150,20);
		balance.setBounds(10, 30, 150,20);
		cInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				uInfo();
			}
        });
		balance.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JButton b=(JButton)e.getSource();
				JFrame f3=new JFrame();
				JPanel p3 = new JPanel();
				TextField txt2 = new TextField(20);
				JLabel l = new JLabel("GET COIN");
				JLabel l2 = new JLabel("10￠=1$");
				JButton pay=new JButton("PAY");
				int j=0;
				p3.setLayout(null);
				l.setBounds(20, 10, 100, 30);
				l2.setBounds(20, 40, 100, 30);
				txt2.setBounds(20, 70, 100, 30);
				pay.setBounds(150,20,100,30);
				pay.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						 String id = JOptionPane.showInputDialog(null, "Input your credit card number", "CARD", JOptionPane.OK_CANCEL_OPTION);
						 duser.inCoin(duser.getCoin()+Integer.parseInt(txt2.getText()));
						 b.setText("Your Coin: "+c.getCoin()+"￠");
					}
		        });
				p3.add(l);
				p3.add(l2);
				p3.add(txt2);
				p3.add(pay);
				
				f3.add(p3);
				f3.setLocation(500, 100);
		        f3.setSize(300,200);
		        f3.setVisible(true);
			}
        });
		p.add(cInfo);
		p.add(balance);
		while(i<gdv.gdv.size()&&i<5*n) {
			gb[i] = gdv.gdv.get(i);
			gb[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					game bg=(game)e.getSource();
					int ans = JOptionPane.showConfirmDialog(null, "Want "+bg.getText()+"?", "확인", JOptionPane.YES_NO_OPTION, JOptionPane.PLAIN_MESSAGE);
					System.out.println(ans);
					if(ans==0) {
						f.dispose();
						new tade(bg,duser);
					}
				}
	        });
			p.add(gb[i]);
			i++;
		}
		if(i%5!=0)i+=(5-(i%5));
		next.setBounds(200,350 , 80, 20);
		pre.setBounds(50, 350, 80, 20);
		next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(5*n<gdv.gdv.size())
				n++;
				//
				while(i<gdv.gdv.size()&&i<5*n) {
					gb[i%5].setInfo(gdv.gdv.get(i).getTitle(), gdv.gdv.get(i).getGenre(), gdv.gdv.get(i).getPrice());
					System.out.println(gb[i%5].getText());
					i++;
				}
				if(i%5!=0) {
					
					for(int j=0;j<(5*n)-i;j++) {
						gb[i%5+j].setInfo("","",0);
					}
				}
				//p.repaint();
				System.out.println(n+" "+i);
			}
        });
		pre.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(n>1)
				n--;
				if(i>=10)i-=10;
				else i=0;
				while(i<gdv.gdv.size()&&i<5*n) {
					gb[i%5].setInfo(gdv.gdv.get(i).getTitle(), gdv.gdv.get(i).getGenre(), gdv.gdv.get(i).getPrice());
					
					System.out.println(gb[i%5].getText());
					i++;
				}
				//p.repaint();
				System.out.println(n+" "+i);
			}
        });
		p.add(next);
		p.add(pre);
		f.add(p);;
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLocation(500, 100);
        f.setSize(500,450);
        f.setVisible(true);
	}
	private void uInfo() {
		JFrame f2=new JFrame();
		JPanel p2 = new JPanel();
		
		JLabel l = new JLabel("Your Game");
		int j=0;
		p2.setLayout(null);
		l.setBounds(200, 10, 100, 30);
		p2.add(l);
		while(j<duser.getLib().size()) {
			game g = duser.getLib().get(j);
			p2.add(g);
			j++;
			
		}
		f2.setLayout(null);
		JScrollPane sp=new JScrollPane(p2);
		sp.setBounds(0, 0, 500, 450);
		//sp.getVerticalScrollBar().setValue(1030);
		//sp.getHorizontalScrollBar().setValue(1005);
		//f2.getContentPane().add(sp);
		f2.add(sp);
		f2.setLocation(500, 100);
        f2.setSize(500,450);
        f2.setVisible(true);
	}
	
}
