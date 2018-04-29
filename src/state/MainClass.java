package state;

import java.io.IOException;

public class MainClass {

	public static void main(String[] args) {

		int c=0;
		
		boolean runFlag = true;
		
		Clock clk = new Clock();
		
		while (runFlag) {
			
			System.out.println("M - Modalità I - Incrementa / illuminazione  Q - Esci \n ");
			
			try {
				c = System.in.read();
				
				switch (c) {
					case 113 : {             // q- quit button
						runFlag = false;
						break;
					}
					case 81 : {             
						runFlag = false;
						break;
					}
					case 77 : {             // m  - modality button
						clk.modeButton();
						break;
					}
					case 109 : {             
						clk.modeButton();
						break;
					}
					case 73 : {               // i - increase 
						clk.changeButton();
						break;
					}
					case 105: {
						clk.changeButton();
						break;
					}
										
					default: {
						
					}
				}				
 
			} catch (IOException e) {
				System.out.println("Problema nello streaming tastiera.. mah");				
			} 
			
		}
		
		
	}
	
}
