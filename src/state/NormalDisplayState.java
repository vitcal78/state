package state;

public class NormalDisplayState implements State  {

	
	private String descr;
	
	public NormalDisplayState() {
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
