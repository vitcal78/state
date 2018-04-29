package state;

import java.util.Calendar;

public class Clock {

	private State outState,normalState,updatingHoursState,updatingMinutesState;
	
	private enum InternalState {N,H,M};
	
	private InternalState clockState;
	
	int ora,min;
	
	Calendar cal;
	
	public Clock() {
		
		normalState = new NormalDisplayState();
		updatingHoursState = new UpdatingHoursState();
		updatingMinutesState = new UpdatingMinutesState();
		
		cal = Calendar.getInstance();
		
		ora = cal.get(Calendar.HOUR_OF_DAY);
		min = cal.get(Calendar.MINUTE);
		
		clockState =  InternalState.N;
		outState = normalState;
		
	}
	
	private void setState(State s) {
		outState = s;
	}
	
	public void displayTime() {
		System.out.print(ora);
		System.out.print(":");
		System.out.print(min);
		System.out.println("\n--------------\n");
	}
	
	public void modeButton() {
		
		displayTime();
		
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
			displayTime();
			outState.changeButton();
	}
	
}
