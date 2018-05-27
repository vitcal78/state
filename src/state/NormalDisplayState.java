package state;

import java.awt.Color;

public class NormalDisplayState implements State  {

	
	private String descr;
	
	Clock c;
	
	public NormalDisplayState(Clock c) {
		this.c =c;
		descr = "Modalità normale  ";
	}
	
	@Override
	public void modeButton() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeButton() {
		// TODO Auto-generated method stub
		
		if (c.orarioLabel.getForeground()==Color.lightGray) {
			c.orarioLabel.setForeground(Color.black);
		}
		    else {
		    	c.orarioLabel.setForeground(Color.lightGray);
		    }			   
		
	}

}
