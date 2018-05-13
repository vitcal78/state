package state;

import java.awt.FlowLayout;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Clock extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	private State outState,normalState,updatingHoursState,updatingMinutesState;
	
	private enum InternalState {N,H,M};
	
	private InternalState clockState;
	
	Integer ora,min;
	
	Calendar cal;
	
	JLabel orarioLabel;
	JButton luceButton,modButton;
	
	public Clock() {
		
		normalState = new NormalDisplayState(this);
		updatingHoursState = new UpdatingHoursState(this);
		updatingMinutesState = new UpdatingMinutesState(this);
		
		cal = Calendar.getInstance();
		
		ora = cal.get(Calendar.HOUR_OF_DAY);
		min = cal.get(Calendar.MINUTE);
		
		clockState =  InternalState.N;
		outState = normalState;
		
		setTitle("Radiosveglia");
		setSize(500, 300);
		setLocation(300, 300);
		
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		orarioLabel = new JLabel(ora.toString()+":"+min.toString());
		orarioLabel.setFont(new Font("Courier New", Font.BOLD, 18));
		
		
		luceButton = new JButton("Incrementa/Luce");
		modButton = new JButton("Modalità");
		
		add(orarioLabel);
		add(luceButton);
		add(modButton);
		
		setVisible(true);
		
		
	}
	
	private void setState(State s) {
		outState = s;
	}
	
	public void displayTime() {

		orarioLabel.setText(ora.toString()+":"+min.toString());
		
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
