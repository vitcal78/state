package state;

public class UpdatingHoursState implements State {

	private String descr;
	
	Clock c;
	
	public UpdatingHoursState(Clock c) {
		this.c = c;
		descr = "Modalit� cambio ora";
	}
	
	@Override
	public void modeButton() {
		// TODO Auto-generated method stub
		System.out.println(descr+" Cambio modalit�..\n");
	}

	@Override
	public void changeButton() {
		// TODO Auto-generated method stub
		System.out.println(descr + " .. incremento ora\n");
		c.incHour();
	}

}
