package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class costomer {
	private String ID; // 0 = Empty, 1~6 = tile01~06
	private String PW;
	private int coin;
	private Vector<game> lib = new Vector<game>();
	int i;
	public costomer(String ID,String PW,int coin,Vector<game> g){
		game ga;
		
		this.ID=ID;
		this.PW=PW;
		this.coin=coin;
		for(i=0;i<g.size();i++) {
			ga=g.get(i);
			ga.setBounds(10, 70+50*(i),400, 50);
			this.lib.add(ga);
		}
	}
	public void inID(String newid) {
		this.ID=newid;
	}
	public void inPW(String newpw) {
		this.PW=newpw;
	}
	public void inCoin(int newcoin) {
		this.coin=newcoin;
	}
	public void lib(game ng) {
		ng.setBounds(10, 70+50*(i),400, 50);
		i++;
		this.lib.add(ng);
	}
	public String getID() {
		return ID;
	}
	public String getPW() {
		return PW;
	}
	public int getCoin() {
		return coin;
	}
	public Vector<game> getLib(){
		return lib;
	}
	public int charge(int price) {
		int remain;
		remain=coin-price;
		return remain;
	}
	
}
