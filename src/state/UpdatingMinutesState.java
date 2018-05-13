package state;

public class UpdatingMinutesState implements State {

	private String descr;
	
	Clock c;
	
	public UpdatingMinutesState(Clock c) {
		descr = "Modalità cambio minuto";
		this.c = c;
	}
	
	@Override
	public void modeButton() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void changeButton() {
		// TODO Auto-generated method stub
		
		c.incMin();
	}

}
