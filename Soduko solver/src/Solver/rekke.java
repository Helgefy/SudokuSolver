package Solver;

import java.util.ArrayList;

public class rekke {
	
	ArrayList<rute> nummer;


	int pos;
	
	public rekke(int i){
		nummer =new ArrayList<rute>();
		setPos(i);
		
	}
	
	void addrute(rute rute){
		
		nummer.add(rute);
		
	}
	
	ArrayList<rute> getruter(){
		
		return nummer;
	}
	
	protected int getPos() {
		return pos;
	}

	protected void setPos(int pos) {
		this.pos = pos;
	}
}
