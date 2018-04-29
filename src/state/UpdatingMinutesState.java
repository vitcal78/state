package state;

public class UpdatingMinutesState implements State {

	private String descr;
	
	Clock c;
	
	public UpdatingMinutesState(Clock c) {
		descr = "Modalit� cambio minuto";
		this.c = c;
	}
	
	@Override
	public void modeButton() {
		// TODO Auto-generated method stub
		System.out.println(descr+" Cambio modalit�..\n");
	}

	@Override
	public void changeButton() {
		// TODO Auto-generated method stub
		System.out.println(descr + " .. incremento minuto\n");
		c.incMin();
	}

}
