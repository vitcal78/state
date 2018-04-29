package state;

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
		System.out.println(descr+" Cambio modalità..\n");
	}

	@Override
	public void changeButton() {
		// TODO Auto-generated method stub
		System.out.println(descr + " ...E luce fu....\n");
	}

}
