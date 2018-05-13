package state;

import java.util.Calendar;

public class Clock {

	private State outState,normalState,updatingHoursState,updatingMinutesState;
	
	private enum InternalState {N,H,M};
	
	private InternalState clockState;
	
	int ora,min;
	
	Calendar cal;
	
	public Clock() {
		
		normalState = new NormalDisplayState(this);
		updatingHoursState = new UpdatingHoursState(this);
		updatingMinutesState = new UpdatingMinutesState(this);
		
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
		System.out.println("\n***----------------**\n");
		System.out.print(ora);
		System.out.print(":");
		System.out.print(min);
		System.out.println("\n**----------------**\n");
	}
	
	public void incHour() {
		cal.add(Calendar.HOUR_OF_DAY, 1);
		ora = cal.get(Calendar.HOUR_OF_DAY);
		displayTime();
	}
	
	public void incMin() {
		cal.add(Calendar.MINUTE, 1);
		min = cal.get(Calendar.MINUTE);
		displayTime();
	}
	
	public void modeButton() {
		
		displayTime();
		
		switch (clockState) {
		
			case N: {
				System.out.println("\n passo alla modalità cambio ora \n");
				clockState = InternalState.H;
				setState(updatingHoursState);
				break;
			}
			case H: {
				System.out.println("\n passo alla modalità cambio minuto \n");
				clockState = InternalState.M;
				setState(updatingMinutesState);
				break;
			}
			case M: {
				System.out.println("\n passo alla modalità normale \n");
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
