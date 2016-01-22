package be.vdab.entities;

import java.io.Serializable;
import java.util.Random;

public class ZoekDeFrietSpel  implements Serializable{
	private static final long serialVersionUID = 1L;
	private static final int AANTAL_DEUREN = 7;
	private final int juisteDeur = new Random().nextInt(AANTAL_DEUREN);
	private final boolean[] deurIsOpen = new boolean[AANTAL_DEUREN];
	
	public int getJuisteDeur() {
		return juisteDeur;
	}
	
	public boolean[] getDeurIsOpen() {
		return deurIsOpen;
	}	
	
	public void setDeurIsOpen(int nr){
		deurIsOpen[nr] = true;
	}
	

}
