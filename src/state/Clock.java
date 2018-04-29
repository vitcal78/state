package state;



public class Clock {

	private State outState,normalState,updatingHoursState,updatingMinutesState;
	
	private enum InternalState {N,H,M};
	
	private InternalState clockState;
	
	public Clock() {
		
		normalState = new NormalDisplayState();
		updatingHoursState = new UpdatingHoursState();
		updatingMinutesState = new UpdatingMinutesState();
		
		clockState =  InternalState.N;
		outState = normalState;
		
	}
	
	private void setState(State s) {
		outState = s;
	}
	
	public void modeButton() {
		
		switch (clockState) {
		
			case N: {
				clockState = InternalState.H;
				setState(updatingHoursState);
				break;
			}
			case H: {
				clockState = InternalState.M;
				setState(updatingMinutesState);
				break;
			}
			case M: {
				clockState = InternalState.N;
				setState(normalState);
				break;
			}
			default : {
				
			}
		
		}
		
	}
	
	public void  changeButton() {
			outState.changeButton();
	}
	
}
