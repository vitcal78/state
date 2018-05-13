package state;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	
	JLabel orarioLabel,statusLabel;
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
		setSize(500, 150);
		setLocation(300, 300);
		
		setLayout(new FlowLayout());
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		orarioLabel = new JLabel(ora.toString()+":"+min.toString());
		orarioLabel.setFont(new Font("Courier New", Font.BOLD, 18));
		
		
		luceButton = new JButton("Incrementa/Luce");
		luceButton.addActionListener(new ChangeButton());
		
		
		modButton = new JButton("Modalità");
		modButton.addActionListener(new ModeButton());
		
		statusLabel = new JLabel("Modalità normale");
		
		
		add(orarioLabel);
		add(luceButton);
		add(modButton);
	    add(statusLabel);			
		
		
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
	
	private class ModeButton implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			
			displayTime();
			
			switch (clockState) {
			
				case N: {
					statusLabel.setText("Modalità cambio ora");					
					clockState = InternalState.H;
					setState(updatingHoursState);
					break;
				}
				case H: {
					statusLabel.setText("Modalità cambio minuto");
					clockState = InternalState.M;
					setState(updatingMinutesState);
					break;
				}
				case M: {
					statusLabel.setText("Modalità normale");
					clockState = InternalState.N;
					setState(normalState);
					break;
				}
				default : {
					
				}
			
			}
 			
		}
		
	}
	
	private class ChangeButton implements ActionListener {			

			@Override
			public void actionPerformed(ActionEvent e) {
				displayTime();
				outState.changeButton();
			}
			
	}
	
}
