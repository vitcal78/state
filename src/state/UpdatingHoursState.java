package state;

public class UpdatingHoursState implements State {

	private String descr;
	
	Clock c;
	
	public UpdatingHoursState(Clock c) {
		this.c = c;
		descr = "Modalità cambio ora";
	}
	
	@Override
	public void modeButton() {
		// TODO Auto-generated method stub
		System.out.println(descr+" Cambio modalità..\n");
	}

	@Override
	public void changeButton() {
		// TODO Auto-generated method stub
		System.out.println(descr + " .. incremento ora\n");
		c.incHour();
	}

}
