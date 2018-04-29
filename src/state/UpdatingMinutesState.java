package state;

public class UpdatingMinutesState implements State {

	private String descr;
	
	public UpdatingMinutesState() {
		descr = "Modalit� cambio minuto";
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
	}

}
