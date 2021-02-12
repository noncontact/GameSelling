package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class tade extends JFrame{
	game tg;
	costomer tuser;
	public tade(game g,costomer c){
		JFrame f2=new JFrame();
		JPanel p2 = new JPanel();
		int j=0;
		tg=new game(g.getText(),g.getlb1(),chStr(g.getlb2()));
		tuser=c;
		JLabel ti = new JLabel(tg.getTitle());
		JLabel l1 = new JLabel("Your Coin   : "+tuser.getCoin()+"￠");
		JLabel l2 = new JLabel("Game price : "+tg.getPrice()+"￠");
		JLabel l3 = new JLabel("balance    : "+tuser.charge(tg.getPrice())+"￠");
		JButton buy=new JButton("BUY");
		p2.setLayout(null);
		ti.setBounds(100, 0, 100, 30);
		l1.setBounds(50, 20, 200, 30);
		l2.setBounds(50, 50, 200, 30);
		l3.setBounds(50, 80, 200, 30);
		buy.setBounds(100, 110, 100, 30);
		buy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(tuser.charge(tg.getPrice())<0) {
					JOptionPane.showMessageDialog(null, "NOT ENOUGH COIN", "FAIL", JOptionPane.WARNING_MESSAGE);
					f2.dispose();
					new display(tuser);
				}
				else {
					tuser.inCoin(tuser.charge(tg.getPrice()));
					tuser.lib(tg);
					JOptionPane.showMessageDialog(null, "COMPLETE BUY", "Success", JOptionPane.WARNING_MESSAGE);
					f2.dispose();
					new display(tuser);
				}
			}
        });
		p2.add(ti);
		p2.add(l1);
		p2.add(l2);
		p2.add(l3);
		p2.add(buy);
		f2.add(p2);
		f2.setLocation(500, 100);
        f2.setSize(300,250);
        f2.setVisible(true);
        
	}
	int chStr(String s) {
		String result = s.substring(0, s.length()-1);
		
		return Integer.parseInt(result);
	}
	
	
	
	
	
}
